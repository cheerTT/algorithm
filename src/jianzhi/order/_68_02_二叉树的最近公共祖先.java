package jianzhi.order;

import java.util.*;

public class _68_02_二叉树的最近公共祖先 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 递归实现
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

    // 非递归实现
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        // 先确定每个节点的父节点
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                parent.put(node.left, node);
                queue.offer(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                queue.offer(node.right);
            }
        }

        Set<TreeNode> ancestor = new HashSet<>();

        while (p != null) {
            ancestor.add(p);
            p = parent.get(p);
        }

        while (!ancestor.contains(q)) {
            q = parent.get(q);
        }

        return q;
    }
}
