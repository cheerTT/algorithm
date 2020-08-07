package type.binarysearch;

public class _1201_丑数3 {

    public int nthUglyNumber(int n, int a, int b, int c) {

        // 两个数的最小公倍数
        int lcmAB = lcm(a, b);
        int lcmAC = lcm(a, c);
        int lcmBC = lcm(b, c);
        // 三个数的最小公倍数
        int lcmABC = lcm(lcmAB, c);

        // 一个周期内符合要求的数
        int t_num = lcmABC / a + lcmABC / b + lcmABC / c - lcmABC / lcmAB - lcmABC / lcmAC - lcmABC / lcmBC + 1;

        // nums
        int nums = n / t_num;
        int comp = n % t_num;
        int res = nums * lcmABC;

        if (comp > 1) {
            int left = 1;
            int right = lcmABC;
            while (left < right) {
                int mid = (left + right) / 2;
                int cur_num = mid / a + mid  / b + mid / c - mid /lcmAB - mid / lcmAC - mid / lcmBC + mid / lcmABC;
                if (cur_num >= comp) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            res += left;
        }

        return res;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a: gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {

        _1201_丑数3 solution = new _1201_丑数3();

        int res = solution.nthUglyNumber(4, 2, 3, 4);
        System.out.println(res);

    }
}
