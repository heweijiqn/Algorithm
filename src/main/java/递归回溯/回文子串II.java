/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 23:08
 */


package 递归回溯;
import java.util.*;

/*
描述
农场主人有一群牛，他给每只牛都取了一个名字，名字由小写字母组成。农场主人希望找出所有的回文子串，
回文串是正着读和反着读都一样的字符串，但不包含长度为1的。请你帮助农场主人找出所有可能的回文子串，每个回文子串按照字典序升序返回。
示例1
输入："aab"
返回值：["aa"]

示例2
输入："abcba"
返回值：["abcba","bcb"]

备注：
1 <= s.length <= 16
 */

public class 回文子串II {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @return string字符串一维数组
     */
    public String[] partitionII (String s) {
        // write code here
        // 主方法，查找所有长度大于1的回文子串，并按字典序返回
        TreeSet<String> palindromes = new TreeSet<>(); // 使用 TreeSet 自动按字典序排序

        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 2; j <= n; j++) { // 从 i 开始的子串，长度至少为2
                String substr = s.substring(i, j);
                if (isPalindrome(substr)) {
                    palindromes.add(substr);
                }
            }
        }

        return palindromes.toArray(new String[0]); // 将 TreeSet 转换为 String 数组返回
    }

    // 辅助方法，检查给定字符串是否为回文
    private boolean isPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }
        return true;
    }
}
