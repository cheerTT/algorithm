package alibaba.str;

import java.util.HashMap;

public class _0290_单词规律 {

    public boolean wordPattern(String pattern, String str) {

        HashMap<Character, String> map = new HashMap<>();
        String[] strs = str.split(" ");
        boolean flag = true;

        if (strs.length != pattern.length()) return false; // 细节一，当不等于的时候直接返回

        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                flag = flag && map.get(pattern.charAt(i)).equals(strs[i]);
            } else {
                if (map.containsValue(strs[i])) { // 细节二，不同key不能保存同样的字符
                    return false;
                } else {
                    map.put(pattern.charAt(i), strs[i]);
                }
            }
        }

        return flag;
    }

    public static void main(String[] args) {

    }
}
