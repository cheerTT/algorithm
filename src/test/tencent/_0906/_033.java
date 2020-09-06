package test.tencent._0906;

import java.util.*;

public class _033 {

    public static void count(List<String> strs, int k) {

        HashMap<String, Integer> map = new HashMap<>();
        for (String str : strs) {
                if (!map.containsKey(str)) {
                    map.put(str, 1);
                } else {
                    map.put(str, map.get(str) + 1);
                }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> {
            if (o1.getValue() - o2.getValue() == 0) {
                return o2.getKey().compareTo(o1.getKey());
            } else {
                return o1.getValue() - o2.getValue();
            }

        });

        for (int i = list.size() - 1; i > list.size() - 1 - k; i--) {
            System.out.println(list.get(i).getKey() + " " + list.get(i).getValue());
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1.getValue() - o2.getValue() == 0) {
                return o1.getKey().compareTo(o2.getKey());
            } else {
                return o1.getValue() - o2.getValue();
            }

        });

        for (int i = 0; i < k; i++) {
            System.out.println(list.get(i).getKey() + " " + list.get(i).getValue());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] first = sc.nextLine().trim().split(" ");
        int n = Integer.parseInt(first[0]);

        int k = Integer.parseInt(first[1]);

        List<String> strs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            strs.add(sc.nextLine());
        }

        count(strs, k);

    }
}


