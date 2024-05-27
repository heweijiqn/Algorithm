/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 22:06
 */


package 字符串;
/*
描述
牛牛和朋友们需要完成一系列任务。这些任务用字符串 s 表示，每个任务都有一个表示其名称的字符串。
他们需要按名称从这些任务列表中任选一个连续子任务来完成。任务列表用字符串数组 words 表示，
数组中的所有字符串长度相同。为了使工作更具有挑战性，他们决定采用以下策略：这些子任务必须按照任务名称在 words 中出现的顺序组成一个子序列。
请编写一个程序，帮助牛群找到 s 中满足该策略的最长连续子串的开始位置。如果没有找到满足条件的子任务，请返回 -1。

示例1
输入："entertainmentss",["enter", "tainm", "entss"]
返回值：0

 */

public class 是否包含长串 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @param words string字符串一维数组
     * @return int整型
     */
    public int findLongestSubstring (String s, String[] words) {
        if (s.length() == 0 || words.length == 0) {
            return 0;
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < words.length; i++) {
            stringBuffer.append(words[i]);
        }
        return s.indexOf(stringBuffer.toString());
    }
}
