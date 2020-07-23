package jianzhi.order;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class _20_表示数值的字符串 {

    // 整个程序都在成员变量上操作
    // 包含小数点：点前面是整数，点后面是无符号整数
    // 包含E、e：前后均是有符号数
    private int idx = 0;

    public boolean isNumber(String s) {

        boolean isNum = isInteger(s);

        if (idx < s.length() && s.charAt(idx) == '.') {
            idx++;
            isNum = isUnsignedInteger(s) || isNum; // .123 也算数字
        }

        if (idx < s.length() && (s.charAt(idx) == 'e' || s.charAt(idx) == 'E')) {
            idx++;
            isNum = isInteger(s) && isNum;
        }

        return idx == s.length() && isNum;
    }

    // 是否为整数
    private boolean isInteger(String s) {

        if (idx < s.length() && (s.charAt(idx) == '-' || s.charAt(idx) == '+')) {
            idx++;
        }

        return isUnsignedInteger(s);
    }

    // 是否为无符号整数
    private boolean isUnsignedInteger(String s) {
        int start = idx;
        while (idx < s.length() && s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
            idx++;
        }
        return idx > start;
    }
}
