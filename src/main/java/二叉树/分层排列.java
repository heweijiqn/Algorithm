/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 23:42
 */


package 二叉树;
import java.util.*;

/*
描述
在一个牧场中，有很多牛。为了方便管理，牧场主将牛的编号排列成一棵二叉树。
现在牧场主想知道每层牛的编号有哪些。请按照从上到下，从左到右的顺序，返回每层牛的编号拼接成的字符串。

示例1
输入：{3, 9, 20, #, #, 15, 7}
返回值：["3","920","157"]

示例2
输入：{1}
返回值：["1"]

备注：
树中节点数目在范围 [0, 2000] 内
0 <= Node.val <= 1000
 */

public class 分层排列 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return string字符串一维数组
     */
    public String[] levelOrder(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return new String[0];
        }

        // 使用队列辅助进行层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // 循环处理队列中的节点
        while (!queue.isEmpty()) {
            int size = queue.size();
            StringBuilder level = new StringBuilder();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.append(node.val);

                // 将左右子节点加入队列
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(level.toString());
        }

        return result.toArray(new String[0]);
    }
}


 class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
      this.val = val;
    }
  }

