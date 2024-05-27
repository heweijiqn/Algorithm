/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 21:20
 */


package 字符串;

/*
描述
草原上的牛群每个成员都有一个昵称，作为身份的标志。这些昵称在去除非字母数字字符和忽略大小写后，
如果正着读和反着读都一样（空串我们认为是回文），则这个昵称被认为是回文昵称。
现在需要你编写一个程序，判断给定的昵称是否为回文昵称.

示例1
输入："Little BoCalf: 77, fLAcoB elTtil!"
返回值：true
说明：
在去除非字母数字字符，并忽略大小写后，昵称为 "littlebocalf77flacobelttil"，它是一个回文昵称。

示例2
输入："Cows jump high!"
返回值：false
说明：
在去除非字母数字字符，并忽略大小写后，昵称为 "cowsjumphigh"，它不是一个回文昵称。

备注：
s（1 <= s.length <= 2 * 10^5），表示牛群中一个成员的昵称，仅包含可打印的 ASCII 字符。
 */

public class 回文昵称 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isPalindromeNickname (String s) {
        // write code here
        // 去除非字母数字字符，并转换为小写
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        String cleanStr = sb.toString();

        // 使用双指针方法判断是否为回文
        int left = 0, right = cleanStr.length() - 1;
        while (left < right) {
            if (cleanStr.charAt(left) != cleanStr.charAt(right)) {
                return false; // 如果左右指针指向的字符不相等，则不是回文
            }
            left++;
            right--;
        }
        return true; // 如果全部比较完毕都相等，则是回文
    }
}
