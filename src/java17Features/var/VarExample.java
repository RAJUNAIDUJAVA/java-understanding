package java17Features.var;

import java.util.ArrayList;

public class VarExample {

    public static void main(String[] args) {
        var name = "Rajunaidu"; // based on "Rajunaidu" type it will infer the type by compiler , compiler will know name is String type
        var l1 = new ArrayList<>(); // compiler know l1 is ArrayList

    }

   /* public static void m1(var x, var y){
       // we cannot use var keyword to return type and method parameters
    }*/
}
