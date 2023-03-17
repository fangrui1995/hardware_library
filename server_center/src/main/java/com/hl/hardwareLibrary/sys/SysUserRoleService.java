package com.hl.hardwareLibrary.sys;

import com.hl.hardwareLibrary.dao.domain.SysRoleUser;
import com.hl.hardwareLibrary.dao.mapper.SysRoleUserMapper;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysUserRoleService {

    @Resource
    private SysRoleUserMapper userRoleMapper;

    public List<SysRoleUser> listByUserId(Long userId) {
        Example example = new Example(SysRoleUser.class);
        example.createCriteria().andEqualTo("userId",userId);
        return userRoleMapper.selectByExample(example);
    }
}