/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 20:59
 */


package 链表;
import java.util.*;

/*
描述
农场里有一些牛，每头牛都有一个编号（0-9）。这些牛按照一定的顺序站立，我们可以把这个顺序看作是一个单链表，牛的编号就是链表的节点。现在农场主想知道，这些牛的编号顺序是否是回文的。如果是，返回 true ；否则，返回 false 。
示例1
输入：{1,2,3,2,1}
返回值：true

示例2
输入：{1,3,4}
返回值：false

备注：
链表中节点数目为n
1 <= n <= 10^5
0 <= Node.val <= 9
 */

public class 链表回文 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @return bool布尔型
     */
    public boolean isPalindrome (ListNode head) {
        // write code here
        // 将链表的编号顺序存储到数组中
        List<Integer> nums = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            nums.add(curr.val);
            curr = curr.next;
        }

        // 使用双指针判断数组是否为回文
        int left = 0, right = nums.size() - 1;
        while (left < right) {
            if (!nums.get(left).equals(nums.get(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;

    }
}
