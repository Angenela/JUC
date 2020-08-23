package EightLockQuestion;

import java.util.concurrent.TimeUnit;

public class Four {
    public static void main(String[] args) throws InterruptedException {
        Data4 data1 = new Data4();
        Data4 data2 = new Data4();
        new Thread(()->{data1.A();}).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{data2.B();}).start();
    }
}

class Data4{
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
