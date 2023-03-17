package com.hl.hardwareLibrary.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 登录参数
 * @Author: lojic
 * @Date: 2020/2/13
 * @see: com.unv.com.ahsh.home.security.auth.dto
 */
@Data
@ApiModel(value = "LoginParam")
public class LoginParam implements Serializable {

    private static final long serialVersionUID = -8955065476698099512L;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "原密码")
    private String passwordRaw;

    @ApiModelProperty(value = "签名")
    private String sign;


}
