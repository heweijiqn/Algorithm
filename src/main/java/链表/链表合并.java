/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 20:52
 */


package 链表;
import java.util.*;

/*
描述
农场主人有多个牛群，每个牛群中的牛都按照编号升序排列。现在农场主人想把所有牛群合并成一个大牛群，
同时要求合并后的大牛群中的牛依然按照编号升序排列。请你编写一个程序，实现这个功能。
示例1
输入：[{2,4,5},{1,3,4},{2,8}]
返回值：{1,2,2,3,4,4,5,8}

备注：
k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 1000
0 <= lists[i][j] <= 5000
lists[i] 按 升序 排列
lists[i].length 的总和不超过 10000
 */
public class 链表合并 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param lists ListNode类一维数组
     * @return ListNode类
     */
    public ListNode mergeKLists (ListNode[] lists) {
        // write code here
        if (lists == null || lists.length == 0) {
            return null;
        }

        // 创建一个新的空链表作为合并后的大牛群
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // 使用数组来存储各个牛群的当前节点
        ListNode[] pointers = new ListNode[lists.length];
        for (int i = 0; i < lists.length; i++) {
            pointers[i] = lists[i];
        }

        // 循环直到所有牛群的节点都加入到大牛群中
        while (true) {
            int minIndex = -1;
            int minValue = Integer.MAX_VALUE;

            // 找到当前所有牛群中最小的节点
            for (int i = 0; i < pointers.length; i++) {
                if (pointers[i] != null && pointers[i].val < minValue) {
                    minValue = pointers[i].val;
                    minIndex = i;
                }
            }

            // 如果所有牛群的节点都已经加入到大牛群中，则退出循环
            if (minIndex == -1) {
                break;
            }

            // 将最小节点加入到大牛群中
            tail.next = pointers[minIndex];
            tail = tail.next;

            // 更新最小节点所在牛群的当前节点指针
            pointers[minIndex] = pointers[minIndex].next;
        }

        return dummy.next;
    }
}
