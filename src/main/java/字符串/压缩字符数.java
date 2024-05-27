/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 22:20
 */


package 字符串;
import java.util.*;

/*
描述
农场里有一群牛，农夫为了方便管理，给每头牛都编了号，用字符来表示。现在农夫想要统计农场里每种牛的数量，
但是由于数量过多，农夫想要将连续的相同的牛的数量进行压缩表示。请你帮助农夫完成这个任务。
给你一个字符数组 cows ，请使用下述算法压缩：
从一个空字符串 s 开始。对于 cows 中的每组 连续重复字符 ：

如果这一组长度为 1 ，则将字符追加到 s 中，不作其他改变
否则，需要向 s 追加字符，后跟这一组的长度。
压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 cows 中。需要注意的是，如果组长度为 10 或 10 以上，则数字在 cows 数组中会被拆分为多个字符。

请在 修改完输入数组后 ，返回该数组的新长度。
你必须设计并实现一个只使用常量额外空间的算法来解决此问题。

示例1
输入：[x,x,y,y,z,z,z]
返回值：[x,2,y,2,z,3]

说明：
"xx" 被 "x2" 替代。"yy" 被 "y2" 替代。"zzz" 被 "z3" 替代。
示例2
输入：[a,b,b,b,b,b,b,b,b,b,b,b,b]
返回值：[a,b,1,2]
复制
说明：
由于字符 "a" 不重复，所以不会被压缩。"bbbbbbbbbbbb" 被 “b12” 替代。
备注：
1 <= cows.length <= 10000
cows[i] 可以是小写英文字母、大写英文字母、数字或符号


 */

public class 压缩字符数 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param chars char字符型一维数组
     * @return char字符型一维数组
     */
    public char[] compress (char[] chars) {
        // write code here
        // 创建一个哈希表，用于存储字符及其出现的次数
        Map<Character, Integer> myMap = new HashMap<>();
        // 统计字符数组中每个字符出现的次数
        for (int i = 0; i < chars.length; i++) {
            myMap.put(chars[i], myMap.getOrDefault(chars[i], 0) + 1);
        }
        // 创建一个字符串缓冲区，用于存储压缩后的结果
        StringBuilder stringBuffer = new StringBuilder();
        // 遍历哈希表的每个键值对
        for (Map.Entry<Character, Integer> map : myMap.entrySet()) {
            // 如果字符出现次数大于1，则将字符及其出现次数添加到结果中
            if (map.getValue() > 1) {
                stringBuffer.append(map.getKey());
                stringBuffer.append(map.getValue());
            } else { // 否则，只将字符添加到结果中
                stringBuffer.append(map.getKey());
            }
        }
        // 将字符串缓冲区转换为字符数组并返回
        return stringBuffer.toString().toCharArray();
    }
}
