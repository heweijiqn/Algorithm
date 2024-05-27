/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 23:35
 */


package 动态规划;

/*
描述
牛牛和朋友正在使用一种新型消息传输系统。在这个系统中，有一个特殊的编码方式，
它允许将两个字符串 s 和 x 交织在一起，形成一个新的字符串 t，
要求保持它们的字符顺序不变。如果字符串 t 既包含字符串 s 的子序列，也包含字符串 x 的子序列，包含部分不重复，且刚好由这两个子序列组成，那么 t 就称为 s 和 x 的交织子序列。
给定三个字符串 s, x, t，请判断 t 是否是 s 和 x 的交织子序列。


示例1
输入："abc","mno","amnbco"
返回值：true

示例2
输入："abco","mno","amxboncd"
返回值：false

示例3
输入："abc","mno","abcmnod"
返回值：false

说明：
t多余的d字符不是前两个字符中的
备注：
 s（0 <= s.length <= 100），x（0 <= x.length <= 100） 和 t（0 <= t.length <= 10^4），只包含小写字母。
 */
public class 交叉子序列 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @param x string字符串
     * @param t string字符串
     * @return bool布尔型
     */
    public boolean isInterleave (String s, String x, String t) {
        // write code here
        int m = s.length();
        int n = x.length();
        int len = t.length();

        if (m + n != len) {
            return false; // 如果字符串 t 的长度不等于字符串 s 和 x 的长度之和，直接返回 false
        }

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true; // 空字符串和空字符串可以交织成空字符串

        // 初始化第一行，表示 s 为空字符串时，x 是否能够交织成 t
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && x.charAt(j - 1) == t.charAt(j - 1);
        }

        // 初始化第一列，表示 x 为空字符串时，s 是否能够交织成 t
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s.charAt(i - 1) == t.charAt(i - 1);
        }

        // 填充 dp 数组
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 如果 s 的第 i 个字符等于 t 的第 i+j 个字符，则取决于 dp[i-1][j]
                if (s.charAt(i - 1) == t.charAt(i + j - 1)) {
                    dp[i][j] = dp[i - 1][j];
                }
                // 如果 x 的第 j 个字符等于 t 的第 i+j 个字符，则取决于 dp[i][j-1]
                if (x.charAt(j - 1) == t.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }

        return dp[m][n]; // 返回 dp[m][n]，表示 s 和 x 是否能够交织成 t
    }

}
