package com.zhonghui.procurementManagement.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 采购—企业信息对象 procurement_enterprise_information
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
public class PmEnterpriseInformation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 企业id */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 公司简介 */
    private String companyProfile;

    /** 营业执照有效期 */
    private Date validityPeriodOfBusinessLicense;

    /** 注册资本（万元） */
    private String registeredCapital;

    /** 单位注册地址 */
    private String unitRegisteredAddress;

    /** 单位注册电话 */
    private String unitRegistrationTelephone;

    /** 开户行地址 */
    private String openingAddress;

    /** 银行账号 */
    @Excel(name = "银行账号")
    private String bankAccountNumber;

    /** 开户行 */
    private String bankOfDeposit;

    /** 实缴资本 */
    private String paidInCapital;

    /** 经营范围 */
    private String businessScope;

    /** 单位联系地址 */
    @Excel(name = "单位联系地址")
    private String corporateContactAddress;

    /** 法人身份证 */
    private String corporateIdentityCard;

    /** 法人 */
    @Excel(name = "法人")
    private String legalPerson;

    /** 企业名称 */
    @Excel(name = "企业名称")
    private String enterpriseName;

    /** 统一社会信用代码 */
    private String unifiedSocialInformationCode;

    /** 公司注册地址 */
    private String companyRegisteredAddress;

    /** 机构类型 */
    private String mechanismType;

    /** 企业性质 */
    @Excel(name = "企业性质")
    private String natureOfEnterprise;

    /** 成立日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "成立日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dateOfEstablishment;

    /** 法人身份证扫描件 */
    private String scLegalPersonIdCard;

    /** 营业执照扫描件 */
    private String scBusinessLicense;

    /** 开户许可证 */
    private String accountOpeningPermit;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setCompanyProfile(String companyProfile) 
    {
        this.companyProfile = companyProfile;
    }

    public String getCompanyProfile() 
    {
        return companyProfile;
    }
    public void setValidityPeriodOfBusinessLicense(Date validityPeriodOfBusinessLicense) 
    {
        this.validityPeriodOfBusinessLicense = validityPeriodOfBusinessLicense;
    }

    public Date getValidityPeriodOfBusinessLicense() 
    {
        return validityPeriodOfBusinessLicense;
    }
    public void setRegisteredCapital(String registeredCapital) 
    {
        this.registeredCapital = registeredCapital;
    }

    public String getRegisteredCapital() 
    {
        return registeredCapital;
    }
    public void setUnitRegisteredAddress(String unitRegisteredAddress) 
    {
        this.unitRegisteredAddress = unitRegisteredAddress;
    }

    public String getUnitRegisteredAddress() 
    {
        return unitRegisteredAddress;
    }
    public void setUnitRegistrationTelephone(String unitRegistrationTelephone) 
    {
        this.unitRegistrationTelephone = unitRegistrationTelephone;
    }

    public String getUnitRegistrationTelephone() 
    {
        return unitRegistrationTelephone;
    }
    public void setOpeningAddress(String openingAddress) 
    {
        this.openingAddress = openingAddress;
    }

    public String getOpeningAddress() 
    {
        return openingAddress;
    }
    public void setBankAccountNumber(String bankAccountNumber) 
    {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankAccountNumber() 
    {
        return bankAccountNumber;
    }
    public void setBankOfDeposit(String bankOfDeposit) 
    {
        this.bankOfDeposit = bankOfDeposit;
    }

    public String getBankOfDeposit() 
    {
        return bankOfDeposit;
    }
    public void setPaidInCapital(String paidInCapital) 
    {
        this.paidInCapital = paidInCapital;
    }

    public String getPaidInCapital() 
    {
        return paidInCapital;
    }
    public void setBusinessScope(String businessScope) 
    {
        this.businessScope = businessScope;
    }

    public String getBusinessScope() 
    {
        return businessScope;
    }
    public void setCorporateContactAddress(String corporateContactAddress) 
    {
        this.corporateContactAddress = corporateContactAddress;
    }

    public String getCorporateContactAddress() 
    {
        return corporateContactAddress;
    }
    public void setCorporateIdentityCard(String corporateIdentityCard) 
    {
        this.corporateIdentityCard = corporateIdentityCard;
    }

    public String getCorporateIdentityCard() 
    {
        return corporateIdentityCard;
    }
    public void setLegalPerson(String legalPerson) 
    {
        this.legalPerson = legalPerson;
    }

    public String getLegalPerson() 
    {
        return legalPerson;
    }
    public void setEnterpriseName(String enterpriseName) 
    {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseName() 
    {
        return enterpriseName;
    }
    public void setUnifiedSocialInformationCode(String unifiedSocialInformationCode) 
    {
        this.unifiedSocialInformationCode = unifiedSocialInformationCode;
    }

    public String getUnifiedSocialInformationCode() 
    {
        return unifiedSocialInformationCode;
    }
    public void setCompanyRegisteredAddress(String companyRegisteredAddress) 
    {
        this.companyRegisteredAddress = companyRegisteredAddress;
    }

    public String getCompanyRegisteredAddress() 
    {
        return companyRegisteredAddress;
    }
    public void setMechanismType(String mechanismType) 
    {
        this.mechanismType = mechanismType;
    }

    public String getMechanismType() 
    {
        return mechanismType;
    }
    public void setNatureOfEnterprise(String natureOfEnterprise) 
    {
        this.natureOfEnterprise = natureOfEnterprise;
    }

    public String getNatureOfEnterprise() 
    {
        return natureOfEnterprise;
    }
    public void setDateOfEstablishment(Date dateOfEstablishment) 
    {
        this.dateOfEstablishment = dateOfEstablishment;
    }

    public Date getDateOfEstablishment() 
    {
        return dateOfEstablishment;
    }
    public void setScLegalPersonIdCard(String scLegalPersonIdCard) 
    {
        this.scLegalPersonIdCard = scLegalPersonIdCard;
    }

    public String getScLegalPersonIdCard() 
    {
        return scLegalPersonIdCard;
    }
    public void setScBusinessLicense(String scBusinessLicense) 
    {
        this.scBusinessLicense = scBusinessLicense;
    }

    public String getScBusinessLicense() 
    {
        return scBusinessLicense;
    }
    public void setAccountOpeningPermit(String accountOpeningPermit) 
    {
        this.accountOpeningPermit = accountOpeningPermit;
    }

    public String getAccountOpeningPermit() 
    {
        return accountOpeningPermit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("companyProfile", getCompanyProfile())
            .append("validityPeriodOfBusinessLicense", getValidityPeriodOfBusinessLicense())
            .append("registeredCapital", getRegisteredCapital())
            .append("unitRegisteredAddress", getUnitRegisteredAddress())
            .append("unitRegistrationTelephone", getUnitRegistrationTelephone())
            .append("openingAddress", getOpeningAddress())
            .append("bankAccountNumber", getBankAccountNumber())
            .append("bankOfDeposit", getBankOfDeposit())
            .append("paidInCapital", getPaidInCapital())
            .append("businessScope", getBusinessScope())
            .append("corporateContactAddress", getCorporateContactAddress())
            .append("corporateIdentityCard", getCorporateIdentityCard())
            .append("legalPerson", getLegalPerson())
            .append("enterpriseName", getEnterpriseName())
            .append("unifiedSocialInformationCode", getUnifiedSocialInformationCode())
            .append("companyRegisteredAddress", getCompanyRegisteredAddress())
            .append("mechanismType", getMechanismType())
            .append("natureOfEnterprise", getNatureOfEnterprise())
            .append("dateOfEstablishment", getDateOfEstablishment())
            .append("scLegalPersonIdCard", getScLegalPersonIdCard())
            .append("scBusinessLicense", getScBusinessLicense())
            .append("accountOpeningPermit", getAccountOpeningPermit())
            .toString();
    }
}
