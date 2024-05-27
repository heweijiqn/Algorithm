/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 23:44
 */


package 二叉树;

/*
描述
农场里有一群牛，牛群的成员分布在山坡上，形成了一个二叉树结构。每头牛都有一个编号，
表示它在牛群中的身份。现在农场主想要调整牛群的结构，即将牛群的二叉树进行翻转，请你编写一个程序，翻转这个牛群的二叉树结构，并返回翻转后的根节点。
示例1
输入：{1, 2, 3}
返回值：{1,3,2}

示例2
输入：{1, 2, 3, 4, 5, 6, 7}
返回值：{1,3,2,7,6,5,4}

备注：
牛群中节点数目范围在 [0, 100] 内
0 <= Node.val <= 1000
 */

public class 翻转 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return TreeNode类
     */
    public TreeNode invertTree (TreeNode root) {
        // write code here
        if (root == null) {
            return null;
        }

        // 交换左子树和右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 递归地翻转左右子树

        invertTree(root.right);
        invertTree(root.left);

        return root;
    }
}
