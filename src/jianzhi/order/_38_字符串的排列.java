package jianzhi.order;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _38_字符串的排列 {

    // 时间复杂度 O(n!)
    // 空间复杂度 O(n2)
    public String[] permutation(String s) {
        List<String> res = new ArrayList<>();

        help(s.toCharArray(), 0, res);

        return res.toArray(new String[res.size()]);
    }

    private void help(char[] str, int i, List<String> list) {

        // 递归终止条件
        if (i == str.length - 1) {
            String res = String.valueOf(str);
            list.add(res);
        } else {
            // 用于排除重复元素
            Set<Character> set = new HashSet<>();
            for (int j = i; j < str.length; j++) {
                if (set.contains(str[j])) continue;
                set.add(str[j]);
                swap(str, i, j);
                help(str, i + 1, list);
                swap(str, i, j);
            }
        }
    }

    private void swap(char[] str, int a, int b) {
        char tmp = str[a];
        str[a] = str[b];
        str[b] = tmp;
    }
}
