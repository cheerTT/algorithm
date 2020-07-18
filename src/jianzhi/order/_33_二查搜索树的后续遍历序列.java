package jianzhi.order;

import java.util.Stack;

public class _33_二查搜索树的后续遍历序列 {

    // 单调栈
    // 二叉搜索树：左 < 根 < 右
    // 后续遍历序列：左-右-根 逆序：根-右-左
    public boolean verifyPostorder1(int[] postorder) {

        Stack<Integer> stack = new Stack<>();

        int root = Integer.MAX_VALUE; // 当前更节点
        for (int i = postorder.length - 1; i >= 0; i--) {

            if (root < postorder[i]) { // 根节点小于左子树节点
                return false;
            }

            while (!stack.isEmpty() && postorder[i] < stack.peek()) {
                root = stack.pop();
            }

            stack.push(postorder[i]);
        }
        return true;
    }

    // 递归
    // 定义最后一个数为根节点，从左开始遍历，找到第一个大于根节点的数的位置
    // 该位置之前所有元素为左子树，该位置之后根节点之前的值应该大于根节点为右子树
    public boolean verifyPostorder2(int[] postorder) {
        return help(postorder, 0, postorder.length - 1);
    }

    private boolean help(int[] postorder, int start, int end) {

        if (start >= end) return true;

        int i = start;
        for (; i < end; i++) {
            if (postorder[i] > postorder[end])
                break;
        }

        for (int j = i; j < end; j++) {
            if (postorder[j] < postorder[end])
                return false;
        }

        return help(postorder, start, i - 1)
                && help(postorder, i, end - 1);
    }

    public static void main(String[] args) {

        _33_二查搜索树的后续遍历序列 solution = new _33_二查搜索树的后续遍历序列();
        int[] postorder = {2,9,5,16,17,15,19,18,12};
        System.out.println(solution.verifyPostorder1(postorder));
        System.out.println(solution.verifyPostorder2(postorder));
    }

}
