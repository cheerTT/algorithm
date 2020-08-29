package hot;

public class _nc_032_求平方根 {

    public int sqrt (int x) {
        // write code here

        int left = 0;
        int right = x / 2 + 1;

        while (left <= right) {

            long mid = (left + right) / 2;

            if (mid * mid == x) return (int)mid;
            else if (mid * mid < x) left = (int) (mid + 1);
            else if (mid * mid > x) right = (int) (mid - 1);
        }

        return right;
    }

    public static void main(String[] args) {

        _nc_032_求平方根 solution = new _nc_032_求平方根();
        int res = solution.sqrt(0);
        System.out.println(res);
    }
}
