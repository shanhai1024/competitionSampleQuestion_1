<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="企业名称" prop="enterpriseName">
        <el-input
          v-model="queryParams.enterpriseName"
          placeholder="请输入企业名称"
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
          v-hasPermi="['procurementManagement:enterpriseInformation:add']"
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
          v-hasPermi="['procurementManagement:enterpriseInformation:edit']"
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
          v-hasPermi="['procurementManagement:enterpriseInformation:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['procurementManagement:enterpriseInformation:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="enterpriseInformationList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="企业id" align="center" prop="id" />
      <el-table-column label="用户id" align="center" prop="userId" />
      <el-table-column label="用户名称" align="center">
        <template slot-scope="scope">
          {{ selectUserListById(scope.row.id) }}
        </template>
      </el-table-column>
      <el-table-column label="银行账号" align="center" prop="bankAccountNumber" />
      <el-table-column label="单位联系地址" align="center" prop="corporateContactAddress" />
      <el-table-column label="法人" align="center" prop="legalPerson" />
      <el-table-column label="企业名称" align="center" prop="enterpriseName" />
      <el-table-column label="企业性质" align="center" prop="natureOfEnterprise" />
      <el-table-column label="成立日期" align="center" prop="dateOfEstablishment" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.dateOfEstablishment, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['procurementManagement:enterpriseInformation:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['procurementManagement:enterpriseInformation:remove']"
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

    <!-- 添加或修改采购—企业信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="600px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="135px">
        <el-form-item label="用户" prop="userId">
          <el-select v-model="form.userId" label="label" placeholder="请选择用户">
            <el-option v-for="item in userList" :label="item.userName" :value="item.userId"/>
          </el-select>
        </el-form-item>
        <el-form-item label="公司简介" prop="companyProfile">
          <el-input v-model="form.companyProfile" placeholder="请输入公司简介" />
        </el-form-item>
        <el-form-item label="营业执照有效期" prop="validityPeriodOfBusinessLicense">
          <el-date-picker clearable
            v-model="form.validityPeriodOfBusinessLicense"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择营业执照有效期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="注册资本" prop="registeredCapital">
          <el-input v-model="form.registeredCapital" placeholder="请输入注册资本" />
        </el-form-item>
        <el-form-item label="单位注册地址" prop="unitRegisteredAddress">
          <el-input v-model="form.unitRegisteredAddress" placeholder="请输入单位注册地址" />
        </el-form-item>
        <el-form-item label="单位注册电话" prop="unitRegistrationTelephone">
          <el-input v-model="form.unitRegistrationTelephone" placeholder="请输入单位注册电话" />
        </el-form-item>
        <el-form-item label="开户行地址" prop="openingAddress">
          <el-input v-model="form.openingAddress" placeholder="请输入开户行地址" />
        </el-form-item>
        <el-form-item label="银行账号" prop="bankAccountNumber">
          <el-input v-model="form.bankAccountNumber" placeholder="请输入银行账号" />
        </el-form-item>
        <el-form-item label="开户行" prop="bankOfDeposit">
          <el-input v-model="form.bankOfDeposit" placeholder="请输入开户行" />
        </el-form-item>
        <el-form-item label="实缴资本" prop="paidInCapital">
          <el-input v-model="form.paidInCapital" placeholder="请输入实缴资本" />
        </el-form-item>
        <el-form-item label="经营范围" prop="businessScope">
          <el-input v-model="form.businessScope" placeholder="请输入经营范围" />
        </el-form-item>
        <el-form-item label="单位联系地址" prop="corporateContactAddress">
          <el-input v-model="form.corporateContactAddress" placeholder="请输入单位联系地址" />
        </el-form-item>
        <el-form-item label="法人身份证" prop="corporateIdentityCard">
          <el-input v-model="form.corporateIdentityCard" placeholder="请输入法人身份证" />
        </el-form-item>
        <el-form-item label="法人" prop="legalPerson">
          <el-input v-model="form.legalPerson" placeholder="请输入法人" />
        </el-form-item>
        <el-form-item label="企业名称" prop="enterpriseName">
          <el-input v-model="form.enterpriseName" placeholder="请输入企业名称" />
        </el-form-item>
        <el-form-item label="统一社会信用代码" prop="unifiedSocialInformationCode">
          <el-input v-model="form.unifiedSocialInformationCode" placeholder="请输入统一社会信用代码" />
        </el-form-item>
        <el-form-item label="公司注册地址" prop="companyRegisteredAddress">
          <el-input v-model="form.companyRegisteredAddress" placeholder="请输入公司注册地址" />
        </el-form-item>
        <el-form-item label="机构类型" prop="mechanismType">
          <el-input v-model="form.mechanismType" placeholder="请输入机构类型" />
        </el-form-item>
        <el-form-item label="企业性质" prop="natureOfEnterprise">
          <el-input v-model="form.natureOfEnterprise" placeholder="请输入企业性质" />
        </el-form-item>
        <el-form-item label="成立日期" prop="dateOfEstablishment">
          <el-date-picker clearable
            v-model="form.dateOfEstablishment"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择成立日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="法人身份证扫描件" prop="scLegalPersonIdCard">
          <el-upload
            ref="elUpload1"
            class="upload-demo"
            :action="this.$BASEUSER + '/procurement/FileUpload'"
            :on-success="onSuccessIdentityCard"
            :before-upload="beforeUpload"
            :limit="1"
          >
            <el-button size="small" type="success" icon="el-icon-upload2"
            >上传</el-button
            >
          </el-upload>
        </el-form-item>
        <el-form-item label="营业执照扫描件" prop="scBusinessLicense">
          <el-upload
            ref="elUpload2"
            class="upload-demo"
            :action="this.$BASEUSER + '/procurement/FileUpload'"
            :on-success="onSuccessLicense"
            :limit="1"
          >
            <el-button size="small" type="success" icon="el-icon-upload2"
            >上传</el-button
            >
          </el-upload>
        </el-form-item>
        <el-form-item label="开户许可证" prop="accountOpeningPermit">
          <el-input v-model="form.accountOpeningPermit" placeholder="请输入开户许可证" />
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
import { listEnterpriseInformation, getEnterpriseInformation, delEnterpriseInformation, addEnterpriseInformation, updateEnterpriseInformation } from "@/api/procurementManagement/enterpriseInformation";
import {listUser} from '@/api/system/user.js'
import log from '@/views/monitor/job/log.vue'
export default {
  name: "EnterpriseInformation",
  data() {
    return {
      // 用户列表
      userList:[],
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
      // 采购—企业信息表格数据
      enterpriseInformationList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        enterpriseName: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        userId: [
          { required: true, message: "用户id不能为空", trigger: "blur" }
        ],
        companyProfile: [
          { required: true, message: "公司简介不能为空", trigger: "blur" }
        ],
        validityPeriodOfBusinessLicense: [
          { required: true, message: "营业执照有效期不能为空", trigger: "blur" }
        ],
        registeredCapital: [
          { required: true, message: "注册资本不能为空", trigger: "blur" }
        ],
        unitRegisteredAddress: [
          { required: true, message: "单位注册地址不能为空", trigger: "blur" }
        ],
        unitRegistrationTelephone: [
          { required: true, message: "单位注册电话不能为空", trigger: "blur" }
        ],
        openingAddress: [
          { required: true, message: "开户行地址不能为空", trigger: "blur" }
        ],
        bankAccountNumber: [
          { required: true, message: "银行账号不能为空", trigger: "blur" }
        ],
        bankOfDeposit: [
          { required: true, message: "开户行不能为空", trigger: "blur" }
        ],
        paidInCapital: [
          { required: true, message: "实缴资本不能为空", trigger: "blur" }
        ],
        businessScope: [
          { required: true, message: "经营范围不能为空", trigger: "blur" }
        ],
        corporateContactAddress: [
          { required: true, message: "单位联系地址不能为空", trigger: "blur" }
        ],
        corporateIdentityCard: [
          { required: true, message: "法人身份证不能为空", trigger: "blur" }
        ],
        legalPerson: [
          { required: true, message: "法人不能为空", trigger: "blur" }
        ],
        enterpriseName: [
          { required: true, message: "企业名称不能为空", trigger: "blur" }
        ],
        unifiedSocialInformationCode: [
          { required: true, message: "统一社会信用代码不能为空", trigger: "blur" }
        ],
        companyRegisteredAddress: [
          { required: true, message: "公司注册地址不能为空", trigger: "blur" }
        ],
        mechanismType: [
          { required: true, message: "机构类型不能为空", trigger: "change" }
        ],
        natureOfEnterprise: [
          { required: true, message: "企业性质不能为空", trigger: "blur" }
        ],
        dateOfEstablishment: [
          { required: true, message: "成立日期不能为空", trigger: "blur" }
        ],
        accountOpeningPermit: [
          { required: true, message: "开户许可证不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
    this.listUser()
  },
  methods: {
    // 根据用户id过滤用户列表，返回用户名称
    selectUserListById(userId){
      for (let i=0;i<this.userList.length;i++){
        if (this.userList[i].userId==userId){
          return this.userList[i].userName;
        }
      }
    },
    // 获取用户列表
    listUser(){
      listUser().then(res=>{
        this.userList=res.rows;
      })
    },
    // 法人身份证扫描件上传成功函数
    onSuccessIdentityCard(response, file, fileList) {
      this.form.scLegalPersonIdCard = response.data;
    },
    // 营业执照扫描件上传成功函数
    onSuccessLicense(response, file, fileList) {
      this.form.scBusinessLicense = response.data;
    },
    // 文件验证
    beforeUpload(file) {
      console.log(file);
      if (file.type != "image/png" && file.type != "image/jpeg") {
        this.$message.warning("只能上传png/jpg文件");
        return false;
      }
    },
    /** 查询采购—企业信息列表 */
    getList() {
      this.loading = true;
      listEnterpriseInformation(this.queryParams).then(response => {
        this.enterpriseInformationList = response.rows;
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
        id: null,
        userId: null,
        companyProfile: null,
        validityPeriodOfBusinessLicense: null,
        registeredCapital: null,
        unitRegisteredAddress: null,
        unitRegistrationTelephone: null,
        openingAddress: null,
        bankAccountNumber: null,
        bankOfDeposit: null,
        paidInCapital: null,
        businessScope: null,
        corporateContactAddress: null,
        corporateIdentityCard: null,
        legalPerson: null,
        enterpriseName: null,
        unifiedSocialInformationCode: null,
        companyRegisteredAddress: null,
        mechanismType: null,
        natureOfEnterprise: null,
        dateOfEstablishment: null,
        scLegalPersonIdCard: null,
        scBusinessLicense: null,
        accountOpeningPermit: null
      };
      this.$nextTick(()=>{
        this.$refs.elUpload1.clearFiles();
        this.$refs.elUpload2.clearFiles();
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
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加采购—企业信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getEnterpriseInformation(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改采购—企业信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.scLegalPersonIdCard==null || this.form.scBusinessLicense==null){
            this.$message.warning('请上传法人身份证扫描件和营业执照扫描件！')
            return
          }
          if (this.form.id != null) {
            updateEnterpriseInformation(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addEnterpriseInformation(this.form).then(response => {
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
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除采购—企业信息编号为"' + ids + '"的数据项？').then(function() {
        return delEnterpriseInformation(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('procurementManagement/enterpriseInformation/export', {
        ...this.queryParams
      }, `enterpriseInformation_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
