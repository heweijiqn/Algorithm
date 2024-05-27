/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 21:13
 */


package 字符串;

/*
描述
牛群活动之后，每个牛都用一个字符串表示他们与附近其他牛的关系，但是由于传递过程中出现了一些混乱，
导致这些单词出现了顺序错乱。现在草原上的牛们把这个任务交给你，请你帮忙恢复他们之间关系的正确顺序。
给你一个字符串 s，要求你将字符串中的单词倒序排列，单词之间需要用一个空格隔开，同时保证开头或结尾没有空格，
以及单词间的空格不会多于一个。请创建一个函数，返回恢复顺序后的字符串。

示例1
输入："cattle find shelter"
返回值："shelter find cattle"

备注：
1 <= s.length <= 104。s 可由英文字母（大写或小写）、数字、空格组成，且至少包含一个非空格字符。
 */

public class 倒序 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @return string字符串
     */
    public String reverseWords(String s) {
        String[] words = s.split(" ");

        // 创建一个 StringBuilder 用于构建倒序排列的字符串
        StringBuilder reversed = new StringBuilder();

        // 从最后一个单词开始遍历，将单词加入 StringBuilder
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty()) {
                reversed.append(words[i]);
                if (i > 0) {
                    reversed.append(" ");
                }
            }
        }

        return reversed.toString().trim();
    }

}
