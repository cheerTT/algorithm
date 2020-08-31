package type.backtrace;

import java.util.ArrayList;
import java.util.List;

public class _0093_复原IP地址 {

    private List<String> res;

    public List<String> restoreIpAddresses(String s) {

        res = new ArrayList<>();
        int[] segments = new int[4];
        backtrace(s, 0, 0, segments);

        return res;
    }

    private void backtrace(String s, int k, int digit, int[] segments) {

        if (digit == 4) {
            if (k == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 3; i++) {
                    sb.append(segments[i]).append(".");
                }
                sb.append(segments[3]);
                res.add(sb.toString());
            }
            return;
        }

        // 提前结束
        if (k == s.length()) return;

        if(s.charAt(k) == '0') {
            segments[digit] = 0;
            backtrace(s, k + 1, digit + 1, segments);
        }

        int tmp = 0;

        for (int i = k; i < s.length(); i++) {

            tmp = tmp * 10 + (s.charAt(i) - '0');

            if (tmp > 0 && tmp <= 255) {
                segments[digit] = tmp;
                backtrace(s, i + 1, digit + 1, segments);
            } else { // 不满足直接退出
                break;
            }
        }
    }

    public static void main(String[] args) {

        _0093_复原IP地址 solution = new _0093_复原IP地址();
        String s = "25525511135";
        List<String> res1 = solution.restoreIpAddresses(s);
        for (String re : res1) {
            System.out.println(re);
        }
    }
}
