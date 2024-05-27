/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 18:39
 */


package 链表;
import java.util.*;

/**
 * 描述
 * 农场里有一群牛，每头牛都有一个编号，编号由一个整数表示，整数范围是[-500, 500]。牛群中的牛用单链表表示。
 * 现在，农场主想要改变牛群的排列顺序。给定一个单链表的头指针 head 和两个整数 left 和 right，
 * 其中 left <= right。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的牛群链表。
 * 示例1
 * 输入：{1,2,3,4,5},2,4
 * 返回值：{1,4,3,2,5}
 * 备注：
 * 链表中节点数目为 n
 * 1 <= n <= 1000
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 */

public class 链表重新排列 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @param left int整型
     * @param right int整型
     * @return ListNode类
     */
    public ListNode reverseBetween (ListNode head, int left, int right) {
        // write code here
        if (head == null || left == right) {
            return head;
        }

        // 将链表转换为数组
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        // 对数组中指定范围内的元素进行反转
        left--;  // 将 left 和 right 转换为数组的索引
        right--;
        while (left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }

        // 将数组转换为链表
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        for (int num : list) {
            tail.next = new ListNode(num);
            tail = tail.next;
        }

        return dummy.next;
    }
}
