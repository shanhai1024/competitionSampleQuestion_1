package com.zhonghui.procurement.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 采购—企业信息表
 *
 * @TableName procurement_enterprise_information
 */
@ApiModel("采购管理系统-我的标的对象")
public class ProcurementEnterpriseInformation implements Serializable {
    /**
     * 企业id
     */
    @ApiModelProperty("企业id")
    private Integer id;
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Integer userId;
    /**
     * 公司简介
     */
    @ApiModelProperty("公司简介")
    private String companyProfile;
    /**
     * 营业执照有效期
     */
    @ApiModelProperty("营业执照有效期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date validityPeriodOfBusinessLicense;
    /**
     * 注册资本（万元）
     */
    @ApiModelProperty("注册资本（万元）")
    private String registeredCapital;
    /**
     * 单位注册地址
     */
    @ApiModelProperty("单位注册地址")
    private String unitRegisteredAddress;
    /**
     * 单位注册电话
     */
    @ApiModelProperty("单位注册电话")
    private String unitRegistrationTelephone;
    /**
     * 开户行地址
     */
    @ApiModelProperty("开户行地址")
    private String openingAddress;
    /**
     * 银行账号
     */
    @ApiModelProperty("银行账号")
    private String bankAccountNumber;
    /**
     * 开户行
     */
    @ApiModelProperty("开户行")
    private String bankOfDeposit;
    /**
     * 实缴资本
     */
    @ApiModelProperty("实缴资本")
    private String paidInCapital;
    /**
     * 经营范围
     */
    @ApiModelProperty("经营范围")
    private String businessScope;
    /**
     * 单位联系地址
     */
    @ApiModelProperty("单位联系地址")
    private String corporateContactAddress;
    /**
     * 法人身份证
     */
    @ApiModelProperty("法人身份证")
    private String corporateIdentityCard;
    /**
     * 法人
     */
    @ApiModelProperty("法人")
    private String legalPerson;
    /**
     * 企业名称
     */
    @ApiModelProperty("企业名称")
    private String enterpriseName;
    /**
     * 统一社会信息代码
     */
    @ApiModelProperty("统一社会信用代码")
    private String unifiedSocialInformationCode;
    /**
     * 公司注册地址
     */
    @ApiModelProperty("公司注册地址")
    private String companyRegisteredAddress;
    /**
     * 机构类型
     */
    @ApiModelProperty("机构类型")
    private String mechanismType;
    /**
     * 企业性质
     */
    @ApiModelProperty("企业性质")
    private String natureOfEnterprise;
    /**
     * 成立日期
     */
    @ApiModelProperty("成立日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfEstablishment;
    /**
     * 法人身份证扫描件
     */
    @ApiModelProperty("法人身份证扫描件")
    private String scLegalPersonIdCard;
    /**
     * 营业执照扫描件
     */
    @ApiModelProperty("营业执照扫描件")
    private String scBusinessLicense;
    @ApiModelProperty("开户许可证")
    private String accountOpeningPermit;

    @Override
    public String toString() {
        return "ProcurementEnterpriseInformation{" +
                "id=" + id +
                ", userId=" + userId +
                ", companyProfile='" + companyProfile + '\'' +
                ", validityPeriodOfBusinessLicense=" + validityPeriodOfBusinessLicense +
                ", registeredCapital='" + registeredCapital + '\'' +
                ", unitRegisteredAddress='" + unitRegisteredAddress + '\'' +
                ", unitRegistrationTelephone='" + unitRegistrationTelephone + '\'' +
                ", openingAddress='" + openingAddress + '\'' +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                ", bankOfDeposit='" + bankOfDeposit + '\'' +
                ", paidInCapital='" + paidInCapital + '\'' +
                ", businessScope='" + businessScope + '\'' +
                ", corporateContactAddress='" + corporateContactAddress + '\'' +
                ", corporateIdentityCard='" + corporateIdentityCard + '\'' +
                ", legalPerson='" + legalPerson + '\'' +
                ", enterpriseName='" + enterpriseName + '\'' +
                ", unifiedSocialInformationCode='" + unifiedSocialInformationCode + '\'' +
                ", companyRegisteredAddress='" + companyRegisteredAddress + '\'' +
                ", mechanismType='" + mechanismType + '\'' +
                ", natureOfEnterprise='" + natureOfEnterprise + '\'' +
                ", dateOfEstablishment=" + dateOfEstablishment +
                ", scLegalPersonIdCard='" + scLegalPersonIdCard + '\'' +
                ", scBusinessLicense='" + scBusinessLicense + '\'' +
                ", accountOpeningPermit='" + accountOpeningPermit + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
