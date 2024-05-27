/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 18:48
 */


package 链表;
import java.util.*;

/**
 * 描述
 * 农场里有一群牛，它们被组织成一个链表形式的队列。每头牛都有一个编号（每只牛编号唯一），编号范围是[-105, 105]。每头牛都有一个指针，指向它后面的一头牛。但是，有一些顽皮的牛可能会指向它们前面的某一头牛，从而形成一个环。
 * 现在，给你一个链表的头节点 head，判断这个牛队列中是否有环。
 * 示例1
 * 输入：
 * {3,2,0,-4,2,0,-4,2,0,-4,2,0,-4,2,0,-4,2,0,-4}
 * 返回值：true
 */

public class 环形链表 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @return bool布尔型
     */
    public boolean hasCycle (ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow.val != fast.val) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


}
