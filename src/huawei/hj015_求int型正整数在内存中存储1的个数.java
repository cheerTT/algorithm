package huawei;

import java.util.Scanner;

public class hj015_求int型正整数在内存中存储1的个数 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int res = 0;
        while (num != 0) {

            if (num % 2 == 1) res++;
            num = num / 2;
        }

        System.out.println(res);
    }
}
