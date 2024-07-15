<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="120px">
      <el-form-item label="标id" prop="bidId">
        <el-input
          v-model="queryParams.bidId"
          placeholder="请输入标id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="企业资料快照id" prop="snapshotInformation">
        <el-input
          v-model="queryParams.snapshotInformation"
          placeholder="请输入企业资料快照id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户id" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入用户id"
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
          v-hasPermi="['procurementManagement:bid:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['procurementManagement:bid:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['procurementManagement:bid:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="bidList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="标标题" align="center" prop="pmMark.title" />
      <el-table-column label="标标状态" align="center" prop="pmMark.bidType" >
        <template slot-scope="scope">
          {{ getBidType(scope.row.pmMark.bidType) }}
        </template>
      </el-table-column>
      <el-table-column label="企业资料名称" align="center" prop="procurementSnapshotInformation.enterpriseName" />
      <el-table-column label="用户id" align="center" prop="userId" >
        <template slot-scope="scope">
          {{ selectUserListById(scope.row.userId) }}
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            v-if="scope.row.pmMark.bidType==0"
            size="mini"
            type="text"
            icon="el-icon-share"
            @click="openSubmitInformation(scope.row)"
          >提交资料</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['procurementManagement:bid:remove']"
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

    <!-- 添加或修改我的投标对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="600px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="110px">
        <el-form-item label="标id" prop="bidId">
          <el-input style="width:300px;margin-right: 25px;" disabled v-model="form.bidId" placeholder="请输入标id" />
          <el-button type="primary" @click="markOpen">选择</el-button>
        </el-form-item>
        <el-form-item label="标标题" prop="title">
          <el-input disabled v-model="form.bidId" placeholder="请输入标标标题" />
        </el-form-item>
        <el-form-item label="结束时间" prop="endTime">
          <el-input disabled v-model="form.bidId" placeholder="请输入标结束时间" />
        </el-form-item>
        <el-form-item label="用户id" prop="userId">
          <el-select v-model="form.userId" placeholder="请选择报名用户">
            <el-option v-for="item in userList" :label="item.userName+' / '+item.userId" :value="item.userId"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  <!-- 选择标列表对话框 -->
    <el-dialog title="选择标" :visible.sync="open2" width="900px" append-to-body>
      <el-table
        :data="mark.list"
        style="width: 100%">
        <el-table-column
          prop="markId"
          align="center"
          label="标id"
          width="55">
        </el-table-column>
        <el-table-column
          prop="title"
          align="center"
          label="标标题"
          width="500">
        </el-table-column>
        <el-table-column
          prop="endTime"
          align="center"
          label="结束时间">
        </el-table-column>
        <el-table-column
          prop="bidType"
          align="center"
          label="标状态">
          <template slot-scope="scope">
            {{ getBidType(scope.row.bidType) }}
          </template>
        </el-table-column>
        <el-table-column
          prop="address"
          align="center"
          label="操作">
          <template slot-scope="scope">
            <el-button @click="markSelection(scope.row)" type="text">选择</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-pagination
        style="padding-top: 20px;"
        background
        layout="prev, pager, next"
        :total="mark.total"
        :page-size="mark.pageSize"
        :current-page.sync="mark.currentPage"
        @current-change="getMarkList"
      ></el-pagination>
    </el-dialog>
    <!--  提交资料  -->
    <el-dialog title="提交资料" :visible.sync="open3" :before-close="beforeClose" width="900px"  append-to-body>
      <span>
            <div class="items">
      <div class="item">
        <div>企业名称：</div>
        <div>{{ data.enterpriseName }}</div>
      </div>
      <div class="item">
        <div>统一社会信用代码：</div>
        <div>{{ data.unifiedSocialInformationCode }}</div>
      </div>
      <div class="item">
        <div>公司注册地址：</div>
        <div>{{ data.companyRegisteredAddress }}</div>
      </div>
      <div class="item">
        <div>机构类型：</div>
        <div>{{ data.mechanismType }}</div>
      </div>
      <div class="item">
        <div>企业性质：</div>
        <div>{{ data.natureOfEnterprise }}</div>
      </div>
      <div class="item">
        <div>成立日期：</div>
        <div>{{ data.dateOfEstablishment }}</div>
      </div>
      <div class="item">
        <div>法人：</div>
        <div>{{ data.legalPerson }}</div>
      </div>
      <div class="item">
        <div>法人身份证：</div>
        <div>{{ data.corporateIdentityCard }}</div>
      </div>
      <div class="item">
        <div>单位联系地址：</div>
        <div>{{ data.corporateContactAddress }}</div>
      </div>
      <div class="item">
        <div>经营范围：</div>
        <div>{{ data.businessScope }}</div>
      </div>
      <div class="item">
        <div>营业执照扫描件：</div>
        <div>
          <el-button
            type="text"
            @click="$refs.elImageBusiness.showViewer = true"
          >查看</el-button
          >
          <el-image
            ref="elImageBusiness"
            style="display: none"
            :preview-src-list="[
              this.$BASEUSER + '/profile/' + data.scBusinessLicense,
            ]"
          ></el-image>
        </div>
      </div>
      <div class="item">
        <div>法人身份证扫描件：</div>
        <div>
          <el-button
            type="text"
            @click="$refs.elImageLegalPerson.showViewer = true"
          >查看</el-button
          >
          <el-image
            ref="elImageLegalPerson"
            style="display: none"
            :preview-src-list="[
              this.$BASEUSER + '/profile/' + data.scLegalPersonIdCard,
            ]"
          ></el-image>
        </div>
      </div>
      <div class="item">
        <div>营业执照有效期：</div>
        <div>{{ data.validityPeriodOfBusinessLicense }}</div>
      </div>
      <div class="item">
        <div>公司简介：</div>
        <div>{{ data.companyProfile }}</div>
      </div>
      <div class="item">
        <div>开户行：</div>
        <div>{{ data.bankOfDeposit }}</div>
      </div>
      <div class="item">
        <div>银行账号：</div>
        <div>{{ data.bankAccountNumber }}</div>
      </div>
      <div class="item">
        <div>开户行地址：</div>
        <div>{{ data.openingAddress }}</div>
      </div>
      <div class="item">
        <div>单位注册电话：</div>
        <div>{{ data.unitRegistrationTelephone }}</div>
      </div>
      <div class="item">
        <div>单位注册地址：</div>
        <div>{{ data.unitRegisteredAddress }}</div>
      </div>
      <div class="item">
        <div>注册资本（万元）：</div>
        <div>{{ data.registeredCapital }}万</div>
      </div>
      <div class="item">
        <div>实缴资本：</div>
        <div>{{ data.paidInCapital }}万</div>
      </div>
      <div class="item">
        <div>开户许可证：</div>
        <div>
          {{ data.accountOpeningPermit }}
        </div>
      </div>
    </div>
    <div class="upload">
      <div style="margin-right: 20px; margin-top: 15px">资料上传：</div>
      <div>
        <el-upload
          ref="elUpload"
          class="upload-demo"
          :action="this.$BASEUSER + '/procurement/FileUpload'"
          :on-success="onSuccess"
          :before-upload="beforeUpload"
          :on-exceed="onExceed"
          multiple
          :limit="10"
        >
          <el-button size="small" type="success" icon="el-icon-upload2"
          >上传</el-button
          >
          <div slot="tip" class="el-upload__tip">
            pdf/zip/rar/png/jpg/jpeg等，单文件不超过100MB，最多可上传10个文件。
          </div>
        </el-upload>
      </div>
    </div>
    <div style="text-align: center; margin-top: 20px">
      <el-button @click="setHaveBidList" type="primary">提交</el-button>
    </div>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { listBid, getBid, delBid, addBid, updateBid,getMarkList,getHaveBidById, setHaveBidList } from "@/api/procurementManagement/bid";
