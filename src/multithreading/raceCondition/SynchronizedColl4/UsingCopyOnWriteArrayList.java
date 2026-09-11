package multithreading.raceCondition.SynchronizedColl4;

import java.util.concurrent.CopyOnWriteArrayList;

public class UsingCopyOnWriteArrayList implements Runnable{

    public static final int NUM_ITERATIONS = 10000;
    CopyOnWriteArrayList<String> sharedResource;

    public UsingCopyOnWriteArrayList(CopyOnWriteArrayList<String> commonResource){
        this.sharedResource= commonResource;
    }

    public void run(){
        for(int i=0; i<NUM_ITERATIONS; i++){
            sharedResource.add("thread updated"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UsingCopyOnWriteArrayList  list = new UsingCopyOnWriteArrayList(new CopyOnWriteArrayList<>());
        Thread t1= new Thread(list);
        Thread t2 = new Thread(list);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(list.sharedResource.size());
    }
}
