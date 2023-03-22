package com.hl.hardwareLibrary.controller.administrator;

import com.hl.hardwareLibrary.common.Result;
import com.hl.hardwareLibrary.dao.domain.ComponentProposal;
import com.hl.hardwareLibrary.service.ComponentProposalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proposal")
@Api(value = "ComponentProposalController", tags = {"建议接口"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class ComponentProposalController {


    @Autowired
    private ComponentProposalService componentProposalService;


    @ApiOperation("查询组件建议列表")
    @GetMapping("/findList")
    public Result findList() {
        return componentProposalService.findList();
    }


    @ApiOperation("修改建议信息")
    @PostMapping("/updateProposal/{id}")
    public Result updateProposal(@ApiParam @RequestBody ComponentProposal componentProposal,
                                    @PathVariable Long id) {
        return componentProposalService.updateProposal(componentProposal,id);
    }


    @ApiOperation("删除建议信息")
    @PostMapping("/deleteProposal/{id}")
    public Result deleteProposal(@PathVariable Long id) {
        return componentProposalService.deleteProposal(id);
    }



    @ApiOperation("新增建议信息")
    @PostMapping("/insertProposal")
    public Result insertProposal(@ApiParam @RequestBody ComponentProposal componentProposal) {
        return componentProposalService.insertProposal(componentProposal);
    }
}
