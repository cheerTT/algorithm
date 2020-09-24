package test.fanruan._0924;

import java.util.*;

public class _01 {

    static class Pair {
        private int key;
        private int val;
        private Pair next;

        public Pair(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] ints = sc.nextLine().split(" ");
        int n = Integer.parseInt(ints[0]);

        long[] pairLen = new long[n];
        for (int i = 0; i < n; i++) {
            pairLen[i] = Long.valueOf(ints[i + 1]);
        }

        Pair[] lists = new Pair[n];
        for (int i = 0; i < n; i++) {
            Pair dummyHead = new Pair(-1, -1);
            Pair cur = dummyHead;

            String[] strings = sc.nextLine().split(" ");
            for (int j = 0; j < pairLen[i]; j++) {

                String[] str = strings[j].split(":");
                Pair node = new Pair(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
                cur.next = node;
                cur = node;
            }
            System.out.println("hello");
            lists[i] = dummyHead.next;
        }

        System.out.println("111");
        // 排序
        for (int i = 0; i < n; i++) {
            lists[i] = sortLists1(lists[i]);
        }

        // 合并
        Pair res = mergeKLists(lists);
        System.out.println("res");

        // 输出
        printLists(res);
    }

    private static Pair merge(Pair l1, Pair l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        Pair cur = null;
        if (l1.key == l2.key) {
            l1.next = merge(l1.next, l2.next);
            l1.val +=l2.val;
            cur = l1;
        }
        if (l1.key < l2.key) {
            l1.next = merge(l1.next, l2);
            cur = l1;
        }
        if (l1.key > l2.key) {
            l2.next = merge(l1, l2.next);
            cur = l2;
        }
        return cur;
    }

    public static Pair mergeKLists(Pair[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        if (lists.length == 2) return merge(lists[0], lists[1]);

        return merge(mergeKLists(Arrays.copyOfRange(lists, 0, lists.length / 2)),
                mergeKLists(Arrays.copyOfRange(lists, lists.length / 2, lists.length)));
    }

    public static void printLists(Pair res) {

        StringBuilder sb = new StringBuilder();
        while (res != null) {
            sb.append(res.key).append(":").append(res.val).append(" ");
            res = res.next;
        }

        if (sb.length() == 0) System.out.println();
        else System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
    }

    public static Pair sortLists1(Pair list) {

        Map<Integer, Integer> map = new HashMap<>();
        while (list != null) {
            if (map.containsKey(list.key)) {
                map.put(list.key, map.get(list.key) + list.val);
            } else {
                map.put(list.key, list.val);
            }
            list = list.next;
        }

        List<Map.Entry<Integer, Integer>> newList = new ArrayList<>(map.entrySet());

        Collections.sort(newList, (o1, o2) -> {return o1.getKey() - o2.getKey();});

        Pair dummyHead = new Pair(-1, -1);
        Pair cur = dummyHead;

        for (int i = 0; i < newList.size(); i++) {
            Pair node = new Pair(newList.get(i).getKey(), newList.get(i).getValue());
            cur.next = node;
            cur = node;
        }

        return dummyHead.next;
    }

    public static Pair sortLists(Pair list) {

        if (list == null || list.next == null) return list;
        Pair slow = list, fast = list, pre = list;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return merge(sortLists(list), sortLists(slow));
    }


}

/**
 *
3 3 4 3
1:5 3:8 5:1
1:2 2:2 4:3 5:2
2:3 4:4 6:3

 **/