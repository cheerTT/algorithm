package jianzhi.order;

public class _67_把字符串转换成整数 {

    // 从头到尾逐步遍历
    public int strToInt(String str) {

        int res = 0;
        int idx = 0;
        boolean flag = false;

        char[] cs = str.toCharArray();

        while (idx < cs.length && cs[idx] == ' ') {
            idx++;
        }

        if (idx == cs.length) return res;

        if (cs[idx] == '+') {
            idx++;
        } else if (cs[idx] == '-'){
            flag = true;
            idx++;
        } else if (cs[idx] < '0' || cs[idx] > '9') {
            return res;
        }

        for (int i = idx; i < cs.length; i++) {
            if (cs[idx] >= '0' && cs[idx] <= '9') {
                int val = cs[i] - '0';
                if (res > (Integer.MAX_VALUE - val) / 10) {
                    return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                res = res * 10 + val;
            } else {
                break;
            }
        }

        return flag ? -res : res;
    }
}
