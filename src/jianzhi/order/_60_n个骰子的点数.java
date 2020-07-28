package jianzhi.order;

public class _60_n个骰子的点数 {

    // d 表示将数字转换成 double
    public double[] twoSum(int n) {
        double[] pre = {1/6d, 1/6d, 1/6d, 1/6d, 1/6d, 1/6d};

        for (int i = 2; i <= n; i++) {
            // i 个骰子点数只能取1个1
            double[] mid = new double[6 * i - i + 1];
            for (int m = 0; m < pre.length; m++) {
                for (int k = 0; k < 6; k++) {
                    mid[m + k] += pre[m] * 1/6d;
                }
            }
            pre = mid;
        }

        return pre;
    }

    public static void main(String[] args) {

        _60_n个骰子的点数 solution = new _60_n个骰子的点数();
        double[] res = solution.twoSum(2);
        for (double re : res) {
            System.out.print(re + " ");
        }
    }
}
