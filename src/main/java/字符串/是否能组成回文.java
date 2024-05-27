/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 21:23
 */


package 字符串;
import java.util.*;

/*
描述
草原上的牛群有一个特殊的传统，他们会为每个新成员创造一个密码。他们觉得，如果一个密码具有一定的神秘性，
那么这个新成员就会受到更多的关注。作为一种神秘性，他们决定新成员的密码只允许包含至多 k 个不同的字符，而且其中一个字符可以被删去而构成回文字符串。
现在需要你编写一个程序，判断给定密码是否满足这一条件。

示例1
输入："callc",3
返回值：true

说明：
密码包含 3 个不同的字符（'c', 'a', 'l'），并且删除 'a' 可以构成回文字符串 "cllc"。
示例2
输入："jumpingcows",4
返回值：false

说明：密码包含超过 4 个不同的字符，无法满足条件。
备注：password（1 <= password.length <= 2 * 10^5），表示一个新的成员的密码，仅包含可打印的 ASCII 字符；
整数 k（1 <= k <= 26），表示只允许包含的不同字符个数。
 */

public class 是否能组成回文 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param password string字符串
     * @param k int整型
     * @return bool布尔型
     */
    public boolean isValidPalindrome (String password, int k) {
        // write code here
        // 将密码转换为字符数组
        char[] c = password.toCharArray();
        int n = c.length;

        // 统计密码中不同字符的数量
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(c[i]);
        }

        // 如果不同字符的数量大于 k，则无法满足条件，返回false
        if (set.size() > k) {
            return false;
        }

        // 遍历每个字符的位置，判断是否存在一个字符，将其删除后能够构成回文字符串
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            boolean flag = true;
            while (left < right && flag) {
                if (left == i) {
                    left++;
                } else if (right == i) {
                    right--;
                } else {
                    if (c[left] != c[right]) {
                        flag = false;
                    }
                    left++;
                    right--;
                }
            }
            // 如果存在一个字符，将其删除后能够构成回文字符串，则返回true
            if (flag) {
                return true;
            }
        }
        // 如果没有找到满足条件的情况，则返回false
        return false;
    }
}
