package com.zhonghui.procurement.domain;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
* 采购—企业信息提交表
* @TableName procurement_snapshot_information
*/
public class ProcurementSnapshotInformation implements Serializable {

    /**
    * id
    */
    @NotNull(message="[id]不能为空")
    @ApiModelProperty("id")
    private Integer id;
    /**
    * 公司简介
    */
    @NotBlank(message="[公司简介]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("公司简介")
    @Length(max= 255,message="编码长度不能超过255")
    private String companyProfile;
    /**
    * 营业执照有效期
    */
    @NotNull(message="[营业执照有效期]不能为空")
    @ApiModelProperty("营业执照有效期")
    private Date validityPeriodOfBusinessLicense;
    /**
    * 注册资本（万元）
    */
    @NotBlank(message="[注册资本（万元）]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("注册资本（万元）")
    @Length(max= 255,message="编码长度不能超过255")
    private String registeredCapital;
    /**
    * 单位注册地址
    */
    @NotBlank(message="[单位注册地址]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("单位注册地址")
    @Length(max= 255,message="编码长度不能超过255")
    private String unitRegisteredAddress;
    /**
    * 单位注册电话
    */
    @NotBlank(message="[单位注册电话]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("单位注册电话")
    @Length(max= 255,message="编码长度不能超过255")
    private String unitRegistrationTelephone;
    /**
    * 开户行地址
    */
    @NotBlank(message="[开户行地址]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("开户行地址")
    @Length(max= 255,message="编码长度不能超过255")
    private String openingAddress;
    /**
    * 银行账号
    */
    @NotBlank(message="[银行账号]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("银行账号")
    @Length(max= 255,message="编码长度不能超过255")
    private String bankAccountNumber;
    /**
    * 开户行
    */
    @NotBlank(message="[开户行]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("开户行")
    @Length(max= 255,message="编码长度不能超过255")
    private String bankOfDeposit;
    /**
    * 实缴资本
    */
    @NotBlank(message="[实缴资本]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("实缴资本")
    @Length(max= 255,message="编码长度不能超过255")
    private String paidInCapital;
    /**
    * 经营范围
    */
    @NotBlank(message="[经营范围]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("经营范围")
    @Length(max= 255,message="编码长度不能超过255")
    private String businessScope;
    /**
    * 单位联系地址
    */
    @NotBlank(message="[单位联系地址]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("单位联系地址")
    @Length(max= 255,message="编码长度不能超过255")
    private String corporateContactAddress;
    /**
    * 法人身份证
    */
    @NotBlank(message="[法人身份证]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("法人身份证")
    @Length(max= 255,message="编码长度不能超过255")
    private String corporateIdentityCard;
    /**
    * 法人
    */
    @NotBlank(message="[法人]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("法人")
    @Length(max= 255,message="编码长度不能超过255")
    private String legalPerson;
    /**
    * 企业名称
    */
    @NotBlank(message="[企业名称]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("企业名称")
    @Length(max= 255,message="编码长度不能超过255")
    private String enterpriseName;
    /**
    * 统一社会信用代码
    */
    @NotBlank(message="[统一社会信用代码]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("统一社会信用代码")
    @Length(max= 255,message="编码长度不能超过255")
    private String unifiedSocialInformationCode;
    /**
    * 公司注册地址
    */
    @NotBlank(message="[公司注册地址]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("公司注册地址")
    @Length(max= 255,message="编码长度不能超过255")
    private String companyRegisteredAddress;
    /**
    * 机构类型
    */
    @NotBlank(message="[机构类型]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("机构类型")
    @Length(max= 255,message="编码长度不能超过255")
    private String mechanismType;
    /**
    * 企业性质
    */
    @NotBlank(message="[企业性质]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("企业性质")
    @Length(max= 255,message="编码长度不能超过255")
    private String natureOfEnterprise;
    /**
    * 成立日期
    */
    @NotNull(message="[成立日期]不能为空")
    @ApiModelProperty("成立日期")
    private Date dateOfEstablishment;
    /**
    * 法人身份证扫描件
    */
    @NotBlank(message="[法人身份证扫描件]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("法人身份证扫描件")
    @Length(max= 255,message="编码长度不能超过255")
    private String scLegalPersonIdCard;
    /**
    * 营业执照扫描件
    */
    @NotBlank(message="[营业执照扫描件]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("营业执照扫描件")
    @Length(max= 255,message="编码长度不能超过255")
    private String scBusinessLicense;
    /**
    * 开户许可证
    */
    @NotBlank(message="[开户许可证]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("开户许可证")
    @Length(max= 255,message="编码长度不能超过255")
    private String accountOpeningPermit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyProfile() {
        return companyProfile;
    }

    public void setCompanyProfile(String companyProfile) {
        this.companyProfile = companyProfile;
    }

    public Date getValidityPeriodOfBusinessLicense() {
        return validityPeriodOfBusinessLicense;
    }

    public void setValidityPeriodOfBusinessLicense(Date validityPeriodOfBusinessLicense) {
        this.validityPeriodOfBusinessLicense = validityPeriodOfBusinessLicense;
    }

    public String getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getUnitRegisteredAddress() {
        return unitRegisteredAddress;
    }

    public void setUnitRegisteredAddress(String unitRegisteredAddress) {
        this.unitRegisteredAddress = unitRegisteredAddress;
    }

    public String getUnitRegistrationTelephone() {
        return unitRegistrationTelephone;
    }

    public void setUnitRegistrationTelephone(String unitRegistrationTelephone) {
        this.unitRegistrationTelephone = unitRegistrationTelephone;
    }

    public String getOpeningAddress() {
        return openingAddress;
    }

    public void setOpeningAddress(String openingAddress) {
        this.openingAddress = openingAddress;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankOfDeposit() {
        return bankOfDeposit;
    }

    public void setBankOfDeposit(String bankOfDeposit) {
        this.bankOfDeposit = bankOfDeposit;
    }

    public String getPaidInCapital() {
        return paidInCapital;
    }

    public void setPaidInCapital(String paidInCapital) {
        this.paidInCapital = paidInCapital;
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    public String getCorporateContactAddress() {
        return corporateContactAddress;
    }

    public void setCorporateContactAddress(String corporateContactAddress) {
        this.corporateContactAddress = corporateContactAddress;
    }

    public String getCorporateIdentityCard() {
        return corporateIdentityCard;
    }

    public void setCorporateIdentityCard(String corporateIdentityCard) {
        this.corporateIdentityCard = corporateIdentityCard;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getUnifiedSocialInformationCode() {
        return unifiedSocialInformationCode;
    }

    public void setUnifiedSocialInformationCode(String unifiedSocialInformationCode) {
        this.unifiedSocialInformationCode = unifiedSocialInformationCode;
    }

    public String getCompanyRegisteredAddress() {
        return companyRegisteredAddress;
    }

    public void setCompanyRegisteredAddress(String companyRegisteredAddress) {
        this.companyRegisteredAddress = companyRegisteredAddress;
    }

    public String getMechanismType() {
        return mechanismType;
    }

    public void setMechanismType(String mechanismType) {
        this.mechanismType = mechanismType;
    }

    public String getNatureOfEnterprise() {
        return natureOfEnterprise;
    }

    public void setNatureOfEnterprise(String natureOfEnterprise) {
        this.natureOfEnterprise = natureOfEnterprise;
    }

    public Date getDateOfEstablishment() {
        return dateOfEstablishment;
    }

    public void setDateOfEstablishment(Date dateOfEstablishment) {
        this.dateOfEstablishment = dateOfEstablishment;
    }

    public String getScLegalPersonIdCard() {
        return scLegalPersonIdCard;
    }

    public void setScLegalPersonIdCard(String scLegalPersonIdCard) {
        this.scLegalPersonIdCard = scLegalPersonIdCard;
    }

    public String getScBusinessLicense() {
        return scBusinessLicense;
    }

    public void setScBusinessLicense(String scBusinessLicense) {
        this.scBusinessLicense = scBusinessLicense;
    }

    public String getAccountOpeningPermit() {
        return accountOpeningPermit;
    }

    public void setAccountOpeningPermit(String accountOpeningPermit) {
        this.accountOpeningPermit = accountOpeningPermit;
    }
}
