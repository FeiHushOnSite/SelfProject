package leedcode;

/**
 * @Auther: Feiyu
 * @Date: 2019/3/14 11:12
 * @Description:
 *
 *
 *    第一种方法：常规方法。利用String.charAt(i)以及String.valueOf(char).equals(" "
 *    )遍历字符串并判断元素是否为空格。是则替换为"%20",否则不替换
 *
 */

public class changeSpace {
    public static void main(String[] args) {
        StringBuffer test = new StringBuffer();
        test.append("We Are Happy.");
        String result = replaceSpace(test);
        System.out.println(result);
    }
    public static String replaceSpace(StringBuffer str){
        int length = str.length();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < length; i++) {
            char b = str.charAt(i);
            if(String.valueOf(b).equals(" ")){
                result.append("%20");
            } else {
                result.append(b);
            }
        }
        return result.toString();
    }
}
