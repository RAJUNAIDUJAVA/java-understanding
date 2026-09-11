package programs;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class p18_sortAMapWithDescending {

    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 90);
        scores.put("Bob", 55);
        scores.put("Charlie", 80);

        Map<String, Integer> res=scores.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).collect(Collectors.toMap(x-> x.getKey(), x->x.getValue(), (e1,e2)-> e2,LinkedHashMap::new));

        System.out.println(res);
    }
}
