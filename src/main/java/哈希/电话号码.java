/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 23:06
 */


package 哈希;
import java.util.*;

/*
描述
农场主有一套牛名生成器，它通过输入数字（2-9），可以生成一系列可能的牛名。生成器的数字到字母的映射如下（与电话九键相同）。注意 1 不对应任何字母。
{'2', "abc"}, {'3', "def"}, {'4', "ghi"}, {'5', "jkl"}, {'6', "mno"}, {'7', "pqrs"}, {'8', "tuv"}, {'9', "wxyz"}
给定一个仅包含数字 2-9 的字符串 digits，请返回所有它能表示的牛名组合。答案可以按最小字典序返回。


示例1
输入："34"
返回值：["dg","dh","di","eg","eh","ei","fg","fh","fi"]

示例2
输入：""
返回值：[]

备注：
0 <= digits.length <= 4
digits[i] 是范围 ['2', '9'] 的一个数字。
 */

public class 电话号码 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param digits string字符串
     * @return string字符串一维数组
     */
    // 数字到字母的映射
    private static final Map<Character, String> DIGIT_TO_LETTERS = new HashMap<>();
    static {
        DIGIT_TO_LETTERS.put('2', "abc");
        DIGIT_TO_LETTERS.put('3', "def");
        DIGIT_TO_LETTERS.put('4', "ghi");
        DIGIT_TO_LETTERS.put('5', "jkl");
        DIGIT_TO_LETTERS.put('6', "mno");
        DIGIT_TO_LETTERS.put('7', "pqrs");
        DIGIT_TO_LETTERS.put('8', "tuv");
        DIGIT_TO_LETTERS.put('9', "wxyz");
    }

    public String[] letterCombinations(String digits) {
        // 如果输入为空，直接返回空数组
        if (digits == null || digits.length() == 0) {
            return new String[0];
        }

        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), digits, 0);
        return result.toArray(new String[0]);
    }

    // 回溯方法，用于生成所有组合
    private void backtrack(List<String> result, StringBuilder current,
                           String digits, int index) {
        // 终止条件：当生成的组合长度等于输入数字字符串的长度时，将该组合加入结果列表
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // 获取当前数字对应的字母字符串
        String letters = DIGIT_TO_LETTERS.get(digits.charAt(index));
        // 遍历每个字母，递归生成组合
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(result, current, digits, index + 1);
            current.deleteCharAt(current.length() - 1); // 回溯
        }
    }

}
