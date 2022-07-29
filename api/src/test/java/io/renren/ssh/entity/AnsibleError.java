package io.renren.ssh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnsibleError {
    private boolean changed;

    private String msg;

    private boolean unreachable;
}
