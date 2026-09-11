package programs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p13_ReverseEachWordInSentence {

    public static void main(String[] args) {
        String sentence = "Java is awesome";
        String res=Arrays.asList(sentence.split(" ")).stream().map(x-> new StringBuilder(x).reverse().toString()).collect(Collectors.joining(" "));
        System.out.println(res);
    }
}
