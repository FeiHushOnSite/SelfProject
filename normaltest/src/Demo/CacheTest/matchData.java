package Demo.CacheTest;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class matchData {
    public static void main(String[] args) {
        String[] a = new String[]{"甲方", "乙方", "丙方"};
        String[] b = new String[]{"石料", "木料", "火料"};
        Map<String, String> result = checkData(a, b);
        System.out.println(result);
    }

    public static Map<String, String> checkData(String[] a, String[] b) {
        Map<String, String> map = new HashMap<>();
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = 0; j < b.length; j++) {
                String s = a[i];
                String s1 = b[i];
                map.put(s, s1);
            }
        }
        return map;
    }
}
