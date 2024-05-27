/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 21:58
 */


package 字符串;

/*
描述
在一个农场中，农夫使用三进制字符串来编码他的牛群。每一头牛都有一个三进制编码，农夫将两头牛的编码相减，
以此来创建一个新的三进制编码。现在，农夫给出了两头牛的编码 a 和 b，你需要帮他计算出它们的编码差。

示例1
输入："2101","101"
返回值："2000"

示例2
输入："20201","10110"
返回值："10021"

示例3
输入："222222222222222222","1111111111111111"
返回值："221111111111111111"

备注：
1 <= a.length, b.length <= 10^4，编码只由字符 '0'、'1' 或 '2' 组成，编码如果不是 "0" ，就不含前导零。
保证a不小于b
 */

public class 三进制相减 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param a string字符串
     * @param b string字符串
     * @return string字符串
     */
    public String subtractTernary (String a, String b) {
        // write code here
        // 初始化指针，分别指向两个字符串的末尾
        int i = a.length() - 1;
        int j = b.length() - 1;
        // 用于存储结果的 StringBuilder
        StringBuilder sb = new StringBuilder();
        // 定义借位标志
        boolean borrow = false;

        // 从右往左依次计算
        while (i >= 0 || j >= 0) {
            // 获取当前位的值，如果 i 或 j 已经到达字符串的开头，则默认为 0
            int digitA = (i >= 0) ? (a.charAt(i--) - '0') : 0;
            int digitB = (j >= 0) ? (b.charAt(j--) - '0') : 0;

            // 如果当前位的值小于需要借位的情况
            if (borrow) {
                // 如果当前位的值不为 0，则需要向前借位
                if (digitA == 0) {
                    digitA = 2;
                    borrow = true;
                } else {
                    digitA--;
                    borrow = false;
                }
            }

            // 计算当前位的差值
            int diff = digitA - digitB;

            // 如果差值为负数，则需要借位
            if (diff < 0) {
                diff += 3;
                borrow = true;
            }

            // 将差值加入到结果的最前面
            sb.insert(0, diff);
        }

        // 去除结果前面的0
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        // 返回结果
        return sb.toString();
    }
}
