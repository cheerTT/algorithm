package jianzhi.order;

public class _28_对称的二叉树 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 左子树的左节点等于右字树的右节点
    // 本题和判断树的子结构 代码类似
    public boolean isSymmetric(TreeNode root) {
        return help(root, root);
    }

    private boolean help(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        if (root1.val != root2.val) return false;

        return help(root1.left, root2.right) && help(root1.right, root2.left);
    }


}
