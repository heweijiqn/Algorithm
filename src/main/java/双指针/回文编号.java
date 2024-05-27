/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 23:12
 */


package 双指针;

/*
描述
在一个农场中，农夫使用整数来标识他的牛群。农夫发现，有些牛的编号在正序（从左向右）和倒序（从右向左）读都是一样的，
他觉得这很有趣。现在农夫给你一个整数 x ，表示一头牛的编号，如果这个编号是一个回文数，返回 true ；否则，返回 false 。
示例1
输入：1331
返回值：true

示例2
输入：123
返回值：false

备注：
0 <= x <= 2^31 - 1
 */

public class 回文编号 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param x int整型
     * @return bool布尔型
     */
    public boolean isPalindrome (int x) {
        // write code here
        // 负数以及以0结尾且不是0的数字不可能是回文数
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        // 将整数转换为字符串形式
        String s = Integer.toString(x);
        int left = 0;
        int right = s.length() - 1;

        // 使用双指针从两端向中间扫描
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
