package Function;

import java.util.function.Supplier;

public class Demo04 {
    public static void main(String[] args) {
        Supplier<String> supplier = ()->{return "angenela";};
        System.out.println(supplier.get());
    }
}
