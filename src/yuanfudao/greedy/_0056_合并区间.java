package yuanfudao.greedy;

import java.util.Arrays;

public class _0056_合并区间 {

    // 贪心策略
    // 输入：[[1,3],[2,6],[8,10],[15,18]]
    // 输出：[[1,6],[8,10],[15,18]]
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        int[][] res = new int[intervals.length][2];

        int idx = -1;

        for (int[] interval : intervals) {
            if (idx == -1 || interval[0] > intervals[idx][1]) {
                res[++idx] = interval;
            } else {
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }

        // 合并
        // 移除某位的 0，记录真正的元素个数
        return Arrays.copyOf(res, idx + 1);
    }

    public static void main(String[] args) {

        _0056_合并区间 solution = new _0056_合并区间();
        int[][] intervals = {{1, 19}, {4, 6}, {8, 10}, {15, 18}};
        int[][] merge = solution.merge(intervals);

        System.out.println(",,,,,,,,,,,,,,,,,,,,,,,");
        for (int[] ints : merge) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }
}