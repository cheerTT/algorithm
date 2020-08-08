package yuanfudao.tree;


import java.util.LinkedList;
import java.util.Queue;

public class _55_01_二叉树的最大高度 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    // 递归实现
    public int height1(TreeNode root) {

        if (root == null) return 0;

        return Math.max(height1(root.left), height1(root.right)) + 1;
    }

    // 非递归实现
    // 时间复杂度 O(N)
    // 空间复杂度 O(N)
    public int height2(TreeNode root) {

        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return res;

        queue.add(root);

        while (!queue.isEmpty()) {
            int num = queue.size();
            for (int i = 0; i < num; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            res++;
        }


        return res;
    }

    public static void main(String[] args) {

        _55_01_二叉树的最大高度 solution = new _55_01_二叉树的最大高度();

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        int res = solution.height2(node1);
        System.out.println("res:" + res);
    }
}
