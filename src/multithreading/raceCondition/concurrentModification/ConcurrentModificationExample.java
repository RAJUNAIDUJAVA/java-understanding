package multithreading.raceCondition.concurrentModification;

import java.util.ArrayList;
import java.util.Iterator;

public class ConcurrentModificationExample implements Runnable {

    ArrayList<String> commonResource;
    public static final int NUM_ITERATIONS = 10000;

    public ConcurrentModificationExample(ArrayList<String> list){
        this.commonResource= list;
    }



    public void run(){

        for(int i=0; i<NUM_ITERATIONS; i++){
            commonResource.add("insert"+Thread.currentThread().getName()+i);
            try{
                Thread.sleep(100);
            }
            catch (InterruptedException e){
               e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> arrayList= new ArrayList<>();
        ConcurrentModificationExample cm = new ConcurrentModificationExample(arrayList);



        Thread t1= new Thread(cm);
        Thread t2 = new Thread(cm);

        t1.start();
        t2.start();

        Thread.sleep(1000);

        Iterator iterator = cm.commonResource.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println(cm.commonResource.size());
    }


}
