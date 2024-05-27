/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 20:57
 */


package 链表;
import java.util.*;

/*
描述
在一个牧场中，有n头牛，牛的品种分为黑牛和白牛，用0和1分别表示。现在需要对牛群进行排序，
使得相同品种的牛相邻，并按照黑牛和白牛的顺序排列。这些牛是按照链表的形式存储的。
请你在不使用库内置的sort函数的情况下解决这个问题。

示例1
输入：{1,0,1,0,1,0}
返回值：{0,0,0,1,1,1}

示例2
输入：{1,0,0}
返回值：{0,0,1}

备注：
n == cows.length
1 <= n <= 3000
Node.val 为 0 或 1
 */

public class 链表排序IV {
    public ListNode sortCowsIV (ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }

        // 统计黑牛和白牛的数量
        int blackCount = 0;
        int whiteCount = 0;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == 0) {
                blackCount++;
            } else {
                whiteCount++;
            }
            curr = curr.next;
        }

        // 重新构建链表
        ListNode dummy = new ListNode(-1);
        curr = dummy;
        // 先添加黑牛节点
        for (int i = 0; i < blackCount; i++) {
            curr.next = new ListNode(0);
            curr = curr.next;
        }
        // 再添加白牛节点
        for (int i = 0; i < whiteCount; i++) {
            curr.next = new ListNode(1);
            curr = curr.next;
        }

        return dummy.next;
    }
}
