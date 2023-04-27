package com.hl.hardwareLibrary.model;

import com.hl.hardwareLibrary.dao.domain.Component;
import com.hl.hardwareLibrary.dao.domain.ComponentInventory;
import lombok.Data;

import java.util.List;

@Data
public class ComponentParam extends Component {

    private List<ComponentInventory> identifies;
}
