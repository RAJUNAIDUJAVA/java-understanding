package java17Features.switchupdate;

public class SwitchNewExample {
    public static void main(String[] args) {
        String name = "Naidu";

        System.out.println(getDayName(3));
        switch (name){
            case "Raju" -> System.out.println("Raju");

            case "Naidu" ->System.out.println("Naidu");

            case "rrr" ->System.out.println("rrr");

            case ""-> System.out.println("empty string");

            default -> System.out.println("name was not matched");

        }
    }

    public static String getDayName(int day){
        return switch (day){
            case 1 ->  "Monday";

            case 2->"Tuesday";

            case 3-> "Wednesday";

            default->"Other day";

        };
        // in java 17 switch cannot return value
    }
}
