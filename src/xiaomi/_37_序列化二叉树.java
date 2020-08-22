package xiaomi;


import java.util.LinkedList;
import java.util.Queue;

public class _37_序列化二叉树 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 层次遍历
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();

        sb.append("[");

        if (root == null) return "[]";

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null,");
                continue;
            }
            sb.append(node.val + ",");

            queue.offer(node.left);
            queue.offer(node.right);
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // 同样也是借助队列的层次遍历
    public TreeNode deserialize(String data) {

        if ("[]".equals(data)) return null;

        String[] nodes = data.substring(1, data.length() - 1).split(",");

        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!"null".equals(nodes[i])) {
                node.left = new TreeNode(Integer.valueOf(nodes[i]));
                queue.offer(node.left);
            }
            i++;
            if (!"null".equals(nodes[i])) {
                node.right = new TreeNode(Integer.valueOf(nodes[i]));
                queue.offer(node.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {

        _37_序列化二叉树 solution = new _37_序列化二叉树();
        TreeNode node1 = solution.new TreeNode(1);
        TreeNode node2 = solution.new TreeNode(2);
        TreeNode node3 = solution.new TreeNode(3);
        TreeNode node4 = solution.new TreeNode(4);
        TreeNode node5 = solution.new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        String str = solution.serialize(node1);
        System.out.println(str);
    }
}
