package bank.observer;

public interface ISubject {
    public void addCreateObserver(CreateObserver observer) ;
    public void addChangeObserver(ChangeObserver observer) ;
    public void doCreateNotify();
    public void doChangeNotify();
}
