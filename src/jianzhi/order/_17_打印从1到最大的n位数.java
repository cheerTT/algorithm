package jianzhi.order;

public class _17_打印从1到最大的n位数 {

    public int[] printNumbers(int n) {

        int max = 0;

        while (n > 0) {
            max += 9 * Math.pow(10, n - 1);
            n--;
        }

        int[] res = new int[max];

        for (int i = 0; i < max; i++) {
            res[i] = i + 1;
        }

        return res;
    }

}
