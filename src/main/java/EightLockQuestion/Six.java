package EightLockQuestion;

import java.util.concurrent.TimeUnit;

public class Six {
    public static void main(String[] args) {
        Data5 data1 = new Data5();
        Data5 data2 = new Data5();

        new Thread(()->{data1.A();}).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{data2.B();}).start();
    }
}
