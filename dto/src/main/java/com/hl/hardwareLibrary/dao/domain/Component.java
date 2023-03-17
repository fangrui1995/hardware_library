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
public class Component implements Serializable {
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
     * 1正常 2禁用  3 其他
     */
    @Column(name = "status_info")
    @ApiModelProperty("1正常 2禁用  3 其他")
    private Integer statusInfo;

    @Column(name = "createTime")
    @ApiModelProperty("")
    private Date createtime;

    @Column(name = "updateTime")
    @ApiModelProperty("")
    private Date updatetime;

    private static final long serialVersionUID = 1L;
}