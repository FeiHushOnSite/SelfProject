package leedcode;

/**
 * copyRight  @力扣（LeetCode） 链接：https://leetcode-cn.com/problems/jewels-and-stones
 *  
 * <p>
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 
 * S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * <p>
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 */
public class JewelryAndStone {
    public static void main(String[] args) {
//        String J = "aA";
//        String S = "aAAbbbb";
        String J = "z";
        String S = "ZZ";
        int i = numJewelsInStones(J, S);
        System.out.println(i);
    }

    public static int numJewelsInStones(String J, String S) {
        int count = 0;
        char[] Jchars = J.toCharArray();
        char[] Schars = S.toCharArray();
        for (int i = 0; i < Jchars.length; i++) {
            for (int j = 0; j < Schars.length; j++) {
                if(Jchars[i] == Schars[j]){
                    count++;
                }
            }
        }
        return count;
    }
}
