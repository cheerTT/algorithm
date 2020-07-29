package type.stack;

import java.util.Stack;

public class _042_接雨水 {

    // 单调栈
    // 0,1,0,2,1,0,1,3,2,1,2,1
    public int trap(int[] height) {

        int res = 0;
        int n = height.length;

        Stack<Integer> stack = new Stack<>();

        int left = -1;
        int right = n;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() < height[i]) {
                int curId = stack.pop();

                if (!stack.isEmpty()) {
                    res += (Math.min(height[stack.peek()], height[i]) - height[curId]) * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }
        return res;
    }
}
