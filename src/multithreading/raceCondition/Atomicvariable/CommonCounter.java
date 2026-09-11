package multithreading.raceCondition.Atomicvariable;

import java.util.concurrent.atomic.AtomicInteger;

public class CommonCounter {

    private AtomicInteger firstNum = new AtomicInteger(0);
    private AtomicInteger secondNum = new AtomicInteger(0);

    public void incrementCounter(){

        firstNum.incrementAndGet();
       /* synchronized (this){
            firstNum++;
        }*/
        secondNum.incrementAndGet();
    }

    public AtomicInteger getFirstNum() {
        return firstNum;
    }

    public AtomicInteger getSecondNum() {
        return secondNum;
    }
}
