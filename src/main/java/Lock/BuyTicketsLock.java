package Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BuyTicketsLock {
    public static void main(String[] args) {
        Tickets2 tickets = new Tickets2();

        new Thread(()->{for (int i = 0; i < 30; i++) tickets.buy();},"lmz").start();
        new Thread(()->{for (int i = 0; i < 30; i++) tickets.buy();},"angenela").start();
        new Thread(()->{for (int i = 0; i < 30; i++) tickets.buy();},"tsy").start();
    }
}

class Tickets2{
    private int tickets = 50;

    Lock lock = new ReentrantLock();

    public void buy(){
        // 加锁
        lock.lock();

        try {
            if (tickets > 0){
                System.out.println(Thread.currentThread().getName()+"购买了第"
                        +(tickets--)+"张票");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 解锁
            lock.unlock();
        }
    }
}
