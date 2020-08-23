package EightLockQuestion;

import java.util.concurrent.TimeUnit;

// 第二个问题：A 方法延迟 2 秒，两个线程；先打印 A 还是 B
public class Two {
    public static void main(String[] args) throws InterruptedException {
        Data2 data = new Data2();
        new Thread(()->{data.A();}).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{data.B();}).start();
    }
}

class Data2{
    public synchronized void A(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("A");
    }

    public synchronized void B(){
        System.out.println("B");
    }
}
