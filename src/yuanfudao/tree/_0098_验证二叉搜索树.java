package yuanfudao.tree;

import java.util.Stack;

public class _0098_验证二叉搜索树 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private long preVal = Long.MIN_VALUE;

    // 中序遍历实现
    public boolean isValidBST(TreeNode root) {

        if (root == null) return true;

        if (!isValidBST(root.left)) {
            return false;
        }

        if (preVal >= root.val) {
            return false;
        }
        preVal = root.val;

        return isValidBST(root.right);
    }

    private int comp = Integer.MAX_VALUE;

    // 非递归实现
    public boolean isValidBST1(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();

        while (stack.isEmpty() || root != null) {
            // 当不为空的时候，不断向左遍历
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (preVal >= stack.peek().val) {
                    return false;
                }
                preVal = stack.peek().val;
                root = stack.pop().right;
            }
        }
        return true;
    }

}
