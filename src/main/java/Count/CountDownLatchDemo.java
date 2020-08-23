package Count;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        // 总数为 10
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                // 数目减 1
                countDownLatch.countDown();
            }).start();
        }

        // 当计数器归零时才会向下执行
        countDownLatch.await();
        System.out.println("计数为0");
    }
}
