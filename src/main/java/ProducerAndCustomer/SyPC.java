package ProducerAndCustomer;

public class SyPC {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(()->{for (int i = 0; i < 10; i++)data.increment();}, "加1").start();
        new Thread(()->{for (int i = 0; i < 10; i++)data.increment();}, "加2").start();
        new Thread(()->{for (int i = 0; i < 10; i++)data.decrement();}, "减1").start();
    }
}

// 资源类
class Data{
    private int data = 0;

    public synchronized void increment(){
        while (data == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        data++;
        System.out.println(Thread.currentThread().getName()+"=>"+data);
        notifyAll();
    }

    public synchronized void decrement(){
        while (data != 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        data--;
        System.out.println(Thread.currentThread().getName()+"=>"+data);
        notifyAll();
    }
}
