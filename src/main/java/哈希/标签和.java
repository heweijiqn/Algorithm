/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 23:02
 */


package 哈希;
import java.util.*;

/*
描述
在一个农场里，有n头牛，每头牛都有一个标签编号。农场主人想找出所有牛的标签中，存在的连续标签编号的和为k。

你需要返回所有和为 k 的连续子数组，每个子数组按照升序排列，子数组之间按照字典序排列。完全相同的子数组要考虑去重。
示例1
输入：[1,2,3,4,5],5
返回值：[[2,3],[5]]

示例2
输入：[2,2,2,2,2],6
返回值：[[2,2,2]]

备注：
1 <= nums.length <= 3 * 10^5
-5000 <= nums[i] <= 5000
-10^7 <= k <= 10^7
 */

public class 标签和 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @param k int整型
     * @return int整型二维数组
     */
    public int[][] subarraySum (int[] nums, int k) {
        // write code here
        // 创建一个列表来存储结果
        List<int[]> list = new ArrayList<>();

        // 创建一个哈希集合来存储已经出现过的子数组（用于去重）
        HashSet<String> set = new HashSet<>();

        // 数组的长度
        int n = nums.length;

        // 遍历数组，从左到右依次计算子数组的和
        for (int l = 0; l < n; l++) {
            int sum = 0;
            // 再次遍历数组，计算以当前位置为起点的子数组的和
            for (int r = l; r < n; r++) {
                sum += nums[r];
                // 如果子数组的和等于目标值 k
                if (sum == k) {
                    // 创建一个临时数组，存储当前满足条件的子数组
                    int[] temp = new int[r - l + 1];
                    System.arraycopy(nums, l, temp, 0, r - l + 1);
                    // 判断当前子数组是否已经出现过，如果没有则加入结果列表和哈希集合
                    if (!set.contains(Arrays.toString(temp))) {
                        list.add(temp);
                        set.add(Arrays.toString(temp));
                    }
                }
            }
        }
        // 将结果列表转换为二维数组并返回
        return list.toArray(new int[0][0]);
    }
}
