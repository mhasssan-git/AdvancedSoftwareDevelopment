package bank.observer;

import java.util.ArrayList;
import java.util.Collection;

public class Subject implements ISubject {
    private Collection<CreateObserver> createObservers = new ArrayList<>();
    private Collection<ChangeObserver> changeObservers = new ArrayList<>();

    public void addCreateObserver(CreateObserver observer) {
        createObservers.add(observer);
    }
    public void addChangeObserver(ChangeObserver observer) {
        changeObservers.add(observer);
    }
    public void doCreateNotify(){
        for (Observer observer: createObservers){
            observer.update();
        }
    }
    public void doChangeNotify(){
        for (Observer observer: changeObservers){
            observer.update();
        }
    }
}
