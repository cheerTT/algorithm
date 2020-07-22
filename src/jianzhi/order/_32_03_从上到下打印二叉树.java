package jianzhi.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _32_03_从上到下打印二叉树 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

        int layer = 1;

        Stack<TreeNode> stack1 = new Stack<>();
        stack1.add(root);
        Stack<TreeNode> stack2 = new Stack<>();

        while (!stack1.isEmpty() || !stack2.isEmpty()) {

            List<Integer> list = new ArrayList<>();
            if (layer % 2 == 1) {
                while (!stack1.isEmpty()) {
                    TreeNode node = stack1.pop();
                    if (node != null) {
                        list.add(node.val);
                        stack2.push(node.left);
                        stack2.push(node.right);
                    }
                }
            } else {
                while (!stack2.isEmpty()) {
                    TreeNode node = stack2.pop();
                    if (node != null) {
                        list.add(node.val);
                        stack1.push(node.right);
                        stack1.push(node.left);
                    }
                }
            }

            if (!list.isEmpty()) {
                res.add(list);
                layer++;
            }
        }
        return res;
    }
}
