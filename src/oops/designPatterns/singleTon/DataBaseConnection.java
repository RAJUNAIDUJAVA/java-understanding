package oops.designPatterns.singleTon;
/*
when we are working on single threaded environment , then we can create a basic singleton Object.
it will always look for same instance
*/
public class DataBaseConnection {

    //  creating a private static instance variable
    private static DataBaseConnection instance;

    // we need to make constructor as private because instantiation need to done by getter method and from outside nobody can
    // create the object
    private DataBaseConnection(){

    }

    public DataBaseConnection getInstance(){
        if (instance == null){
            // if no instance yet
            instance = new DataBaseConnection(); // create a new instance
            return instance;
        }
        return instance;// if instance available return same instance
    }




}
