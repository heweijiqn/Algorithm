/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 23:04
 */


package 哈希;
import java.util.*;

/*
描述
在一个农场里，有n头牛，每头牛的体重可能相同也可能不同。农场主人想要统计每种体重的牛的数量。
给你一个长度为n的整数数组weight，其中weight[i]是第i头牛的体重。请你帮助农场主人判断是否每种体重的牛的数量都是不同的。
如果每种体重的牛的数量都是不同的，就返回 true；否则返回 false。

示例1
输入：[500, 500, 600]
返回值：true

示例2
输入：[500, 0, 500, 500, 500, 500, 500, 500, 1000, 0]
返回值：true

示例3
输入：[500, 500, 500, 600, 600, 700, 700, 700]
返回值：false

备注：
n == weight.length
1 <= n <= 10000
0 <= weight[i] <= 1000
 */

public class 不同的体重 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param arr int整型一维数组
     * @return bool布尔型
     */
    public boolean uniqueOccurrences (int[] arr) {
        // write code here
        // 使用哈希表统计每种体重的出现次数
        Map<Integer, Integer> weightCount = new HashMap<>();
        for (int w : arr) {
            weightCount.put(w, weightCount.getOrDefault(w, 0) + 1);
        }

        // 使用集合来检查出现次数是否唯一
        Set<Integer> occurrences = new HashSet<>();
        for (int count : weightCount.values()) {
            // 如果集合中已经存在该出现次数，返回 false
            if (!occurrences.add(count)) {
                return false;
            }
        }
        // 如果所有出现次数都是唯一的，返回 true
        return true;
    }
}
