package Demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Auther: Feiyu
 * @Date: 2019/2/12 10:03
 * @Description:
 */

public class hackerTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1101");
        list.add("1001");
        plus(list);
    }
    public static String plus(List<String> list){
        StringBuilder sb = new StringBuilder();
        int x = 0;
        int y = 0;
        int pre = 0;
        int sum = 0;
        for(int i = 0; i<=list.size()-1;i++){
            x = list.get(0).charAt(1) - '0';
            y = list.get(1).charAt(1) - '0';
            sum = x + y + pre;
            System.out.println(sum);
        }
        return null;
    }
}
