-> what is Exception
    exception is  a event when there is a abnormality in the flow of execution, then it will create a event 
    and will stop the further execution. this type of event is called exception
-> what are the types of exceptions we have
    we have two types of exception first one is Runtime Exception and second one is CompileTimeexception
-> Runtime exceptions are will occur in Runtime , for example ArthematicException , NullPointerException
-> CompileTime Exceptions are will occur in compile time itself . for example if we are working on some IO operaitons
    then at compile time itself you need to handle for IO Exception. same way for SQL Exceptions also
-> how you can create a Custom Exception
    we can create the custom exception by extending a class with RuntimeException or Exception class
    if we want to pass the excpetion message to the super class then we can use super keyword from constructor itself
-> how you will handle the exception in runtime
    for handling the excpetions either we can throw the excpetion to caller method by using throws keyword
    or with help if try and catch block we can handle the exceptions
-> we can put the code which we suspect can throw the exception in try block if there is any exception in try block
    then catch block will get executed .
-> if there is some block of code must need to execute irrespective of whether exception came or not then we can
    use finally block
-> what is mean by AutoClosable?
    AutoClosable is a interface which will help us to close the resource once the operation was completed for that object
    for exaple if i implemented the AutoClosable for one of the Object. and if some action was performed on that object
    then it will execute the code which was return in the overriden method-> 
-> when Finally will not execute?
    when JVM crashes or ended up with some OutofMemoryError or some other Error then Finally will not exxecute
    apart from this when System.exit was called before the finally blcok i.e in try block then finally will 
    not get executed
-> what is the difference between throw and throws keyword
    throw which we used throw the exception manually
    throws is a keyword which used to propagate the exception to called method. so caller method can handle the
    exception

-> is multi catch possible?
yes we can use multiple catches. but one thing needs to sure the Excpetion class must need to use in last catch
otherwise we will ended up with propagation issues.

-> what happen main method will throw exception
    JVM print the track trace and terminate the execution


-> best practices:
Always log meaningful messages
create custom exceptions instead of generic exception

-> create a custom excpetion and throw
public class InvalidXmlExcpeption extends RuntimeException{

    public InvalidXmlExcpeption(String message){
        super(message);
    }

    public InvalidXmlExcpeption (String message, Throwable cause){
        super(message, cause);
    }
}

public static void main(String[] args) {
Optional<String> name = Optional.ofNullable(null);
String names=name.orElseThrow(() ->new InvalidXmlExcpeption("no element present"));
}

-> implement AutoClosable to close the connections

public class DataSource implements AutoCloseable{
@Override
public void close() throws Exception {
System.out.println("close the connection");
}
}

public class AutoClosableExample {

    public static void main(String[] args) {
        try(DataSource ds = new DataSource()){
            String s= "rajunaidu";
            System.out.println(s);
        }
        catch (Exception e){
            System.out.println("Exception called");
        }
    }
}




