package hot;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Stack;

public class _nc01_求二叉树的前序遍历 {

    class TreeNode {
      int val = 0;
      TreeNode left = null;
      TreeNode right = null;
    }

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write code here
        ArrayList<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        if (root == null) return res;

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return res;

    }
}
