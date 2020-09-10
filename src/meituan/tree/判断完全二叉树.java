package meituan.tree;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;

public class 判断完全二叉树 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    private boolean isLeaf = false;

    // 右孩子为空，左孩子不为空，则一定 false
    // 右孩子为空，后继结点是否为叶子结点，不是则 false
    public boolean isCompleteTree(TreeNode root) {

        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            TreeNode leftChild = node.left;
            TreeNode rightChild = node.right;

            if ((rightChild != null && leftChild == null)
            || (isLeaf && (leftChild != null || rightChild != null))) {
                isLeaf = false;
            }

            if (leftChild != null) queue.offer(leftChild);
            if (rightChild != null) queue.offer(rightChild);
            else isLeaf = true;

        }

        return true;
    }
}
