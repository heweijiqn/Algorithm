/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 23:15
 */


package 双指针;
import java.util.*;

/*
描述
在一个农场里，有n头牛，每头牛都有一个唯一的标签编号。农场主人想找出所有牛的标签中，存在的四个标签编号，它们的和为target。
你需要返回所有和为 0 且不重复的四元组。
注意：
每个四元组按照升序排列，四元组之间按照字典序排列。


示例1
输入：[1,0,-1,0,-2,2],0
返回值：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

示例2
输入：[2,2,2,2,2],8
返回值：[[2,2,2,2]]

备注：
4 <= nums.length <= 100
-3*10^ 5 <= nums[i] <= 3*10^ 5
-3*10^7 <= target <= 3*10^7
 */

public class 标签和 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @param target int整型
     * @return int整型二维数组
     */
    public int[][] fourSum (int[] nums, int target) {
        // write code here
        List<int[]> result = new ArrayList<>();
        Arrays.sort(nums); // 先对数组排序
        int n = nums.length;

        // 四个数的组合，需要嵌套两层循环遍历
        for (int i = 0; i < n - 3; i++) {
            // 避免重复的组合
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 缩小问题规模，转化为三数之和
            for (int j = i + 1; j < n - 2; j++) {
                // 避免重复的组合
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1, right = n - 1;
                int newTarget = target - nums[i] - nums[j];

                // 使用双指针寻找剩余两个数的组合
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == newTarget) {
                        result.add(new int[] {nums[i], nums[j], nums[left], nums[right]});

                        // 避免重复的组合
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum < newTarget) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
