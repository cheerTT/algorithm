package test.b._0904;

import java.util.ArrayList;
import java.util.List;

public class _03 {

    public int GetFragment (String str) {

        List<String> list = compute(str);

        int res = 0;

        for (String s : list) {
            res += s.length();
        }
        return list.size() == 0 ? 0 : res / list.size();
    }

    private List<String> compute(String str) {

        List<String> list = new ArrayList<>();

        if (str == null || str.length() == 0) return list;

        int start = 0;
        int len = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                len++;
            } else {
                list.add(str.substring(start, start + len));
                start = i;
                len = 1;
            }
        }

        list.add(str.substring(start, start + len));

        return list;
    }

    public static void main(String[] args) {

        _03 solution = new _03();

        List<String> list = solution.compute("");
        System.out.println(list.size());
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();


        int a = solution.GetFragment("");
        System.out.println(a);
    }
}
