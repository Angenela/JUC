package Lock;

public class BuyTickets {
    public static void main(String[] args) {
        Tickets tickets = new Tickets();
        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                tickets.buy();
            }
        },"lmz").start();
        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                tickets.buy();
            }
        },"angenela").start();
        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                tickets.buy();
            }
        },"tsy").start();
    }
}

class Tickets{
    private int tickets = 50;

    public synchronized void buy(){
        if (tickets > 0){
            System.out.println(Thread.currentThread().getName()+"购买了第"
                    +(tickets--)+"张票");
        }
    }
}
