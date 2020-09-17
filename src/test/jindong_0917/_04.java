package test.jindong_0917;

import java.util.Scanner;

public class _04 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        StringBuilder sb = isNum(str);

        if (sb == null || sb.length() < 4) System.out.println();
        else System.out.println(sb.deleteCharAt(sb.length() - 1));
    }

    private static StringBuilder isNum(String str) {

        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                cnt++;
            } else {
                if (cnt == 4) {
                    int tmp = Integer.parseInt(str.substring(i - cnt, i));
                    if (tmp >= 1000 && tmp <= 3999) {
                        sb.append(tmp).append(" ");
                    }
                }
                cnt = 0;
            }
        }

        if (cnt == 4) {
            int tmp = Integer.parseInt(str.substring(str.length() - cnt));
            if (tmp >= 1000 && tmp <= 3999) {
                sb.append(tmp).append(" ");
            }
        }
        return sb;
    }
}
