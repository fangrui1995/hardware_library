package com.hl.hardwareLibrary.sys;

import com.hl.hardwareLibrary.dao.domain.SysRoleMenu;
import com.hl.hardwareLibrary.dao.mapper.SysRoleMenuMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 后台管理端菜单与角色关联接口
 */
@Service
public class SysRoleMenuService {

    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

    /**
     * 根据角色id获取菜单id
     * @param roleId
     * @return
     */
    public List<Long> getMenuIdsByRoleId(Integer roleId){
        Example example = new Example(SysRoleMenu.class);
        example.createCriteria().andEqualTo("roleId",roleId);
        List<SysRoleMenu> sysRoleMenus = sysRoleMenuMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(sysRoleMenus)){
            return null;
        }
        List<Long> menuIds = new ArrayList<>();
        sysRoleMenus.forEach(sysRoleMenu -> menuIds.add(sysRoleMenu.getMenuId()));
        return menuIds;
    }
}
