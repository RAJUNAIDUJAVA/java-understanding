package programs;

import java.finallearning.A;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class p6_convertMapintoTwoLists {

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Alice", 90);
        map1.put("Bob", 85);
        List<String> keys=map1.entrySet().stream().map(k -> k.getKey()).collect(Collectors.toList());
        List<Integer> values =map1.entrySet().stream().map(v -> v.getValue()).collect(Collectors.toList());
        System.out.println(keys);
        System.out.println(values);
    }
}
