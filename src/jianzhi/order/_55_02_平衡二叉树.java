package jianzhi.order;

public class _55_02_平衡二叉树 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

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
