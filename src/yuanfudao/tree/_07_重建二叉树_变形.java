package yuanfudao.tree;

import jianzhi.order._07_重建二叉树;
import sun.reflect.generics.tree.Tree;

// 由先序序列和中序序列构建二叉树
// 由中序序列和后续序列构建二叉树
public class _07_重建二叉树_变形 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 知道前序和中序，重建二叉树
    //    // 以中序遍历为基准
    public TreeNode buildTree1(int[] preorder, int[] inorder) {

        return help1(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode help1(int[] preorder, int startPre, int endPre,
                       int[] inorder, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) return null;

        TreeNode root = new TreeNode(preorder[startPre]);

        for (int i = startIn; i <= endIn; i++) {
            if (inorder[i] == preorder[startPre]) {
                root.left = help1(preorder, startPre + 1, startPre + i - startIn,
                        inorder, startIn, i - 1);
                root.right = help1(preorder, startPre + i - startIn + 1, endPre,
                        inorder, i + 1, endIn);
            }
        }
        return root;
    }

    // 知道中序和后序，构建二叉树
    // 在中序遍历后找啊找
    public TreeNode buildTree2(int[] inorder, int[] postorder) {

        return help2(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    private TreeNode help2(int[] inorder, int startIn, int endIn, int[] postorder, int startPost, int endPost) {

        if (startIn > endIn || startPost > endPost) return null;

        TreeNode root = new TreeNode(postorder[endPost]);

        for (int i = startIn; i <= endIn; i++) {
            if (root.val == inorder[i]) {
                root.left = help2(inorder, startIn, i - 1,
                        postorder, startPost, startPost + i - startIn);
                root.right = help2(inorder, i + 1, endIn,
                        postorder, startPost + i - startIn + 1, endPost - 1);
            }
        }

        return root;
    }

}
