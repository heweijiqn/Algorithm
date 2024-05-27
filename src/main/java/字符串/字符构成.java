/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 22:15
 */


package 字符串;
import java.util.*;

/*
描述
为了提高农场效率，陈经理决定引入人工智能系统帮助管理农场。他请你开发一个智能系统来完成牛只数量统计的任务。
你需要编写一个程序，根据农场管理员输入的字符串 allocations 和 requirements ，
判断 requirements 是否能全部由 allocations 中的字符构成。要求字符使用一一对应，即 allocations 中的每个字符只能在 requirements 中使用一次。


示例1
输入："AB","AAB"
返回值："YES"

示例2
输入："A","B"
返回值："NO"

示例3
输入："AA","AB"
返回值："NO"

备注：
1 <= len(allocations), len(requirements) <= 10^5
allocations 和 requirements 均由大写英文字母组成。
 */

public class 字符构成 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param requirements string字符串
     * @param allocations string字符串
     * @return string字符串
     */
    public String can_construct (String requirements, String allocations) {
        // write code here
        // 统计 allocations 中字符的数量
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : allocations.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // 检查 requirements 是否能由 allocations 中的字符构成
        for (char c : requirements.toCharArray()) {
            if (!charCount.containsKey(c) || charCount.get(c) == 0) {
                return "NO";
            }
            charCount.put(c, charCount.get(c) - 1);
        }

        // 返回结果
        return "YES";
    }
}
