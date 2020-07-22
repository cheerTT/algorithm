package jianzhi.order;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _34_二叉树中和为某一值的路径 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new LinkedList<>();

    // 递归 + 回溯
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return res;
        help(root, sum);
        return res;
    }

    private void help(TreeNode root, int sum) {

        path.add(root.val);

        if (root.val == sum && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }

        if (root.left != null) {
            help(root.left, sum - root.val);
        }

        if (root.right != null) {
            help(root.right, sum - root.val);
        }

        path.remove(path.size() - 1);
    }
}
