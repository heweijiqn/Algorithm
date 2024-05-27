/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 23:19
 */


package 二分分治;

/*
描述
在一个牧场中，有两个牛群，牛群A和牛群B，分别有m头和n头牛。每头牛都有一个独特的体重，体重由一个整数表示。

牛群A和牛群B的牛都按照体重从小到大进行排序。你的任务是找出这两个牛群的所有牛的体重的中位数。

请你设计一个算法，使得算法的时间复杂度为O(log (m+n))。

示例1
输入：[100, 300],[200]
返回值：200.00000

说明：
合并体重 = [100,200,300] ，中位数 200
备注：
weightsA.length == m
weightsB.length == n
0 <= m <= 2000
0 <= n <= 2000
1 <= m + n <= 4000
0 <= weightsA[i], weightsB[i] <= 10^6
 */

public class 中位数 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param weightsA int整型一维数组
     * @param weightsB int整型一维数组
     * @return double浮点型
     */
    public double findMedianSortedArrays (int[] weightsA, int[] weightsB) {
        // write code here
        int m = weightsA.length;
        int n = weightsB.length;
        int len = m + n;
        int[] merged = new int[len];

        // 使用双指针进行归并
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (weightsA[i] <= weightsB[j]) {
                merged[k++] = weightsA[i++];
            } else {
                merged[k++] = weightsB[j++];
            }
        }
        while (i < m) {
            merged[k++] = weightsA[i++];
        }
        while (j < n) {
            merged[k++] = weightsB[j++];
        }

        // 计算中位数
        if (len % 2 == 0) {
            return (merged[len / 2 - 1] + merged[len / 2]) / 2.0;
        } else {
            return merged[len / 2];
        }
    }
}
