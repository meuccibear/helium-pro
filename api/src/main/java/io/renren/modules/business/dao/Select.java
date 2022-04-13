package io.renren.modules.business.dao;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Select {
    private String label;
    private String value;
    private List<Select> options;
    private List<Select> children;

    public Select(String label) {
        this.label = label;
        this.value = value;
    }

    public Select(String label, List<Select> options) {
        this.label = label;
        this.options = options;
    }

    public Select(String label, String value) {
        this.label = label;
        this.value = value;
    }
    public Select(String label, String value, List<Select> children) {
        this.label = label;
        this.value = value;
        this.children = children;
    }


}
