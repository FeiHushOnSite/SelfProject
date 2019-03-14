package Demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Feiyu
 * @Date: 2019/2/12 16:42
 * @Description:
 */

public class hackerTest1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("shanghai->guangzhou->zhengzhou->changsha");
        list.add("shenzhen->shanghai->beijing->haerbin");
        list.add("nanning->changsha->shanghai->nanjing");
        list.add("sichuan->beijing->shanghai->guangzhou");
        String populuarcity = populuarcity(list);
        System.out.println(populuarcity);

    }

    private static String populuarcity(List<String> list) {
        int count = 0;
        String result = null;
        for (String s : list) {
            String[] split = s.split("->");
            for (int i = 0; i < split.length; i++) {
                String s1 = split[i];
                if(s1.equals("shanghai")){
                    count++;
                    result = count + "  " +s1;
                }
            }
        }
        return result;
    }
}
