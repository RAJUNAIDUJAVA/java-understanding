package java17Features.switchupdate;

public class SwitchOldExample {

    public static void main(String[] args) {
        String name = "Naidu";

        System.out.println(getDayName(2));

        /*switch (name){
            case "Raju" : System.out.println("Raju");
            case "Naidu": System.out.println("Naidu");
            case "rrr": System.out.println("rrr");
            case "": System.out.println("empty string");
            default : System.out.println("name was not matched");

        }*/

        switch (name){
            case "Raju" : System.out.println("Raju");
            break;
            case "Naidu": System.out.println("Naidu");
            break;
            case "rrr": System.out.println("rrr");
            break;
            case "": System.out.println("empty string");
            break;
            default : System.out.println("name was not matched");

        }


    }

    public static String getDayName(int day){
          /* return */switch (day){
            case 1 : return "Monday";

            case 2: return "Tuesday";

            case 3: return "Wednesday";

            default: return "Other day";

        }
        // in java 8 switch cannot return value
    }
}
