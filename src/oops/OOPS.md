-> Private methods in interface?
    is private methods is allowed in interface?
    first if we make private methods then we cannot access in implemented classes .so for normal methods private is not possible
    then for default methods we can not make private because we need to use default keyword
    then for static methods there is no use if we make method is private
    so finally private methods are not possible in interface upto java8.
    but from java 9 onwards we can keep private methods also in interface
    the reason for this is any static and default methods will have some common logic and no need to have access for implemented classes
    then we can make that methods are private
public interface PrivateMethodsInInterface {

    public default void defMethod(){
        m11();
    }
    public static void statMethod(){
        m12();
    }
    private void m11(){
        
    }
    private static void m12(){
        
    }
}


-> what are the types of methods we can have in interface
    we can have public abstract methods by child classes
    we can have default methods for backward compatability
    we can have static methods for utility 
    we can have private methods for using in both static and non static methods but will have visability for implemented classes
public interface MethodsInInterface {

    public abstract void m1();
    public default void m2(){
        m4();
    }
    public static void m3(){
        m5();
    }
    private void m4(){
    }
    private static void m5(){
    }
}


Default method conflict resolution
    one class implementing by two interfaces and both the interfaces will have  samme default methods signature then we will end up with this isse
    to resolve this issue we must need to override with child class implementation
    another way is we can call specific interface method with interface name using super keyword
public interface InterfaceA {
public void m1();
public default void m2(){
System.out.println("m2 from A");
}
}
public interface InterfaceB {

    public void m1();
    public default void m2(){
        System.out.println("from m2 B");
    }
}
public class A implements InterfaceB, InterfaceA{
@Override
public void m1() {
System.out.println("called");
}
@Override
public void m2() {
System.out.println("this is from child class implementation");

        InterfaceA.super.m2();
        InterfaceB.super.m2();
    }
}


SOLID Principles:
what exactly SOLID Principles:
S-> Single Responsibility principle  (SRP)
means Single Responsibility for example we have invoice summary service. this service will take care of 
invoice calculation ,invoice repository to get the details from DB, and invoice printing
so instead of keeping everything in one service , each task will have a seperate class
for example InvoiceCalculation service will take care of invoice calculation
invoiceRepositoryService will take care of getting the details from DB
invoicePrintingService will take care of Printing the invoice
so as summary a class can have only single responsibility

O -> Open/Closed Principle (we should be able to add new code without modifying the existing code) (OCP)
this principle will tell us a class must be open for addition and closed for modification
for example if we create a paymentService we can have different payment methods and based on payment method the 
logic will be different
so by using interface/abstract class we can create paymentProcessor and based on paymentProcessor implementation
we can implement different types of payment methods. so if any new payment needs to be added we can just implement
payment processor
that is the reason we must need to use interfaces 

basically this principle will help us to ensure there is no break in existing implementations.
because for every new implementation we are just adding new code and not touching the previous code


L -> Liskov Substitution principle: (LSP)
subtypes must be substitutable to their base types
for example Rectangle is a base type if we are implementing with Square class then we are breaking the expected behaviour
for this principle in real time , we must need to ensure all implementing classes must be substitable to parent class
the parent class all methods must need to be related to the child class even though we not overriden

it ensures that subclasses can stand in for their parent without breaking functionality

I -> interface segregation principle    (ISP)
Client should not be forced to depend on methods they dont use
example: instead of one big userService interface with createUser(), sendEmail(), generateReport()
split into smaller interfaces like UserRepository, EmailSender, ReportGenerator

D -> Dependency inversion principle (DIP)
depends on abstractions not concreate implementations
example: A notificationService should depend on an interface messageSender , not directly on EmailSender or SmsSender.
this allows easy swapping and unit testing with mocks

Design patterns:
while coming to the design patterns we have two different types of design patterns
1.Creational Design pattern (Singleton , Factory method) -> how object are created
2.Structural Design patten (Adapter, Decorator)
2.Behavioural Design pattern (Observer, Strategy) -> how object behaved while runtime , communication between objects

Singleton Design pattern:
A singleton design pattern will ensures only one single instance is available through out the application
and it provides a single global access point to it
examples: database connections -> basically database connections are cost in terms of memory and we must need to have 
one connection for all database related operations
logging -> 
configuration classes ->
caching

how we can implement basic singleton implementation: 
we need to create a private static instance for assigning the object
and we need to make constructor as private to stop outside instantiation
and we need to check whether instance is already created or not if yes return the existing instance. else create new one

now the problem is this will work for single thread application. but for multi threaded applications because of dirty 
reads there is a chance to create two obejcts .so to avoid this issue we need to use volatile

while using volatile first we will check instance == null with out any lock and then again we will check with syncronized lock


Factory method Design pattern:
The Factory method Design pattern allows you to create objects without exposing the creation logic to the client
instead,it lets subclasses decide which objects to create
basically with using factory class we can hide the actual implementation and the factory class will decide which class needs 
to be called in runtime
 the client does not know the exact class name that will be instantiated
it improves maintainbility -> adding a new payment type required minimal changes

Strategy design pattern:
this pattern defines a family of algorithms ,encapsulates each one and makes them interchangable at runtime
where it is used: when multiple algorithms can be applied for the same task
when you need to switch logic dynamically based on conditions
concept explanation: think of a ecommerce site where discounts vary like festival discount use discount or no discount
you can dynamically chose which discount startegy to apply
for example i have a use case like based on runtime object the startegy needs to be become change 
for that we can implement startegy design pattern . for example we have discountInterface and we have different types of 
discounts . based on type of discount it will apply the percentage dynamically
it is like open/closed SOLID principle


Observer Design pattern: this is a design pattern where we need to implement notification service
one person will publish and will observe by different people

the observer design pattern defines one to many relationship between objects
when one object (the subject) changes state, all its dependents (Observers) are notified automatically
where it is used:
Event Handling system
notification service
Messaging and pub/sub model








    