package type.dp.回文子串;

public class _0005_最长回文子串 {

     public String longestPalindrome(String s) {

         int n = s.length();

         if (n < 2) return s;

         boolean[][] dp = new boolean[n][n];

         int start = 0;
         int maxLen = 0;
         for (int j = 0; j < n; j++) {
             for (int i = 0; i <= j; i++) {
                 if (s.charAt(i) != s.charAt(j)) {
                     dp[i][j] = false;
                 } else {
                     if (j - i + 1 < 4) {
                         dp[i][j] = true;
                     } else {
                         dp[i][j] = dp[i + 1][j - 1];
                     }

                     if (dp[i][j] && j - i + 1 > maxLen) {
                         maxLen = j - i + 1;
                         start = i;
                     }
                 }
             }
         }

         return s.substring(start, start + maxLen);
     }
}
