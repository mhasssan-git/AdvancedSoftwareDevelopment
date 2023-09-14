package customers;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ChicagoFilterIterator implements Iterator<Customer> {
    private final List<Customer> list;
    private int position;
    public ChicagoFilterIterator(List<Customer> list)
    {
        this.list=list.stream().
                filter(t->t.getAddress().getCity().toLowerCase().contains("chicago"))
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
