/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 23:45
 */


package 二叉树;
import java.util.*;

/*
描述
农场里有一群牛，牛群的成员分布在山坡上，形成了一个二叉树结构。每头牛都有一个编号，表示它在牛群中的身份。请你编写一个程序，检查这个牛群的结构是否轴对称。
示例1
输入：{1, 2, 2, 3, #, #, 3}
返回值：true

示例2
输入：{1, 3, 3, 2, 5, 5, 2}
返回值：true

备注：
树中节点数目在范围 [1, 100] 内
0 <= Node.val <= 1000
#表示空节点
 */

public class 轴对称结构 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode node1, TreeNode node2) {
        // 如果两个节点都为空，则是对称的
        if (node1 == null && node2 == null) return true;
        // 如果一个节点为空，另一个不为空，或者它们的值不相等，则不对称
        if (node1 == null || node2 == null || node1.val != node2.val) return false;
        // 递归检查左子树的左节点和右子树的右节点，以及左子树的右节点和右子树的左节点是否镜像对称
        return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }
}
