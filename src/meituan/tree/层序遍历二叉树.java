package meituan.tree;


public class 层序遍历二叉树 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 二叉树的层序遍历，不用队列
     * @param root
     */
    public void printLayer(TreeNode root) {

        TreeNode[] queue = new TreeNode[1000];

        if (root == null) return;

        int p = 0;
        int q = 0;

        queue[q++] = root;

        while (p != q) {
            TreeNode node = queue[p++];

            System.out.println(node.val);

            if (node.left != null) queue[q++] = node.left;
            if (node.right != null) queue[q++] = node.right;


        }

    }
}
