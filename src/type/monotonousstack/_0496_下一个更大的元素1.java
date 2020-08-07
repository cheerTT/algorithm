package type.monotonousstack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _0496_下一个更大的元素1 {

    // 下一个更大的元素 单调栈结合map
    // 思路：先将 nums2 中下一个最大的的元素索引存下，在计算 nums1 的结果
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] res = new int[nums1.length];

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                int curId = stack.pop();
                map.put(nums2[curId], i);
            }
            stack.push(i);
        }

        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                res[i] = nums2[map.get(nums1[i])];
            } else {
                res[i] = -1;
            }
        }

        return res;
    }
}
