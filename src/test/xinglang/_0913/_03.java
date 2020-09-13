package test.xinglang._0913;

import java.util.Arrays;
import java.util.Scanner;

public class _03 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        char[] chars = str.toCharArray();


        Arrays.sort(chars);

        boolean flag = true;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == chars[i]) flag = false;
        }

        System.out.println(flag);


    }
}
