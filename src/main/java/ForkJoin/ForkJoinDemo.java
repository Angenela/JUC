package ForkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo extends RecursiveTask<Long> {

    private Long start;
    private Long end;
    // 分隔判断值
    private Long terminal = 10000L;

    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinDemo(0L, 10_0000_0000L);
        forkJoinPool.submit(task);
        System.out.println(task.get());
    }

    // 类似于递归
    @Override
    protected Long compute() {
        if (end - start < terminal){
            Long sum = 0L;
            for (Long i = start; i <= end; i++){
                sum += i;
            }
            return sum;
        }else {
            long middle = (start + end) / 2;
            ForkJoinTask<Long> task1 = new ForkJoinDemo(start, middle);
            ForkJoinTask<Long> task2 = new ForkJoinDemo(middle + 1, end);
            task1.fork();
            task2.fork();
            return task1.join() + task2.join();
        }
    }
}
