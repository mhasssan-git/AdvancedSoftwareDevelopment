package customers;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class TweleveFilterIterator implements Iterator<Customer> {
    private final List<Customer> list;
    private int position;
    public TweleveFilterIterator(List<Customer> list)
    {
        this.list=list.stream().
                filter(t->t.getAddress().getZip().startsWith("12"))
                .collect(Collectors.toList());
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
