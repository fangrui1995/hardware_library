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
@Table(name = "sys_permission")
public class SysPermission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @ApiModelProperty("")
    private String permission;

    @ApiModelProperty("")
    private String name;

    @Column(name = "createTime")
    @ApiModelProperty("")
    private Date createtime;

    @Column(name = "updateTime")
    @ApiModelProperty("")
    private Date updatetime;

    private static final long serialVersionUID = 1L;
}