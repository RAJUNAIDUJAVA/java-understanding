package multithreading.raceCondition.performance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListPerformance {

    ArrayList<String> arrayList = new ArrayList<>();
    List<String> list = Collections.synchronizedList(new ArrayList<>());
    Vector<String> vector = new Vector<>();
    CopyOnWriteArrayList<String> cowa = new CopyOnWriteArrayList<>();
    public static final int NUM_ITERATIONS = 1000000;


    public void arrayListPerformance (){
        Long startTime = System.currentTimeMillis();
        for(int i=0; i<NUM_ITERATIONS; i++){
            arrayList.add("Element"+i);
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("the time taken in ms are "+(endTime-startTime));
    }

    public void synchronizedListPerformance(){
        Long startTime = System.currentTimeMillis();
        for(int i=0; i<NUM_ITERATIONS; i++){
            list.add("Element"+i);
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("the time taken in ms are "+(endTime-startTime));
    }

    public void vectorPerformance(){
        Long startTime = System.currentTimeMillis();
        for(int i=0; i<NUM_ITERATIONS; i++){
            vector.add("Element"+i);
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("the time taken in ms are "+(endTime-startTime));
    }

    public void copyOnWriteArrayListPerformance(){
        Long startTime = System.currentTimeMillis();
        for(int i=0; i<NUM_ITERATIONS; i++){
            cowa.add("Element"+i);
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("the time taken in ms are "+(endTime-startTime));
    }

    public static void main(String[] args) {
        ArrayListPerformance arrayListPerformance = new ArrayListPerformance();
        arrayListPerformance.arrayListPerformance();
        arrayListPerformance.synchronizedListPerformance();
        arrayListPerformance.vectorPerformance();
        arrayListPerformance.copyOnWriteArrayListPerformance();
    }
}
