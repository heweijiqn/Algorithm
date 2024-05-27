/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 20:54
 */


package 链表;
import  java.util.*;

/*
描述
农场主人记录了一群牛的身高，并将它们按照链表的形式存储。链表的头结点为 head，请你将这些身高数据按升序排列，并返回排序后的链表。
示例1
输入：{4,2,1,3}
返回值：{1,2,3,4}

示例2
输入：{5, 0, 3, 4}
返回值：{0,3,4,5}

备注：
链表中节点的数目在范围 [0, 5000] 内
0 <= Node.val <= 10000
 */

public class 链表排序 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode sortList (ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }

        // 将链表的节点值存储到数组中
        List<Integer> values = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }

        // 将数组排序
        Collections.sort(values);

        // 将排序后的数组重新转换为链表
        ListNode dummy = new ListNode(-1);
        curr = dummy;
        for (int val : values) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        return dummy.next;
    }
}
