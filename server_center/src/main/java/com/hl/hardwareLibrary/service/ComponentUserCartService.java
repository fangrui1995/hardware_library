package com.hl.hardwareLibrary.service;

import cn.hutool.core.collection.CollUtil;
import com.hl.hardwareLibrary.common.Result;
import com.hl.hardwareLibrary.dao.domain.ComponentUserCart;
import com.hl.hardwareLibrary.dao.domain.ext.ComponentView;
import com.hl.hardwareLibrary.dao.mapper.ComponentMapper;
import com.hl.hardwareLibrary.dao.mapper.ComponentUserCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComponentUserCartService {

    @Autowired
    private ComponentUserCartMapper componentUserCartMapper;

    @Autowired
    private ComponentMapper componentMapper;

    @Autowired
    private ComponentReservationService componentReservationService;



    public Result findCartListByUser(Long userId) {


        ComponentUserCart componentUserCart = new ComponentUserCart();
        componentUserCart.setUserId(userId);
        List<ComponentUserCart> select = componentUserCartMapper.select(componentUserCart);

        if (CollUtil.isEmpty(select)){
            return new Result(201,"该用户收藏列表为空");
        }

        List<Long> list = new ArrayList<>();
        if(CollUtil.isNotEmpty(select)){
            for (ComponentUserCart userCart : select) {
                list.add(userCart.getComponentId());
            }
        }
        //查询对应组件信息
        List<ComponentView> componentViewList = componentMapper.findContentInfo(list);

        return new Result(componentViewList);

    }

    public Result insertCart(ComponentUserCart componentUserCart) {
        componentUserCartMapper.insert(componentUserCart);
        return new Result("添加成功");

    }

    public Result deleteCart(Long id) {
        componentUserCartMapper.deleteByPrimaryKey(id);
        return new Result("删除成功");
    }

    public Result findComponentViewByUser(Long userId) {

        return componentReservationService.findListByUserId(userId);

    }
}
