package jianzhi.order;

public class _07_重建二叉树 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 知道前序和中序，重建二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;

        return reconstruct(preorder, 0, preorder.length - 1, inorder, 0,inorder.length - 1);
    }

    private TreeNode reconstruct(int[] preorder, int startPre, int endPre,
                                 int[] inorder, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) return null;

        TreeNode root = new TreeNode(preorder[startPre]);
        // 确定先序遍历根节点，然后到中序遍历中递归寻找
        for (int i = startIn; i <= endIn; i++) {
            if (root.val == inorder[i]) {
                root.left = reconstruct(preorder,
                        startPre + 1,
                        startPre + (i - startIn),
                        inorder,
                        startIn,
                        i - 1);
                root.right = reconstruct(preorder,
                        startPre + (i - startIn) + 1,
                        endPre,
                        inorder,
                        i + 1,
                        endIn);
            }
        }
        return root;
    }
}
