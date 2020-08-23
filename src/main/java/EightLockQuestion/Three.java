package EightLockQuestion;

import java.util.concurrent.TimeUnit;

// 第三个问题：先打印 A 还是 C
public class Three {
    public static void main(String[] args) throws InterruptedException {
        Data3 data = new Data3();
        new Thread(()->{data.A();}).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{data.C();}).start();
    }
}

class Data3{
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

    public void C(){
        System.out.println("C");
    }
}
