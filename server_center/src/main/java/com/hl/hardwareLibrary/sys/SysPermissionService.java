package com.hl.hardwareLibrary.sys;

import com.hl.hardwareLibrary.dao.domain.SysPermission;
import com.hl.hardwareLibrary.dao.mapper.SysPermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Description: 权限管理
 * @Author: lojic
 * @Date: 2020/3/19
 */
@Service
public class SysPermissionService {

    @Autowired
    private SysPermissionMapper permissionMapper;

    public SysPermission selectById(Long id){
        return permissionMapper.selectByPrimaryKey(id);
    }

    public List<SysPermission> selectByIds(List<Long> ids){
        Example example = new Example(SysPermission.class);
        example.createCriteria().andIn("id",ids);
        return permissionMapper.selectByExample(example);
    }

}
