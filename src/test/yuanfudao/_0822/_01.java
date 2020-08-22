package test.yuanfudao._0822;

import java.util.*;

public class _01 {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        TreeNode root = construct(nums);

        int[] res = new int[n];

        TreeNode first = root;
        int i = 0;
        while (first != null) {
            res[i++] = first.val;
            first = first.left;
        }

        TreeNode last = root.right;
        int j = nums.length - 1;
        while (last != null) {
            res[j--] = last.val;
            last = last.right;
        }
        List<List<Integer>> lists = levelOrder(root);

        List<Integer> list1 = lists.get(lists.size() - 1);
        List<Integer> list2 = lists.get(lists.size() - 2);

        for (int k = 1; k < list1.size(); k++) {
            res[i++] = list1.get(k);
        }
        for (int k = 1; k < list2.size() - 1; k++) {
            res[i++] = list2.get(k);
        }

        System.out.print(res[0]);
        for (int k = 1; k < res.length; k++) {
            System.out.print(" " + res[k]);
        }
    }


    private static TreeNode construct(int[] nums) {

        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < nums.length && !queue.isEmpty()) {
            TreeNode node = queue.poll();
            node.left = new TreeNode(nums[i]);
            queue.offer(node.left);
            i++;
            if (i == nums.length) break;
            node.right = new TreeNode(nums[i]);
            queue.offer(node.right);
            i++;
            if (i == nums.length) break;
        }

        return root;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(list);
        }
        return res;
    }

}
