/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 18:41
 */


package 链表;
import java.util.*;

/**
 * 描述
 * 农场里有两群牛，每群牛都有一定的能量值。能量值由一个整数表示，整数范围是[-100, 100]。
 * 每群牛的能量值已经按照非递增顺序排列，并存储在链表中。
 * 现在，你需要将这两群牛的能量值合并为一个新的非递增链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例1
 * 输入：{4, 2, 1},{4, 3, 1}
 * 返回值：{4,4,3,2,1,1}
 * 示例2
 * 输入：{},{0}
 * 返回值：{0}
 * 备注：
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按非递增顺序排列
 */

public class 合并两链表值 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param l1 ListNode类
     * @param l2 ListNode类
     * @return ListNode类
     */
    public ListNode mergeEnergyValues (ListNode l1, ListNode l2) {
        // write code here
        // 如果其中一个链表为空，直接返回另一个链表
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // 将两个链表的元素值存储到数组中
        List<Integer> values = new ArrayList<>();
        while (l1 != null) {
            values.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            values.add(l2.val);
            l2 = l2.next;
        }

        // 对数组中的元素进行排序
        Collections.sort(values, Collections.reverseOrder());

        // 将排好序的数组转换为链表
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        for (int val : values) {
            tail.next = new ListNode(val);
            tail = tail.next;
        }

        return dummy.next;
    }
}
