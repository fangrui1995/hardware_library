package com.hl.hardwareLibrary.service;

import cn.hutool.core.collection.CollUtil;
import com.hl.hardwareLibrary.common.Result;
import com.hl.hardwareLibrary.dao.domain.ComponentProposal;
import com.hl.hardwareLibrary.dao.domain.SysUser;
import com.hl.hardwareLibrary.dao.mapper.SysUserMapper;
import com.hl.hardwareLibrary.enums.CommonEnum;
import com.hl.hardwareLibrary.enums.ReservationEnum;
import com.hl.hardwareLibrary.model.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    public Result findList() {

        Example example = new Example(SysUser.class);
        example.createCriteria().andNotEqualTo("statusInfo", CommonEnum.DISABLE.getKey());

        example.setOrderByClause("create_time desc");

        List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
        return new Result(sysUsers);
    }

    public Result deleteUser(Long id) {

        SysUser one = sysUserMapper.selectByPrimaryKey(id);
        if(null==one){
            return new Result(-1,"请传入正确id");
        }

        one.setUpdateTime(new Date());
        one.setStatusInfo(ReservationEnum.DISABLE.getKey());
        sysUserMapper.updateByPrimaryKeySelective(one);
        return new Result("删除成功");
    }

    public Result insertUser(SysUser sysUser) {

        sysUser.setCreateTime(new Date());
        sysUserMapper.insert(sysUser);
        return new Result("新增成功");
    }

    public Result login(LoginParam loginParam) {

        SysUser sysUserParam = new SysUser();
        sysUserParam.setAccount(loginParam.getUsername());

        List<SysUser> select = sysUserMapper.select(sysUserParam);

        if(CollUtil.isNotEmpty(select)){
            SysUser sysUser = select.get(0);

            if(sysUser.getPassword().equals(loginParam.getPassword())){
                return new Result(sysUser);
            }else {
                return new Result("密码错误");
            }

        }

        return new Result("没有该用户信息");

    }
}
