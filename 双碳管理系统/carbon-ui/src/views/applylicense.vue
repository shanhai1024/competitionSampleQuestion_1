<template>
  <div class="login">
    <div
      style="display: flex; justify-content: space-between; align-items: center"
    >
      <el-form
        ref="licenseForm"
        :model="licenseForm"
        :rules="licenseRules"
        label-position="left"
        label-width="100px"
        class="login-form"
      >
        <h3 class="title">
          {{ title }}
        </h3>
        <el-form-item label="申请学校" prop="collage">
          <el-input
            v-model="licenseForm.collage"
            disabled
            style="width: 370px"
          />
        </el-form-item>

        <el-form-item label="申请证书id" prop="licenseId">
          <el-input v-model="licenseForm.licenseId" style="width: 370px" />
        </el-form-item>
        <el-form-item label="申请人姓名" prop="studentName">
          <el-input v-model="licenseForm.studentName" style="width: 370px" />
        </el-form-item>
        <el-form-item label="申请人电话" prop="mobilePhone">
          <el-input v-model="licenseForm.mobilePhone" style="width: 370px" />
        </el-form-item>

        <el-form-item label="短信验证码" prop="smsCode">
          <el-input v-model="licenseForm.smsCode" style="width: 63%" />
          <div class="login-code">
            <el-button
              v-if="showText"
              type="primary"
              class="submission"
              @click="sendSMS()"
            >
              <span> 获取验证码 </span>
            </el-button>
            <el-button v-else type="primary" class="submission" disabled>
              <span> 重新发送（{{ second }}s） </span>
            </el-button>
          </div>
        </el-form-item>
        <el-button
          style="display: block; margin: 0 auto"
          :disabled="disable"
          :loading="loading"
          type="primary"
          class="submission"
          @click="handleSubmit('licenseForm')"
        >
          <span v-if="!loading">申请证书 </span>
          <span v-else>证书申请...</span>
        </el-button>
      </el-form>
    </div>
    <!--  底部  -->
    <div v-if="$store.state.settings.showFooter" id="el-login-footer">
      <span v-html="$store.state.settings.footerTxt" />
    </div>
  </div>
</template>

<script>
import { apply, getLicense, getSMS } from "@/api/yxLicense";
import { getCodeImg } from "@/api/login";
import { shutdown } from "../api/yxLicense";
import { isvalidPhone } from "@/utils/validate";
export default {
  name: "applylicense",
  data() {
    const validPhone = (rule, value, callback) => {
      if (!value) {
        callback(new Error("请输入电话号码"));
      } else if (!isvalidPhone(value)) {
        callback(new Error("请输入正确的11位手机号码"));
      } else {
        callback();
      }
    };
    return {
      imgUrl: process.env.VUE_APP_BASE_API,
      codeUrl: "",
      loading: false,
      disable: false,
      licenseForm: {},
      title: "",
      second: 120,
      showText: true,
      licenseRules: {
        studentName: [
          {
            required: true,
            message: "请输入申请人姓名",
            trigger: "blur",
          },
        ],

        mobilePhone: [
          {
            required: true,
            message: "请输入申请人电话",
            trigger: "blur",
            validator: validPhone,
          },
        ],
        code: [
          {
            required: true,
            trigger: "blur",
            message: "验证码不能为空",
          },
        ],
        licenseId: [
          {
            required: true,
            trigger: "blur",
            message: "申请证书id不能为空",
          },
        ],
        smsCode: [
          {
            required: true,
            trigger: "blur",
            message: "短信验证码不能为空",
          },
        ],
      },
      licenseRules1: {
        mobilePhone: [
          {
            required: true,
            message: "请输入申请人电话",
            trigger: "blur",
            validator: validPhone,
          },
        ],
        code: [
          {
            required: true,
            trigger: "blur",
            message: "验证码不能为空",
          },
        ],
      },
    };
  },
  created() {
    getLicense().then((res) => {
      console.log(res);
      if (res === "证书校验成功") {
        this.$router.push("/login");
      }
    });
    this.getCode();
    this.title = "系统没有证书无法启动，请先申请证书";
  },
  methods: {
    getCode() {
      getCodeImg().then((res) => {
        this.codeUrl = "data:image/gif;base64," + res.img;
        this.licenseForm.uuid = res.uuid;
        this.licenseForm.collage = res.productCompany;
      });
    },
    handleSubmit(name) {
      this.$refs[name].validate((valid) => {
        if (valid) {
          this.loading = true;
          apply(this.licenseForm)
            .then((res) => {
              this.title = "证书申请成功,正在安装证书！";
              this.loading = false;
              this.disable = true;
              shutdown(this.licenseForm).then((res) => {
                this.$router.push("/login");
              });
            })
            .catch(() => {
              this.loading = false;
              this.getCode();
            });
        } else {
          return false;
        }
      });
    },
    sendSMS() {
      if (!this.licenseForm.mobilePhone) {
        this.$message.warning("手机号没有录入！");
        return;
      }

      getSMS(this.licenseForm)
        .then((res) => {
          if (res.data.code == "OK") {
            var that = this;
            var interval = setInterval(() => {
              that.showText = false;
              var times = that.second - 1;
              that.second = times;
            }, 1000);
            setTimeout(() => {
              clearInterval(interval);
              that.second = 120;
              that.showText = true;
            }, 120000);
            this.$message.success("短信发送成功，请查收！");
            this.getCode();
          }
        })
        .catch(() => {
          this.getCode();
        });
    },
  },
};
</script>

<style rel="stylesheet/scss" lang="scss">
.login {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  background-image: url("../assets/images/login-background.jpg");
  background-size: cover;
}

.title {
  margin: 0 auto 30px auto;
  text-align: center;
  color: #707070;
}

.login-form {
  border-radius: 6px;
  background: #ffffff;
  width: 585px;
  padding: 25px 25px 5px 25px;

  .el-input {
    height: 38px;

    input {
      height: 38px;
    }
  }

  .input-icon {
    height: 39px;
    width: 14px;
    margin-left: 2px;
  }
}

.login-tip {
  font-size: 13px;
  text-align: center;
  color: #bfbfbf;
}

.login-code {
  width: 33%;
  display: inline-block;
  height: 38px;
  float: right;

  img {
    width: 80%;
    height: 100%;
    cursor: pointer;
    vertical-align: middle;
  }
}
</style>
