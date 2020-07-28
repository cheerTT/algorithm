package jianzhi.order;

public class _61_扑克牌中的顺子 {

    public boolean isStraight(int[] nums) {

        int[] store = new int[14]; // 一共有 13 个数
        int min = 14;
        int max = -1;

        for (int i = 0; i < nums.length; i++) {
            store[nums[i]] ++;

            // 当前值为0的时候，直接进行下一轮循环
            if (nums[i] == 0) continue;

            // 除 0 以外，当一个数字出现 2 次以上的时候，肯定不是顺子
            if (store[nums[i]] > 1) return false;

            if (min > nums[i]) min = nums[i];

            if (max < nums[i]) max = nums[i];
        }

        return max - min < 5;
    }
}
