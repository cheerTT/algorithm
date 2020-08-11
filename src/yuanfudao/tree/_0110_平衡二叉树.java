package yuanfudao.tree;

public class _0110_平衡二叉树 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 判断是否是平衡二叉树
    public boolean isBalanced(TreeNode root) {

        return help(root) != -1;
    }

    private int help(TreeNode root) {

        if (root == null) return 0;

        int left = help(root.left);

        if (left == -1) return -1;

        int right = help(root.right);

        if (right == -1) return -1;

        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
