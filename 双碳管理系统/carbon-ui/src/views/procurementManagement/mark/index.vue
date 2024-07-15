<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="标标题" prop="title">
        <el-input
          v-model="queryParams.title"
          placeholder="请输入标标题"
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
          v-hasPermi="['procurementManagement:mark:add']"
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
          v-hasPermi="['procurementManagement:mark:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['procurementManagement:mark:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="markList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="标id" align="center" prop="markId" />
      <el-table-column label="标标题" align="center" prop="title" />
      <el-table-column label="招标公告id" align="center" prop="announcementId" />
      <el-table-column label="投标状态" align="center" prop="bidType" >
        <template slot-scope="scope">
          <span>{{ getBidType(scope.row.bidType) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="结束时间" align="center" prop="endTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.endTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="signUp(scope.row)"
            v-hasPermi="['procurementManagement:mark:edit']"
            :disabled="scope.row.bidType!=5"
          >报名</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['procurementManagement:mark:edit']"
          >修改</el-button>
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

    <!-- 添加或修改参与投标表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="标标题" prop="title">
          <el-input v-model="form.title" placeholder="请输入标标题" />
        </el-form-item>
        <el-form-item label="招标公告id" prop="title">
          <el-input style="width:280px;margin-right: 25px;"  disabled v-model="form.announcementId" placeholder="请输入招标公告id" />
          <el-button type="text" @click="openAnnouncements">选择</el-button>
        </el-form-item>
        <el-form-item label="结束时间" prop="endTime">
          <el-date-picker clearable
            v-model="form.endTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择结束时间">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
    <!-- 选择公告对话框 -->
    <el-dialog title="选择公告" :visible.sync="open2" width="1000px">
      <el-table :data="mark.list" style="width: 100%">
        <el-table-column align="center" label="公告id" prop="listId" width="150">
        </el-table-column>
        <el-table-column prop="title" label="公告名称"> </el-table-column>
        <el-table-column
          width="150"
          label="公告类型"
          :filters="[
            { text: '招标预告', value: '1' },
            { text: '招标公告', value: '2' },
            { text: '中标公告', value: '3' },
            { text: '企业采购', value: '4' },
          ]"
          :filter-method="filterHandler"
        >
          <template slot-scope="scope">
            {{ getAnnouncementType(scope.row.announcementType) }}
          </template>
        </el-table-column>
        <el-table-column
          align="center"
          prop="releaseTime"
          label="发布时间"
          width="150"
        >
          <template slot-scope="scope">
            <i class="el-icon-time"></i>
            <span style="margin-left: 10px">{{ scope.row.releaseTime }}</span>
          </template>
        </el-table-column>
        <el-table-column
          align="center"
          prop="releaseTime"
          label="操作"
          width="150"
        >
          <template slot-scope="scope">
            <el-button :disabled="scope.row.announcementType!=2" type="text" @click="selectionAnnouncemen(scope.row)">选择</el-button>
          </template>
        </el-table-column>
      </el-table>
      <div>
        <el-pagination
          style="padding-top: 20px;"
          background
          layout="prev, pager, next"
          :total="mark.total"
          :page-size="mark.pageSize"
          :current-page.sync="mark.currentPage"
          @current-change="getAnnouncementList"
        ></el-pagination>
      </div>
    </el-dialog>
    <el-dialog title="标报名" :visible.sync="open3" width="480px">
      <el-form :model="signUpFrom" ref="ruleForm"  label-width="130px" class="demo-ruleForm">
        <el-form-item label="选择报名用户" prop="userId">
          <el-select v-model="signUpFrom.userId" placeholder="请选择报名用户">
            <el-option v-for="item in userList" :label="item.userName+' / '+item.userId" :value="item.userId"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="confirmationSignUp()">报名</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listMark, getMark, delMark, addMark, updateMark,getListByPage,signUp } from "@/api/procurementManagement/mark";
import { listUser } from '@/api/system/user'

export default {
  name: "Mark",
  data() {
    return {
      userList:[],
      signUpFrom:{
        bidId:'',
        userId:''
      },
      mark:{
        markId:'',
        list: [],
        currentPage: 1,
        total: 0,
        pageSize: 10,
      },
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
      // 参与投标表表格数据
      markList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      open2:false,
      open3:false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        title: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        endTime: [
          { required: true, message: "结束时间不能为空", trigger: "blur" }
        ],
        announcementId: [
          { required: true, message: "招标公告id不能为空", trigger: "change" }
        ],
        title: [
          { required: true, message: "标标题不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    // 标报名
    confirmationSignUp(){
      if (this.signUpFrom.userId==''){
        this.$message.warning('请先选择报名用户')
        return
      }
      signUp(this.signUpFrom).then(res=>{
        if (res.code == 200){
          this.$message.success(res.msg)
        }else {
          this.$message.warning(res.msg)
        }
        this.open3=false
      })
      this.getList()
    },
    // 打开报名对话框
    signUp(item){
      console.log(item)
      this.signUpFrom.bidId=item.markId
      this.listUser()
      this.open3 = true
    },
    // 获取用户列表
    listUser(){
      listUser().then(res=>{
        this.userList=res.rows;
        console.log(this.userList)
      })
    },
    // 选择公告
    selectionAnnouncemen(item){
      this.form.announcementId=item.listId
      this.open2=false
    },
    // 公告类型过滤
    filterHandler(value, row, column) {
      return row['announcementType'] + "" == value;
    },
    // 公告类型转换
    getAnnouncementType(type) {
      if (type == 1) {
        return "招标预告";
      } else if (type == 2) {
        return "招标公告";
      } else if (type == 3) {
        return "中标公告";
      } else if (type == 4) {
        return "企业采购";
      }
    },
    // 获取公告列表
    getAnnouncementList(){
      getListByPage({
        pageIndex: this.mark.currentPage,
        pageSize: this.mark.pageSize,
        listType: 1,
      }).then(res=>{
        this.mark.list=res.data
        this.mark.total=res.total
      })
    },
    // 打开公告对话框
    openAnnouncements(id){
      this.getAnnouncementList()
      this.mark.markId=id
      this.open2 = true
    },
    // 转换投标状态
    getBidType(type){
      if (type==0){
        return "报名成功"
      }else if (type==1){
        return "已过期"
      }else if (type==2){
        return "资质审核"
      }else if (type==3){
        return "待开标"
      }else if (type==4){
        return "开标结果"
      }else {
        return '待报名'
      }
    },
    /** 查询参与投标表列表 */
    getList() {
      this.loading = true;
      listMark(this.queryParams).then(response => {
        this.markList = response.rows;
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
        markId: null,
        endTime: null,
        announcementId: null,
        bidType: null,
        title: null
      };
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
      this.ids = selection.map(item => item.markId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加参与投标表";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const markId = row.markId || this.ids
      getMark(markId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改参与投标表";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.markId != null) {
            updateMark(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addMark(this.form).then(response => {
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
      const markIds = row.markId || this.ids;
      this.$modal.confirm('是否确认删除参与投标表编号为"' + markIds + '"的数据项？').then(function() {
        return delMark(markIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('procurementManagement/mark/export', {
        ...this.queryParams
      }, `mark_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
