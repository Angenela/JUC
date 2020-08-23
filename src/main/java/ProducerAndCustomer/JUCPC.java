package ProducerAndCustomer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JUCPC {
    public static void main(String[] args) {
        Data2 data = new Data2();
        new Thread(() -> {for (int i = 0; i < 10; i++) data.increment();}, "加1").start();
        new Thread(() -> {for (int i = 0; i < 10; i++) data.increment();}, "加2").start();
        new Thread(() -> {for (int i = 0; i < 10; i++) data.decrement();}, "减1").start();
    }
}

// 资源类
class Data2 {
    private int data = 0;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void increment() {
        lock.lock();
        try {
            while (data == 0) {
                condition.await();
            }
            data++;
            System.out.println(Thread.currentThread().getName() + "=>" + data);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            while (data != 0) {
                condition.await();
            }
            data--;
            System.out.println(Thread.currentThread().getName() + "=>" + data);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
