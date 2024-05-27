/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 22:39
 */


package 栈与队列;

import java.util.*;

/*
描述
农场的牛只有一定的活动范围，每只牛在一天中的活动范围可以用一个整数数组来表示，
数组中的每个元素表示牛在一小时内的活动范围的大小。农民想知道，在连续的k个小时内，牛的最小活动范围是多少。请你帮助农民解决这个问题。
示例1
输入：[1, 2, 3, 4, 5, 6],3
返回值：[1,2,3,4]

示例2
输入：[-1, -2, -3, -4, -5],2
返回值：[-2,-3,-4,-5]

备注：
输出一个长度为n-k+1的数组，表示每k个连续小时内，牛的最小活动范围。
 1 <= n <= 10^5, -10^4 <= 活动范围[i] <= 10^4, 1 <= k <= n
 */

public class 最小数组 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @param k int整型
     * @return int整型一维数组
     */
    public int[] minSlidingWindow (int[] nums, int k) {
        // write code here
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>(); // 存储窗口内的索引

        for (int i = 0; i < n; i++) {
            // 维护窗口，保证窗口大小不超过k
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // 移除窗口中比当前元素小的元素
            while (!deque.isEmpty() && nums[deque.peekLast()] >= nums[i]) {
                deque.pollLast();
            }

            // 将当前元素加入窗口
            deque.offer(i);

            // 添加窗口内的最小值到结果列表中
            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }

        return result;
    }

}
