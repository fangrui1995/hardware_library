package com.hl.hardwareLibrary.dao.domain.ext;

import com.hl.hardwareLibrary.dao.domain.Component;
import lombok.Data;

@Data
public class ComponentView extends Component {

    private Integer count;
}
