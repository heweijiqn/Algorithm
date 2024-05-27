/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 23:26
 */


package 贪心算法;
import java.util.*;

/*
描述
在一个牧场里，务必使得各牛舍之间互不干扰。为了这个目的，现在给定一个无重叠区间列表 intervals，
该列表表示现有牛舍所占据的区间，按照区间起始端点排序。现在，一个新的牛舍需要被扩建，收到了新的区间 newInterval。向列表中插入新区间，并确保列表中的区间仍然有序且不重叠。如果需要，可以合并后使得列表的区间不重叠，用[start, end]表示区间。
示例1
输入：[[1, 3], [6, 9]],[2, 5]
返回值：[[1,5],[6,9]]

示例2
输入：[[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]],[4, 8]
返回值：[[1,2],[3,10],[12,16]]
复制
备注：
0 <= intervals.size() <= 10^4，0 <= intervals[i][0] <= intervals[i][1] <= 10^5
0 <= newInterval[0] <= newInterval[1] <= 10^5
 */

public class 区间覆盖 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param intervals int整型二维数组
     * @param new_interval int整型一维数组
     * @return int整型二维数组
     */
    public int[][] insertNewInterval (int[][] intervals, int[] new_interval) {
        // write code here
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // 添加所有在 newInterval 之前的区间
        while (i < n && intervals[i][1] < new_interval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // 合并所有与 newInterval 重叠的区间
        while (i < n && intervals[i][0] <= new_interval[1]) {
            new_interval[0] = Math.min(new_interval[0], intervals[i][0]);
            new_interval[1] = Math.max(new_interval[1], intervals[i][1]);
            i++;
        }
        // 将合并后的 newInterval 添加到结果中
        result.add(new_interval);

        // 添加所有在 newInterval 之后的区间
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
