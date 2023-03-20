package com.hl.hardwareLibrary.service.administrator;

import com.hl.hardwareLibrary.common.Result;
import com.hl.hardwareLibrary.dao.domain.Component;
import com.hl.hardwareLibrary.dao.mapper.ComponentMapper;
import com.hl.hardwareLibrary.dao.domain.ext.ComponentView;
import com.hl.hardwareLibrary.enums.CommonEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ComponentService {

    @Autowired
    private ComponentMapper componentMapper;

    public Result findContentInfo() {

        List<ComponentView> componentViewList = componentMapper.findContentInfo();
        return new Result(componentViewList);

    }

    public Result updateContent(Component component, Long id) {

        if(null!=id){
            Component one = componentMapper.selectByPrimaryKey(id);
            if(null==one){
                return new Result(-1,"请传入正确id");
            }
        }else {
            return new Result(-1,"请传入id");
        }


        component.setId(id);
        component.setUpdatetime(new Date());
        componentMapper.updateByPrimaryKeySelective(component);
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

    public Result insertContent(Component component) {

        component.setStatusInfo(CommonEnum.ENABLE.getKey());
        component.setCreatetime(new Date());
        componentMapper.insert(component);
        return new Result("新增成功");
    }
}
