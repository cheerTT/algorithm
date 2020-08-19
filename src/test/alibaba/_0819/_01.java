package test.alibaba._0819;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            Queue<Integer> n_queue = new LinkedList<>();
            Queue<Integer> m_queue = new LinkedList<>();
            for (int x = 0; x < n; x++) {
                n_queue.offer(sc.nextInt());
            }

            for (int j = 0; j < m; j++) {
                m_queue.offer(sc.nextInt());
            }

            Queue<Integer> t_queue = new LinkedList<>();

            for (int j = 0; j < m + n; j++) {
                t_queue.offer(sc.nextInt());
            }

            while (!n_queue.isEmpty() || !m_queue.isEmpty()) {
                if (!m_queue.isEmpty() && t_queue.peek() == m_queue.peek()) {
                    m_queue.poll();
                    t_queue.poll();
                } else if (!n_queue.isEmpty() && t_queue.peek() == n_queue.peek()) {
                    n_queue.poll();
                    t_queue.poll();
                } else {
                    System.out.println("not possible");
                    break;
                }
            }
            if (t_queue.isEmpty()) {
                System.out.println("possible");
            }

        }
    }
}

