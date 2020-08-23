package Single;

public class LazyMan {
    private LazyMan(){
        System.out.println(Thread.currentThread());
    }

    private static LazyMan instance;

    public static LazyMan getInstance() {
        if (instance == null){
            synchronized (LazyMan.class){
                if (instance == null){
                    instance = new LazyMan();
                }
            }
        }

        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
