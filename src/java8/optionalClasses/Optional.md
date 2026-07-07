can you explain about optional classes
-> what is optional class . optional is a class which can hold both null value and non null value
-> why we need optional class. when we are working the get calls that time either we can get value or not as part
    of response . but when we dont have the value for that response and when we are trying to call variable then
    we will end up with null pointer expection. so now the thing will be how we are handling the null values at
    runtime that we can achieve with Optional classes because it will hold both null values and non null value
-> give me the example where you implemented optional -> basically i have requirement which we need the xml and 
    need to convert the xml into document class to get the respective tags. while converting the XML into Document
    sometimes because of invalid XML we will end up with null value as a response
    while trying to get the value from the response we will ended up with null pointer response and we ended up with 
    th run time exception. so now my requiremnt will be if there is a invalid xml i dont want to stop the execution
    and same xml will be available in database and need to look the xml from database. that time we can use orElse 
    method we can stop null pointer exceptions
-> what is the difference between orElse and orElseGet methoods
    orElse method will return the constant value when we doesnt have the  value in container
    orElseGet method wil use supplier to get the value dynamically when container have null values
-> list out the optional class methods and their use case
    1)Optional.of() -> we can use when the response is null directly it will throw exception
    2)Optional.ofNullable -> we can use when we dont want to stop execution even though container is null
    3)Optional.get() -> to get the element from the Optional class
    4)Optional.orElse() -> if there is no element in the container then we can set the constant value
    5)Optional.orElseGet() -> if there is no element in the container we can use supplier to assign the value
    6)Optional.orElseThrow() -> id there is no element we can throw a custom exception
    7)Optional.isEmpty()-> will return true if the container is empty
    8)Optional.isPresent() -> will return false if the container doesnt have element
    9) Optional.ifPresent(consumer)-> will consume and perform action on the value.
    10)Optional.ifPresentOrElse() -> Action if present else fallback
    11)Optional.map() -> transform the value
    12)Optional.flatmap()->Transform to another Optional
    13)Optional.filter() -> keep value if matches
    14)Optional.stream() -> convert to stream

-> Best parctices for optional:
    use only for return type, dont use for method parameters, fields
    get() is discouraged ,prefer safe alternatives
    misusing orElse() with expensive defaults


-> some practice programs

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
