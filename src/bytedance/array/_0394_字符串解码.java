package bytedance.array;

import java.util.Stack;

public class _0394_字符串解码 {

    // 时间复杂度 O(n)
    // 空间复杂度 O(n)
    public String decodeString(String s) {

        StringBuilder sb = new StringBuilder();
        Stack<Integer> digits = new Stack<>();
        Stack<String> strs = new Stack<>();

        char[] chars = s.toCharArray();
        int n = chars.length;
        int num = 0;

        int i = 0;
        while (i < n) {

            // 当等于左符号的时候，前面数字入栈，然后清空
            // 前面字符入栈，然后清空
            if (chars[i] == '[') {
                digits.push(num);
                strs.push(sb.toString());
                // 重新来过
                num = 0;
                sb = new StringBuilder();
            } else if (chars[i] == ']') {
                // 当等于右符号时
                StringBuilder tmp = new StringBuilder();
                int times = digits.pop();
                for (int j = 0; j < times; j++) {
                    tmp.append(sb);
                }
                sb = new StringBuilder(strs.pop() + tmp);
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                // 防止出现 2位数及两位以上的情况
                num = num * 10 + chars[i] - '0';
            } else {
                sb.append(chars[i]);
            }
            i++;
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        _0394_字符串解码 solution = new _0394_字符串解码();

        String res = solution.decodeString("abc3[cd]xyz");
        System.out.println(res);
    }

}
