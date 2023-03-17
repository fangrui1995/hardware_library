package com.hl.hardwareLibrary.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SelectParam {

    @ApiModelProperty(value = "内容")
    private String name;

    @ApiModelProperty(value = "任务分类")
    private List<String> taskSourceNames;

    @ApiModelProperty(value = "页数")
    private Integer pageNum;

    @ApiModelProperty(value = "每页数量")
    private Integer pageSize;


}
