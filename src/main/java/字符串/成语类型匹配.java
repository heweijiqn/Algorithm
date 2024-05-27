/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 22:13
 */


package 字符串;
import java.util.*;

/*
描述
描述：陈经理的农场养了很多头牛，他决定采用一种指导规律来帮助他管理牛群。
他命名了不同类别的牛和分类规律。输入指导规律pattern和管理策略plan，请你编写一个程序来判断管理策略plan是否遵循相同的指导规律。
遵循指导规律定义：
plan中的每个单词，分别与pattern中的每个字符匹配
顺序完全匹配
例如我们常用的AABB式成语之类的

示例1
输入："aabb","calf calf bull bull"
返回值：true

示例2
输入："aabb","calf calf bull cow"
返回值：false

备注：
1 <= len(pattern) <= 300
pattern 仅包含小写英文字母
1 <= len(plan) <= 3000
plan 仅包含小写英文字母和 ' '
plan 不包含任何前导或尾随对空格
plan 中每个单词都被单个空格分隔
 */

public class 成语类型匹配 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param pattern string字符串
     * @param plan string字符串
     * @return bool布尔型
     */
    public boolean isValidPattern (String pattern, String plan) {
        // write code here
        // 将 pattern 和 plan 按空格分割成字符数组和单词数组
        String[] patterns = pattern.split("");
        String[] plans = plan.split(" ");

        // 如果 pattern 和 plan 的长度不相等，则直接返回 false
        if (patterns.length != plans.length) {
            return false;
        }

        // 使用两个哈希表来存储字符和单词之间的映射关系
        Map<String, String> patternToPlan = new HashMap<>();
        Map<String, String> planToPattern = new HashMap<>();

        // 遍历 pattern 和 plan 的每个字符和单词，分别建立两个哈希表的映射关系
        for (int i = 0; i < patterns.length; i++) {
            String patt = patterns[i];
            String pl = plans[i];
            // 如果当前字符或单词在其中一个哈希表中已经有了映射，但是映射关系不一致，则返回 false
            if ((patternToPlan.containsKey(patt) && !patternToPlan.get(patt).equals(pl))
                    || (planToPattern.containsKey(pl) && !planToPattern.get(pl).equals(patt))) {
                return false;
            }
            patternToPlan.put(patt, pl);
            planToPattern.put(pl, patt);
        }

        // 如果遍历完成后没有出现不一致的映射关系，返回 true
        return true;
    }
}
