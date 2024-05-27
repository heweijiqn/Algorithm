/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 23:37
 */


package 动态规划;

/*
描述
农场里有一群牛，每头牛都有一个能量值，这些能量值组成一个环形整数数组 energy。现在农场主想知道，从这群牛中选择一个连续的子群，使得这个子群的能量值之和最大。请你编写一个程序，实现这个功能。

环形数组意味着数组的末端将会与开头相连呈环状。形式上，energy[i] 的下一个元素是 energy[(i + 1) % n] ，energy[i] 的前一个元素是 energy[(i - 1 + n) % n]。

子群中每个位置的元素最多只能出现一次。

示例1
输入：[3,-2,2,3]
返回值：8

示例2
输入：[2,3,1,-5,4]
返回值：10

备注：
n == energy.length
1 <= n <= 3000
-2000 <= energy[i] <= 2000
 */

public class 最大数组环 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param energy int整型一维数组
     * @return int整型
     */
    public int maxEnergyCircular (int[] energy) {
        // write code here
        // 边界条件，如果数组为空，返回0
        if (energy == null || energy.length == 0) {
            return 0;
        }

        int n = energy.length;
        int maxKadane = kadane(energy); // 非环形的最大子数组和
        int totalSum = 0;

        // 计算总和和最小子数组和
        for (int i = 0; i < n; i++) {
            totalSum += energy[i];
            energy[i] = -energy[i];
        }

        int minKadane = kadane(energy);
        // 由于我们之前取了相反数，所以这里的 Kadane 实际上给我们的是最小子数组和的相反数

        int maxCircular = totalSum + minKadane; // 最大环形子数组和

        // 如果 maxCircular 为 0，则意味着数组中全是负数，我们应该返回 maxKadane
        if (maxCircular == 0) {
            return maxKadane;
        }

        return Math.max(maxKadane, maxCircular);
    }

    // Kadane 的算法实现，计算最大子数组和
    private int kadane(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
