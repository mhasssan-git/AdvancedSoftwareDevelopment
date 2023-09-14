package application;

@Service(name="two")
public class MyServiceTwo {
    private String name = "myServiceTwo";

    private void print(){
        System.out.println(name);
    }
}
