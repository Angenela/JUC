package Pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadMethod {
    public static void main(String[] args) {
        Executors.newSingleThreadExecutor();
        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(5);
        ExecutorService service = Executors.newSingleThreadExecutor();

        try {
            service.execute(()->{
                System.out.println("a");
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
    }
}
