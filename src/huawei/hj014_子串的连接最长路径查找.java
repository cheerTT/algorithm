package huawei;

import java.util.*;

public class hj014_子串的连接最长路径查找 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int n  = Integer.parseInt(str);

        String[] list = new String[n];

        for (int i = 0; i < n; i++) {
            list[i] = sc.nextLine();
        }

        Arrays.sort(list);

        for (String s : list) {
            System.out.println(s);
        }
    }
}
