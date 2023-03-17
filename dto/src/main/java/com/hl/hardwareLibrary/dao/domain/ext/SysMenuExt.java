package com.hl.hardwareLibrary.dao.domain.ext;

import com.hl.hardwareLibrary.dao.domain.SysMenu;
import lombok.Data;

import java.util.List;

/**
 * 管理端菜单扩展
 */
@Data
public class SysMenuExt extends SysMenu {

    private List<SysMenuExt> childrens;

}

