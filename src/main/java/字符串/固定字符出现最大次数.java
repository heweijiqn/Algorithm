/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 21:49
 */


package 字符串;

/*
描述
农场里的牛群正在进行一场比赛，每头牛都有一个唯一的编号，用字符来表示。农夫想要知道在这场比赛中，
哪个编号的牛的出场次数最多。由于比赛的时间很长，农夫想要通过一个固定长度的时间窗口来统计。请你帮助农夫完成这个任务。
给你一个字符串 s 和一个整数 k ，以及一个字符串 t，表示牛的编号，返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大牛编号的出场次数。

示例1
输入："abciiidef",3,"i"
返回值：3

示例2
输入："abcdefg",2,"gh"
返回值：1

备注：
1 <= s.length <= 10^5
s 由小写英文字母组成
1 <= k <= s.length
t 由小写英文字母组成
 */

public class 固定字符出现最大次数 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @param k int整型
     * @param t string字符串
     * @return int整型
     */
    public int maxCount (String s, int k, String t) {
        // write code here

        // 将字符串 s 的前 k 个字符转换成字符数组
        char[] chs = s.substring(0, k).toCharArray();
        // 将字符串 t 转换成字符数组
        char[] cht = t.toCharArray();
        // 统计 t 在前 k 个字符中的出现次数
        int sk = 0;
        for (int i = 0; i < chs.length; i++) {
            for (int j = 0; j < cht.length; j++) {
                if (chs[i] == cht[j]) {
                    sk++;
                }
            }
        }
        return sk;
    }
}