import { listUser } from '@/api/system/user'
import { listMark, signUp } from '@/api/procurementManagement/mark'
import ScrollPane from '@/layout/components/TagsView/ScrollPane.vue'
export default {
  name: "Bid",
  components: { ScrollPane },
  data() {
    return {
      data:[],
      fileList: [],
      InformationId:'',
      userList:[],
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
      // 我的投标表格数据
      bidList: [],
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
        bidId: null,
        snapshotInformation: null,
        userId: null,
        information: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        bidId: [
          { required: true, message: "标id不能为空", trigger: "blur" }
        ],
        userId: [
          { required: true, message: "用户id不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
    this.listUser()
  },
  methods: {
    beforeClose(){
      this.$refs.elUpload.clearFiles();
      this.fileList=[]
    },
    // 提交资料
    setHaveBidList() {
      if (this.fileList.length == 0) {
        this.$message.warning("请至少上传一个文件");
        return;
      }
      setHaveBidList({
        id: this.InformationId,
        fileList: this.fileList.join(","),
      }).then((res) => {
        if (res.code == 200) {
          this.$message.success("提交成功");
          this.open3=false
        } else {
          this.$message.warning("提交失败");
        }
        this.getList()
        this.beforeClose()
      });
    },
    // 获取
    getInfo(id) {
      getHaveBidById({ id:id }).then((res) => {
        this.data = res.data.procurementSnapshotInformation;
        console.log(res);
      });
    },
    // 文件大小验证
    beforeUpload(file) {
      console.log(file);
      if (file.size > 100 * 1024 * 1024) {
        this.$message.warning("单文件不超过100MB!");
        return false;
      }
    },
    // 文件上传成功钩子
    onSuccess(response, file, fileList) {
      this.fileList = [];
      fileList.forEach((item) => {
        this.fileList.push(item.response.data);
      });
      console.log(this.fileList);
    },
    // 文件数量超出提示
    onExceed() {
      this.$message.warning("最多可上传10个文件!");
    },
    // 打开提交资料对话框
    openSubmitInformation(item){
      this.open3 = true
      this.InformationId=item.id
      this.getInfo(item.id)
    },
    // 选择标
    markSelection(item){
      this.form.bidId=item.markId
      this.form.endTime=item.endTime
      this.form.title=item.title
      this.open2 = false
    },
    // 转换投标状态
    getBidType(type){
      if (type==0){
        return "资料待提交"
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
    // 打开标选择对话框
    markOpen(){
      this.getMarkList()
      this.open2 = true
    },
    // 查询标列表
    getMarkList(){
      listMark({
        pageNum: this.mark.currentPage,
        pageSize: this.mark.pageSize,
      }).then(res=>{
        console.log(res)
        this.mark.list=res.rows
        this.mark.list = this.mark.list.filter(function(item) {
          return item.bidType==5
        });
        this.mark.total=res.total
      })
    },
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
    // 打开标对话框
    openMark(){
      this.open2=true
      // 查询标列表
      getMarkList({
        pageIndex: this.currentPage,
        pageSize: this.pageSize,
      }).then((res) => {
        this.list = res;
      });
    },
    /** 查询我的投标列表 */
    getList() {
      this.loading = true;
      listBid(this.queryParams).then(response => {
        this.bidList = response.rows;
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
        bidId: null,
        snapshotInformation: null,
        userId: null,
        information: null
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
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加我的投标";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getBid(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改我的投标";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateBid(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            signUp({ bidId: this.form.bidId, userId: this.form.userId }).then(res=>{
              if (res.code == 200){
                this.$message.success('新增成功')
              }else {
                this.$message.warning('新增失败')
              }
            })

          }
        }
        this.open = false;
        this.getList();
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除我的投标编号为"' + ids + '"的数据项？').then(function() {
        return delBid(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('procurementManagement/bid/export', {
        ...this.queryParams
      }, `bid_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
<style scoped>
.upload {
  display: flex;
  padding-left: 80px;
  margin-top: 20px;
}
.items {
  display: flex;
  flex-wrap: wrap;
  margin-top: 25px;
}
.items > div {
  width: 50%;
}
.item {
  box-sizing: border-box;
  display: flex;
  align-items: center;
  margin: 15px 0;
  padding-left: 80px;
}
.item > div:nth-child(1) {
  margin-right: 20px;
  text-align: left;
}
.item button {
  padding: 0 !important;
}
.item > div:nth-child(2) {
  color: #666;
}
</style>
