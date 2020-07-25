package jianzhi.order;

public class _43_1n整数中1出现的次数 {


    // 对于一个数：nx, nx-1, ... , n2, n1;
    // ni 表示当前位 cur
    // ni-1, ni-2, ... , n2, n1 表示低位 low
    // nx, nx-1, ..., ni+1 表示高位 high
    // 10^i 累加，表示数位（比如，1,11,111,1111,...） digit
    public int countDigitOne(int n) {

        int res = 0;

        int cur = n % 10;
        int high = n / 10;
        int low = 0;
        int digit = 1;

        while (cur != 0 || high != 0) {
            if (cur == 0) {
                res += high * digit;
            } else if (cur == 1) {
                res += high * digit + low + 1;
            } else {
                res += (high + 1) * digit;
            }

            low += cur * digit;
            cur = high % 10;
            high = high / 10;
            digit *= 10;
        }

        return res;
    }
}
