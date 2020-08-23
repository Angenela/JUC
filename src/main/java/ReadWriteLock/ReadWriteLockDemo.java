package ReadWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// 如果没有读写锁，写时打印的两个语句并不会连在一起
// 读时打印的两个语句随机放置
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        // 写
        for (int i = 0; i < 50; i++) {
            final String temp = String.valueOf(i);
            new Thread(()->{
                myCache.put(temp, temp);
            }).start();
        }

        // 读
        for (int i = 0; i < 5; i++) {
            final String temp = String.valueOf(i);
            new Thread(()->{
                myCache.get(temp);
            }).start();
        }
    }
}

class MyCache{
    private Map<String, String> map = new HashMap<>();
    // 读写锁，可以更加细粒度的操作
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void get(String key){
        // lock.lock()，和使用 Lock 差不多
        readWriteLock.readLock().lock();
        try {
            System.out.println("读取"+key);
            map.get(key);
            System.out.println("读取"+key+"完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void put(String key, String value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println("存储"+key);
            map.put(key, value);
            System.out.println("存储"+key+"完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
}
