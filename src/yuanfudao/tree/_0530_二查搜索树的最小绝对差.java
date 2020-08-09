package yuanfudao.tree;

public class _0530_二查搜索树的最小绝对差 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private TreeNode pre;
    private int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {

        getMin(root);
        return min;
    }

    private void getMin(TreeNode root) {
        if (root == null) return;

        getMin(root.left);

        if (pre != null) {
            min = Math.min(min, root.val - pre.val);
        }
        pre = root;

        getMin(root.right);
    }
}
