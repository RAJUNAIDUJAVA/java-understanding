package oops.observer;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {
    private final List<Observer> observers= new ArrayList<>();
    public void register(Observer observer){
        observers.add(observer);
    }
    public void notifyAllObservers(String stockname, double price){
        for(Observer observer : observers){
            observer.update(stockname, price);
        }
    }
}
