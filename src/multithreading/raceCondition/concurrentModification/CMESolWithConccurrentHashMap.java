package multithreading.raceCondition.concurrentModification;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class CMESolWithConccurrentHashMap implements Runnable {

    ConcurrentHashMap<String,String> sharedResource;

    public CMESolWithConccurrentHashMap(ConcurrentHashMap<String,String> sr){
        this.sharedResource = sr;
    }

    public void run(){
        for(int i=0; i<20; i++){
            sharedResource.put(Thread.currentThread().getName()+"key"+i, Thread.currentThread().getName()+"value"+i );
            try{
                Thread.sleep(100);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ConcurrentHashMap<String,String> map1= new ConcurrentHashMap<>();
        CMESolWithConccurrentHashMap cmeWithHashMap = new CMESolWithConccurrentHashMap(map1);
        Thread t1= new Thread(cmeWithHashMap,"thread1");
        Thread t2 = new Thread(cmeWithHashMap, "thread2");

        t1.start();
        t2.start();
        Thread.sleep(1000);
        Iterator iterator = cmeWithHashMap.sharedResource.keySet().iterator();

        while(iterator.hasNext()){
            System.out.println(map1.get(iterator.next()));
            Thread.sleep(1000);
        }
    }
}
