package com.hl.hardwareLibrary.dao.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Accessors(chain = true)
@ApiModel("")
@Table(name = "sys_role_user")
public class SysRoleUser implements Serializable {
    /**
     * 用户id
     */
    @Id
    @Column(name = "user_id")
    @ApiModelProperty("用户id")
    private Long userId;

    /**
     * 角色id
     */
    @Id
    @Column(name = "role_id")
    @ApiModelProperty("角色id")
    private Integer roleId;

    private static final long serialVersionUID = 1L;
}