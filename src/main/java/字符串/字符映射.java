/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 22:11
 */


package 字符串;
import java.util.*;

/*
描述
陈经理的农场中有各种各样的动物，特别是牛。为了管理方便，陈经理决定对农场中的动物进行分类。
他定义了两种分类方式对应于两个字符串 s 和 t，然后请你编写一个程序，判断这两种分类方式是否同构。
同构定义：如果 s 中的字符可以按某种映射关系替换得到 t，那么这两个字符串是同构的。

要求：
每个出现的字符都应当映射到另一个字符
不改变字符的顺序
不同字符不能映射到同一个字符上
相同字符只能映射到同一个字符上
字符可以映射到自己本身

示例1
输入："AAB","AAC"
返回值："YES"

示例2
输入："AAA","ABC"
返回值："NO"
 */

public class 字符映射 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @param t string字符串
     * @return string字符串
     */
    public String isIsomorphic(String s, String t) {
        // 如果两个字符串长度不相等，则肯定不是同构的
        if (s.length() != t.length()) {
            return "NO";
        }
        // 使用哈希表来存储 s 中字符到 t 中字符的映射关系
        Map<Character, Character> map = new HashMap<>();
        // 遍历两个字符串
        for (int i = 0; i < s.length(); i++) {
            // 如果当前字符不相等
            if (s.charAt(i) != t.charAt(i)) {
                // 如果 s 中当前字符已经有了映射
                if (map.containsKey(s.charAt(i))) {
                    // 如果 s 中当前字符映射的 t 中字符与当前 t 中字符不相等，则返回 "NO"
                    if (map.get(s.charAt(i)) != t.charAt(i)) {
                        return "NO";
                    }
                }
                // 如果 s 中当前字符没有映射，则判断当前 t 中字符是否已经被映射到 s 中其他字符上
                else if (map.getOrDefault(t.charAt(i), t.charAt(i)) == s.charAt(i)) {
                    return "NO";
                }
                // 如果 s 中当前字符没有映射，且 t 中当前字符也没有被其他字符映射到，则建立映射关系
                else {
                    map.put(s.charAt(i), t.charAt(i));
                }
            }
        }
        // 如果遍历完成后没有出现不一致的映射关系，则返回 "YES"
        return "YES";
    }

}
