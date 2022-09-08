package io.renren.modules.business.dao;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectAddressAndNameResult {
    private String address;
    private String name;
}
