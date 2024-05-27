/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 23:18
 */


package 二分分治;


/*
描述
在农场里，农民们有三个牛群，每个牛群里的牛数量不同。农民们将每个牛群牛的体重按照从小到大的顺序记录在不同的数组中。
现在农民们想要知道，如果将这三个牛群合并在一起，那么中位数是多少。请你编写一个程序，找出这三个正序数组的中位数。
算法的时间复杂度应该为 O(log (m+n+p)) ，其中m、n、p分别为三个数组的长度。
示例1
输入：[1,3],[2],[4,5]
返回值：3.00000

说明：
合并数组 = [1,2,3,4,5] ，中位数 3
备注：
herd1.length == m
herd2.length == n
herd3.length == p
0 <= m,n,p <= 1000
1 <= m + n + p <= 3000
0 <= herd1[i], herd2[i], herd3[i] <= 10000
 */
public class 三数组中中位数 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param herd1 int整型一维数组
     * @param herd2 int整型一维数组
     * @param herd3 int整型一维数组
     * @return double浮点型
     */
    public double findMedianSortedArray(int[] herd1, int[] herd2, int[] herd3) {
        int m = herd1.length;
        int n = herd2.length;
        int p = herd3.length;
        int len = m + n + p;
        int[] merged = new int[len];

        // 使用三个指针进行归并
        int i = 0, j = 0, k = 0, l = 0;
        while (i < m && j < n && k < p) {
            if (herd1[i] <= herd2[j] && herd1[i] <= herd3[k]) {
                merged[l++] = herd1[i++];
            } else if (herd2[j] <= herd1[i] && herd2[j] <= herd3[k]) {
                merged[l++] = herd2[j++];
            } else {
                merged[l++] = herd3[k++];
            }
        }
        while (i < m) {
            merged[l++] = herd1[i++];
        }
        while (j < n) {
            merged[l++] = herd2[j++];
        }
        while (k < p) {
            merged[l++] = herd3[k++];
        }

        // 计算中位数
        if (len % 2 == 0) {
            return (merged[len / 2 - 1] + merged[len / 2]) / 2.0;
        } else {
            return merged[len / 2];
        }
    }
}
