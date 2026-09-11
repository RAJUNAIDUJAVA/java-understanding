package multithreading.raceCondition.SynchronizedColl4;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class UsingSynchronizedColelction implements Runnable {
    private static final int NUM_ITERATIONS = 10000;
    /*ArrayList<String> sharedResource;

    public UsingSynchronizedColelction(ArrayList<String> sharedResource){
        this.sharedResource = sharedResource;
    }*/

    Collection<String> sharedResource;
    public UsingSynchronizedColelction(Collection<String> sharedResource){
        this.sharedResource= sharedResource;
    }



    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        for(int i=0; i<NUM_ITERATIONS; i++){
            sharedResource.add(threadName + "data"+ i);
        }
    }


    public static void main(String[] args) throws InterruptedException{

        //UsingSynchronizedColelction synchronizedColelction = new UsingSynchronizedColelction(new ArrayList<>());

        UsingSynchronizedColelction synchronizedColelction = new UsingSynchronizedColelction(Collections.synchronizedCollection(new ArrayList<>()));
        Thread t1 = new Thread(synchronizedColelction);
        Thread t2 = new Thread(synchronizedColelction);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(synchronizedColelction.sharedResource.size());
    }
}
