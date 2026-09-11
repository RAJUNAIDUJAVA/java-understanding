package programs;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class p17_FilterAMapUsingStreams {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 90);
        scores.put("Bob", 55);
        scores.put("Charlie", 80);

     Map<String,Integer> res=   scores.entrySet().stream().filter(x->x.getValue()>60).collect(Collectors.toMap(x-> x.getKey(), y->y.getValue()));
        System.out.println(res);
    }
}
