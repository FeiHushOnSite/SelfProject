package leedcode;

public class RomeNumberToInt {
    private static int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new IllegalArgumentException("Illegal character");
        }
    }

    public static int ramanToInt(String s) {
        int result = 0, i = 0, n = s.length();
        while (i < n) {
            int current = getValue(s.charAt(i));

            //如果字符串长度等于
            if (i == n - 1 || current >= getValue(s.charAt(i + 1))) {
                result += current;
            }
            else{
                result -= current;
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int result = ramanToInt("MDIDCXL");
        System.out.println(result);
    }
}
