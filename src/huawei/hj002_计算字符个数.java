package huawei;

import java.util.Scanner;

public class hj002_计算字符个数 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String c = sc.nextLine();

        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (c.equalsIgnoreCase(str.charAt(i)+"")) {
                res++;
            }
        }

        System.out.println(res);
    }
}
