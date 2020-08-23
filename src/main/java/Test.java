import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("aaaaaa");
        }).start();


        TimeUnit.SECONDS.sleep(1);


        new Thread(()->{
            System.out.println("bbbbbb");
        }).start();
    }
}
