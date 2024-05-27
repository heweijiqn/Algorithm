/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 23:34
 */


package 动态规划;

/*
描述
农场里有一种特殊的牛，这种牛有一个特点，它不能连续吃草，如果它连续吃相邻的草料，
会降低它的食欲，所以农场主人需要安排它吃草的顺序。农场主人准备了n块草料，每块草的饱腹感不同，你需要帮农场主人计算出在不引起该牛食欲降低的情况下，能够让牛吃到的草得到的最高饱腹感是多少。


示例1
输入：[1,2,3,1]
返回值：4

说明：
让牛吃第1块草(饱腹感=1)，然后它吃第3块草(饱腹感=3)。总饱腹感=1+3=4。
备注：
1 <= nums.length <= 1000
0 <= nums[i] <= 4000
 */

public class 不能连续吃草的牛 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int eatGrass (int[] nums) {
        // write code here
        int n = nums.length;

        if (n == 0) {
            return 0; // 没有房屋可偷
        } else if (n == 1) {
            return nums[0]; // 只有一间房屋
        } else if (n == 2) {
            return Math.max(nums[0], nums[1]); // 只有两间房屋，取最大值
        }

        // 创建动态规划数组
        int[] dp = new int[n];

        // 基础情况
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // 填充 dp 数组
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]); // 选择最佳选项
        }

        return dp[n - 1]; // 最终的最大收益
    }
    // 设 dp[i] 表示前 i 块草能获得的最高饱腹感。

    // 当 i = 0 时，dp[0] = nums[0]，因为只有一块草。

    // 当 i = 1 时，dp[1] = max(nums[0],
    // nums[1])，因为不能连续吃相邻的草。

    // 当 i > 1 时，有两种情况：

    // 如果吃了第 i 块草，则前一块草不能吃，所以 dp[i] = dp[i - 2] +
    // nums[i]；
    // 如果不吃第 i 块草，则前 i - 1
    // 块草能获得的最高饱腹感，所以 dp[i] = dp[i - 1]。
    // 因此，dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])。
}
