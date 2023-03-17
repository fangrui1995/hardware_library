package com.hl.hardwareLibrary.dao.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
@ApiModel("")
@Table(name = "sys_menu")
public class SysMenu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    /**
     * 父菜单id
     */
    @Column(name = "parent_id")
    @ApiModelProperty("父菜单id")
    private Long parentId;

    /**
     * 菜单名称
     */
    @ApiModelProperty("菜单名称")
    private String name;

    /**
     * 排序字段
     */
    @ApiModelProperty("排序字段")
    private Integer sort;

    /**
     * 菜单类型 1-后端管理
     */
    @Column(name = "m_type")
    @ApiModelProperty("菜单类型 1-后端管理")
    private Integer mType;

    @Column(name = "createTime")
    @ApiModelProperty("")
    private Date createtime;

    @Column(name = "updateTime")
    @ApiModelProperty("")
    private Date updatetime;

    private static final long serialVersionUID = 1L;
}