package com.hl.hardwareLibrary.controller.administrator;

import com.hl.hardwareLibrary.common.Result;
import com.hl.hardwareLibrary.dao.domain.Component;
import com.hl.hardwareLibrary.service.administrator.ComponentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/content")
@Api(value = "ComponentController", tags = {"组件相关接口"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class ComponentController {

    @Autowired
    private ComponentService componentService;


    @ApiOperation("查询组件信息内容(首页内容)")
    @GetMapping("/findContentInfo")
    public Result findContentInfo() {
        return componentService.findContentInfo();
    }



    @ApiOperation("修改组件信息内容")
    @PostMapping("/updateContent/{id}")
    public Result updateContent(@ApiParam @RequestBody Component component,
                                @PathVariable Long id) {
        return componentService.updateContent(component,id);
    }


    @ApiOperation("删除组件信息内容")
    @PostMapping("/deleteContent/{id}")
    public Result deleteContent(@PathVariable Long id) {
        return componentService.deleteContent(id);
    }


    @ApiOperation("新增组件信息内容")
    @PostMapping("/insertContent")
    public Result insertContent(@ApiParam @RequestBody Component component) {
        return componentService.insertContent(component);
    }

}
