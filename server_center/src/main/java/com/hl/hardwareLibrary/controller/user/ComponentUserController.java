package com.hl.hardwareLibrary.controller.user;

import com.hl.hardwareLibrary.common.Result;
import com.hl.hardwareLibrary.dao.domain.ComponentProposal;
import com.hl.hardwareLibrary.dao.domain.ComponentUserCart;
import com.hl.hardwareLibrary.service.ComponentProposalService;
import com.hl.hardwareLibrary.service.ComponentUserCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contentUser")
@Api(value = "ComponentProposalController", tags = {"用户端接口"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class ComponentUserController {

    @Autowired
    private ComponentProposalService componentProposalService;

    @Autowired
    private ComponentUserCartService componentUserCartService;


    @ApiOperation("查询用户建议列表")
    @GetMapping("/findProposalListByUser")
    public Result findProposalListByUser(@RequestParam Long id) {
        return componentProposalService.findListByUser(id);
    }


    @ApiOperation("新增用户建议")
    @PostMapping("/insertProposal")
    public Result insertProposal(@ApiParam @RequestBody ComponentProposal componentProposal) {
        return componentProposalService.insertProposal(componentProposal);
    }


    @ApiOperation("查询用户收藏的组件列表")
    @GetMapping("/findCartListByUser")
    public Result findCartListByUser(@RequestParam Long userId) {
        return componentUserCartService.findCartListByUser(userId);
    }

    @ApiOperation("用户新增收藏")
    @PostMapping("/insertCart")
    public Result insertCart(@RequestBody ComponentUserCart componentUserCart) {
        return componentUserCartService.insertCart(componentUserCart);
    }

    @ApiOperation("用户删除收藏")
    @PostMapping("/deleteCart/{id}")
    public Result deleteCart(@PathVariable Long id) {
        return componentUserCartService.deleteCart(id);
    }


    @ApiOperation("查询用户组件列表")
    @GetMapping("/findComponentViewByUser")
    public Result findComponentViewByUser(@RequestParam Long userId) {
        return componentUserCartService.findComponentViewByUser(userId);
    }

}
