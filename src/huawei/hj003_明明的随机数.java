package huawei;

import java.util.*;

public class hj003_明明的随机数 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            Set<Integer> set = new TreeSet<>();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                set.add(sc.nextInt());
            }
            for (Integer i : set) {
                System.out.println(i);
            }

        }
    }
}
