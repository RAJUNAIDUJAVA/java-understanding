package programs;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class p7_MostFrequentElementInList {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "a", "c", "a", "b");

        Optional<String> mostFreq=list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);

        System.out.println(mostFreq.get());
    }
}
