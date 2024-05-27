/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 18:35
 */


package 链表;
import java.util.*;

/**
 *描述
 * 农场里有一群牛，每头牛都有一个编号，编号由一个整数表示，整数范围是[0, 1000]。牛群中的牛用单链表表示。
 * 现在，农场主想要重新分组牛群。给定一个单链表的头指针 head 和一个整数 k，每 k 个节点一组进行翻转，请你返回修改后的牛群链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * 示例1
 * 输入：
 * {1,2,3,4,5},2
 * 返回值：{2,1,4,3,5}
 * 示例2
 * 输入：{1,2,3,4,5},3
 * 返回值：{3,2,1,4,5}
 * 备注：
 * 链表中的节点数目为 n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 10000
 */
public class 链表重新分组 {
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        if (head == null || k <= 1) {
            return head;
        }

        // 将链表转换为数组
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        // 对数组进行分组翻转
        int n = list.size();
        for (int i = 0; i < n / k; i++) {
            int left = i * k;
            int right = (i + 1) * k - 1;
            while (left < right) {
                int temp = list.get(left);
                list.set(left, list.get(right));
                list.set(right, temp);
                left++;
                right--;
            }
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
