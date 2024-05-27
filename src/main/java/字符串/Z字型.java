/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 21:26
 */


package 字符串;

/*
描述
牛牛和朋友们为了在相对远距离进行信息传递，他们使用了一种旗语方式。他们通过将信号字符串在特定的行数采用"Z"字形排列方式加密（从上往下，从左到右读取）。然而，由于网络问题，有时候加密过后的旗语传递效果不佳，这导致他们需要程序师们提交一个函数来解码这些被加密过的旗语，他们找到了你，请你实现一个函数，根据给定的加密字符串 s 和行数 numRows 进行解码。
示例1
输入："TWIPARSEHC_NK",3
返回值："TAHKWPRECNIS_"

说明：字符串的Z字型排列为：
T      A       H      K
W P R  E  C   N
I       S       _
故从Z字型读取该字符串就是TWIPARSEHC_NK，需要还原的是正常横向读取的
示例2
输入："P",1
返回值："P"

备注：
 1 <= s.length <= 1000, s 仅由大小写英文字母、'_' 和 '-' 组成
 1 <= numRows <= 1000
 */

public class Z字型 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @param numRows int整型
     * @return string字符串
     */
    public String decodeFlag (String s, int numRows) {
        // write code here
        // 如果只有一行，直接返回原字符串
        if (numRows == 1) {
            return s;
        }
        // 创建一个字符串数组，用于存储每行的字符
        StringBuilder[] rows = new StringBuilder[numRows];
        // 初始化每行的 StringBuilder 对象
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        // 初始化行号和方向
        int row = 0;
        boolean goingDown = false;
        // 遍历字符串 s
        for (char c : s.toCharArray()) {
            // 将当前字符添加到对应的行
            rows[row].append(c);
            // 如果到达了第一行或最后一行，改变方向
            if (row == 0 || row == numRows - 1) {
                goingDown = !goingDown;
            }
            // 根据方向更新行号
            row += goingDown ? 1 : -1;
        }
        // 将每行的字符拼接起来作为结果
        StringBuilder result = new StringBuilder();
        for (StringBuilder rowString : rows) {
            result.append(rowString);
        }
        return result.toString();
    }
}
