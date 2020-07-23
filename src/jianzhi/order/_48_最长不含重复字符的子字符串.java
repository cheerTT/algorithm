package jianzhi.order;

import java.util.HashMap;
import java.util.Map;

public class _48_最长不含重复字符的子字符串 {

    // 双指针 + hash表
    public int lengthOfLongestSubstring(String s) {

        int res = 0;

        Map<Character, Integer> map = new HashMap<>();

        int i = -1;
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, s.charAt(j));
            }
            map.put(s.charAt(j), j);
            res = Math.max(res, j - i);
        }
        return res;
    }
}
