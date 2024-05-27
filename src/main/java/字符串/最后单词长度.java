/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 21:10
 */


package 字符串;

/*
描述
牛牛和朋友在玩耍时发现了一款关于单词长度的智力游戏。在这个游戏中，他
们首先会输入一串由若干单词组成的字符串 s，单词之间用一些空格字符隔开。
他们的任务是计算字符串中最后一个单词的长度。例如，他们可以模仿说："牛X牛 Y 牛Z"，最后一个单词是"牛Z"，长度为2。请编写一个函数，计算给定字符串 s 中最后一个单词的长度。
示例1
输入："I am a Cow"
返回值：3
说明：
最后一个单词是"Cow"，长度为 3。
示例2
输入："Hello World from Grassland"
返回值：9

说明：
最后一个单词是"Grassland"，长度为 9。

备注：
1 <= s.length <= 10^4
s 仅由英文字母和空格 ' ' 组成。
s 中至少存在一个单词。
返回结果不包含空格。
 */

public class 最后单词长度 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @return int整型
     */
    public int lengthOfLastWord (String s) {
        // write code here
        // 去除字符串末尾可能存在的空格
        s = s.trim();
        int length = 0;
        // 从字符串末尾开始向前遍历
        for (int i = s.length() - 1; i >= 0; i--) {
            // 如果遇到空格字符，则结束循环
            if (s.charAt(i) == ' ') {
                break;
            }
            length++;
        }
        return length;
    }
}
