/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 22:32
 */


package 栈与队列;
import java.util.*;

/*
描述
农场主有一群牛，每头牛都有一个独特的名字，名字由英文字母组成。农场主想要从这些牛的名字中选出一些牛，
使得他们的名字中包含了所有的指定英文字母。你需要帮助农场主找出一个最短的名字序列，这个序列中的名字能够包含所有的指定英文字母。
示例1
输入："ABCDEFGHIJKLMNOPQRSTUVWXYZ","XZ"
返回值："XYZ"

示例2
输入："ABCDEFGHIJKLMNOPQRSTUVWXYZ","ZZZZZZZZZZZZZZZZZZZZZZZZZZ"
返回值：""

备注：
输入：第一行是一个字符串s，表示所有牛的名字拼接起来的字符串。第二行是一个字符串t，表示指定的英文字母。

输出：返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

注意：对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。如果 s 中存在这样的子串，我们保证它是唯一的答案。

m == s.length，n == t.length，1 <= m, n <= 10^5，s 和 t 由英文字母组成
 */

public class 最短覆盖 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @param t string字符串
     * @return string字符串
     */
    public String minWindow(String s, String t) {
        // 创建哈希表 m，用于记录 t 中每个字符的数量，并初始化
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            m.put(t.charAt(i), m.getOrDefault(t.charAt(i), 0) - 1);
        }

        // 初始化滑动窗口的两个指针 slow 和 fast，和用于记录结果的 left 和 right
        int slow = 0, fast = 0;
        int left = -1, right = -1;
        // 初始化 cnt 为一个足够大的值，用于记录最小窗口的长度
        int cnt = s.length() + 1;

        // 遍历字符串 s
        while (fast < s.length()) {
            char c = s.charAt(fast);
            // 如果当前字符在 t 中，更新哈希表中的数量
            if (m.containsKey(c)) {
                m.put(c, m.get(c) + 1);
            }
            // 检查当前窗口是否包含 t 中所有字符
            while (check(m)) {
                // 更新最小窗口的长度和位置
                if (cnt > fast - slow + 1) {
                    cnt = fast - slow + 1;
                    left = slow;
                    right = fast;
                }
                // 移动慢指针 slow，尝试缩小窗口
                char ch = s.charAt(slow);
                if (m.containsKey(ch)) {
                    m.put(ch, m.get(ch) - 1);
                }
                slow++;
            }
            // 移动快指针 fast，扩展窗口
            fast++;
        }
        // 如果 left 未被更新，说明没有找到符合条件的子字符串，返回空字符串
        if (left == -1) {
            return "";
        }
        // 返回最小窗口子字符串
        return s.substring(left, right + 1);
    }

    // 检查当前窗口是否包含 t 中所有字符
    private boolean check(Map<Character, Integer> m) {
        for (Integer value : m.values()) {
            if (value < 0) {
                return false;
            }
        }
        return true;
    }
}
