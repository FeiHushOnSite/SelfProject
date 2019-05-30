package leedcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个只包含数字2---9的字符串,返回它能表示的字母组合
 * <p>
 * 示例: 输入:"23"
 * 输出:{"ad","ae","af","bd","be","bf","cd","ce","cf"}
 *
 * 时间复杂度： O(3^N \times 4^M)O(3
 * N
 *  ×4
 * M
 *  ) ，其中 N 是输入数字中对应 3 个字母的数目（比方说 2，3，4，5，6，8）， M 是输入数字中对应 4 个字母的数目（比方说 7，9），N+M 是输入数字的总数。
 *
 * 空间复杂度：O(3^N \times 4^M)O(3
 * N
 *  ×4
 * M
 *  ) ，这是因为需要保存 3^N \times 4^M3
 * N
 *  ×4
 * M
 *   个结果
 */
public class telenumberandletter {
    Map<String, String> phone = new HashMap<String, String>() {
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };

    List<String> output = new ArrayList<>();

    public void backtrack(String combination, String next_digits){
        // if there is no more digits to check
        if(next_digits.length() == 0){
            // the comnination is done
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map
            // the next available digit
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }
}
