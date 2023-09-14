package application;

@Service(name="one")
public class MyServiceOne {
    private String nameOne = "nameOne";
    @Inject
    private String nameTwo = "nameTwo";

    public void print(){
        System.out.println(nameOne);
    }

    @Print
    public void print2(){
        System.out.println(nameTwo);
    }
}
