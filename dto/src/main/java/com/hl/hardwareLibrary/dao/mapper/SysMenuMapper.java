package com.hl.hardwareLibrary.dao.mapper;

import com.hl.hardwareLibrary.common.MyMapper;
import com.hl.hardwareLibrary.dao.domain.SysMenu;
import com.hl.hardwareLibrary.dao.domain.ext.SysMenuExt;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysMenuMapper extends MyMapper<SysMenu> {

    List<SysMenuExt> getMenusByIds(@Param("ids") List<Long> ids);
}