/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 18:22
 */

/**
 * 描述
 * 农场主人有一群牛，他给每只牛都打了一个编号，编号由整数表示。这些牛按照编号的大小形成了一个链表。
 * 现在农场主人想删除链表中比前后结点值都大的牛的编号，你能帮他设计一个算法来实现这个功能吗？注意，只考虑删除前，首尾的牛的编号不删除。
 * 示例1
 * 输入：{1,3,2,4,5}
 * 返回值：{1,2,4,5}
 * 示例2
 * 输入：{5,4,3,2,1}
 * 返回值：{5,4,3,2,1}
 * 备注：
 * 链表长度[0, 10000]
 * 0 < Node.val <= 10000
 */
package 链表;
import java.util.*;
public class 删除链表峰值 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteNodes (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //转数组
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }

        // 遍历数组进行删除
        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i - 1) && list.get(i) > list.get(i + 1)) {
                list.remove(i);
                i--; // 因为删除一个元素后，后面的元素会前移，所以需要减1继续检查当前位置
            }
        }

        // 将数组转换回链表形式
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int num : list) {
            tail.next = new ListNode(num);
            tail = tail.next;
        }
        return dummy.next;

    }

}

class ListNode {
   int val;
    ListNode next = null;
    public ListNode(int val) {
      this.val = val;
    }
  }

