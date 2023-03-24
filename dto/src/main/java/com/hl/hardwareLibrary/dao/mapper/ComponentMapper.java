package com.hl.hardwareLibrary.dao.mapper;

import com.hl.hardwareLibrary.common.MyMapper;
import com.hl.hardwareLibrary.dao.domain.Component;
import com.hl.hardwareLibrary.dao.domain.ext.ComponentView;

import java.util.List;

public interface ComponentMapper extends MyMapper<Component> {
    List<ComponentView> findContentInfo(List<Long> list);

    List<ComponentView> findContentInfoLike(List<Long> list,String name);

    ComponentView findViewById(Long id);
}