package multithreading.raceCondition.SynchronizedColl4;

import com.sun.jdi.event.ThreadStartEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsingSynchronizedList implements Runnable{

    public static final int NUM_ITERATIONS = 10000;
    List<String> commonResource;

    public UsingSynchronizedList(List<String> commonResource){
        this.commonResource = commonResource;
    }

    public void run(){
        for(int i=0; i<NUM_ITERATIONS; i++){
            commonResource.add("adding"+i);
        }
    }


    public static void main(String[] args) throws InterruptedException{
       // UsingSynchronizedList list = new UsingSynchronizedList(new ArrayList<>());

        UsingSynchronizedList list = new UsingSynchronizedList(Collections.synchronizedList(new ArrayList<>()));

        Thread t1 = new Thread(list);
        Thread t2 = new Thread(list);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(list.commonResource.size());
    }
}
