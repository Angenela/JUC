package Queue;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueDemo {
    public static void main(String[] args) {
        SynchronousQueue<String> synQueue = new SynchronousQueue();

        new Thread(()->{
            try {
                System.out.println("put 1");
                synQueue.put("1");
                System.out.println("put 2");
                synQueue.put("2");
                System.out.println("put 3");
                synQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("get 1");
                synQueue.take();
                TimeUnit.SECONDS.sleep(3);
                System.out.println("get 2");
                synQueue.take();
                TimeUnit.SECONDS.sleep(3);
                System.out.println("get 3");
                synQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
