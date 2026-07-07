can you expalin java 17 features

ok i will list out java 17 features. the biggest migration was happened in java 17 after java 8
1. Sealed classes java 17 -> i have a class which i want to extend/restrict only with some specific group of classes. then i can 
make that class as sealed class. for example
   public sealed class Shape permits Circle,Rectangle {}
    please make sure the subclasses must be either final /sealed
    the reason is the subclasses can not extends further with other non sealed classes. 
    what are the permitted classes we have that all classes must need to extend the super class. upto that
    we will end up with compile time error.
    the reason for this is sealed classes are implemented such a way to make to work with pattern matching and switch
   -> the sub classes must need to be in same package and other wise we will end up with compile time exception
2. Patten Matching switch: 
    -> this is the update for switch.
    -> basically upto java 8 when we forget to use break condition ,once the case was satisified it will not break
     and we ended up with all remaining cases execution. so we must need to use break
   -> in java 17 we can use -> and even though we not used break it will stop the execution once the case got match
    -> in java 8 switch cannot return the value directly . but in java 17 switch can return the value
    ->switch can match on types also. in java 8 it will match values only
    -> for example we can tell if integer do this if string do this like that. if java 8 we must need to tell the value
    -> null was not supported in java 8, java 17 and null was supported in java 21

3. Records 17 -> when i want to create a immutable class without any getters setters and modifiers. then i can go for 
sealed classes. for example i am getting the response from downstream service and with out any modication i want to send
to my upstream service as it is then i can go for sealed class
 -> records will help me to reduce boiler plate code. records by default generate constructor,equals(),
    hashcode() , toString()

4. var keyword -> var keyword we can use to stop explicityly mentioning the specific type. based on assigned value 
at compile time compiler will assign the specific data type
    
    -> the limitations of var keyword are 
        1. when we want to know what values that method or variable was returning then we need to avoid the var keyword
        2.we can only use for local variables we cannot use for fields , method arguments and return types
        3. we must need to initialize with value
        4.cannot be null
5. 
