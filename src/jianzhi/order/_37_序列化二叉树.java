package jianzhi.order;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class _37_序列化二叉树 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public String serialize(TreeNode root) {

        if (root == null) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val + ",");
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                sb.append("null,");
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");

        return sb.toString();
    }

    public TreeNode deserialize(String data) {

        if ("[]".equals(data)) return null;

        String[] datas = data.substring(1, data.length() - 1).split(",");

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(datas[0]));
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            if (!"null".equals(node)) {
                node.left = new TreeNode(Integer.parseInt(datas[i]));
                queue.offer(node.left);
            }
            i++;
            if (!"null".equals(node)) {
                node.right = new TreeNode(Integer.parseInt(datas[i]));
                queue.offer(node.right);
            }
            i++;

        }
        return root;


    }
}
