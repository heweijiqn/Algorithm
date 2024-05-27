/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 22:55
 */


package 栈与队列;

/*
描述
在一个牧场中，有n个牛舍，每个牛舍的占地面积都不同。每个牛舍都与相邻的牛舍紧密相连，每个牛舍的宽度都为1。每个牛舍的长度都不同，记录在数组areas中。
现在需要在这些牛舍中选择一些连续的牛舍盖棚，棚是长方形的，为了节省成本，它能照顾到同样的宽度，但是只能照顾到较短的长度，求棚能覆盖的到的最大面积。

示例1
输入：[5,4,3,2,1]
返回值：9

说明：
前三个牛舍拼起来

示例2
输入：[2,4]
返回值：4

备注：
1 <= areas.length <=10000
0 <= areas[i] <= 5000
 */

public class 最小占地面积 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param areas int整型一维数组
     * @return int整型
     */
    public int maxArea (int[] areas) {
        // write code here
        int n = areas.length;
        // 创建一个二维数组用于保存每个区间内的最小值
        int[][] minArr = new int[n][n]; // 保存最小值
        int ans = 0; // 最大面积
        // 遍历每个牛舍
        for (int i = 0; i < n; i++) {
            // 初始化当前牛舍的面积为自身面积，更新最大面积
            minArr[i][i] = areas[i];
            ans = Math.max(ans, areas[i]);
            // 遍历以当前牛舍为起点的所有区间
            for (int j = i + 1; j < n; j++) {
                // 计算当前区间内的最小值
                minArr[i][j] = Math.min(minArr[i][j - 1], areas[j]);
                // 计算当前区间的面积，并更新最大面积
                ans = Math.max(ans, minArr[i][j] * (j - i + 1));
            }
        }
        // 返回最大面积
        return ans;
    }
}
