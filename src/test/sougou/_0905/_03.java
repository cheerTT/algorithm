package test.sougou._0905;

import java.util.HashSet;
import java.util.Set;

public class _03 {


    Set<String> res;

    public long getPasswordCount (String password) {

        res = new HashSet<>();

        for (int i = 0; i <= 9; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            backtrace(password, 1, sb, i);
        }

        return res.size() - 1;
    }

    private void backtrace(String password, int start, StringBuilder sb, int pre) {

        if (start == password.length()) {
            res.add(sb.toString());
            return;
        }

        int cur = password.charAt(start) - '0';

        double newNum = (cur + pre) / 2.0;

        int num = (int) newNum;

        sb.append(num);
        backtrace(password, start + 1, sb, num);
        sb.deleteCharAt(sb.length() - 1);

        if (newNum > num) {
            sb.append(num + 1);
            backtrace(password, start + 1, sb, num + 1);
            sb.append(sb.length() - 1);
        }

    }

    public static void main(String[] args) {

        _03 solution = new _03();

        long res = solution.getPasswordCount("12345");

        System.out.println(res);
    }
}
