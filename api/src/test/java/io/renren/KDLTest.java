package io.renren;

import io.renren.common.gitUtils.kdl.AuthFactory;
import lombok.SneakyThrows;
import org.junit.Test;

/**
 * @program: helium-pro-new
 * @ClassName KDLTest
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-04-14 17:46
 * @Version 1.0
 **/
public class KDLTest {


    @SneakyThrows
    @Test
    public void run(){
        System.out.println(AuthFactory.useKDL());
    }

}
