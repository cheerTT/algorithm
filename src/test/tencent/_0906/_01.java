package test.tencent._0906;

import java.util.*;

public class _01 {

    private static Queue<Long> count(Queue<Long> stack1, Queue<Long> stack2) {

        Queue<Long> res = new LinkedList<>();

        while (!stack1.isEmpty() && !stack2.isEmpty()) {

            if (stack1.peek() == stack2.peek()) {
                res.offer(stack1.peek());
                stack1.poll();
                stack2.poll();
            } else {
                long max = Math.max(stack1.peek(), stack2.peek());
                if (stack1.peek() == max) stack1.poll();
                else stack2.poll();
            }
        }

        return res;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();

        Queue<Long> stack1 = new LinkedList<>();
        for (int i = 0; i < n1; i++) {
            stack1.add(sc.nextLong());
        }

        int n2 = sc.nextInt();

        Queue<Long> stack2 = new LinkedList<>();
        for (int i = 0; i < n2; i++) {
            stack2.add(sc.nextLong());
        }

        Queue<Long> res = count(stack1, stack2);

        StringBuilder sb = new StringBuilder();

        while (!res.isEmpty()) {
            sb.append(res.poll()).append(" ");
        }

        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }
}
