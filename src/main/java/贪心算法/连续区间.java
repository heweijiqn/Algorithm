/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 23:29
 */


package 贪心算法;
import java.util.*;

/*
描述
在一个牧场里，有 n 头奶牛各自分布在编号为 0 到 10000 的若干个喂养时间段。每一个喂养时间段由开始时刻 start 和结束时刻 end 组成，[start, end]。现在牧场的管理员需要合并所有的重叠喂养时间期间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有时间区间。给定一个数组 intervals ，表示这些喂养时间。你需要返回的是合并后的时间区间的列表。
示例1
输入：[[1, 3], [2, 6], [8, 10], [15, 18]]
返回值：[[1,6],[8,10],[15,18]]

示例2
输入：[[1, 4],[4, 5]]
返回值：[[1,5]]

备注：
  (1 <= n <= 10^4)
（0 <= start <= end <= 10000）
 */

public class 连续区间 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param intervals int整型二维数组
     * @return int整型二维数组
     */
    public int[][] mergeTimeIntervals (int[][] intervals) {
        // write code here
        if (intervals.length == 0) {
            return new int[0][];
        }

        // 按照区间的起始位置排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            // 如果 merged 为空或者当前区间与 merged 中最后一个区间不重叠，直接添加到 merged 中
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // 否则，合并当前区间与 merged 中最后一个区间
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1],
                        interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
