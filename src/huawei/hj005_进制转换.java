package huawei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * ascii
 *
 * a 97
 * A 65
 * 0 48
 */
public class hj005_进制转换 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Set<Character> set = new HashSet<>(Arrays.asList('a','b','c','d','e','f'));
        while(sc.hasNext()) {
            String str = sc.nextLine();
            str = str.toLowerCase();

            int res = 0;
            for (int i = str.length() - 1; i >= 2; i--) {

                if (set.contains(str.charAt(i))) {
                    res += Math.pow(16, (str.length() - 1 - i)) * (str.charAt(i) - 97 + 10);
                } else {
                    res += Math.pow(16, (str.length() - 1 - i)) * (str.charAt(i) - 48);
                }
            }

            System.out.println(res);
        }
    }
}
