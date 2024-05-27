/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 21:24
 */


package 字符串;

/*
描述
特工牛牛需要根据密码来找到他们组织内部的相关信息。一条密码如果是另一条信息的子序列，那么这条密码就可以用来找到那条信息。
给定两个字符串 s 和 t，判断 s 是否为 t 的子序列。如果 s 是 t 的子序列，返回 true；否则返回 false。

示例1
输入："moo","hmookrpiodc"
返回值：true

示例2
输入："boo","hmookrpiodc"
返回值：false

备注：
 s（0 <= s.length <= 100）和 t（0 <= t.length <= 10^4），只包含小写字母。
子序列即原始字符串删除一些或者不删除字符而不改变剩余字符相对位置形成的新字符串，即可以不用相邻。
 */

public class 子串 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @param t string字符串
     * @return bool布尔型
     */
    public boolean isSubsequence (String s, String t) {
        // write code here
        int sIndex = 0, tIndex = 0;
        // 遍历 t 字符串
        while (sIndex < s.length() && tIndex < t.length()) {
            // 如果当前字符相同，则移动 s 的指针
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            // 移动 t 的指针
            tIndex++;
        }
        // 如果 s 的指针到达了末尾，则说明 s 是 t 的子序列
        return sIndex == s.length();
    }
}
