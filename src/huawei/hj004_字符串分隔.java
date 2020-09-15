package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class hj004_字符串分隔 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        String b = sc.nextLine();

        List<String> res = new ArrayList<>();
        int num1 = a.length() / 8;
        int mod1 = a.length() % 8;

        int num2 = b.length() / 8;
        int mod2 = b.length() % 8;

        for (int i = 0; i < num1; i++) {
            res.add(a.substring(i*8, i*8+8));
        }

        if (mod1 != 0) {
            StringBuilder sb1 = new StringBuilder(a.substring(num1 * 8));
            for (int i = 0; i < 8 - mod1; i++) {
                sb1.append("0");
            }
            res.add(sb1.toString());
        }


        for (int i = 0; i < num2; i++) {
            res.add(b.substring(i*8, i*8+8));
        }
        if (mod2 != 0) {
            StringBuilder sb2 = new StringBuilder(b.substring(num2 * 8));
            for (int i = 0; i < 8 - mod2; i++) {
                sb2.append("0");
            }
            res.add(sb2.toString());
        }

        for (String re : res) {
            System.out.println(re);
        }

    }
}

/*
*
* urivthvtlqqerctlxmjvkgvfclaaduwmaadedpadanl
* batkqdhjnrwtsmzidswdnenqpsblsszldyttytrgenaizwehntqiaaufble
*
* */