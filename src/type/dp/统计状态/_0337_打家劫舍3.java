package type.dp.统计状态;

public class _0337_打家劫舍3 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // dp[node][j]
    //      j == 0, 以 node 为根节点的树不偷
    //      j == 1, 以 node 为根节点的树偷
    // 状态分析：
    //      当前节点不偷，左右节点选最大值
    //      当前节点偷，左右节点都不能选
    public int rob(TreeNode root) {
        int[] res = postOrder(root);
        return Math.max(res[0], res[1]);
    }

    // 后续遍历，左右根
    private int[] postOrder(TreeNode root) {

        if (root == null) {
            return new int[] {0, 0};
        }

        int[] left = postOrder(root.left);
        int[] right = postOrder(root.right);

        int[] dp = new int[2];

        // 当前节点不选，选其孩子节点
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = root.val + left[0] + right[0];

        return dp;
    }
}
