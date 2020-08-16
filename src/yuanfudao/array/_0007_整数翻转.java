package yuanfudao.array;

public class _0007_整数翻转 {

    // 翻转之后越界的问题
    public int reverse(int x) {

        String str = String.valueOf(Math.abs(x));
        char[] strs = str.toCharArray();

        int i = 0;
        int j = str.length() - 1;

        while (i < j) {
            swap(strs, i++, j--);
        }

        int res;

        try {
            res = Integer.valueOf(String.valueOf(strs));
        } catch (Exception e) {
            res = 0;
        }

        return x > 0 ? res : -res;
    }

    private void swap(char[] strs, int a, int b) {
        char tmp = strs[a];
        strs[a] = strs[b];
        strs[b] = tmp;
    }

    // 从数字角度出发
    public int reverse1(int x) {

        long res = 0;
        int digt = 1;

        while (x != 0) {
            res = res * 10 + x % 10;;
            x = x / 10;
        }

        return (int) res == res ? (int) res : 0;
    }

    public static void main(String[] args) {

        System.out.println(Integer.valueOf("-01231"));
    }

}
