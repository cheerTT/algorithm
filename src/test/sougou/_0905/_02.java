package test.sougou._0905;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _02 {

    public int getHouses (int t, int[] xa) {

        List<double[]> list = count(xa);
//        Collections.sort(list, (o1, o2) -> (int)(o1[0] - o2[0]));

        if (list.size() == 0) return 1;

        int res = 2;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1)[0] - list.get(i)[1] > t) {
                res += 2;
            } else if (list.get(i + 1)[0] - list.get(i)[1] == t) {
                res += 1;
            }
        }

        return res;
    }

    private List<double[]> count(int[] xa) {

        List<double[]> res = new ArrayList<>();

        for (int i = 0; i < xa.length; i+=2) {

            double tmp = xa[i + 1] / 2.0;

            res.add(new double[] {(double)(xa[i]) - tmp, (double)(xa[i]) + tmp});
        }

        return res;
    }

    public static void main(String[] args) {

        _02 solution = new _02();

        int[] nums = {};

//        List<double[]> counts = solution.count(nums);
//
//        for (double[] count : counts) {
//            System.out.println(count[0] + " " + count[1]);
//        }


        int res = solution.getHouses(2, nums);
        System.out.println(res);
    }
}
