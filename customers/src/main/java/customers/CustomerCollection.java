package customers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomerCollection {
    List<Customer> customers = new ArrayList<Customer>();

    public void add(Customer customer) {
        customers.add(customer);
    }

    public Iterator<Customer> ageIterator() {
        return new AgeIterator(customers);
    }

    public Iterator<Customer> chicagoFilterIterator() {
        return new ChicagoFilterIterator(customers);
    }
    public Iterator<Customer> tweleveFilterIterator() {
        return new TweleveFilterIterator(customers);
    }

    public Iterator<Customer> skippingFilterIterator() {
        return new SkipFilterIterator(customers);
    }

    public void print() {
        Iterator<Customer> aI = ageIterator();
        while (aI.hasNext()) {
            System.out.println(aI.next());
        }
        System.out.println("*********************** Chicago filter applied **********************************");
        Iterator<Customer> cfi = chicagoFilterIterator();
        while (cfi.hasNext()) {
            System.out.println(cfi.next());
        }

        System.out.println("*********************** 12 filter applied **********************************");
        Iterator<Customer> tfi = tweleveFilterIterator();
        while (tfi.hasNext()) {
            System.out.println(tfi.next());
        }

        System.out.println("*********************** skipping filter applied **********************************");
        Iterator<Customer> skip = skippingFilterIterator();
        while (skip.hasNext()) {
            System.out.println(skip.next());
        }
    }

}
