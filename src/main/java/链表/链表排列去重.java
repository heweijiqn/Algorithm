/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 18:27
 */

/**
 * 描述
 * 农场里有一群牛，每头牛都有一个独特的编号，编号由一个整数表示，整数范围是[0, 200]。牛群中的牛用单链表表示，链表已经按照非降序排列。
 * 因为一些事故，导致一头牛可能多次出现在链表中。给你一个链表的头 head，删除链表中所有重复的编号，只留下所有牛的不重复编号。返回已排序的链表。
 * 示例1
 * 输入：{1,2,2,3,3,4,5,5}
 * 返回值：{1,2,3,4,5}
 * 备注：
 * 链表中节点数目在范围 [0, 1000] 内
 * 0 <= Node.val <= 200
 */

package 链表;

import java.util.*;

public class 链表排列去重 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }

        // 将链表转换为数组
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        // 删除数组中的重复元素
        List<Integer> uniqueList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (!uniqueList.contains(list.get(i))) {
                uniqueList.add(list.get(i));
            }
        }

        // 将去重后的数组转换为链表
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int num : uniqueList) {
            tail.next = new ListNode(num);
            tail = tail.next;
        }

        return dummy.next;
    }
}



