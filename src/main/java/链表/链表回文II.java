/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 21:00
 */


package 链表;
import java.util.*;

/*
描述
农场里有一些牛，每头牛都有一个编号（0-9）。这些牛按照一定的顺序站立，
我们可以把这个顺序看作是一个单链表，牛的编号就是链表的节点。现在农场主想知道，
这些牛的编号顺序是否是回文的。如果是，则返回空链表；如果不是，返回最大的连续回文子链表的头节点（保证唯一）。
示例1
输入：{1,2,3,2,1,4,5,6,7,8,9,0}
返回值：{1,2,3,2,1}

示例2
输入：{1,1,2,3,4,5,6,7,8,9,0}
返回值：{1,1}

备注：
链表中节点数目n
1 <= n <= 100
0 <= Node.val <= 9
 */

public class 链表回文II {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode maxPalindrome (ListNode head) {
        // 将链表的编号顺序转换为字符串
        StringBuffer stringBuffer = new StringBuffer();
        while (head != null) {
            stringBuffer.append(head.val);
            head = head.next;
        }
        // 如果整个链表都是回文，则返回空链表
        if (isParame(stringBuffer.toString())) {
            return null;
        }

        ListNode result = null; // 存储结果的头节点
        int length = 0; // 最大回文子链表的长度
        // 遍历所有可能的子链表
        for (int i = 0; i < stringBuffer.length(); i++) {
            for (int j = i + 1; j <= stringBuffer.length(); j++) {
                String string = stringBuffer.substring(i,
                        j); // 获取子链表对应的字符串
                // 如果当前子链表是回文且长度大于之前找到的最大回文子链表的长度
                if (string.length() > length && isParame(string)) {
                    length = string.length(); // 更新最大回文子链表的长度
                    ListNode node = new ListNode(0); // 创建新的头节点
                    result = node; // 更新结果头节点
                    // 将当前子链表对应的字符串转换为链表
                    for (int k = 0; k < string.length(); k++) {
                        node.next = new ListNode(string.charAt(k) -
                                '0'); // 将字符转换为数字节点
                        node = node.next; // 移动到下一个节点
                    }
                }
            }
        }
        return result.next; // 返回最大回文子链表的头节点
    }

    // 判断字符串是否为回文
    public static boolean isParame(String s) {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append(s);
        return stringBuffer.reverse().toString().equals(
                s); // 反转字符串并比较是否相等
    }
}
