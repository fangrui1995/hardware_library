package com.hl.hardwareLibrary.sys;

import com.hl.hardwareLibrary.dao.domain.ext.SysMenuExt;
import com.hl.hardwareLibrary.dao.mapper.SysMenuMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 后台管理端菜单接口
 */
@Service
public class SysMenuService {

    @Resource
    private SysMenuMapper sysMenuMapper;

    /**
     * 根据菜单id，返回菜单列表
     * @param menuIds
     * @return
     */
    public List<SysMenuExt> getMenuByMenuIds(List<Long> menuIds){
        return sysMenuMapper.getMenusByIds(menuIds);
    }

    /**
     * 改为树状结构
     * @param menus
     * @return
     */
    public List<SysMenuExt> listWithTree(List<SysMenuExt> menus){
        return  menus.stream().filter(o-> o.getParentId() == 0 ) // 找出所有一级分类，再映射每一个一级分类，添加子菜单
                // 给每一级分类添加子类
                .peek(o-> o.setChildrens(getChildMenuList(o,menus)))
                // 排序
                .sorted(Comparator.comparing(SysMenuExt::getSort))
                // 收集
                .collect(Collectors.toList());
    }

    /**
     * 获取子菜单 根据递归找到子菜单的子菜单
     * @param currMenu
     * @param menuExts
     * @return
     */
    public  List<SysMenuExt> getChildMenuList(SysMenuExt currMenu,List<SysMenuExt> menuExts){
        return menuExts.stream().filter(o -> o.getParentId().equals(currMenu.getId()))
                .peek(o -> o.setChildrens(getChildMenuList(o,menuExts)))
                .sorted(Comparator.comparing(SysMenuExt::getSort))
                .collect(Collectors.toList());
    }
}
