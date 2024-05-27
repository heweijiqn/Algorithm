/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 22:25
 */


package 数组;

/*
描述
在草原上，有一群牛分散在不同的位置，他们用整数表示每头牛的位置坐标。牧民召唤了一只牧犬来驱赶牛群。
当牧犬在某个位置时，牠会发出召唤牛群集合的信号（用一个整数 val 表示），此时，与牧犬相同位置的所有牛将会集合到其他位置。你需要移除数组中与 val 相同的元素，并返回移动后的数组与剩余元素数量。
要求在原数组的基础上完成移除任务，不引入额外的数组空间。操作的空间复杂度必须为 O(1)。牛群的顺序可以改变。不用考虑新数组长度之外的位置元素。

示例1
输入：[2, 1, 3, 1, 1, 5],1
返回值：3

备注：
必须在原数组上修改，不返回原数组，但要检验。
0 <= nums.length <= 100
0 <= nums[i] <= 100
0 <= val <= 100
 */

public class 某一个数的次数 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @param val int整型
     * @return int整型
     */
    public int remove_cows (int[] nums, int val) {
        // write code here
        int idx = 0;
        // 遍历原数组
        for (int i = 0; i < nums.length; i++) {
            // 如果当前元素与指定值不相同
            if (nums[i] != val) {
                // 将当前元素移动到有效元素位置
                nums[idx] = nums[i];
                // 更新有效元素位置指针
                idx++;
            }
        }
        // 返回移动后的数组长度
        return idx;
    }
}
