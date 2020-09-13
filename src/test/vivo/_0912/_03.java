package test.vivo._0912;

import java.util.*;

public class _03 {

    public String compileSeq (String input) {
        // write code here

        if (input == null || input.length() == 0 || (input.length() == 1 && Integer.parseInt(input) != -1)) {
            return "0";
        }

        Map<Integer, String> map = new HashMap<>();

        String[] splits = input.split(",");
        for (int i = 0; i < splits.length; i++) {
            if (map.containsKey(Integer.parseInt(splits[i]))) {
                map.put(Integer.parseInt(splits[i]), map.get(Integer.parseInt(splits[i])) + String.valueOf(i));
            } else {
                map.put(Integer.parseInt(splits[i]), String.valueOf(i));
            }
        }

        StringBuilder sb = new StringBuilder();

        boolean flag = true;

        while (sb.length() < map.size()) {
            for (Integer key : map.keySet()) {
                if (flag && key == -1) {
                    flag = false;
                    sb.append(map.get(key));
                } else if (Integer.parseInt(sb.charAt(sb.length() - 1)+"") == key) {
                    sb.append(map.get(key));
                }
            }
        }

        String tmp = sb.toString();
        StringBuilder r = new StringBuilder();

        for (int i = 0; i < tmp.length(); i++) {
            r.append(tmp.charAt(i)).append(",");
        }
        
        return r.deleteCharAt(r.length() - 1).toString();
    }

    public static void main(String[] args) {

        _03 solution = new _03();

        String res = solution.compileSeq("");
        System.out.println(res);
    }
}
