package jianzhi.order;

import java.nio.channels.Channel;
import java.util.HashMap;
import java.util.Map;

public class _50_第一个只出现一次的字符 {

    // 哈希表
    public char firstUniqChar(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) + 1);
        }

        // 任意只出现一次的字符
//        for (Character c : map.keySet()) {
//            if (map.get(c) == 1) {
//                return c;
//            }
//        }

        // 第一个只出现一次的字符
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }

        return ' ';
    }
}
