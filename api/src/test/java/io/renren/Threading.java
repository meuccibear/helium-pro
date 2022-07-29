package io.renren;

/**
 * @program: helium-pro-new
 * @ClassName aaa
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-05-09 10:53
 * @Version 1.0
 **/
public class Threading {

    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++)
                    ;
            }
        };

        long start = System.nanoTime();
        int runs = 1000000;
        for (int i = 0; i < runs; i++)
            new Thread(task).start();

        long time = System.nanoTime() - start;
        System.out.printf("Time for task to complete: %.2f seconds", (double) time / 1000000000.0);
    }
}
