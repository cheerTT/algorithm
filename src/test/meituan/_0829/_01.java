package test.meituan._0829;

import java.util.Scanner;

public class _01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String n = sc.nextLine();

        String str = sc.nextLine();

        str.indexOf('T');

        str.lastIndexOf("M");

        int start = 0;
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'T' && flag) {
                start = i;
                break;
            }
            if (str.charAt(i) == 'M') {
                flag = true;
            }

        }

        int end = 0;
        flag = false;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == 'M' && flag) {
                end = i;
                break;
            }
            if (str.charAt(i) == 'T') {
                flag = true;
            }

        }

        System.out.println(str.substring(start + 1, end));

    }
}
