package yuanfudao.tree;

import java.util.ArrayList;
import java.util.List;

public class _0113_路径总和2 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<List<Integer>> res = new ArrayList<>();

    // 回溯法
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> comp = new ArrayList<>();
        help(root, 0, sum, comp);
        return res;
    }

    private void help(TreeNode root, int cur, int sum, List<Integer> comp) {

        if (root == null) return;

        cur += root.val;
        comp.add(root.val);

        if (cur == sum && root.left == null && root.right == null) {
            res.add(new ArrayList<>(comp)); // 全局只有一份，必须拷贝
            comp.remove(comp.size() - 1); // return 之前必须重置
            return;
        }

        help(root.left, cur, sum, comp);
        help(root.right, cur, sum, comp);

        // 回溯
        comp.remove(comp.size() - 1);
    }
}
