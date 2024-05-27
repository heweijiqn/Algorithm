/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 23:48
 */


package 二叉树;
import java.util.*;

/*
描述
在一片牧场上，农场主人种植了两棵大树，每棵树的叶子上都住着一头牛。树的叶子按从左到右的顺序排列形成一个叶值序列，每个叶子上的牛都有其特定的编号。

现在农场主人想要知道，这两棵树的叶子（牛的编号）是否刚好为逆序。也就是说，第一棵树从左到右的叶子顺序，是否与第二棵树从右到左的叶子顺序一致。

如果是，则返回 true；否则返回 false。

示例1
输入：{1,2,3},{1,3,2}
返回值：true

示例2
输入：{3,2,1},{1,2,3}
返回值：false

备注：
给定的两棵树结点数在 [1, 200] 范围内
给定的两棵树上的值在 [0, 200] 范围内
 */

public class 相逆叶子 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root1 TreeNode类
     * @param root2 TreeNode类
     * @return bool布尔型
     */
    // 判断两棵树的叶子节点是否相似的方法
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // 分别保存两棵树的叶子节点值的列表
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        // 使用深度优先搜索遍历第一棵树，将叶子节点的值保存到列表中
        dfs(root1, leaves1);
        // 使用深度优先搜索遍历第二棵树，将叶子节点的值保存到列表中
        dfs(root2, leaves2);

        // 判断两个列表是否相等或者逆序相等
        return reverseEquals(leaves1, leaves2);
    }

    // 辅助方法：深度优先搜索遍历树，将叶子节点的值保存到列表中
    private void dfs(TreeNode node, List<Integer> leaves) {
        // 如果节点为空，则返回
        if (node == null) return;

        // 如果节点是叶子节点，则将其值加入列表
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
        }

        // 递归遍历左子树
        dfs(node.left, leaves);
        // 递归遍历右子树
        dfs(node.right, leaves);
    }

    // 辅助方法：判断两个列表是否逆序相等
    private boolean reverseEquals(List<Integer> list1, List<Integer> list2) {
        if (list1.size() != list2.size()) return false;
        Collections.reverse(list2); // 反转 list2
        return list1.equals(list2);
    }
}
