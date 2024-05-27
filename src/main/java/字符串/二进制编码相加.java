/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 21:54
 */


package 字符串;

/*
描述
在一个农场中，农夫使用二进制字符串来编码他的牛群。每一头牛都有一个二进制编码，农夫将两头牛的编码相加，
以此来创建一个新的二进制编码。现在，农夫给出了两头牛的编码 a 和 b，你需要帮他计算出它们的编码和。
示例1
输入："1101","101"
返回值："10010"

示例2
输入："1111","1111"
返回值："11110"

备注：
1 <= a.length, b.length <= 10^4，编码只由字符 '0' 或 '1' 组成，编码如果不是 "0" ，就不含前导零。
 */

public class 二进制编码相加 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param a string字符串
     * @param b string字符串
     * @return string字符串
     */
    public String addBinary(String a, String b) {
        // 设置指针 i 和 j 分别指向两个字符串的末尾
        int i = a.length() - 1;
        int j = b.length() - 1;
        // 初始化进位标志为 0
        int flag = 0;
        // 用于存储结果的 StringBuilder
        StringBuilder sb = new StringBuilder();

        // 当两个字符串任意一个还有位数未处理或者有进位时，继续循环
        while (i >= 0 || j >= 0 || flag > 0) {
            // sum 用于存储当前位的和，初始化为进位值
            int sum = flag;
            // 如果字符串 a 还有未处理位数，则将当前位加到 sum 中，并移动指针 i
            if (i >= 0) {
                sum = sum + a.charAt(i) - '0';
                i--;
            }
            // 如果字符串 b 还有未处理位数，则将当前位加到 sum 中，并移动指针 j
            if (j >= 0) {
                sum = sum + (int) b.charAt(j) - '0';
                j--;
            }
            // 将 sum 对 2 取模得到当前位的值，并插入到结果的最前面
            sb.insert(0, sum % 2);
            // 更新进位标志，如果 sum 大于等于 2，则进位为 1，否则为 0
            flag = sum / 2;
        }
        // 返回结果字符串
        return sb.toString();
    }

}
