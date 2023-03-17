package com.hl.hardwareLibrary.dao.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
@ApiModel("")
@Table(name = "sys_role_menu")
public class SysRoleMenu implements Serializable {
    /**
     * 角色id
     */
    @Column(name = "role_id")
    @ApiModelProperty("角色id")
    private Integer roleId;

    /**
     * 菜单名称
     */
    @Column(name = "menu_id")
    @ApiModelProperty("菜单名称")
    private Long menuId;

    @Column(name = "createTime")
    @ApiModelProperty("")
    private Date createtime;

    private static final long serialVersionUID = 1L;
}