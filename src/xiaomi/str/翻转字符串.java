package xiaomi.str;

import java.util.Arrays;

public class 翻转字符串 {

    public static String reverse(String s) {

        char[] chars = s.toCharArray();

        int i = 0;
        int j = chars.length - 1;

        while (i < j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {

        String s = "i am a student";

        String[] s1 = s.split(" ");

        StringBuilder sb = new StringBuilder();
        for (String s2 : s1) {
            sb.append(reverse(s2).toUpperCase()).append(" ");
        }

        System.out.println(sb.toString());
    }
}
