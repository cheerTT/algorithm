package type.stack;

import java.util.Stack;

public class _0581_最短无序连续子数组 {

    public int findUnsortedSubarray(int[] nums) {

        int min = nums.length;
        int max = -1;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                min = Math.min(min, stack.pop());
            }
            stack.push(i);
        }

        stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                max = Math.max(max, stack.pop());
            }
            stack.push(i);
        }

        return max > min ? max - min + 1 : 0;
    }

    public static void main(String[] args) {

        _0581_最短无序连续子数组 solution = new _0581_最短无序连续子数组();
        int[] nums = {2,6,4,8,10,9,15};
        int res = solution.findUnsortedSubarray(nums);

        System.out.println(res);
    }
}
