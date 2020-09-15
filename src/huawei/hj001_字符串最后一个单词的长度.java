package huawei;

import java.util.Scanner;

public class hj001_字符串最后一个单词的长度 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String[] strs = str.split(" ");

        System.out.println(strs[strs.length - 1].length());
    }
}
