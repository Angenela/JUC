package Single;

public class HungerMan {

    // 浪费内存
    private byte[] data1 = new byte[1024 * 1024];
    private byte[] data2 = new byte[1024 * 1024];
    private byte[] data3 = new byte[1024 * 1024];
    private byte[] data4 = new byte[1024 * 1024];

    private HungerMan(){}

    private static final HungerMan instance = new HungerMan();

    public static HungerMan getInstance() {
        return instance;
    }
}
