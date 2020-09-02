package type.backtrace;

import java.util.ArrayList;
import java.util.List;

public class _0131_分割回文串 {

    List<List<String>> res;

    // 排列问题
    public List<List<String>> partition(String s) {

        res = new ArrayList<>();
        List<String> list = new ArrayList<>();

        backtrack(s, list);

        return res;

    }

    private void backtrack(String s, List<String> list) {

        if (s.length() == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (isPal(s.substring(0, i + 1))) {
                list.add(s.substring(0, i + 1));
                backtrack(s.substring(i + 1), list);
                list.remove(list.size() - 1);
            }

        }
    }

    private boolean isPal(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {

        _0131_分割回文串 solution = new _0131_分割回文串();

        List<List<String>> res = solution.partition("aan");

        for (List<String> re : res) {
            for (String s : re) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
