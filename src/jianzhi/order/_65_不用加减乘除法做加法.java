package jianzhi.order;

public class _65_不用加减乘除法做加法 {

    // 异或相当于无进位加 1^0=1 1^1=0 0^1=1 0^0=0
    // 与相当于进位 1&0=0 0&1=0 1&1=1 0&0=0

    // 不用新变量交换两个数的值
    // a = a + b; b = a - b; a = a - b;
    // a = a ^ b; b = a ^ b; a = a ^ b;
    public int add(int a, int b) {
        while (b != 0) {
            int tmp = a ^ b;
            b = (a & b) << 1;
            a = tmp;
        }

        return a;
    }

    public static void main(String[] args) {

        _65_不用加减乘除法做加法 solution = new _65_不用加减乘除法做加法();
        int res = solution.add(2, 7);
        System.out.println(res);
    }
}
