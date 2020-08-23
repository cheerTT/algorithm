package hot;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

public class _nc_011_将升序数组转化为平衡二叉树 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int x) {val = x;}
    }

    public TreeNode sortedArrayToBST(int[] num) {

        if (num == null || num.length == 0) return null;

        return sortedArrayToBST(num, 0, num.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int left, int right) {

        if (right < left) return null;

        if (left == right) return new TreeNode(nums[left]);

        int mid = (left + right + 1) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = sortedArrayToBST(nums, left, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, right);

        return root;
    }
}
