package io.renren.modules.helium.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cell {

    Long timestamp;

    Integer cellId;

    Boolean operationMode;

    String hotspotAddress;

    String ownerAddress;

    String hotspotType;

    String cbsdCategory;

    String cbsdId;

}
