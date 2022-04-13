package io.renren.modules.helium.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lean {

    private String object;
    private String url;
    private boolean cached;
    private boolean has_more;
    private int limit;
    private int total_count;
    private String proximity_hex;
    private List<LeanData> data;
}
