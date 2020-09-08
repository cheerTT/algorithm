package test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class _02 {

    public static void main(String[] args) {

//        TreeMap<Integer, Integer> tree = new TreeMap<>();
//        tree.put(6, 6);
//        tree.put(5, 5);
//        tree.put(4, 4);
//        tree.put(3, 3);
//        tree.put(2, 2);
//        tree.put(1, 1);
//
//        for (Integer integer : tree.keySet()) {
//            System.out.println(integer + " " + tree.get(integer));
//        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(3, 3);
        map.put(2, 2);
        map.put(1, 1);

        for (Integer integer : map.keySet()) {
            System.out.println(integer + " " + map.get(integer));
        }
    }
}
