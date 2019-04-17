package Demo;

/**
 * @Auther: Feiyu
 * @Date: 2019/4/17 13:11
 * @Description:
 */

public class staticDemo {
    static int inital_value = 10;

    static {
        inital_value = inital_value / 3;
    }

    public static void main(String[] args) {
        System.out.println("这个初始值是:" + inital_value);
    }

    static {
        inital_value += 5;
    };
}
