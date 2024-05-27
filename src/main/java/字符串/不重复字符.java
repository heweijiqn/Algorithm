/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 22:09
 */


package 字符串;
import java.util.*;

/*
描述
牛牛和朋友都有一个任务编号，编号由一个仅包含大小写字母、数字、符号和空格的字符串表示。这些编号按照他们完成任务的顺序排列。
为了提高完成任务的效率，他们决定采用一种更加高效的策略。每完成一个任务后，接下来的任务必须确保与上一个任务的编号不重复。
请你找出在这种策略下，最多可以连续完成多少个任务的长度。

示例1
输入："ABC18CAK"
返回值：5

说明：
"ABC18"不重复
示例2
输入："AAAAAA"
返回值：1

备注：
s（0 <= s.length <= 5 * 10^4）
 */

public class 不重复字符 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @return int整型
     */
    public int lengthOfLongestContinuousTasks(String s) {
        // 使用 HashSet 来存储当前连续任务序列中出现过的字符
        HashSet<Character> set = new HashSet<>();
        int len = s.length();
        char ch;
        int max = 0;
        // 使用双指针 i 和 j 来表示当前连续任务序列的起始位置和结束位置
        for (int i = 0, j = 0; j < len; j++) {
            // 获取当前右指针位置的字符
            ch = s.charAt(j);
            // 当 set 包含当前字符时，说明当前字符已经在当前连续任务序列中出现过
            while (set.contains(ch)) {  // 当 set 包含右指针字符
                // 左指针右移，同时从 set 中删除左指针位置的字符
                set.remove(s.charAt(i));  // set 删除左指针的字符，并移动左指针
                i++;
            }
            // 将当前字符加入 set 中
            set.add(ch);
            // 更新最大连续任务序列的长度
            if (set.size() > max) max = set.size();
        }
        // 返回最长连续任务序列的长度
        return max;
    }
}
