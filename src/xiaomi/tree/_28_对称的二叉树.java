package xiaomi.tree;

import java.util.LinkedList;
import java.util.Queue;

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

    // 非递归实现
    private boolean isSymmetric1(TreeNode root) {

        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) return true;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);

        }
        return true;
    }

    private int a = 0;

    public static void main(String[] args) {

        _28_对称的二叉树 solution = new _28_对称的二叉树();
        System.out.println(solution.a);
    }
}
