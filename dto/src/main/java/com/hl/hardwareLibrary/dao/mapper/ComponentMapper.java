package com.hl.hardwareLibrary.dao.mapper;

import com.hl.hardwareLibrary.common.MyMapper;
import com.hl.hardwareLibrary.dao.domain.Component;
import com.hl.hardwareLibrary.dao.domain.ext.ComponentView;

import java.util.List;

public interface ComponentMapper extends MyMapper<Component> {
    List<ComponentView> findContentInfo();
}