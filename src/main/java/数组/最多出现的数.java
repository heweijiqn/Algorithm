/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 22:28
 */


package 数组;
import java.util.*;

/*
描述
在一片广阔的草原上，有多个不同种类的牛群。我们可以用一个数组 nums 表示这些牛的种类（用整数表示）。
每种牛的数量不同，但总是存在一种优势牛种，其数量是总数量的一半以上。你需要编写一个函数，找到这个优势牛种，用整数表示。

示例1
输入：[3, 1, 3]
返回值：3

备注：
nums（1 <= |nums| <= 5 * 10^4）
 */

public class 最多出现的数 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int majority_cow (int[] nums) {
        // write code here
        // 创建哈希表，用于统计每种牛的数量
        Map<Integer, Integer> countMap = new HashMap<>();
        // 统计每种牛的数量
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        // 找到数量超过总数量一半以上的牛种
        for (int key : countMap.keySet()) {
            if (countMap.get(key) > nums.length / 2) {
                return key;
            }
        }

        return -1;

    }

}
