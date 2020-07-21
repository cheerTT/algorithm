package jianzhi.order;

public class _26_树的子结构 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {

        boolean res = false;
        if (A == null || B == null) return false;

        res = core(A, B);

        if (!res) {
            core(A.left, B);
        }

        if (!res) {
            core(A.right, B);
        }

        return res;
    }

    private boolean core(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null) return false;

        // 值不相等，返回 false
        if (A.val != B.val) return false;

        return core(A.left, B.left) && core(A.right, B.right);
    }
}
