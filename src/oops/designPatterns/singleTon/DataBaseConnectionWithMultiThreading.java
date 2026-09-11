package oops.designPatterns.singleTon;
/*
* when we are working with multi threading environment for singleton because of dirty reads there is a possibility
* to create two objects. for example one thread was looking for instance and it is not null and using same object but
* some other thread because of dirty read if read instance as null and it will create second object and will break the
* singleton design pattern
* */



public class DataBaseConnectionWithMultiThreading {
    // here volatile will ensure all the threads have the updated value. so there will not be any dirty reads
    // volatile ensured always threads looks the latest value from memory and not from cache
    // volatile prevents threads from using cached copies of the variable
    private static volatile DataBaseConnectionWithMultiThreading instance;
    // make constructor as private because from outside we need to stop the initialisation
    private DataBaseConnectionWithMultiThreading(){

    }

    public DataBaseConnectionWithMultiThreading getInstance(){
        if(instance == null){ // first check with out locking
            synchronized (DataBaseConnectionWithMultiThreading.class){
                if (instance == null){
                    instance = new DataBaseConnectionWithMultiThreading(); // with locking
                    return instance;
                }

            }
        }
        return instance;
    }

}
