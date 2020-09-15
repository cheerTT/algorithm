package huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class hj006_质数因子 {

    // 判断一个数是否是质数
    private static void isPrime(long n) {

        while (n != 1) {
            for (int i = 2; i <= n; i++) {
                if (n % i == 0) {
                    n = n / i;
                    System.out.print(i + " ");
                    break;
                }
            }
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long num = sc.nextLong();

        isPrime(num);

    }

}
