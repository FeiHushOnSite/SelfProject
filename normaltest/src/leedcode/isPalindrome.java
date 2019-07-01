package leedcode;


/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class isPalindrome {

    public static void main(String[] args) {
        int a = 1001;
        boolean palindrome = isPalindrome(a);
        System.out.println(palindrome);

//        int z = 123 / 100;
//        int y = 123 % 100;
//        int c = y / 10;
//        int v = y % 10;
//        System.out.println(z + ":::" + y + ":::" + c + ":::" + v);
//        1:::23:::2:::3

    }

    public static boolean isPalindrome(int x) {
        if (0 <= x && x < 10) {
            return true;
        }
        if (x < 0)
            return false;

//        if (x >= 100) {
//            int t = x / 1000;
//            int z = x / 100;
//            int y = x % 100;
//            //   int c = y / 10;
//            int v = y % 10;
//            if (z == v || t == v)
//                return true;
//                if(z == y){
//                    return true;
//                }
//            else
//                return false;
//        }
//        if (x > 10 && x < 100) {
//            int a = x / 10;
//            int b = x % 10;
//            if (a == b)
//                return true;
//            else
//                return false;
//        }

        int div = 1;
        while (x / div >= 10) div *= 10;
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }
}
