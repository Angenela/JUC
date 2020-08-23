package Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class UseDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(myThread);
        new Thread(futureTask).start();
        Integer integer = futureTask.get();
        System.out.println(integer);
    }
}

class MyThread implements Callable<Integer>{

    public int aa = 0;

    @Override
    public Integer call() throws Exception {
        System.out.println("call");
        aa++;
        return 100;
    }
}
