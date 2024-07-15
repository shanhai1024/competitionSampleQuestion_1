package com.zhonghui.wms.domain;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;

/**
 * 库区对象 wms_warehouse_area
 *
 * @author zhonghui
 * @date 2022-05-20
 */
@ApiModel("库区对象")
public class WmsWarehouseArea extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 库区ID */
    @ApiModelProperty("编号")
    private Long id;

    /** 仓库ID */
    @Excel(name = "仓库ID")
    @ApiModelProperty("仓库ID")
    private Long warehouseId;

    /** 库区编码 */
    @Excel(name = "库区编码")
    @ApiModelProperty("库区编码")
    private String areaCode;

    /** 库区名称 */
    @Excel(name = "库区名称")
    @ApiModelProperty("库区名称")
    private String areaName;

    /** 仓库名称 */
    @Excel(name = "仓库名称")
    @ApiModelProperty("仓库名称")
    private String warehouseName;

    /** 库位信息 */
    @ApiModelProperty("库位信息")
    private List<WmsWarehouseSeat> wmsWarehouseSeatList;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setWarehouseId(Long warehouseId)
    {
        this.warehouseId = warehouseId;
    }

    public Long getWarehouseId()
    {
        return warehouseId;
    }
    public void setAreaCode(String areaCode)
    {
        this.areaCode = areaCode;
    }

    public String getAreaCode()
    {
        return areaCode;
    }
    public void setAreaName(String areaName)
    {
        this.areaName = areaName;
    }

    public String getAreaName()
    {
        return areaName;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public List<WmsWarehouseSeat> getWmsWarehouseSeatList()
    {
        return wmsWarehouseSeatList;
    }

    public void setWmsWarehouseSeatList(List<WmsWarehouseSeat> wmsWarehouseSeatList)
    {
        this.wmsWarehouseSeatList = wmsWarehouseSeatList;
    }

    @Override
    public String toString() {
        return "WmsWarehouseArea{" +
                "id=" + id +
                ", warehouseId=" + warehouseId +
                ", areaCode='" + areaCode + '\'' +
                ", areaName='" + areaName + '\'' +
                ", warehouseName='" + warehouseName + '\'' +
                ", wmsWarehouseSeatList=" + wmsWarehouseSeatList +
                '}';
    }
}
