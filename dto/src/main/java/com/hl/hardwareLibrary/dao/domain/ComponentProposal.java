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
@Table(name = "component_proposal")
public class ComponentProposal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String name;

    /**
     * 描述
     */
    @ApiModelProperty("描述")
    private String description;

    /**
     * 网站
     */
    @ApiModelProperty("网站")
    private String websites;

    /**
     * 图片路径
     */
    @Column(name = "image_path")
    @ApiModelProperty("图片路径")
    private String imagePath;

    /**
     * pdf路径
     */
    @Column(name = "pdf_path")
    @ApiModelProperty("pdf路径")
    private String pdfPath;

    /**
     * 硬件类型
     */
    @ApiModelProperty("硬件类型")
    private String categories;

    /**
     * 1-申请 2-同意 3-拒绝 6-删除
     */
    @Column(name = "status_info")
    @ApiModelProperty("1-申请 2-同意 3-拒绝 6-删除")
    private Integer statusInfo;

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
     * 成本
     */
    @ApiModelProperty("成本")
    private String cost;

    /**
     * 数量
     */
    @ApiModelProperty("数量")
    private String qty;

    /**
     * 学生方案
     */
    @Column(name = "student_programme")
    @ApiModelProperty("学生方案")
    private String studentProgramme;

    @Column(name = "createTime")
    @ApiModelProperty("")
    private Date createtime;

    @Column(name = "updateTime")
    @ApiModelProperty("")
    private Date updatetime;

    private static final long serialVersionUID = 1L;
}