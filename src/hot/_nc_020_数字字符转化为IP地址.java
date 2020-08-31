package hot;

import java.util.ArrayList;

public class _nc_020_数字字符转化为IP地址 {

    private ArrayList<String> res;

    public ArrayList<String> restoreIpAddresses (String s) {
        // write code here
        res = new ArrayList<>();
        int[] segments = new int[4];
        backtrace(s, 0, 0, segments);
        return res;
    }

    /**
     *
     * @param s 输入字符串 s
     * @param k 当前遍历的索引
     * @param digits 当前到达的位数
     * @param segments 分别存放IP的四个数
     */
    private void backtrace(String s, int k, int digits, int[] segments) {

        if (digits == 4) {
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

        // 提前遍历结束，直接return
        if (k == s.length()) return;


        // 对 0 开头的字符特殊处理
        if (s.charAt(k) == '0') {
            segments[digits] = 0;
            backtrace(s, k + 1, digits + 1, segments);
        }


        int tmp = 0;
        for (int i = k; i < s.length(); i++) {

            tmp = tmp * 10 + (s.charAt(i) - '0');

            if (tmp > 0 && tmp <= 255) {
                segments[digits] = tmp;
                backtrace(s, i + 1, digits + 1, segments);
            } else { // 直接返回，后面不需要处理，这种情况肯定不满足
                break;
            }
        }
    }
}
