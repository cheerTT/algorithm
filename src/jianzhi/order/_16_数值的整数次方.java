package jianzhi.order;

public class _16_数值的整数次方 {

    // 分治
    public double myPow(double x, int n) {

        long N = n;

        double res = help(x, Math.abs(N));

        return N >= 0 ? res : 1 / res;
    }

    private double help(double x, long n) {

        if (n == 0) return 1;
        if (n == 1) return x;

        double sub = help(x, n / 2);

        return n % 2 == 1 ? sub * sub * x : sub * sub;
    }
}
