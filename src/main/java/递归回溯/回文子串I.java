/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 23:09
 */


package 递归回溯;
import java.util.*;


/*
描述
农场主人有一群牛，他给每只牛都取了一个名字，名字由小写字母组成。农场主人希望将这些牛分成一些组，
每组的牛的名字合在一起都是回文串。回文串是正着读和反着读都一样的字符串。请你帮助农场主人找出所有可能的分组方案。每个分组方案按照字典序升序返回。

示例1
输入："xxy"
返回值：[["x","x","y"],["xx","y"]]

备注：
1 <= s.length <= 15
 */
public class 回文子串I {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @return string字符串二维数组
     */
    // 主方法，返回所有可能的回文分组方案，以 String[][] 格式返回
    public String[][] partition(String s) {
        List<List<String>> result = new ArrayList<>();

        // 调用递归回溯方法来找出所有的回文分组方案
        backtrack(s, 0, new ArrayList<>(), result);

        // 将结果 List 转换为 String[][] 数组
        String[][] resultArray = new String[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            List<String> partition = result.get(i);
            resultArray[i] = partition.toArray(new String[0]);
        }
        return resultArray;
    }

    // 回溯方法，生成所有可能的回文分组
    private void backtrack(String s, int start, List<String> currentList,
                           List<List<String>> result) {
        // 如果起始位置等于字符串长度，表示已经处理完所有字符
        if (start == s.length()) {
            result.add(new ArrayList<>(currentList)); // 将当前分组添加到结果集
            return;
        }

        // 从起始位置开始，尝试每一个可能的结束位置
        for (int end = start; end < s.length(); end++) {
            // 如果从 start 到 end 的子串是回文
            if (isPalindrome(s, start, end)) {
                currentList.add(s.substring(start, end + 1)); // 将子串加入当前分组
                backtrack(s, end + 1, currentList, result); // 递归处理剩余的字符串
                currentList.remove(currentList.size() -
                        1); // 回溯，移除刚刚添加的子串
            }
        }
    }

    // 辅助方法，判断子串是否为回文
    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(
                    high--)) { // 如果字符不相等，则不是回文
                return false;
            }
        }
        return true; // 如果所有字符都相等，则是回文
    }

}
