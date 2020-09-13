package test.vivo._0912;

import java.util.Scanner;

public class _02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        if (str == null || str.length() == 0) {
            System.out.println("false");
            return;
        }

        boolean res = isPar(str, -1);
        if (res) {
            System.out.println(str);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            res = isPar(str, i);
            if (res) {
                System.out.println(str.substring(0, i) + str.substring(i + 1));
                break;
            }
        }

        if (!res) System.out.println("false");
    }

    private static boolean isPar(String str, int idx) {

        int i = 0;
        int j = str.length() - 1;

        while (i < j) {
            if (i == idx) {
                i++;
                continue;
            }
            if (j == idx) {
                j--;
                continue;
            }
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
