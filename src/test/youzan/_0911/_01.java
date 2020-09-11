package test.youzan._0911;

public class _01 {

    public long sum (int num, int itemNum) {
        // write code here

        if (itemNum <= 0) return 0;

        StringBuilder sb = new StringBuilder();
        sb.append(num);
        String tmp = sb.toString().substring(0, 1);

        for (int i = 1; i < itemNum; i++) {
            sb.append(num);

            tmp = addBigInteger(tmp, sb.toString());
        }
        return Integer.parseInt(tmp);
    }

    private String addBigInteger(String str1, String str2) {

        StringBuilder sb = new StringBuilder();

        int i = str1.length() - 1;
        int j = str2.length() - 1;

        long comp = 0;
        while (i >= 0 || j >= 0) {

            long a = i < 0 ? 0 : Integer.parseInt(str1.charAt(i) + "");
            long b = j < 0 ? 0 : Integer.parseInt(str2.charAt(j) + "");
            long tmp = a + b + comp;
            comp = tmp / 10;
            sb.append(tmp % 10);
            i--;
            j--;
        }

        if (comp != 0) sb.append("1");

        return sb.reverse().toString();
    }

    private StringBuilder add(String str, long comp) {

        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            long tmp = Integer.parseInt(str.charAt(i)+"") + comp;
            comp = tmp / 10;
            sb.append(tmp % 10);
        }

        if (comp != 0) sb.append(1);
        return sb;
    }

    public static void main(String[] args) {

        _01 solution = new _01();

//        String s = solution.addBigInteger("22", "222");
//        System.out.println(s);

        long sum = solution.sum(9, 3);
        System.out.println(sum);

//        String add = solution.add("999", 1);
//        System.out.println(add);
    }

}
