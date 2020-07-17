package jianzhi.order;

public class _68_02_二叉树的最近公共祖先 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 左子树为空，说明 p q 在右字树
        if (left == null) return right;
        // 右子树为空，说明 p q 在左子树
        if (right == null) return left;
        // 否则返回当前节点
        return root;
    }
}
