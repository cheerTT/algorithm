package huawei;

import java.util.Scanner;

public class hj007_取近似值 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String num = sc.nextLine();

        String[] strs = num.split("\\.");

        int a = Integer.parseInt(strs[0]);
        int b = Integer.parseInt(strs[1].charAt(0)+"");
        if (b >= 5) System.out.println(a + 1);
        else System.out.println(a);
    }
}
