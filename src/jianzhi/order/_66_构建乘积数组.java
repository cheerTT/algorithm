package jianzhi.order;

public class _66_构建乘积数组 {

    // 不能使用除法
    public int[] constructArr(int[] a) {

        int[] b = new int[a.length];
        b[0] = 1;

        for (int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }

        int tmp = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }

        return b;
    }
}
