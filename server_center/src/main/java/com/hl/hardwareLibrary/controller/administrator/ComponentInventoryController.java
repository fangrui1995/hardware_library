package com.hl.hardwareLibrary.controller.administrator;

import com.hl.hardwareLibrary.common.Result;
import com.hl.hardwareLibrary.dao.domain.ComponentInventory;
import com.hl.hardwareLibrary.service.ComponentInventoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
@Api(value = "ComponentController", tags = {"组件库存相关接口"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class ComponentInventoryController {

    @Autowired
    private ComponentInventoryService componentInventoryService;


    @ApiOperation("根据组件id查询库存接口")
    @GetMapping("/findListByComponentId")
    public Result findListByComponentId(@RequestParam Long id) {
        return componentInventoryService.findListByComponentId(id);
    }



    @ApiOperation("删除库存信息")
    @PostMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable Long id) {
        return componentInventoryService.deleteById(id);
    }



    @ApiOperation("新增库存信息")
    @PostMapping("/insertInventory")
    public Result insertInventory(@ApiParam @RequestBody ComponentInventory componentInventory) {
        return componentInventoryService.insertInventory(componentInventory);
    }
}
