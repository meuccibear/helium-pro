package io.renren.modules.business.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessAssociation {
    private Long id;

    private String tableName;

    private Long key;

    private Long value;

    private Long userId;

    private Integer status;
}