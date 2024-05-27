/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 21:45
 */


package 字符串;
/*
描述
草原上的牛们都有各种各样的名字，它们认为名字中包含共同的前缀表示有共同的祖先。
现在草原上的牛们请求你帮忙找出他们中间有哪些牛有共同的祖先，
请编写一个函数，求解这些名字中的最长公共前缀。如果不存在共同的祖先（没有公共前缀），请返回空字符串""。请编写一个函数，返回字符串数组中的最长公共前缀。
示例1
输入：["touthill", "touttail", "toutrain"]
返回值：
"tout"

备注：
1 <= names.length <= 200
0 <= names[i].length <= 200
names[i] 仅由小写英文字母组成
 */

public class 相同前缀 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param names string字符串一维数组
     * @return string字符串
     */
    public String findAncestor (String[] names) {
        // write code here
        if (names == null || names.length == 0) {
            return "";
        }

        String prefix = names[0];

        for (int i = 1; i < names.length; i++) {
            while (!names[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}
