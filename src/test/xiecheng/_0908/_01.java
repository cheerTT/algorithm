package test.xiecheng._0908;

import java.util.Arrays;
import java.util.Scanner;

import static com.sun.jmx.snmp.ThreadContext.contains;

public class _01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String regex = sc.nextLine();
        String str = sc.nextLine();
        String replace = sc.nextLine();

        String[] strs = str.split(" ");

        StringBuilder sb = new StringBuilder();

        for (String s : strs) {

            if (s.split(",").length <= 1 && isEqual(regex, s)) {
                sb.append(replace).append(" ");
            } else if (s.split(",").length > 1) {
                String[] splits = s.split(",");
                for (String split : splits) {
                    if (isEqual(regex, split)) {
                        sb.append(replace).append(",");
                    } else {
                        sb.append(split).append(",");
                    }
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.append(" ");
            } else {
                sb.append(s).append(" ");
            }
        }

        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());

    }

    private static boolean isEqual(String regex, String str) {

        if (regex.length() != str.length()) return false;

        char[] regex_chars = regex.toCharArray();
        char[] str_chars = str.toCharArray();

        Arrays.sort(regex_chars);
        Arrays.sort(str_chars);

        return String.valueOf(str_chars).contains(String.valueOf(regex_chars));

//        for (int i = 0; i < regex.length(); i++) {
//            if (regex_chars[i] != str_chars[i]) return false;
//        }
//
//        return true;
    }
}
