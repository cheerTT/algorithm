package yuanfudao.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _0049_字母异位词分组 {

    // 先排序，再放入 hashmap 中
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();



        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();

            Arrays.sort(chars);

            if (map.containsKey(String.valueOf(chars))) {
                map.get(String.valueOf(chars)).add(strs[i]);
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(strs[i]);
                map.put(String.valueOf(chars), tmp);
            }
        }

        for (String s : map.keySet()) {
            res.add(map.get(s));
        }

        return res;
    }
}
