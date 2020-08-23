package ForkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class CompareDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long time1 = System.currentTimeMillis();
        StreamTest();
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);

        long time3 = System.currentTimeMillis();
        ForkJoinTest();
        long time4 = System.currentTimeMillis();
        System.out.println(time4 - time3);

        long time5 = System.currentTimeMillis();
        ForTest();
        long time6 = System.currentTimeMillis();
        System.out.println(time6 - time5);
    }

    public static void ForTest(){
        Long sum = 0L;
        for (Long i = 1L; i <= 10_0000_0000; i++){
            sum += i;
        }
    }

    public static void ForkJoinTest() throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinDemo(0L, 10_0000_0000L);
        forkJoinPool.submit(task);
        task.get();
    }

    public static void StreamTest(){
        // parallel 就是进行 并行 操作
        long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0L, (l, r)->{return l+r;});
    }
}