package Function;

import java.util.Arrays;
import java.util.List;

//题目要求:一分钟内完成此题，只能用一行代码实现!
//现在有5个用户!筛选:
//1、ID必须是偶数
//2、年龄必须大于23岁
//3、用户名转为大写字母
//4、用户名字母倒着排序
//5、只输出一个用户!
public class StreamDemo {
    public static void main(String[] args) {
        User a = new User(18, "a", 1);
        User b = new User(24, "b", 2);
        User c = new User(17, "c", 3);
        User d = new User(20, "d", 4);
        User e = new User(21, "e", 5);
        User f = new User(28, "e", 6);

        List<User> users = Arrays.asList(a, b, c, d, e, f);

        // 流式计算 + lambda + 函数式接口
        users.stream()
                .filter(user -> {return user.id % 2 == 0;})
                .filter(user -> {return user.age > 23;})
                .map(user -> {return user.name.toUpperCase();})
                .sorted((u1,u2)->{return u2.compareTo(u1);})
                .limit(1)
                .forEach(user->{System.out.println(user);});
    }
}

class User{
    public int age;
    public String name;
    public int id;

    public User(int age, String name, int id) {
        this.age = age;
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
