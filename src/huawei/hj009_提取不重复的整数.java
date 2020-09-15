package huawei;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class hj009_提取不重复的整数 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        Set<Integer> set = new LinkedHashSet<>();

        for (int i = str.length() - 1; i >= 0; i--) {
            set.add(Integer.parseInt(str.charAt(i)+""));
        }

        StringBuilder sb = new StringBuilder();
        for (Integer i : set) {
            sb.append(i);
        }

        System.out.println(sb.toString());
    }
}
