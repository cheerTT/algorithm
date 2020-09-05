package test.haoweilai._0905;

import org.omg.CORBA.INTERNAL;
import sun.reflect.generics.tree.Tree;

import java.util.Stack;

public class _01 {

    class TreeNode {
      int val = 0;
      TreeNode left = null;
      TreeNode right = null;
    }

    public String notReCuPreOrder (TreeNode root) {

        StringBuilder sb = new StringBuilder();

        if (root == null) return sb.toString();

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();
            sb.append(node.val).append(",");

            if (node.right != null) stack.push(node.right);

            if (node.left != null) stack.push(node.left);
        }

        return sb.toString().substring(0, sb.length() - 1);
    }
}
