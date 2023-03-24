package com.hl.hardwareLibrary.service;

import com.hl.hardwareLibrary.common.Result;
import com.hl.hardwareLibrary.dao.domain.ComponentReservation;
import com.hl.hardwareLibrary.dao.mapper.ComponentReservationMapper;
import com.hl.hardwareLibrary.enums.ReservationEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class ComponentReservationService {

    @Autowired
    private ComponentReservationMapper componentReservationMapper;

    public Result findList(String name) {

        Example example = new Example(ComponentReservation.class);
        example.createCriteria().andNotEqualTo("statusInfo", ReservationEnum.DISABLE.getKey()).andLike("componentName","%"+name+"%");
        example.setOrderByClause("createTime desc");

        List<ComponentReservation> componentReservations = componentReservationMapper.selectByExample(example);
        return new Result(componentReservations);
    }

    public Result updateReservation(ComponentReservation componentReservation, Long id) {


        ComponentReservation one = componentReservationMapper.selectByPrimaryKey(id);
        if(null==one){
            return new Result(-1,"请传入正确id");
        }

        componentReservation.setId(id);
        componentReservation.setUpdatetime(new Date());
        componentReservationMapper.updateByPrimaryKeySelective(componentReservation);
        return new Result("修改成功");


    }

    public Result deleteReservation(Long id) {

        ComponentReservation one = componentReservationMapper.selectByPrimaryKey(id);
        if(null==one){
            return new Result(-1,"请传入正确id");
        }

        one.setUpdatetime(new Date());
        one.setStatusInfo(ReservationEnum.DISABLE.getKey());
        componentReservationMapper.updateByPrimaryKeySelective(one);
        return new Result("删除成功");



    }

    public Result insertReservation(ComponentReservation componentReservation) {
        componentReservation.setCreatetime(new Date());
        componentReservationMapper.insert(componentReservation);
        return new Result("新增成功");

    }

    public Result findListByUserId(Long userId) {

        Example example = new Example(ComponentReservation.class);
        example.createCriteria().andEqualTo("userId",userId).andNotEqualTo("statusInfo", ReservationEnum.DISABLE.getKey());
        example.setOrderByClause("createTime desc");

        List<ComponentReservation> componentReservations = componentReservationMapper.selectByExample(example);
        return new Result(componentReservations);
    }
}
