package multithreading.raceCondition.concurrentModification;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentModifcationExampleWithCopyOnWrite implements Runnable {

    CopyOnWriteArrayList<String> sharedResource;
    public ConcurrentModifcationExampleWithCopyOnWrite (CopyOnWriteArrayList list){
       this.sharedResource= list;
    }


    @Override
    public void run() {
        for (int i=0; i<29; i++){
            sharedResource.add("task"+Thread.currentThread().getName()+ i);
            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        CopyOnWriteArrayList cl = new CopyOnWriteArrayList();

        ConcurrentModifcationExampleWithCopyOnWrite cwa= new ConcurrentModifcationExampleWithCopyOnWrite(cl);

        Thread t1= new Thread(cwa);
        Thread t2 = new Thread(cwa);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        Iterator il = cl.iterator();
        while(il.hasNext()){
            System.out.println(il.next());
        }
    }
}
