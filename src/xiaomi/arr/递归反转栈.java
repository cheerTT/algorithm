package xiaomi.arr;

import java.util.Stack;

public class 递归反转栈 {


    private static void recur(Stack stack, Stack res) {

        if (stack.isEmpty()) return;

        res.push(stack.pop());

        recur(stack, res);
    }

    private static void print(Stack stack) {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        Stack<Integer> res = new Stack<>();

        recur(stack, res);

        print(res);
    }
}
