package jianzhi.order;

import java.util.Stack;

public class _09_两个栈实现队列 {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public _09_两个栈实现队列() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // 尾部添加元素
    public void appendTail(int value) {
        stack1.push(value);
    }

    // 头部删除元素
    public int deleteHead() {

        if (stack1.isEmpty() && stack2.isEmpty()) {
            return -1;
        }

        while (!stack1.isEmpty() && stack2.isEmpty()) {
            stack2.push(stack1.pop());
        }

        return stack2.pop();
    }
}
