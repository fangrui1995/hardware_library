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
@Table(name = "sys_user")
public class SysUser implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("主键")
    private Long id;

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
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;

    /**
     * 当前角色使用的角色id
     */
    @Column(name = "role_id")
    @ApiModelProperty("当前角色使用的角色id")
    private Integer roleId;



    /**
     * 1正常 2禁用  3 其他
     */
    @Column(name = "status_info")
    @ApiModelProperty("1正常 2禁用  3 其他")
    private Integer statusInfo;

    /**
     * 登录ip
     */
    @Column(name = "login_ip")
    @ApiModelProperty("登录ip")
    private String loginIp;

    /**
     * 登录时间
     */
    @Column(name = "login_time")
    @ApiModelProperty("登录时间")
    private Date loginTime;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @ApiModelProperty("更新时间")
    private Date updateTime;


    private static final long serialVersionUID = 1L;
}