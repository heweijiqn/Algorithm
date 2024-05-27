/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 21:51
 */


package 字符串;

/*
描述
农场主有一群牛，每头牛都有一个独特的名字，名字由英文字母组成。农场主注意到，
有一些牛的名字具有特殊的规律，这些名字可以由一个子串重复若干次得到。
现在，农场主想要找出一个最长的子串，这个子串既可以生成牛A的名字str1，也可以生成牛B的名字str2。你需要帮助农场主找出这个子串。
示例1
输入："ABCABC","ABC"
返回值："ABC"

示例2
输入："ABABAB","ABAB"
返回值："AB"

备注：
m == str1.length，n == str2.length，1 <= m, n <= 1000，s 和 t 由大写英文字母组成
 */

public class 共同子串 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param str1 string字符串
     * @param str2 string字符串
     * @return string字符串
     */
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        // 寻找最大公因子
        int gcdLength = gcd(len1, len2);
        String gcdString = str1.substring(0, gcdLength);

        // 检查是否满足条件
        if (checkDivisible(str1, gcdString) && checkDivisible(str2, gcdString)) {
            return gcdString;
        } else {
            return "";
        }
    }

    // 辅助函数：求两个数的最大公因子
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    // 辅助函数：检查字符串是否能被子串整除
    private boolean checkDivisible(String str, String sub) {
        int len = str.length();
        int subLen = sub.length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len / subLen; i++) {
            sb.append(sub);
        }

        return sb.toString().equals(str);
    }
}
