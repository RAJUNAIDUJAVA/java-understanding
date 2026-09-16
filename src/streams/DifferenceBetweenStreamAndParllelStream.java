package streams;

import oops.interfaceConflict.InterfaceA;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DifferenceBetweenStreamAndParllelStream {


    public static long timeForStreams;
    public static long timeForParallelStreams;
    public static void main(String[] args) {
       List<Integer> numbers = IntStream.rangeClosed(1,1000000).boxed().collect(Collectors.toList());


        long startSeq = System.currentTimeMillis();
        List<String> res=numbers.stream().map(x-> Integer.toString(x)).collect(Collectors.toList());
        long endSeq= System.currentTimeMillis();

        System.out.println("total time taken"+(endSeq-startSeq));

        long startParseq = System.currentTimeMillis();
        List<String> res2=numbers.parallelStream().map(x-> Integer.toString(x)).collect(Collectors.toList());
        long endParSeq = System.currentTimeMillis();
        System.out.println(endParSeq-startParseq);

        List.of(1,2,3,4,5).stream().limit(10).forEach(n-> System.out.println(n));
        List.of(1,2,3,4,5).parallelStream().limit(10).forEach(n -> System.out.println(n));


    }




}
