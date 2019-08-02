package Demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class normaltest11 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int sign = 0;
        List<Integer> result = new ArrayList<>();
        for (int k = 0; k <= 500; k++) {
            int i = new Random().nextInt(1000) + 1;
            result.add(i);
        }
        for (Integer integer : result) {
            while (integer > 999) {
                sign++;
                System.out.println("存储数据" + integer);
                break;
            }
        }
        System.out.println("计算次数" + sign);

        long end = System.currentTimeMillis();
        System.out.println("计算时间" + (end - start));
    }
}
