package com.hl.hardwareLibrary.service;

import com.hl.hardwareLibrary.common.Result;
import com.hl.hardwareLibrary.dao.domain.ComponentInventory;
import com.hl.hardwareLibrary.dao.domain.ComponentReservation;
import com.hl.hardwareLibrary.dao.domain.SysUser;
import com.hl.hardwareLibrary.dao.mapper.ComponentInventoryMapper;
import com.hl.hardwareLibrary.enums.InventoryEnum;
import com.hl.hardwareLibrary.enums.ReservationEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class ComponentInventoryService {

    @Autowired
    private ComponentInventoryMapper componentInventoryMapper;

    public Result findListByComponentId(Long id) {


        Example example = new Example(ComponentInventory.class);
        example.createCriteria().andNotEqualTo("statusInfo", InventoryEnum.DISABLE.getKey());

        example.setOrderByClause("createTime desc");
        List<ComponentInventory> list = componentInventoryMapper.selectByExample(example);
        return new Result(list);
    }

    public Result deleteById(Long id) {

        ComponentInventory one = componentInventoryMapper.selectByPrimaryKey(id);
        if (null == one) {
            return new Result(-1, "请传入正确id");
        }

        one.setUpdatetime(new Date());
        one.setStatusInfo(ReservationEnum.DISABLE.getKey());
        componentInventoryMapper.updateByPrimaryKeySelective(one);
        return new Result("删除成功");


    }

    public Result insertInventory(ComponentInventory componentInventory) {

        componentInventory.setCreatetime(new Date());
        componentInventory.setStatusInfo(InventoryEnum.STOCK.getKey());
        componentInventoryMapper.insert(componentInventory);
        return new Result("新增成功");
    }
}
