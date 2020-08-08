package yuanfudao.tree;

import java.util.LinkedList;
import java.util.Queue;

public class _0814_二叉树剪枝 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 左右节点为空，且值为 0
    public TreeNode pruneTree(TreeNode root) {

        return help(root);
    }

    private TreeNode help(TreeNode root) {

        if (root == null) return root;

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }


        return root;
    }
}
