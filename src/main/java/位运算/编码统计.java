/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 23:23
 */


package 位运算;
import java.util.*;

/*
描述
在一个农场中，农夫使用32位有符号整数的二进制字符串来编码他的牛群。
有一天，农夫想要统计一下他的牛群中，编码中'0'的个数。现在，农夫给出了一头牛的编码 n，你需要帮他计算出编码中'0'的个数。

示例1
输入：11
返回值：29

说明：
二进制00000000000000000000000000001011中有29位0
备注：
输入数字n为32位有符号数
 */

public class 编码统计 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param n int整型
     * @return int整型
     */
    public int countZeros (int n) {
        // write code here
        //将整型转化为二进制码
        String binary = Integer.toBinaryString(n);
        int count = 0;
        //还需要补充开头0的个数
        String supple = "";

        if (binary.length() < 32) {
            for (int i = 0; i < 32 - binary.length(); i++) {
                supple += "0";
            }
        }
        //遍历二进制字符串，统计 '0' 的个数
        binary = supple + binary;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') count++;
        }
        return count;
    }
}
