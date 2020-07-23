package jianzhi.order;

public class _15_二进制中1的个数 {

    public int hammingWeight(int n) {

        String s = Integer.toBinaryString(n);

        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                res += 1;
        }

        return res;
    }
}
