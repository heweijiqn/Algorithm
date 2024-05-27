/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 18:33
 */


package 链表;
import  java.util.*;

/**
 * 描述
 * 农场里有一群牛，每头牛都有一个编号，编号由一个整数表示，整数范围是[0, 100]。牛群中的牛用单链表表示。
 * 现在，农场主想要调整牛群的顺序。给你一个链表，将链表中的倒数第 n 个结点移到链表的末尾，并且返回调整后的链表的头结点。
 * 示例1
 * 输入：{1,2,3,4,5},2
 * 返回值：{1,2,3,5,4}
 * 备注：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class 调整链表顺序 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @param n int整型
     * @return ListNode类
     */
    public ListNode moveNthToEnd (ListNode head, int n) {
        // write code here
        if (head == null || n <= 0) {
            return head;
        }

        // 将链表转换为数组
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        // 获取倒数第n个节点的索引
        int targetIndex = list.size() - n;
        if (targetIndex < 0) {
            return head; // 链表长度不足n
        }

        // 移除倒数第n个节点
        int targetValue = list.remove(targetIndex);

        // 将移除的节点值添加到数组末尾
        list.add(targetValue);

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
