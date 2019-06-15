package leedcode;

import java.util.HashSet;

/**
 * @Auther: Feiyu
 * @Date: 2019/3/15 09:53
 * @Description: LeetCode: 给定一个包含大写字母和小写字母的字符串，
 * 找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如"Aa"不能当做一个回文字符串。
 * 注 意:假设字符串的长度不会超过 1010。
 * 示 例:
 * 输入:
 * "abccccdd"
 * <p>
 * 输出:
 * 7
 * <p>
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * <p>
 * 构成回文串的两种情况
 * 字符出现次数为双数的组合
 * 字符出现次数为双数的组合+一个只出现一次的字符
 */

public class reverseString {
    public static int longestPalindrome(String s) {
        if (s.length() == 0) {
            return 0;
        }
        //用于存放字符
        HashSet<Character> hashSet = new HashSet<Character>();
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!hashSet.contains(chars[i])) { //如果hashset没有此字符就添加进去
                hashSet.add(chars[i]);
            } else { //如果有就让 count++ (说明找到了一个成对的字符),然后把该字符去掉
                hashSet.remove(chars[i]);
                count++;
            }
        }
        return hashSet.isEmpty() ? count * 2 : count * 2 + 1;
    }

    public static void main(String[] args) {
        String test = "abccccdd";
        int i = longestPalindrome(test);
        System.out.println(i);
    }
}
