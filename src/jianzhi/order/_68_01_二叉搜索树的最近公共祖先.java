package jianzhi.order;


public class _68_01_二叉搜索树的最近公共祖先 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (p.val > q.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }

        while (root != null) {
            if (root.val < p.val) { // 说明在右子树
                root = root.right;
            } else if (root.val > q.val) { // 说明在左子树
                root = root.left;
            } else {
                break;
            }
        }

        return root;
    }
}
