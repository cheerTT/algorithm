package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class _01 {

    public static void main(String[] args){

        _01 solution = new _01();
        List<Integer> list1 = new ArrayList<>();
        list1.add(38);
        list1.add(1);
        list1.add(11);
        list1.add(21);
    }

    private List<List<Integer>> generate(List<Integer> list1, List<Integer> list2, List<Integer> weight) {

        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();

        for (int i = 0; i < weight.size(); i++) {

            int cnt = Math.max(list1.get(i), list2.get(i));

            if (list1.get(i) == list2.get(i)) {
                for (int j = 0; j < weight.get(i); j++) {
                    res1.add(list1.get(i) + j);
                    res2.add(list2.get(i) + j);
                }
            } else if (cnt == list1.get(i)) {
                for (int j = 0; j < weight.get(i); j++) {
                    res1.add(list1.get(i) + j);
                }
                for (int j = 0; j < weight.get(i); j++) {
                    res2.add(list2.get(i) - j);
                }
            } else if (cnt == list2.get(i)) {
                for (int j = 0; j < weight.get(i); j++) {
                    res2.add(list2.get(i) - j);
                }
                for (int j = 0; j < weight.get(i); j++) {
                    res1.add(list1.get(i) + j);
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(res1);
        res.add(res2);

        return res;
    }
}
