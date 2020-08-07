package type.monotonousstack;

import java.util.Stack;

public class _0316_去除重复字母 {

    public String removeDuplicateLetters(String s) {

        StringBuilder sb = new StringBuilder();

        // 栈中存放的肯定是当前最优的解
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            // 若当前字符已经存在，则没有必要再继续计算下去
            if (!stack.isEmpty() && stack.contains(s.charAt(i))) {
                continue;
            }
            // 顺序不满足，直接移除
            while (!stack.isEmpty() && stack.peek() > s.charAt(i) && s.indexOf(stack.peek(), i) > 0) {
                stack.pop();
            }
            stack.push(s.charAt(i));
        }

        for (Character c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        _0316_去除重复字母 solution = new _0316_去除重复字母();
        String s = solution.removeDuplicateLetters("cbacdcbc");


        System.out.println(s);
    }
}
