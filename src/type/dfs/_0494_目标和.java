package type.dfs;

public class _0494_目标和 {


    public int findTargetSumWays(int[] nums, int S) {

        return dfs(nums, 0, S);
    }

    private int dfs(int[] nums, int start, int S) {

        if (start == nums.length) {
            return S == 0 ? 1 : 0;
        }

        return dfs(nums, start + 1 , S - nums[start])
                + dfs(nums, start + 1, S + nums[start]);
    }
}
