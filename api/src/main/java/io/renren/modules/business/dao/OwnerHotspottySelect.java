package io.renren.modules.business.dao;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerHotspottySelect {
    private Long hotspottyId;
    private String name;
    private String owner;
}
