<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="流水号" prop="serialNo">
        <el-input
          v-model="queryParams.serialNo"
          placeholder="请输入流水号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="生产计划id" prop="productionPlanId">
        <el-input
          v-model="queryParams.productionPlanId"
          placeholder="请输入生产计划id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="物料id" prop="materialId">
        <el-input
          v-model="queryParams.materialId"
          placeholder="请输入物料id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="bomid" prop="bomId">
        <el-input
          v-model="queryParams.bomId"
          placeholder="请输入bomid"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="工厂id" prop="factoryId">
        <el-input
          v-model="queryParams.factoryId"
          placeholder="请输入工厂id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="工艺id" prop="technologyId">
        <el-input
          v-model="queryParams.technologyId"
          placeholder="请输入工艺id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="待产数量" prop="producedQuantity">
        <el-input
          v-model="queryParams.producedQuantity"
          placeholder="请输入待产数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="已产数量" prop="quantityProduced">
        <el-input
          v-model="queryParams.quantityProduced"
          placeholder="请输入已产数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="生产日期" prop="manufactureDate">
        <el-date-picker clearable
          v-model="queryParams.manufactureDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择生产日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="交货日期" prop="deliveryDate">
        <el-date-picker clearable
          v-model="queryParams.deliveryDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择交货日期">
        </el-date-picker>
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
          v-hasPermi="['productionScheduling:productionScheduling:add']"
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
          v-hasPermi="['productionScheduling:productionScheduling:edit']"
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
          v-hasPermi="['productionScheduling:productionScheduling:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['productionScheduling:productionScheduling:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="productionSchedulingList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="流水号" align="center" prop="serialNo" />
      <el-table-column label="生产计划id" align="center" prop="productionPlanId" />
      <el-table-column label="物料id" align="center" prop="materialId" />
      <el-table-column label="bomid" align="center" prop="bomId" />
      <el-table-column label="工厂id" align="center" prop="factoryId" />
      <el-table-column label="工艺id" align="center" prop="technologyId" />
      <el-table-column label="待产数量" align="center" prop="producedQuantity" />
      <el-table-column label="已产数量" align="center" prop="quantityProduced" />
      <el-table-column label="生产日期" align="center" prop="manufactureDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.manufactureDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="交货日期" align="center" prop="deliveryDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.deliveryDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="发布状态：0未发布，1已下发" align="center" prop="status" />
      <el-table-column label="领料状态：0未领料，1已领料" align="center" prop="pickingStatus" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['productionScheduling:productionScheduling:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['productionScheduling:productionScheduling:remove']"
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

    <!-- 添加或修改计划排产对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="流水号" prop="serialNo">
          <el-input v-model="form.serialNo" placeholder="请输入流水号" />
        </el-form-item>
        <el-form-item label="生产计划id" prop="productionPlanId">
          <el-input v-model="form.productionPlanId" placeholder="请输入生产计划id" />
        </el-form-item>
        <el-form-item label="物料id" prop="materialId">
          <el-input v-model="form.materialId" placeholder="请输入物料id" />
        </el-form-item>
        <el-form-item label="bomid" prop="bomId">
          <el-input v-model="form.bomId" placeholder="请输入bomid" />
        </el-form-item>
        <el-form-item label="工厂id" prop="factoryId">
          <el-input v-model="form.factoryId" placeholder="请输入工厂id" />
        </el-form-item>
        <el-form-item label="工艺id" prop="technologyId">
          <el-input v-model="form.technologyId" placeholder="请输入工艺id" />
        </el-form-item>
        <el-form-item label="待产数量" prop="producedQuantity">
          <el-input v-model="form.producedQuantity" placeholder="请输入待产数量" />
        </el-form-item>
        <el-form-item label="已产数量" prop="quantityProduced">
          <el-input v-model="form.quantityProduced" placeholder="请输入已产数量" />
        </el-form-item>
        <el-form-item label="生产日期" prop="manufactureDate">
          <el-date-picker clearable
            v-model="form.manufactureDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择生产日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="交货日期" prop="deliveryDate">
          <el-date-picker clearable
            v-model="form.deliveryDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择交货日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
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
import { listProductionScheduling, getProductionScheduling, delProductionScheduling, addProductionScheduling, updateProductionScheduling } from "@/api/productionScheduling/productionScheduling";

export default {
  name: "ProductionScheduling",
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
      // 计划排产表格数据
      productionSchedulingList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        serialNo: null,
        productionPlanId: null,
        materialId: null,
        bomId: null,
        factoryId: null,
        technologyId: null,
        producedQuantity: null,
        quantityProduced: null,
        manufactureDate: null,
        deliveryDate: null,
        status: null,
        pickingStatus: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询计划排产列表 */
    getList() {
      this.loading = true;
      listProductionScheduling(this.queryParams).then(response => {
        this.productionSchedulingList = response.rows;
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
        serialNo: null,
        productionPlanId: null,
        materialId: null,
        bomId: null,
        factoryId: null,
        technologyId: null,
        producedQuantity: null,
        quantityProduced: null,
        manufactureDate: null,
        deliveryDate: null,
        status: null,
        pickingStatus: null,
        remark: null
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
      this.title = "添加计划排产";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getProductionScheduling(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改计划排产";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateProductionScheduling(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addProductionScheduling(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除计划排产编号为"' + ids + '"的数据项？').then(function() {
        return delProductionScheduling(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('productionScheduling/productionScheduling/export', {
        ...this.queryParams
      }, `productionScheduling_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
