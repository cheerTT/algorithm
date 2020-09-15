package huawei;

import java.util.Scanner;

public class hj010_字符个数统计 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int[] count = new int[128];

        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }

        int res = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) res++;
        }

        System.out.println(res);
    }
}
