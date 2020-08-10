package yuanfudao.tree;

import java.util.Currency;

public class _0112_路径总和 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 判断是否存在这样的一条路径
    // 从根节点开始，递归判断
    public boolean hasPathSum1(TreeNode root, int sum) {
        return help(root, 0, sum);
    }

    // 帮助函数
    private boolean help(TreeNode root, int cur, int sum) {

        if (root == null) return false;

        cur += root.val;
        if (root.left == null && root.right == null) {
            return cur == sum;
        } else {
            return help(root.left, cur, sum) || help(root.right, cur, sum);
        }
    }

    public boolean hasPathSum2(TreeNode root, int sum) {

        if (root == null) return false;

        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        } else {
            return hasPathSum2(root.left, sum - root.val) || hasPathSum2(root.right, sum - root.val);
        }
    }
}
