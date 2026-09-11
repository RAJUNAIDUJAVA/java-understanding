package multithreading.raceCondition.Atomicvariable;

public class CountIncrementor implements Runnable{

    private CommonCounter myCounter;
    private int numIterations;

    public CountIncrementor(CommonCounter commonCounter, int numIterations){
        this.myCounter = commonCounter;
        this.numIterations= numIterations;
    }

    @Override
    public void run() {

        for(int i=0; i<numIterations; i++){
            myCounter.incrementCounter();
        }

    }


}
