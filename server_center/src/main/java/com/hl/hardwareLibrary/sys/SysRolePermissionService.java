package com.hl.hardwareLibrary.sys;

import com.hl.hardwareLibrary.dao.domain.SysRolePermission;
import com.hl.hardwareLibrary.dao.mapper.SysRolePermissionMapper;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 角色权限关联表服务
 * @Author: lojic
 * @Date: 2020/3/19
 */
@Service
public class SysRolePermissionService {

    @Resource
    private SysRolePermissionMapper sysRolePermissionMapper;

    public SysRolePermission selectById(Long id){
        return sysRolePermissionMapper.selectByPrimaryKey(id);
    }

    public List<SysRolePermission> listByRoleId(List<Integer> roleIds){
        Example example = new Example(SysRolePermission.class);
        example.createCriteria().andIn("roleId",roleIds);
        return sysRolePermissionMapper.selectByExample(example);
    }
}
