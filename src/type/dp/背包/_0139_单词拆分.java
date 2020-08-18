package type.dp.背包;

import java.util.List;

public class _0139_单词拆分 {

    public boolean wordBreak(String s, List<String> wordDict) {

        int n = s.length();

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i < s.length(); i++) {
            for (String word : wordDict) { // 顺序完全背包放在里面
                int len = word.length();
                if (i >= len && word.equals(s.substring(i - len, i))) {
                    dp[i] = dp[i] || dp[i - len];
                }
            }
        }

        return dp[n];
    }


}
