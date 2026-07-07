package java8.optionalClasses;

import java.util.Optional;

public class OptionalExamples {
    public static void main(String[] args) {
        Optional<String> res = Optional.empty();
        //System.out.println(Optional.of(res));
        //System.out.println(Optional.ofNullable(res));

        String output=res.map(x-> x+"output").orElse("default output");
        System.out.println(output);

        String outputw = res.map(x-> x+"out").orElseGet(()-> getName());
        System.out.println(outputw);
        if(res.isPresent()){
            System.out.println("value is available");
        }
        else{
            System.out.println("value is not available");
        }
        res.ifPresent(x-> System.out.println(x));
        res.ifPresentOrElse(x-> System.out.println(x), ()-> System.out.println("no value found"));

        Optional<String> named = Optional.ofNullable("Raju");
        named.filter(x-> x.length()>5).ifPresent(x-> System.out.println(x));

    }
    public static String getName(){
       return "amma";
    }
}

