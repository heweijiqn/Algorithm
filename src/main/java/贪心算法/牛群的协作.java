/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 23:25
 */


package 贪心算法;
import java.util.*;

/*
描述
在一个平行世界里，有一群牛位于一维平面上。它们的位置可以用一维整数坐标系表示。
牛群的位置记录在整数数组 cow_ranges，其中 cow_ranges[i] = [left, right] 表示第 i 头牛所在的范围从 left 到 right。所有的牛都位于 y=0 处。
为了保存平行世界的和平，你需要发起一场特殊的攻击来击败这些牛。所有特殊攻击都在 x 轴上进行，且角度始终垂直。特殊攻击可以在任意 x 位置释放，牛的范围若是包含x位置就会被击败。
给定一个数组 cow_ranges，返回击败所有牛所需的最小特殊攻击次数。



示例1
输入：[[11,18],[3,10],[2,7],[8,15]]
返回值：2

说明：
可以用2次特殊攻击击败：

在 x = 7 处释放特殊攻击，击败牛 [3,10] 和 [2,7]。
在 x = 11 处释放特殊攻击，击败牛 [11,18] 和 [8,15]。
或者有其他击败方式，取最少次数即可。
示例2
输入：[[2,3],[5,6],[8,9],[11,12]]
返回值：4

说明：
每头牛都需要进行一次特殊攻击，总共需要4次。
备注：
1 <= cow_ranges.length <= 2 * 10^5
cow_ranges[i].length == 2
-2^31 <= left < right <= 2^31 - 1
 */

public class 牛群的协作 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param cow_ranges int整型二维数组
     * @return int整型
     */
    public int minParallelAttacks (int[][] cow_ranges) {
        // write code here
        // 按结束时间排序
        Arrays.sort(cow_ranges, (a, b) -> Integer.compare(a[1], b[1]));

        int attackCount = 0;
        int currentAttackPosition = Integer.MIN_VALUE;

        for (int[] range : cow_ranges) {
            if (range[0] > currentAttackPosition) {
                // 如果当前区间的开始大于当前特殊攻击的位置，则需要一次新的攻击
                attackCount++;
                currentAttackPosition = range[1]; // 更新当前特殊攻击的位置
            }
        }

        return attackCount;
    }
}
