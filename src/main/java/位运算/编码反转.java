/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 23:22
 */


package 位运算;

/*
描述
在一个农场中，农夫使用32位有符号整数的二进制字符串来编码他的牛群。有一天，农夫想要改变编码方式，他决定把每一头牛的编码反转。现在，农夫给出了一头牛的编码 n，你需要帮他计算出反转后的编码。
示例1
输入：1
返回值：-2147483648

说明：
00000000 00000000 00000000 00000001
翻转后为
10000000 00000000 00000000 00000000
示例2
输入：1431655765
返回值：-1431655766

示例3
输入：-1
返回值：-1
 */

public class 编码反转 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param n int整型
     * @return int整型
     */
    public int reverseBits (int n) {
        // write code here
        // 将整数转换为32位二进制字符串
        String binaryString = Integer.toBinaryString(n);
        // 补齐到32位
        while (binaryString.length() < 32) {
            binaryString = "0" + binaryString;
        }

        // 将二进制字符串进行逆序（反转）
        StringBuilder reversedBinaryString = new StringBuilder(binaryString).reverse();

        // 将逆序后的二进制字符串转换回整数
        return Integer.parseUnsignedInt(reversedBinaryString.toString(), 2);
    }
}
