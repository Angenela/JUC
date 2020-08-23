package EightLockQuestion;

import java.util.concurrent.TimeUnit;

// 第一个问题：标准情况下，两个线程；先打印 A 还是 B
public class One {
    public static void main(String[] args) throws InterruptedException {
        Data data = new Data();
        new Thread(()->{data.A();}).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{data.B();}).start();
    }
}

class Data{
    public synchronized void A(){
        System.out.println("A");
    }

    public synchronized void B(){
        System.out.println("B");
    }
}
