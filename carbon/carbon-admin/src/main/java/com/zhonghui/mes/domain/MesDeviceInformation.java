package com.zhonghui.mes.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;

/**
 * 设备信息对象 mes_device_information
 * 
 * @author zhonghui
 * @date 2022-05-21
 */
@ApiModel("设备信息对象")
public class MesDeviceInformation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    @Excel(name = "编号")
    @ApiModelProperty("编号")
    private Integer id;

    /** 名称 */
    @Excel(name = "名称")
    @ApiModelProperty("名称")
    private String deviceName;

    /** 编码 */
    @Excel(name = "编码")
    @ApiModelProperty("编码")
    private String deviceCode;

    /** 型号 */
    @Excel(name = "型号")
    @ApiModelProperty("型号")
    private String deviceModel;

    /** 生产日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生产日期", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("生产日期")
    private Date produceDate;

    /** 生产批号 */
    @Excel(name = "生产批号")
    @ApiModelProperty("生产批号")
    private String produceCode;

    /** 制造商 */
    @Excel(name = "制造商")
    @ApiModelProperty("制造商")
    private String manufacturer;

    /** 设备状态 */
    @Excel(name = "设备状态")
    @ApiModelProperty("设备状态")
    private Long deviceStatus;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setDeviceName(String deviceName) 
    {
        this.deviceName = deviceName;
    }

    public String getDeviceName() 
    {
        return deviceName;
    }
    public void setDeviceCode(String deviceCode) 
    {
        this.deviceCode = deviceCode;
    }

    public String getDeviceCode() 
    {
        return deviceCode;
    }
    public void setDeviceModel(String deviceModel) 
    {
        this.deviceModel = deviceModel;
    }

    public String getDeviceModel() 
    {
        return deviceModel;
    }
    public void setProduceDate(Date produceDate) 
    {
        this.produceDate = produceDate;
    }

    public Date getProduceDate() 
    {
        return produceDate;
    }
    public void setProduceCode(String produceCode) 
    {
        this.produceCode = produceCode;
    }

    public String getProduceCode() 
    {
        return produceCode;
    }
    public void setManufacturer(String manufacturer) 
    {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() 
    {
        return manufacturer;
    }
    public void setDeviceStatus(Long deviceStatus) 
    {
        this.deviceStatus = deviceStatus;
    }

    public Long getDeviceStatus() 
    {
        return deviceStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deviceName", getDeviceName())
            .append("deviceCode", getDeviceCode())
            .append("deviceModel", getDeviceModel())
            .append("produceDate", getProduceDate())
            .append("produceCode", getProduceCode())
            .append("manufacturer", getManufacturer())
            .append("deviceStatus", getDeviceStatus())
            .append("remark", getRemark())
            .toString();
    }
}
