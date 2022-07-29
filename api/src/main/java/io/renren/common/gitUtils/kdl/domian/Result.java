package io.renren.common.gitUtils.kdl.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: helium-pro-new
 * @ClassName Result
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-04-14 17:54
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private String msg;
    private Integer code;
    private Object data;

}
