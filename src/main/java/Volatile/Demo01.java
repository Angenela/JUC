package Volatile;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo01 {
    private static volatile AtomicInteger num = new AtomicInteger(0);

    // 加 synchronized 可以保证原子性
    private static void add(){
        num.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 100; j++) {
                    add();
                }
            }).start();
        }

        TimeUnit.SECONDS.sleep(1);

        // 如果 volatile 保证原子性，那么 num 应该为 2000
        System.out.println(num);
    }
}
