/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 18:45
 */


package 链表;
import java.util.*;

/**
 * 描述
 * 农场里有两群牛，每群牛都有一定的能量值。能量值由一个非负整数表示，
 * 且每头牛的能量值只有一位数字。能量值按照逆序的方式存储在链表中，即链表的第一个节点表示个位，第二个节点表示十位，以此类推。
 * 现在，你需要将这两群牛的能量值相加，然后以相同的逆序形式返回表示和的链表。
 * 注意：除了数字0之外，这两个数都不会以0开头。
 * 示例1
 * 输入：{9, 8, 7, 6, 5},{ 1, 1, 1, 1, 1}
 * 返回值：{0,0,9,7,6}
 * 说明：
 * 56789+11111=67900
 * 备注：
 * 每个链表中的节点数在范围 [1, 500] 内
 * 0 <= Node.val <= 9
 */

public class 链表相加 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param l1 ListNode类
     * @param l2 ListNode类
     * @return ListNode类
     */
    public ListNode addEnergyValues (ListNode l1, ListNode l2) {
        // write code here
        ListNode dummy = new ListNode(0); // 创建虚拟头节点
        ListNode curr = dummy;
        int carry = 0; // 进位

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0; // 获取l1当前节点的值
            int val2 = (l2 != null) ? l2.val : 0; // 获取l2当前节点的值

            int sum = val1 + val2 + carry; // 计算当前位置的和
            carry = sum / 10; // 更新进位
            int digit = sum % 10; // 当前位置上的数字

            curr.next = new ListNode(
                    digit); // 创建新节点存储当前位置上的数字
            curr = curr.next; // 移动到下一个节点

            // 移动到链表的下一个节点
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next; // 返回结果链表的头节点
    }
}
