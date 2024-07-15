<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="投诉标题" prop="title">
        <el-input
          v-model="queryParams.title"
          placeholder="请输入投诉标题"
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
          v-hasPermi="['procurementManagement:complaint:add']"
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
          v-hasPermi="['procurementManagement:complaint:edit']"
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
          v-hasPermi="['procurementManagement:complaint:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['procurementManagement:complaint:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="complaintList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="投诉id" align="center" prop="complaintId" />
      <el-table-column label="投诉标题" align="center" prop="title" />
      <el-table-column label="处理状态" align="center" prop="complaintType" >
        <template slot-scope="scope">
          <span>{{ scope.row.complaintType==0?'处理中':'已处理' }}</span>
        </template>
      </el-table-column>
      <el-table-column label="联系电话" align="center" prop="contactNumber" />
      <el-table-column label="联系人" align="center" prop="contactPerson" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['procurementManagement:complaint:edit']"
          >处理投诉</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['procurementManagement:complaint:remove']"
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

    <!-- 添加或修改采购—投诉对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="800px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="投诉标题" prop="title">
          <el-input :disabled="form.complaintId!=null" v-model="form.title" placeholder="请输入投诉标题" />
        </el-form-item>
        <el-form-item label="创建时间" prop="creationTime">
          <el-date-picker clearable
            :disabled="form.complaintId!=null"
            v-model="form.creationTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择创建时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="联系电话" prop="contactNumber">
          <el-input :disabled="form.complaintId!=null" v-model="form.contactNumber" placeholder="请输入联系电话" />
        </el-form-item>
        <el-form-item label="联系人" prop="contactPerson">
          <el-input :disabled="form.complaintId!=null" v-model="form.contactPerson" placeholder="请输入联系人" />
        </el-form-item>
        <el-form-item label="附件地址" prop="attachment">
          <el-upload
            ref="elUpload"
            class="upload-demo"
            :action="this.$BASEUSER + '/procurement/FileUpload'"
            :on-success="onSuccess"
            :limit="3"
          >
            <el-button :disabled="form.complaintId!=null" size="small" type="success" icon="el-icon-upload2"
            >上传</el-button
            >
          </el-upload>
        </el-form-item>
        <el-form-item label="投诉内容" prop="complaintText">
          <el-input :disabled="form.complaintId!=null" resize="none" rows="5" v-model="form.complaintText" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="处理结果" prop="processingResult">
          <el-input :disabled="form.complaintId==null" resize="none" rows="5" v-model="form.processingResult" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="处理状态" prop="complaintType">
          <el-select :disabled="form.complaintId==null" v-model="form.complaintType" label="label" placeholder="请选择处理状态">
            <el-option label="处理中" :value="0"></el-option>
            <el-option label="已处理" :value="1"></el-option>
          </el-select>
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
import { listComplaint, getComplaint, delComplaint, addComplaint, updateComplaint } from "@/api/procurementManagement/complaint";

export default {
  name: "Complaint",
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
      // 采购—投诉表格数据
      complaintList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        title: null,
        complaintType: null,
      },
      // 表单参数
      form: {
        attachment: []
      },
      // 表单校验
      rules: {
        title: [
          { required: true, message: "投诉标题不能为空", trigger: "blur" }
        ],
        creationTime: [
          { required: true, message: "创建时间不能为空", trigger: "blur" }
        ],
        contactNumber: [
          { required: true, message: "联系电话不能为空", trigger: "blur" }
        ],
        contactPerson: [
          { required: true, message: "联系人不能为空", trigger: "blur" }
        ],
        complaintText: [
          { required: true, message: "投诉内容不能为空", trigger: "blur" }
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
    /** 查询采购—投诉列表 */
    getList() {
      this.loading = true;
      listComplaint(this.queryParams).then(response => {
        this.complaintList = response.rows;
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
      this.form = {
        complaintId: null,
        title: null,
        creationTime: null,
        complaintType: null,
        contactNumber: null,
        contactPerson: null,
        attachment: null,
        complaintText: null,
        processingResult: null
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
      this.ids = selection.map(item => item.complaintId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.form.complaintType=0
      this.title = "添加采购—投诉";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const complaintId = row.complaintId || this.ids
      getComplaint(complaintId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改采购—投诉";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.complaintId != null) {
            updateComplaint(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addComplaint(this.form).then(response => {
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
      const complaintIds = row.complaintId || this.ids;
      this.$modal.confirm('是否确认删除采购—投诉编号为"' + complaintIds + '"的数据项？').then(function() {
        return delComplaint(complaintIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('procurementManagement/complaint/export', {
        ...this.queryParams
      }, `complaint_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
