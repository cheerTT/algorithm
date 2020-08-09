package yuanfudao.array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class _0386_字典序排数 {

    // 暴力
    public List<Integer> lexicalOrder1(int n) {

        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));

        for (int i = 1; i <= n; i++) {
            queue.offer(String.valueOf(i));
        }

        List<Integer> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            res.add(Integer.parseInt(queue.poll()));
        }

        return res;
    }

    // dfs
    public List<Integer> lexicalOrder2(int n) {
        List<Integer> res = new ArrayList<>();
        dfs(0, n, res);
        return res;
    }

    private void dfs(int k, int n, List<Integer> res) {

        if (k > n) return;

        if (k != 0) res.add(k);

        for (int i = 0; i <= 9; i++) {
            if (10 * k + i > 0) {
                dfs(10 * k + i, n, res);
            }
        }

    }
}
