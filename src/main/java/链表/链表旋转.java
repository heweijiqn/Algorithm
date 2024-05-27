/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 20:49
 */


package 链表;
import java.util.*;

/*
描述
农场里有一群牛，每头牛都有一个编号，编号由一个整数表示，整数范围是[-100, 100]。牛群中的牛用单链表表示。
现在，农场主想要调整牛群的顺序。给你一个链表的头节点 head ，将链表每头牛向右移动 k 个位置。
示例1
输入：{1,2,3,4,5,6,7,8,9},3
返回值：{7,8,9,1,2,3,4,5,6}

示例2
输入：{1,2,3},4
返回值：{3,1,2}

备注：
链表中节点的数目在范围 [0, 500] 内
-100 <= Node.val <= 100
0 <= k <= 2 * 10^9
 */

public class 链表旋转 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode rotateLeft (ListNode head, int k) {
        // write code here
        if (head == null || k == 0) {
            return head;
        }

        // 计算链表的长度
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        // 计算向右移动k个位置等价于向左移动len - k个位置
        k %= len;
        if (k == 0) {
            return head; // 如果k等于0，说明不需要移动，直接返回原链表
        }

        // 将链表的节点值存储到数组中
        int[] values = new int[len];
        ListNode curr = head;
        int i = 0;
        while (curr != null) {
            values[i++] = curr.val;
            curr = curr.next;
        }

        // 构建新的链表数组
        int[] newValues = new int[len];
        for (i = 0; i < len; i++) {
            newValues[(i + k) % len] = values[i];
        }

        // 将新的链表数组转换为链表
        ListNode dummy = new ListNode(-1);
        curr = dummy;
        for (int val : newValues) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        return dummy.next;
    }
}
