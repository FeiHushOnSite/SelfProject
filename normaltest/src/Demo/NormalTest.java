package Demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Feiyu
 * @Date: 2019/2/11 12:55
 * @Description:
 */

public class NormalTest {
    public static void main(String[] args) {
        int l = 3;
        int r = 9;
        List<Integer> integers = oddNumbers(l, r);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
    static List<Integer> oddNumbers(int l, int r) {
        List<Integer> list = new ArrayList();
        for(int i=l;i<=r;i++){
            if(i%2!=0){
                list.add(i);
            }
        }
        return list;
    }
}
