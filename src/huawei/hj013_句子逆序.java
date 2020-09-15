package huawei;

import java.util.Scanner;

public class hj013_句子逆序 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String[] strs = str.split(" ");

        int i = 0;
        int j = strs.length - 1;

        while (i < j) {
            String tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
            i++;
            j--;
        }

        for (String s : strs) {
            System.out.print(s + " ");
        }
    }
}
