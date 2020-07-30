package type.stack;

import java.util.Stack;

public class _0084_柱状图中的最大矩形 {

    // 2,1,5,6,2,3
    // 单调栈
    // 时间复杂度 O(n)
    // 空间复杂度 O(n)
    public int largestRectangleArea(int[] heights) {

        int res = 0;

        int[] n_heights = new int[heights.length + 2];
        System.arraycopy(heights, 0, n_heights, 1, heights.length);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n_heights.length; i++) {
            while (!stack.isEmpty() && n_heights[stack.peek()] > n_heights[i]) {
                int curId = stack.pop();
                res = Math.max(res, (i - stack.peek() - 1) * n_heights[curId]);
            }
            stack.push(i);
        }

        return res;
    }
}
