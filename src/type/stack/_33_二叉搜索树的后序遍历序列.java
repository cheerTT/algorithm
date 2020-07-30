package type.stack;

import com.sun.org.apache.bcel.internal.generic.POP;

import java.util.Stack;

public class _33_二叉搜索树的后序遍历序列 {

    // 1,6,3,2,5  false
    // 1,3,2,6,5  true
    // 后续遍历  左-右-根
    // 正常序列  左 < 根 < 右
    public boolean verifyPostorder(int[] postorder) {

        Stack<Integer> stack = new Stack();

        // 从右往左，分别为根，右，左
        // 假设该 root 的左节点为整个 postorder 的左节点
        int root = Integer.MAX_VALUE;

        for (int i = postorder.length - 1; i >= 0; i--) {

            if (postorder[i] > root) return false;

            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }
            stack.push(postorder[i]);
        }
        return true;
    }
}
