package jianzhi.order;

import java.util.Stack;

public class _30_包含min函数的栈 {

    Stack<Integer> stack;
    Stack<Integer> min;

    public _30_包含min函数的栈() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);

        if (min.isEmpty() || min.peek() > x) {
            min.push(x);
        } else {
            min.push(min.peek());
        }
    }

    public void pop() {
        if (!stack.isEmpty()) stack.pop();
        if (!min.isEmpty()) min.pop();
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        } else {
            return -1;
        }
    }

    public int min() {
        if (!min.isEmpty()) {
           return min.peek();
        }
        return -1;
    }
}
