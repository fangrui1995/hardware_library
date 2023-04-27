package com.hl.hardwareLibrary.service;

import cn.hutool.core.collection.CollectionUtil;
import com.hl.hardwareLibrary.common.Result;
import com.hl.hardwareLibrary.dao.domain.Component;
import com.hl.hardwareLibrary.dao.domain.ComponentInventory;
import com.hl.hardwareLibrary.dao.mapper.ComponentInventoryMapper;
import com.hl.hardwareLibrary.dao.mapper.ComponentMapper;
import com.hl.hardwareLibrary.dao.domain.ext.ComponentView;
import com.hl.hardwareLibrary.enums.CommonEnum;
import com.hl.hardwareLibrary.enums.InventoryEnum;
import com.hl.hardwareLibrary.model.ComponentParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ComponentService {

    @Autowired
    private ComponentMapper componentMapper;

    @Autowired
    private ComponentInventoryMapper componentInventoryMapper;

    public Result findContentInfo(String name) {

        List<ComponentView> componentViewList = componentMapper.findContentInfoLike(null,name);
        return new Result(componentViewList);

    }

    public Result updateContent(ComponentParam componentParam, Long id) {

        Date date = new Date();
        if(null!=id){
            Component one = componentMapper.selectByPrimaryKey(id);
            if(null==one){
                return new Result(-1,"请传入正确id");
            }
        }else {
            return new Result(-1,"请传入id");
        }


        Component component = new Component();
        BeanUtils.copyProperties(componentParam, component);
        component.setId(id);
        component.setUpdatetime(date);
        componentMapper.updateByPrimaryKeySelective(component);

        //修改库存信息
        List<ComponentInventory> identifies = componentParam.getIdentifies();

        if(CollectionUtil.isNotEmpty(identifies)){

            //删除历史信息

            Example example = new Example(ComponentInventory.class);
            example.createCriteria().andEqualTo("componentId",componentParam.getId());
            componentInventoryMapper.deleteByExample(example);

            for (ComponentInventory identify : identifies) {

                if(StringUtil.isEmpty(identify.getSerialNumber())){
                    continue;
                }
                identify.setComponentId(componentParam.getId());
                identify.setComponentName(componentParam.getName());
                identify.setCreatetime(date);
                identify.setStatusInfo(InventoryEnum.STOCK.getKey());
                componentInventoryMapper.insert(identify);
            }
        }


        return new Result("修改成功");
    }

    public Result deleteContent(Long id) {

        Component one = componentMapper.selectByPrimaryKey(id);
        if(null==one){
            return new Result(-1,"请传入正确id");
        }

        one.setStatusInfo(CommonEnum.DISABLE.getKey());
        one.setUpdatetime(new Date());
        componentMapper.updateByPrimaryKeySelective(one);
        return new Result("删除成功");
    }

    public Result insertContent(ComponentParam componentParam) {

        Date date = new Date();

        Component component = new Component();
        BeanUtils.copyProperties(componentParam, component);
        component.setStatusInfo(CommonEnum.ENABLE.getKey());
        component.setCreatetime(new Date());
        componentMapper.insertUseGeneratedKeys(component);


        //修改库存信息
        List<ComponentInventory> identifies = componentParam.getIdentifies();

        if(CollectionUtil.isNotEmpty(identifies)){

            //删除历史信息

            Example example = new Example(ComponentInventory.class);
            example.createCriteria().andEqualTo("componentId",componentParam.getId());
            componentInventoryMapper.deleteByExample(example);

            for (ComponentInventory identify : identifies) {

                if(StringUtil.isEmpty(identify.getSerialNumber())){
                    continue;
                }

                identify.setComponentId(component.getId());
                identify.setComponentName(componentParam.getName());
                identify.setCreatetime(date);
                identify.setStatusInfo(InventoryEnum.STOCK.getKey());

                componentInventoryMapper.insert(identify);
            }


        }



        return new Result("新增成功");
    }

    public Result findDetailsById(Long id) {

        ComponentView componentView = componentMapper.findViewById(id);

        Example example = new Example(ComponentInventory.class);
        example.createCriteria().andEqualTo("componentId",id).andNotEqualTo("statusInfo", InventoryEnum.DISABLE.getKey());

        example.setOrderByClause("createTime desc");
        List<ComponentInventory> list = componentInventoryMapper.selectByExample(example);

        componentView.setComponentInventories(list);

        return new Result(componentView);


    }
}
