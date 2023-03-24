package com.hl.hardwareLibrary.controller.administrator;

import com.hl.hardwareLibrary.common.Result;
import com.hl.hardwareLibrary.dao.domain.ComponentReservation;
import com.hl.hardwareLibrary.service.ComponentReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
@Api(value = "ReservationController", tags = {"预定接口"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class ComponentReservationController {

    @Autowired
    private ComponentReservationService componentReservationService;


    @ApiOperation("查询组件预定列表")
    @GetMapping("/findList")
    public Result findList(@RequestParam(required = false,defaultValue = "") String name) {
        return componentReservationService.findList(name);
    }



    @ApiOperation("修改预定信息")
    @PostMapping("/updateReservation/{id}")
    public Result updateReservation(@ApiParam @RequestBody ComponentReservation componentReservation,
                                    @PathVariable Long id) {
        return componentReservationService.updateReservation(componentReservation,id);
    }


    @ApiOperation("删除预定信息")
    @PostMapping("/deleteReservation/{id}")
    public Result deleteReservation(@PathVariable Long id) {
        return componentReservationService.deleteReservation(id);
    }



    @ApiOperation("新增预定信息")
    @PostMapping("/insertReservation")
    public Result insertReservation(@ApiParam @RequestBody ComponentReservation componentReservation) {
        return componentReservationService.insertReservation(componentReservation);
    }




}
