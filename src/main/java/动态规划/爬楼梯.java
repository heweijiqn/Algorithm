/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 23:39
 */


package 动态规划;


/*
描述
农场里有一只特别贪吃的牛，这牛喜欢吃草，一次性可以吃1块或者2块草料。现在农场主要为牛吃草料，他准备了n块草料，你需要计算出这头牛有多少种不同的方式吃完这n块草料。
示例1
输入：1
返回值：1

示例2
输入：2
返回值：2

说明：
一次性吃两块，或者分两次吃一块
示例3
输入：4
返回值：5
复制
备注：
1 <= n <= 25
 */
public class 爬楼梯 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param n int整型
     * @return int整型
     */
    public int eatGrass (int n) {
        // write code here
        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
