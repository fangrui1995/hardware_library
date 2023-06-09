package com.hl.hardwareLibrary.controller.administrator;

import com.hl.hardwareLibrary.common.Result;
import com.hl.hardwareLibrary.dao.domain.Component;
import com.hl.hardwareLibrary.model.ComponentParam;
import com.hl.hardwareLibrary.service.ComponentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/content")
@Api(value = "ComponentController", tags = {"组件相关接口"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class ComponentController {

    @Autowired
    private ComponentService componentService;


    @ApiOperation("查询组件信息内容(首页内容)")
    @GetMapping("/findContentInfo")
    public Result findContentInfo(@RequestParam(required = false,defaultValue = "") String name) {
        return componentService.findContentInfo(name);
    }


    @ApiOperation("查询组件详细信息")
    @GetMapping("/findDetailsById")
    public Result findDetailsById(@RequestParam Long id) {
        return componentService.findDetailsById(id);
    }



    @ApiOperation("修改组件信息内容")
    @PostMapping("/updateContent/{id}")
    public Result updateContent(@ApiParam @RequestBody ComponentParam componentParam,
                                @PathVariable Long id) {
        return componentService.updateContent(componentParam,id);
    }


    @ApiOperation("删除组件信息内容")
    @PostMapping("/deleteContent/{id}")
    public Result deleteContent(@PathVariable Long id) {
        return componentService.deleteContent(id);
    }


    @ApiOperation("新增组件信息内容")
    @PostMapping("/insertContent")
    public Result insertContent(@ApiParam @RequestBody ComponentParam componentParam) {
        return componentService.insertContent(componentParam);
    }

}
