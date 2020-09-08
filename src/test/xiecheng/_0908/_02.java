package test.xiecheng._0908;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();


        String[] strs = str.trim().split(" ");

        StringBuilder sb = new StringBuilder();

        List<String> res = new ArrayList<>();

        backtrace(strs, 0, sb, res);

        for (String re : res) {
            System.out.println(re);
        }
    }


    private static boolean flag = false;

    private static void backtrace(String[] strs, int start, StringBuilder sb, List<String> res) {

        if (sb.length() == strs.length) {

            if (flag) res.add(sb.toString() + "--circular dependency");
            else  res.add(sb.toString());

            flag = false;
            return;
        }

        for (int i = start; i < strs.length; i++) {

            for (char c : strs[i].toCharArray()) {

                if (sb.toString().contains(c + "") && sb.length() == i) {
                    System.out.println("111:" + sb.toString() + " " + c);
                    flag = true;
                }

                sb.append(c);

                backtrace(strs, i + 1, sb, res);

                sb.deleteCharAt(sb.length() - 1);


            }
        }
    }
}
