/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 23:31
 */


package 动态规划;
/*
描述
农场里有一种特殊的牛，这种牛有一个特点，它不能连续吃草，如果它连续吃相邻的草料，
会降低它的食欲，所以农场主人需要安排它吃草的顺序。农场主人准备了n块草料，每块草的饱腹感不同，但是这些草料是围成一个环的，
也就是第一块草和最后一块草是相邻的。你需要帮农场主人计算出在不引起该牛食欲降低的情况下，能够让牛吃到的草得到的最高饱腹感是多少。
示例1
输入：[2,3,2]
返回值：3

说明：
让牛吃第2块草(饱腹感=3)。总饱腹感=3。
示例2
输入：[1,2,3,1]
返回值：4

说明：
让牛吃第1块草(饱腹感=1)，然后让牛吃第3块草(饱腹感=3)。总饱腹感=1+3=4。

备注：
1 <= nums.length <= 1000
0 <= nums[i] <= 4000
 */

public class 不能连续吃草的牛II {
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
        if (n == 1) {
            return nums[0];
        }

        // 情况1：如果吃了第一块草，则不能吃最后一块草
        int[] dp1 = new int[n];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
        }
        int max1 = dp1[n - 2];

        // 情况2：如果没吃第一块草，则可以吃最后一块草
        int[] dp2 = new int[n];
        dp2[0] = 0; // 没吃第一块草
        dp2[1] = nums[1];
        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
        }
        int max2 = dp2[n - 1];

        // 取两种情况的最大值作为结果
        return Math.max(max1, max2);
    }

}
