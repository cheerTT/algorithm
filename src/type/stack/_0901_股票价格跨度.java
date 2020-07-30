package type.stack;

import java.util.Stack;

public class _0901_股票价格跨度 {

    // 100, 80, 60, 70, 60, 75, 85
    // 1, 1, 1, 2, 1, 4, 6
    Stack<Integer> stack;
    Stack<Integer> cache;

    public _0901_股票价格跨度() {
        stack = new Stack<>();
        cache = new Stack<>();
    }

    public int next(int price) {

        int ans = 1;

        while (!stack.isEmpty() && stack.peek() <= price) {
            stack.pop(); // 移除元素后，也记录相应的值；
            ans += cache.pop();
        }
        stack.push(price);
        cache.push(ans);
        return ans;
    }

    public static void main(String[] args) {

        _0901_股票价格跨度 solution = new _0901_股票价格跨度();
        System.out.println(solution.next(100));
        System.out.println(solution.next(80));
        System.out.println(solution.next(60));
        System.out.println(solution.next(70));
        System.out.println(solution.next(60));
        System.out.println(solution.next(75));
        System.out.println(solution.next(85));
    }
}
