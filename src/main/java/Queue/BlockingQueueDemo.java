package Queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue queue = new LinkedBlockingQueue(5);
        queue.add("a");
        queue.offer("b");
        queue.offer("c", 2, TimeUnit.SECONDS);
        queue.put("d");

        queue.remove("a");
        queue.poll();
        queue.poll(2, TimeUnit.SECONDS);
        queue.take();
    }
}
