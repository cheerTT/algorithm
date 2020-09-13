package test.xinglang._0913;


import jianzhi.order._32_01_从上到下打印二叉树;
import jianzhi.order._37_序列化二叉树;
import meituan.tree.层序遍历二叉树;

import java.util.*;

public class _01 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public TreeNode updownReverse(TreeNode root) {

        TreeNode node = root;
        TreeNode parent = null;
        TreeNode right = null;

        while (node != null) {
            TreeNode left = node.left;
            node.left = right;
            right = node.right;
            node.right = parent;
            parent = node;
            node = left;
        }


        return parent;
    }

    private TreeNode construcotrTree(String[] strs) {

        if (strs == null || strs.length == 0) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < strs.length) {

            TreeNode node = queue.poll();

            node.left = new TreeNode(Integer.parseInt(strs[i]));
            queue.offer(node.left);
            i++;
            node.right = new TreeNode(Integer.parseInt(strs[i]));
            queue.offer(node.right);
            i++;

        }
        return root;
    }

    public List<Integer> printTree(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if (root == null) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return res;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String[] strs = str.split(",");

        _01 solution = new _01();


        TreeNode root = solution.construcotrTree(strs);

        TreeNode res = solution.updownReverse(root);


        List<Integer> dst = solution.printTree(res);
        StringBuilder sb = new StringBuilder();
        for (int i : dst) {
            sb.append(i).append(",");
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
    }
}
