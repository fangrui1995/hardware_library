package com.hl.hardwareLibrary.dao.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel("")
@Table(name = "component_reservation")
public class ComponentReservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    /**
     * 组件id
     */
    @Column(name = "component_id")
    @ApiModelProperty("组件id")
    private String componentId;

    /**
     * 组件名称
     */
    @Column(name = "component_name")
    @ApiModelProperty("组件名称")
    private String componentName;

    /**
     * 组件编号
     */
    @Column(name = "serial_number")
    @ApiModelProperty("组件编号")
    private String serialNumber;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    @ApiModelProperty("用户id")
    private Long userId;

    /**
     * 用户名称 
     */
    @Column(name = "user_name")
    @ApiModelProperty("用户名称 ")
    private String userName;

    /**
     * 用户学校
     */
    @Column(name = "user_school")
    @ApiModelProperty("用户学校")
    private String userSchool;

    /**
     * 用户email
     */
    @Column(name = "user_email")
    @ApiModelProperty("用户email")
    private String userEmail;

    /**
     * 1-申请 2-同意 3-拒绝 4-借出中 5-回收 6-删除
     */
    @Column(name = "status_info")
    @ApiModelProperty("1-申请 2-同意 3-拒绝 4-借出中 5-回收 6-删除")
    private Integer statusInfo;

    /**
     * 计划归还时间
     */
    @Column(name = "due_date")
    @ApiModelProperty("计划归还时间")
    private Date dueDate;

    /**
     * 实际归还时间
     */
    @Column(name = "return_date")
    @ApiModelProperty("实际归还时间")
    private Date returnDate;

    @Column(name = "createTime")
    @ApiModelProperty("")
    private Date createtime;

    @Column(name = "updateTime")
    @ApiModelProperty("")
    private Date updatetime;

    private static final long serialVersionUID = 1L;
}