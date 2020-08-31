package test.tongcheng._0831;

import java.util.HashMap;
import java.util.Map;

public class _01 {

    public static void main(String[] args) {

        Map<String, Object> map = new HashMap<>();

        map.put("A", null);
        map.put("A", "111");

        System.out.println(map.get("A"));

        Integer aa = 11;

        System.out.println("21e1" + aa);

    }
}
