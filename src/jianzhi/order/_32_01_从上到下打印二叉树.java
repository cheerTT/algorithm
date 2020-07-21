package jianzhi.order;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _32_01_从上到下打印二叉树 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 二叉树的层序遍历
    public int[] levelOrder(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if (root == null) return new int[] {};

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
