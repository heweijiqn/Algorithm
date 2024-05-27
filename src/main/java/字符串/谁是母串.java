/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 21:52
 */


package 字符串;

/*
描述
农场主有一群牛，每头牛都有一个独特的名字，名字由英文字母组成。农场主注意到，有一些牛的名字具有特殊的规律，
这些名字可以由一个子串重复若干次得到。现在，农场主想要找出一个最短的子串，
这个子串既可以由牛A的名字str1生成，也可以由牛B的名字str2生成。你需要帮助农场主找出这个子串。
示例1
输入："ABC","ABCABC"
返回值："ABCABC"

示例2
输入："ABABABAB","ABAB"
返回值："ABABABAB"

备注：
m == str1.length，n == str2.length，1 <= m, n <= 1000，s 和 t 由大写英文字母组成
 */

public class 谁是母串 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param str1 string字符串
     * @param str2 string字符串
     * @return string字符串
     */
    public String lcmOfStrings (String str1, String str2) {
        // write code here
        // 判断一个字符串是否包含另一个字符串
        if (str1.contains(str2)) {
            return str1;
        } else if (str2.contains(str1)) {
            return str2;
        } else {
            return "";
        }
    }
}
