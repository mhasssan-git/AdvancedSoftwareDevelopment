package customers;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class SkipFilterIterator implements Iterator<Customer> {
    private final List<Customer> list;
    private int position;
    public SkipFilterIterator(List<Customer> list)
    {
        this.list=list;
        position=0;
    }
    @Override
    public boolean hasNext() {
        return position<list.size();
    }

    @Override
    public Customer next() {
        Customer customer= list.get(position);
        position+=2;
        return customer;
    }
}
