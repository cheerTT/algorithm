package huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class hj008_合并表记录 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();


        // 需要保证输出元素有序
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int key = sc.nextInt();
            int val = sc.nextInt();

            if (map.containsKey(key)) {
                map.put(key, map.get(key) + val);
            } else {
                map.put(key, val);
            }
        }

        for (Integer key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }
}
