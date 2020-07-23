package jianzhi.order;

import java.util.Stack;

public class _31_栈的压入弹出序列 {

    // 通过栈模拟实现
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        if (pushed == null || pushed.length != popped.length) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();

        int k = 0;
        for (int i = 0; i < pushed.length; i++) {

            stack.push(pushed[i]);

            while (!stack.isEmpty() && stack.peek() == popped[k]) {
                stack.pop();
                k++;
            }

        }

        return stack.isEmpty();
    }
}
