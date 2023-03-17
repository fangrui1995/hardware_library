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
@Table(name = "sys_role_permission")
public class SysRolePermission implements Serializable {
    /**
     * 角色id
     */
    @Id
    @Column(name = "role_id")
    @ApiModelProperty("角色id")
    private Integer roleId;

    /**
     * 菜单按钮id
     */
    @Id
    @Column(name = "permission_id")
    @ApiModelProperty("菜单按钮id")
    private Long permissionId;

    private static final long serialVersionUID = 1L;
}