package xiaomi.window;

import java.util.Deque;
import java.util.LinkedList;

public class _59_02_最大减最小小于指定值的个数 {

    public int getNum(int[] arr, int num) {

        // 维护 arr[i...j] 的最大值最小值更新结构
        Deque<Integer> qmax = new LinkedList<>(); // 降序，头最大
        Deque<Integer> qmin = new LinkedList<>(); // 升序，头最小

        int i = 0;
        int j = 0;
        int res = 0;

        while (i < arr.length) {
            while (j < arr.length) {

                // 当前值小于等于队尾，更新值
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
                    qmin.pollLast();
                }
                qmin.addLast(j);

                // 当前值大于等于队尾，更新值
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
                    qmax.pollLast();
                }
                qmax.addLast(j);

                // 不达标的情况
                if (arr[qmax.peekLast()] - arr[qmin.peekLast()] > num) break;

                j++;
            }

            // 判断最大值最小值过期了没
            if (qmin.peekFirst() == i) {
                qmin.peekFirst();
            }

            if (qmax.peekFirst() == i) {
                qmax.peekFirst();
            }

            res += j - i;
            i++;
        }

        return res;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        _59_02_最大减最小小于指定值的个数 solution = new _59_02_最大减最小小于指定值的个数();
        int res = solution.getNum(arr, 2);
        System.out.println(res);
    }
}
