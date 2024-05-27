package 二叉树;

/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 23:51
 */

/*
描述
农场里有两群牛，每群牛的成员分布在山坡上，形成了一个二叉树结构。每头牛都有一个编号，表示它在牛群中的身份。请你编写一个程序，判断这两个牛群的结构是否相同。
如果两个牛群在结构上相同，并且牛的编号具有相同的值，则认为它们的结构是相同的。
示例1
输入：{1, #, 2},{1, #, 2}
返回值：true

示例2
输入：{1, 2, 3, 4, 5, 6, 7},{1, 2, 3, 4, 5, 6, 8}
返回值：false

示例3
输入：{1, #, 2},{1, 2, #}
返回值：false

备注：
两个牛群上的节点数目都在范围 [0, 100] 内
0 <= Node.val <= 10^4
#表示空节点
 */
public class 树相似结构 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param p TreeNode类
     * @param q TreeNode类
     * @return bool布尔型
     */
    public boolean isSameTree (TreeNode p, TreeNode q) {
        // write code here
        // 如果两个树都是空的，则它们相同
        if (p == null && q == null) {
            return true;
        }
        // 如果一个树是空的，另一个不是，则它们不同
        if (p == null || q == null) {
            return false;
        }
        // 如果两个树的根节点的值不同，则它们不同
        if (p.val != q.val) {
            return false;
        }
        // 递归比较左子树和右子树
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}



