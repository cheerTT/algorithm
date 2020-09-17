package test.jindong_0917;

import java.util.Scanner;

public class _01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String[] strs = str.split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strs.length; i++) {

            if (isNum(strs[i]) != null) {
                sb.append(isNum(strs[i]) + " ");
            }
        }

        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }

    private static Integer isNum(String str) {

        int i = 0;

        while (i < str.length() - 4) {
            String tmp = str.substring(i, i + 4);
            try {
                int res = Integer.parseInt(tmp);
                if (res >= 1000 && res <= 3999) {
                    return res;
                }
            } catch (Exception e) {

            }
            i++;
        }

        return null;
    }
}

// And millionaires will hold 46% of total wealth by 2019, the report says. This ratio is likely to increase in 2020.
