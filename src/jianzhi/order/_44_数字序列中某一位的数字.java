package jianzhi.order;

public class _44_数字序列中某一位的数字 {

    // 1、求 n 所在数字的数位：digit(数位), start(该数位下开始的值)
    // 2、确定 n 所在的数字：(n-1)/digit
    // 3、确定 n 在 num 的哪一位：(n-1)%digit
    public int findNthDigit(int n) {

        int digit = 1;
        int start = 1;
        int count = 9 * start * digit;

        // 1、确定数位
        while (n > count) {
            n -= count;
            start *= 10;
            digit += 1;
            count = 9 * start * digit;
        }
        // 2、确定数字
        long num = start + (n - 1) / digit;

        // 3、确定位数

        return String.valueOf(num).charAt((n - 1) % digit) - '0';
    }

    public static void main(String[] args) {

        _44_数字序列中某一位的数字 solution = new _44_数字序列中某一位的数字();
        int nthDigit = solution.findNthDigit(11);
        System.out.println(nthDigit);




    }
}
