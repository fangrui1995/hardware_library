package com.hl.hardwareLibrary.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;

@Data
@ApiModel
public class SysUserParam {

    /**
     * 用户名
     */
    @Column(name = "user_name")
    @ApiModelProperty("用户名")
    private String userName;

    /**
     * 账号
     */
    @ApiModelProperty("账号")
    private String account;



    /**
     * 当前角色使用的角色id
     */
    @Column(name = "role_id")
    @ApiModelProperty("当前角色使用的角色id")
    private Integer roleId;

    /**
     * 部门编码
     */
    @Column(name = "dept_id")
    @ApiModelProperty("部门编码")
    private String deptId;


    @ApiModelProperty("职位")
    private String position;
}
