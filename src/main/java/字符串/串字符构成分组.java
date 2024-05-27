/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 22:19
 */


package 字符串;
import java.util.*;


/*
描述
陈经理的农场有多个牛棚，每个牛棚都含有不同品种的牛。陈经理决定对牛棚进行整顿，
将构成相同的牲畜品种分组合并。编写一个程序，根据提供的牛棚品种信息列表，
将重新排列源单词的所有字母组成的相同牛棚内品种，并以逗号形式隔开，并将组合在一起的结果以列表形式返回，列表中以字典序确定单词顺序。
示例1
输入：["eat", "tea", "tan", "ate", "nat", "bat"]
返回值：["bat","eat,tea,ate","tan,nat"]

示例2
输入：["a"]
返回值：["a"]

备注：
1 <= len(strs) <= 2 * 10^4
0 <= len(strs[i]) <= 100
strs[i] 仅包含小写英文字母。
 */

public class 串字符构成分组 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param strs string字符串一维数组
     * @return string字符串一维数组
     */

    public String[] groupAnagrams(String[] strs) {
        // 创建一个哈希表，键为重新排列后的单词，值为包含原始单词的列表
        HashMap<String, String> map = new HashMap();
        // 遍历输入的字符串数组
        for (String s : strs) {
            // 将字符串转换为字符数组并排序
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            // 将排好序的字符数组转换为字符串作为哈希表的键
            String sortedStr = new String(arr);
            // 如果哈希表中不存在该键，则将其加入，并将对应的值设为当前字符串
            if (map.get(sortedStr) == null)
                map.put(sortedStr, s);
                // 如果哈希表中已经存在该键，则将当前字符串追加到值的末尾，并以逗号隔开
            else
                map.put(sortedStr, map.get(sortedStr) + "," + s);
        }
        // 创建一个字符串数组用于存放结果
        String[] ans = new String[map.size()];
        // 遍历哈希表的值，并将其存入结果数组中
        int idx = 0;
        for (String val : map.values()) {
            ans[idx++] = val;
        }
        // 对结果数组进行排序
        Arrays.sort(ans);
        // 返回结果数组
        return ans;
    }
}
