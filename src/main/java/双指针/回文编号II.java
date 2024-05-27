/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 23:14
 */


package 双指针;

/*
描述
在一个农场中，农夫使用浮点数来标识他的牛群。农夫发现，有些牛的编号在小数点两边各自都是回文数，
他觉得这很有趣。现在农夫给你一个浮点数 x ，表示一头牛的编号，如果这个编号的小数点两边各自都是回文数（不算前导0和后导0，某一边为空也算回文），返回 true ；否则，返回 false 。
示例1
输入："121.121000"
返回值：true

示例2
输入："123.321000"
返回值：false

示例3
输入："131.000000"
返回值：true

备注：
浮点数用string的形式输入，string长度2 <= length <= 10^5
 */
public class 回文编号II {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param x string字符串
     * @return bool布尔型
     */
    public boolean isPalindromeNumber (String x) {
        // write code here
        // 将字符串按小数点分割
        String[] parts = x.split("\\.");

        // 获取整数部分和小数部分
        String integerPart = parts[0];
        String fractionalPart = parts.length > 1 ? parts[1].replaceAll("0+$", "") : "";

        // 检查整数部分是否是回文数
        if (!isPartPalindrome(integerPart)) {
            return false;
        }

        // 检查小数部分是否是回文数
        if (!isPartPalindrome(fractionalPart)) {
            return false;
        }

        return true;
    }

    private boolean isPartPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
