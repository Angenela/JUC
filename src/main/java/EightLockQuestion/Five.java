package EightLockQuestion;

import java.util.concurrent.TimeUnit;

public class Five {
    public static void main(String[] args) throws InterruptedException {
        Data5 data1 = new Data5();
        new Thread(()->{data1.A();}).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{data1.B();}).start();
    }
}

class Data5{
    public static synchronized void A(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("A");
    }

    public static synchronized void B(){
        System.out.println("B");
    }
}
