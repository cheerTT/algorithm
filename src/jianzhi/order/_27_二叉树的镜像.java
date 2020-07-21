package jianzhi.order;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _27_二叉树的镜像 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 非递归实现，用栈和队列均可
    // 时间复杂度 O(n)
    // 空间复杂度 O(n)
    public TreeNode mirrorTree1(TreeNode root) {

        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null || node.right != null) {
                swap(node);
            }

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return root;
    }

    // 递归实现
    // 时间复杂度 O(n)
    // 空间复杂度 O(n)
    public TreeNode mirrorTree2(TreeNode root) {

        if (root == null) return null;

        TreeNode tmp = mirrorTree2(root.left);
        root.left = mirrorTree2(root.right);
        root.right = tmp;

        return root;
    }

    private void swap(TreeNode node) {
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }
}
