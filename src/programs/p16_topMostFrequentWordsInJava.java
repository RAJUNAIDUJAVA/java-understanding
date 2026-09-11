package programs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class p16_topMostFrequentWordsInJava {
    public static void main(String[] args) {
        String text = "java stream java lambda stream java amma amma";
       List<String> name= Arrays.asList(text.split(" ")).stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.<String,Long>comparingByValue().reversed()).filter(x-> x.getValue()!=1).map(x->x.getKey()).collect(Collectors.toList());

        System.out.println(name);

    }
}
