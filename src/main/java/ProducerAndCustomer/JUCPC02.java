package ProducerAndCustomer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JUCPC02 {
    public static void main(String[] args) {
        Data3 data3 = new Data3();
        new Thread(()->{for (int i = 0; i < 10; i++) {data3.printA();}}).start();
        new Thread(()->{for (int i = 0; i < 10; i++) {data3.printB();}}).start();
        new Thread(()->{for (int i = 0; i < 10; i++) {data3.printC();}}).start();
    }
}

class Data3{
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    // 标识符，1 执行 A，2 执行 B，3 执行 C
    private int flag = 1;

    public void printA(){
        lock.lock();
        try {
            while (flag != 1) {
                condition1.await();
            }
            flag = 2;
            System.out.println("A");
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB(){
        lock.lock();
        try {
            while (flag != 2) {
                condition2.await();
            }
            flag = 3;
            System.out.println("B");
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC(){
        lock.lock();
        try {
            while (flag != 3) {
                condition3.await();
            }
            flag = 1;
            System.out.println("C");
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
