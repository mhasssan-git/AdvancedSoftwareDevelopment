package customers;

import java.util.*;

public class AgeIterator implements Iterator<Customer> {
    private final List<Customer> list;
    private int position;
    public AgeIterator(List<Customer> list)
    {
        Collections.sort(list, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        this.list=list;
        position=0;
    }
    @Override
    public boolean hasNext() {
        return position<list.size();
    }

    @Override
    public Customer next() {
        return list.get(position++);
    }
}
