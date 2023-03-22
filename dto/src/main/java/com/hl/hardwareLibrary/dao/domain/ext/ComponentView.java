package com.hl.hardwareLibrary.dao.domain.ext;

import com.hl.hardwareLibrary.dao.domain.Component;
import com.hl.hardwareLibrary.dao.domain.ComponentInventory;
import lombok.Data;

import java.util.List;

@Data
public class ComponentView extends Component {

    private Integer count;

    private List<ComponentInventory> componentInventories;
}
