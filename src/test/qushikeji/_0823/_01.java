package test.qushikeji._0823;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _01 {

    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//
//        List<int[]> list = new ArrayList<>();
//
//        for (int i = 0; i < n + 2; i++) {
//            int[] point = new int[2];
//            point[0] = sc.nextInt();
//            point[1] = sc.nextInt();
//            list.add(point);
//        }

        int[] start = {0, 0};
        int[] end = {99, 99};
        List<int[]> nums = new ArrayList<>();
        nums.add(new int[] {34, 32});
        nums.add(new int[] {35, 92});
        nums.add(new int[] {33, 22});
        nums.add(new int[] {14, 62});
        nums.add(new int[] {94, 22});

        int res = help(start, end, nums);

        System.out.println(res);
    }

    private static int help(int[] start, int[] end, List<int[]> points) {

        List<List<int[]>> res = new ArrayList<>();
        List<int[]> list = new ArrayList<>();
        boolean[] visited = new boolean[points.size()];
        perm(points, visited, list, res);

        int tmp = Integer.MAX_VALUE;
        for (List<int[]> re : res) {
            int val = (Math.abs(re.get(0)[0] - start[0]) + Math.abs(re.get(0)[1] - start[1]));
            for (int i = 1; i < re.size(); i++) {
                val += (Math.abs(re.get(i)[0] - re.get(i - 1)[0]) + Math.abs(re.get(i)[1] - re.get(i - 1)[1]));
            }
            val += (Math.abs(re.get(re.size() - 1)[0] - end[0]) + Math.abs(re.get(re.size() - 1)[1] - end[1]));
            tmp = Math.min(tmp, val);
        }

        return tmp;
    }

    private static void perm(List<int[]> points, boolean[] visited, List<int[]> list, List<List<int[]>> res) {

        if (list.size() == points.size()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < points.size(); i++) {

            if (visited[i]) continue;

            visited[i] = true;

            list.add(points.get(i));

            perm(points, visited, list, res);

            list.remove(list.size() - 1);

            visited[i] = false;
        }
    }
}
