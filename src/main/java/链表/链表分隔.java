/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 18:57
 */


package 链表;
import java.util.*;

/**
 * 描述
 * 农场里有一群牛，每头牛都有一个编号，编号由一个整数表示，整数范围是[0, 100]，同时也表示牛的体重级别。牛群中的牛用单链表表示。
 * 现在，农场主想要调整牛群的顺序，使体重较大的牛在一边，体重较小的牛在一边。给你一个链表的头节点 head 和一个特定值 x ，
 * 请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 示例1
 * 输入：{1,2,3,4,5,6,7,8,9},5
 * 返回值：{1,2,3,4,5,6,7,8,9}
 * 示例2
 * 输入：{4,3,2,5,2},3
 * 返回值：{2,2,4,3,5}
 * 备注：
 * 链表中节点的数目在范围 [0, 200] 内
 * 0 <= Node.val <= 100
 * 0 <= x <= 200
 */

public class 链表分隔 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @param x int整型
     * @return ListNode类
     */
    public ListNode cow_partition (ListNode head, int x) {
        // write code here
        if (head == null) {
            return null;
        }

        // 将链表的节点值存储到数组中
        List<Integer> smallerList = new ArrayList<>();
        List<Integer> greaterEqualList = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                smallerList.add(curr.val);
            } else {
                greaterEqualList.add(curr.val);
            }
            curr = curr.next;
        }

        // 将数组中的节点值重新连接为链表
        List<Integer> combinedList = new ArrayList<>();
        combinedList.addAll(smallerList);
        combinedList.addAll(greaterEqualList);
        ListNode dummy = new ListNode(0);
        curr = dummy;
        for (int val : combinedList) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        return dummy.next;
    }

}
