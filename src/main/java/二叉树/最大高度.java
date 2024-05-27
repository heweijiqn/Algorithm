/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 23:54
 */


package 二叉树;
import java.util.*;

/*
描述
农场里有一群牛，牛群的成员分布在山坡上，形成了一个二叉树结构。每头牛都有一个高度值，表示它在山坡上的高度。请你编写一个程序，找出牛群中的最高牛。
说明：最高牛是指高度值最大的牛。

示例1
输入：{1, 2, 3, #, #, 4, 5}
返回值：5

示例2
输入：{1, 2, 3}
返回值：3

备注：
输入包含一个二叉树，表示牛群的分布。二叉树由一组整数表示，其中 # 表示空节点。节点按层序遍历的顺序给出。
二叉树节点数[1, 100]
 */

public class 最大高度 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return int整型
     */
    public int findMaxHeight (TreeNode root) {
        // write code here
        // 检查根节点是否为空，如果为空则返回0（表示没有牛）
        if (root == null) {
            return 0;
        }
        // 初始化一个变量来记录最大高度值
        int maxHeight = root.val;
        // 使用栈来进行深度优先搜索
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        // 遍历整个二叉树
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            // 更新最大高度值
            if (current.val > maxHeight) {
                maxHeight = current.val;
            }
            // 如果当前节点有左子节点，将其压入栈中
            if (current.left != null) {
                stack.push(current.left);
            }
            // 如果当前节点有右子节点，将其压入栈中
            if (current.right != null) {
                stack.push(current.right);
            }

        }
        // 返回最大高度值
        return maxHeight;
    }
}
