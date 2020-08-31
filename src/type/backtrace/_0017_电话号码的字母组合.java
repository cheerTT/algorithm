package type.backtrace;

import java.util.ArrayList;
import java.util.List;

// 时间复杂度 O(2^n)
public class _0017_电话号码的字母组合 {

    public static final String[] KEYS = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private List<String> res;

    public List<String> letterCombinations(String digits) {

        res = new ArrayList<>();

        StringBuilder str = new StringBuilder();
        backtrace(digits, str);

        return res;
    }

    private void backtrace(String digits, StringBuilder str) {

        if (str.length() == digits.length()) {
            res.add(str.toString());
            return;
        }

        String values = KEYS[digits.charAt(str.length() - '0')];

        for (char c : values.toCharArray()) {
            str.append(c);
            backtrace(digits, str);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
