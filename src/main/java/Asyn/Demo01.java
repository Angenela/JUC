package Asyn;

import java.util.concurrent.TimeUnit;

public class Demo01 {

    private static volatile int num = 0;
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while (num == 0){}      // num == 0 就会进入死循环
        }).start();

        TimeUnit.SECONDS.sleep(1);

        num = 1;        // 你会发现程序并不会结束
    }
}
