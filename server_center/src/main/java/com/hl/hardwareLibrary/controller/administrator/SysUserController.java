package com.hl.hardwareLibrary.controller.administrator;

import com.hl.hardwareLibrary.common.Result;
import com.hl.hardwareLibrary.dao.domain.SysUser;
import com.hl.hardwareLibrary.model.LoginParam;
import com.hl.hardwareLibrary.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(value = "SysUserController", tags = {"用户相关接口"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;


    @ApiOperation("查询用户列表")
    @GetMapping("/findList")
    public Result findList() {
        return sysUserService.findList();
    }


    @ApiOperation("登录接口")
    @PostMapping("/login")
    public Result login(@RequestBody LoginParam loginParam) {
        return sysUserService.login(loginParam);
    }


    @ApiOperation("删除用户信息")
    @PostMapping("/deleteUser/{id}")
    public Result deleteUser(@PathVariable Long id) {
        return sysUserService.deleteUser(id);
    }



    @ApiOperation("新增用户信息")
    @PostMapping("/insertUser")
    public Result insertUser(@ApiParam @RequestBody SysUser sysUser) {
        return sysUserService.insertUser(sysUser);
    }

}
