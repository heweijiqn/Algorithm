/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 23:17
 */


package 二分分治;

/*
描述
农场里有一群牛，每头牛都有一个身高，这些身高按照从高到低的顺序排列在一个 n 的牛棚中。
为了混乱猎豹的视线，农场主人决定旋转牛群的排列顺序，也就是将牛棚中的牛按照一定的次数向后旋转。例如，原数组 heights = [7,6,5,4,3,2,1] 在变化后可能得到：
若旋转 4 次，则可以得到 [4,3,2,1,7,6,5]
若旋转 7 次，则可以得到 [7,6,5,4,3,2,1]
注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
请你找出并返回数组中的 最小元素 。
你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。

示例1
输入：[5,4,3,2,1,7,6]
返回值：1

示例2
输入：[2,1,7,6,5,4,3]
返回值：1

示例3
输入：[17,15,13,11]
返回值：11

备注：
n == heights.length
1 <= n <= 5000
0 <= heights[i] <= 5000
heights 中的所有整数 互不相同
heights 原来是一个降序排序的数组，并进行了 1 至 k 次旋转，k未知
 */

public class 旋转排列之找出最矮的牛 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param heights int整型一维数组
     * @return int整型
     */
    public int findMin (int[] heights) {
        // write code here
        // 定义一个变量来存储最小值，初始值为数组中的第一个元素
        int min = heights[0];
        // 获取数组的长度
        int heightsLen = heights.length;
        // 如果第一个元素大于最后一个元素，说明数组是降序排列的，那么最小值就是最后一个元素
        if (heights[0] > heights[heightsLen - 1])
            min = heights[heightsLen - 1];
        // 遍历数组中的元素
        for (int i = 0; i < heightsLen - 1; i++) {
            // 如果当前元素小于下一个元素，则更新最小值为当前元素
            if (heights[i] < heights[i + 1])
                min = heights[i];
        }
        // 返回最小值
        return min;
    }
}
