<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="标题" prop="title">
        <el-input
          v-model="queryParams.title"
          placeholder="请输入标题"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['procurementManagement:policiesRegulations:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['procurementManagement:policiesRegulations:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['procurementManagement:policiesRegulations:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['procurementManagement:policiesRegulations:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="PoliciesRegulationsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="列表id" align="center" prop="listId" />
      <el-table-column label="标题" align="center" prop="title" />
      <el-table-column label="发布时间" align="center" prop="releaseTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.releaseTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="发布者" align="center" prop="publisher" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['procurementManagement:policiesRegulations:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['procurementManagement:policiesRegulations:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改政策法规对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body :before-close="reset">
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="标题" prop="title">
          <el-input v-model="form.title" placeholder="请输入标题" />
        </el-form-item>
        <el-form-item label="发布时间" prop="releaseTime">
          <el-date-picker clearable
            v-model="form.releaseTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择发布时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="内容">
          <editor v-model="form.text" :min-height="192"/>
        </el-form-item>
        <el-form-item label="附件" prop="attachment">
          <el-upload
            ref="elUpload"
            class="upload-demo"
            :action="this.$BASEUSER + '/procurement/FileUpload'"
            :on-success="onSuccess"
            :limit="3"
          >
            <el-button size="small" type="success" icon="el-icon-upload2"
            >上传</el-button
            >
          </el-upload>
        </el-form-item>
        <el-form-item label="发布者" prop="publisher">
          <el-input v-model="form.publisher" placeholder="请输入发布者" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listPoliciesRegulations, getPoliciesRegulations, delPoliciesRegulations, addPoliciesRegulations, updatePoliciesRegulations } from "@/api/procurementManagement/policiesRegulations";

export default {
  name: "PoliciesRegulations",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 政策法规表格数据
      PoliciesRegulationsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        title: null,
      },
      // 表单参数
      form: {
        attachment: []
      },
      // 表单校验
      rules: {
        title: [
          { required: true, message: "标题不能为空", trigger: "blur" }
        ],
        releaseTime: [
          { required: true, message: "发布时间不能为空", trigger: "blur" }
        ],
        text: [
          { required: true, message: "内容不能为空", trigger: "blur" }
        ],
        publisher: [
          { required: true, message: "发布者不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    // 上传成功函数
    onSuccess(response, file, fileList) {
      this.form.attachment=[]
      fileList.forEach(item=>{
        this.form.attachment.push(item.response.data)
      })
      this.form.attachment = this.form.attachment.join(',')
    },
    /** 查询政策法规列表 */
    getList() {
      this.loading = true;
      listPoliciesRegulations(this.queryParams).then(response => {
        this.PoliciesRegulationsList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.open = false;
      this.form = {
        listId: null,
        title: null,
        releaseTime: null,
        text: null,
        attachment: [],
        publisher: null,
        listType: null,
        announcementType: null
      };
      this.$nextTick(()=>{
        this.$refs["elUpload"].clearFiles()
      })
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.listId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加政策法规";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const listId = row.listId || this.ids
      getPoliciesRegulations(listId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改政策法规";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.listId != null) {
            updatePoliciesRegulations(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPoliciesRegulations(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const listIds = row.listId || this.ids;
      this.$modal.confirm('是否确认删除政策法规编号为"' + listIds + '"的数据项？').then(function() {
        return delPoliciesRegulations(listIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('procurementManagement/policiesRegulations/export', {
        ...this.queryParams
      }, `PoliciesRegulations_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
