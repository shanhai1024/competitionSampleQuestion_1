package com.zhonghui.wms.domain;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;

/**
 * 仓库对象 wms_warehouse
 *
 * @author zhonghui
 * @date 2022-05-20
 */
@ApiModel("仓库对象")
public class WmsWarehouse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 仓库ID */
    @ApiModelProperty("编号")
    private Long id;

    /** 编码 */
    @Excel(name = "编码")
    @ApiModelProperty("编码")
    private String warehouseCode;

    /** 仓库名称 */
    @Excel(name = "仓库名称")
    @ApiModelProperty("仓库名称")
    private String warehouseName;

    /** 库区信息 */
    @ApiModelProperty("库区信息")
    private List<WmsWarehouseArea> wmsWarehouseAreaList;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setWarehouseCode(String warehouseCode)
    {
        this.warehouseCode = warehouseCode;
    }

    public String getWarehouseCode()
    {
        return warehouseCode;
    }
    public void setWarehouseName(String warehouseName)
    {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseName()
    {
        return warehouseName;
    }

    public List<WmsWarehouseArea> getWmsWarehouseAreaList()
    {
        return wmsWarehouseAreaList;
    }

    public void setWmsWarehouseAreaList(List<WmsWarehouseArea> wmsWarehouseAreaList)
    {
        this.wmsWarehouseAreaList = wmsWarehouseAreaList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("warehouseCode", getWarehouseCode())
            .append("warehouseName", getWarehouseName())
            .append("wmsWarehouseAreaList", getWmsWarehouseAreaList())
            .toString();
    }
}
