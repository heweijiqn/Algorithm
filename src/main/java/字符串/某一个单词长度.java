/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 21:16
 */


package 字符串;

/*
描述
在草原上，牛群为了进行信息传递-同步安全信息，他们需要在一串信息中查找到对方关键词的起始位置。
他们请你实现一个函数，给定一串信息 message 和一个关键词 keyword，找到关键词 keyword
 第一次出现在信息 message 中的起始位置下标。如果关键词并未出现在信息中，返回 -1。

示例1
输入："The_shy_cow_never_gets_the_grass","cow"
返回值：8

示例2
输入："Jumping_over_the_fences_makes_me_hungry","tiger"
返回值：-1

备注：
1 <= message.length, keyword.length <= 10^4，message 和 keyword 仅由大小写英文字母、数字和符号组成。
 */

public class 某一个单词长度 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param message string字符串
     * @param keyword string字符串
     * @return int整型
     */
    public int findKeyword (String message, String keyword) {
        // write code here
        return message.indexOf(keyword);
    }
}
