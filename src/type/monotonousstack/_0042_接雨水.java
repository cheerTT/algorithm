package type.monotonousstack;

import java.util.Stack;

public class _0042_接雨水 {

    // 单调栈
    // 0,1,0,2,1,0,1,3,2,1,2,1
    public int trap(int[] height) {

        int res = 0;
        int n = height.length;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int curId = stack.pop();

                if (!stack.isEmpty()) {
                    res += (Math.min(height[stack.peek()], height[i]) - height[curId]) * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }
        return res;
    }

    // 双指针
    // 0,1,0,2,1,0,1,3,2,1,2,1
    // 时间复杂度 O(n)
    // 空间复杂度 O(1)
    public int trap1(int[] height) {

        int res = 0;
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {

            if (height[left] < height[right]) {
                if (height[left] >= leftMax){
                    leftMax = height[left];
                } else {
                    res += (leftMax - height[left]);
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    res += (rightMax - height[right]);
                }
                right--;
            }
        }

        return res;
    }

}
