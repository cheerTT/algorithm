package yuanfudao.tree;

public class _27_二叉树的镜像 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 采用递归，从整体上观察
    // 交换左右子树，需要引入中间变量，类比两个数的交换
    public TreeNode mirrorTree(TreeNode root) {

        if (root == null) return root;

        TreeNode tmp = mirrorTree(root.left);
        tmp.left = mirrorTree(root.right);
        tmp.right = tmp;

        return root;
    }
}
