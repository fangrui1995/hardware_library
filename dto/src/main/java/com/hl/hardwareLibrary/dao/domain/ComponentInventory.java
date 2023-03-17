package com.hl.hardwareLibrary.dao.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel("")
@Table(name = "component_inventory")
public class ComponentInventory implements Serializable {
    /**
     * 组件标号
     */
    @Id
    @Column(name = "serial_number")
    @ApiModelProperty("组件标号")
    private String serialNumber;

    /**
     * 组件id
     */
    @Column(name = "component_id")
    @ApiModelProperty("组件id")
    private String componentId;

    /**
     * 组件名称
     */
    @Column(name = "component_name")
    @ApiModelProperty("组件名称")
    private String componentName;

    /**
     * 1-在库 2-借出 3-丢失 4-删除
     */
    @Column(name = "status_info")
    @ApiModelProperty("1-在库 2-借出 3-丢失 4-删除")
    private Integer statusInfo;

    @Column(name = "createTime")
    @ApiModelProperty("")
    private Date createtime;

    @Column(name = "updateTime")
    @ApiModelProperty("")
    private Date updatetime;

    private static final long serialVersionUID = 1L;
}