package type.stack;

import java.util.Stack;

public class _0402_移调k位数字 {

    // 移调 k 位数字，使得剩下的数字最小
    // 递增栈
    public String removeKdigits(String num, int k) {

        int comp = num.length() - k;

        StringBuilder res = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            while (k != 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }

        // 处理 "9" 1 这样的情况
        while (stack.size() > comp) {
            stack.pop();
        }

        for (Character c : stack) {
            res.append(c);
        }

        // 去除先导 "0"
        String r = res.toString();
        int m = 0;
        while (m < r.length() && r.charAt(m) == '0') {
            m++;
        }

        return m == r.length() ? "0" : r.substring(m);
    }

    public static void main(String[] args) {

        _0402_移调k位数字 solution = new _0402_移调k位数字();

        String res = solution.removeKdigits("1173", 2);
        System.out.println(res);
    }

}
