/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 22:16
 */


package 字符串;
import java.util.*;

/*
描述
陈经理的农场有两个牛棚，每个牛棚都有各种品种的牛。陈经理现在需要管理牛棚，他想知道两个牛棚的牛群构成是否相同，
也就是每个品种的牛在牛棚内的数量是否相同。编写一个程序，根据提供牛棚的牛群分类字符串 s 和 t，来判断牛棚的牛群构成是否相同（即判断s 和 t 中每个字符出现的次数是否都相同）。

示例1
输入："abcde","edcba"
返回值：true

示例2
输入："aabbcc","ddccbb"
返回值：false

备注：
1 <= len(s), len(t) <= 2 * 10^4
s 和 t 仅包含小写字母。
 */

public class 两串字符次数 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @param t string字符串
     * @return bool布尔型
     */
    public boolean areHerdCompositionsEqual (String s, String t) {
        // write code here
        // 统计字符串 s 和 t 中每个字符出现的次数
        Map<Character, Integer> countS = new HashMap<>();
        Map<Character, Integer> countT = new HashMap<>();

        // 统计字符串 s 中每个字符出现的次数
        for (char c : s.toCharArray()) {
            countS.put(c, countS.getOrDefault(c, 0) + 1);
        }

        // 统计字符串 t 中每个字符出现的次数
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        // 遍历两个哈希表，对比每个字符出现的次数是否相同
        for (Map.Entry<Character, Integer> entry : countS.entrySet()) {
            char c = entry.getKey();
            int countSVal = entry.getValue();
            int countTVal = countT.getOrDefault(c, 0);
            if (countSVal != countTVal) {
                return false;
            }
        }

        // 如果遍历完成后每个字符出现的次数都相同，则返回 true
        return true;
    }
}
