package io.renren.run.device;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @program: helium-pro-new
 * @ClassName Cursor
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-09-29 14:48
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "cursor") //通过collection参数指定当前实体类对应的文档
public class Cursor {

    private long id;
    private long height;
    private List<String> filter_modes;
    private long before_block;
    private String before_address;
    private String cursor;

}
