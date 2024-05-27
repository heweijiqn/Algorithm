/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 23:38
 */


package 动态规划;


/*
描述
农场里有一群牛，每头牛都有一个能量值。现在农场主想知道，从这群牛中选择一个连续的子群，使得这个子群的能量值之和最大。请你编写一个程序，实现这个功能。
示例1
输入：[1,2,3,4,5]
返回值：15

示例2
输入：[-1,-2,-3,-4,-5]
返回值：-1

备注：
1 <= energy.length <= 10000
-1000 <= energy[i] <= 1000
 */
public class 最大数组和 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param energy int整型一维数组
     * @return int整型
     */
    public int maxEnergy (int[] energy) {
        // write code here
        // 边界条件，如果数组为空，返回0
        if (energy == null || energy.length == 0) {
            return 0;
        }

        // 初始化当前子数组和和全局最大和
        int currentSum = energy[0];
        int maxSum = energy[0];

        // 遍历数组，更新当前子数组和和全局最大和
        for (int i = 1; i < energy.length; i++) {
            // 如果当前子数组和小于0，则从当前元素重新开始计算子数组和
            currentSum = Math.max(energy[i], currentSum + energy[i]);
            // 更新全局最大和
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
