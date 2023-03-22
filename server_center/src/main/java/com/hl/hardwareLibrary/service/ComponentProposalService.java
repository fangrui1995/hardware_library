package com.hl.hardwareLibrary.service;

import com.hl.hardwareLibrary.common.Result;
import com.hl.hardwareLibrary.dao.domain.ComponentProposal;
import com.hl.hardwareLibrary.dao.domain.ComponentReservation;
import com.hl.hardwareLibrary.dao.mapper.ComponentProposalMapper;
import com.hl.hardwareLibrary.enums.ReservationEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class ComponentProposalService {

    @Autowired
    private ComponentProposalMapper componentProposalMapper;
    public Result findList() {

        Example example = new Example(ComponentProposal.class);
        example.createCriteria().andNotEqualTo("statusInfo", ReservationEnum.DISABLE.getKey());

        example.setOrderByClause("createTime desc");

        List<ComponentProposal> componentProposals = componentProposalMapper.selectByExample(example);
        return new Result(componentProposals);

    }

    public Result updateProposal(ComponentProposal componentProposal, Long id) {

        ComponentProposal one = componentProposalMapper.selectByPrimaryKey(id);
        if(null==one){
            return new Result(-1,"请传入正确id");
        }

        componentProposal.setId(id);
        componentProposal.setUpdatetime(new Date());
        componentProposalMapper.updateByPrimaryKeySelective(componentProposal);
        return new Result("修改成功");
    }

    public Result deleteProposal(Long id) {

        ComponentProposal one = componentProposalMapper.selectByPrimaryKey(id);
        if(null==one){
            return new Result(-1,"请传入正确id");
        }

        one.setUpdatetime(new Date());
        one.setStatusInfo(ReservationEnum.DISABLE.getKey());
        componentProposalMapper.updateByPrimaryKeySelective(one);
        return new Result("删除成功");
    }

    public Result insertProposal(ComponentProposal componentProposal) {

        componentProposal.setCreatetime(new Date());
        componentProposalMapper.insert(componentProposal);
        return new Result("新增成功");
    }

    public Result findListByUser(Long id) {

        Example example = new Example(ComponentProposal.class);
        example.createCriteria().andEqualTo("userId",id).andNotEqualTo("statusInfo", ReservationEnum.DISABLE.getKey());

        example.setOrderByClause("createTime desc");

        List<ComponentProposal> componentProposals = componentProposalMapper.selectByExample(example);
        return new Result(componentProposals);

    }
}
