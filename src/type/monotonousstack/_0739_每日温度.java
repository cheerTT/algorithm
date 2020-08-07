package type.monotonousstack;

import java.util.Stack;

public class _0739_每日温度 {

    // 观测比当天高的温度需要等待的天数
    // 73, 74, 75, 71, 69, 72, 76, 73
    // 1, 1, 4, 2, 1, 1, 0, 0
    // 时间复杂度 O(n)
    // 空间复杂度 O(n)
    // 单调递减栈
    public int[] dailyTemperatures(int[] T) {

        int[] res = new int[T.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int curId = stack.pop();
                res[curId] = i - curId;
            }
            stack.push(i);
        }

        return res;
    }

}
