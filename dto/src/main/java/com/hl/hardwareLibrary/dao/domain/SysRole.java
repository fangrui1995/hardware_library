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
@Table(name = "sys_role")
public class SysRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Integer id;

    /**
     * 角色code
     */
    @ApiModelProperty("角色code")
    private String code;

    /**
     * 角色名
     */
    @ApiModelProperty("角色名")
    private String name;

    @Column(name = "createTime")
    @ApiModelProperty("")
    private Date createtime;

    @Column(name = "updateTime")
    @ApiModelProperty("")
    private Date updatetime;

    private static final long serialVersionUID = 1L;
}