package com.hl.hardwareLibrary.utils.sign;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 权限对接bean
 * @Author: lojic
 * @Date: 2020/9/18
 * @see: com.wtkj.internalsimulation.com.ahsh.home.utils.sign
 */
@Data
@ApiModel(value = "SignBean")
public class SignBean {

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "组织id")
    private String orgId;

    @ApiModelProperty(value = "签名")
    private String sign;
}
