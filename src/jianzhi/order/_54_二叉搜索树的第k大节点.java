package jianzhi.order;

public class _54_二叉搜索树的第k大节点 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int res;
    private int k;

    public int kthLargest(TreeNode root, int k) {

        this.k = k;
        inorder(root);
        return res;
    }

    // 右 - 根 - 左
    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.right);

        if (k == 0) return;
        if (--k == 0) res = root.val;

        inorder(root.left);
    }
}
