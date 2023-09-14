package order;

import shopping.Cartitem;
import shopping.ShoppingCart;

public class OrderService {
    OrderDAO orderDAO = new OrderDAO();
    EmailSender emailSender = new EmailSender();


    public void createOrder(ShoppingCart shoppingCart, int ordernumber){
        Order order = new Order(ordernumber);
        for (Cartitem cartitem: shoppingCart.getCartlist()){
            order.addOrderLine(new Orderline(cartitem.getProduct(), cartitem.getQuantity()));
        }
        orderDAO.save(order);
    }

    public Order getOrder(int ordernumber){
        return orderDAO.find(ordernumber);
    }

    public void saveOrder(Order order) {
        orderDAO.save(order);
    }

    public void placeOrder(int ordernumber) {
        Order order = getOrder(ordernumber);
        emailSender.sendEmail(order.getCustomer().getEmail(), "Thank for your order with ordernumber "+order.getOrdernumber());
    }
}
