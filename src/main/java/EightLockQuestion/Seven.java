package EightLockQuestion;

import java.util.concurrent.TimeUnit;

public class Seven{
    public static void main(String[] args) throws InterruptedException {
        Data7 data1 = new Data7();
        new Thread(()->{data1.A();}).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{data1.B();}).start();
    }
}

class Data7{
    public static synchronized void A(){
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
