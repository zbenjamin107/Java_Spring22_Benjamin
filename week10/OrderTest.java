import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class OrderTest {
    private Date date;
    private String invoice;
    private Customer customer;
    private ArrayList<OrderItem> cart;
    Order order;
    
    @BeforeEach 
    public void setUp(){
        date = new Date();
        customer = new Customer();
        order = new Order(customer);
    }

    @Test
    public void testGetCustomer(){
        setUp();
        Customer cust = order.getCustomer();// create a customer instance 
        cust.setName("zach");// should not change any of the og values while changing these values
        cust.setEmail("a@b.com");
        cust.setPhone("1234567890");
        customer = new Customer();// if any of the og values were changed, they will be assigned to customer 
        assertFalse(cust.getName().equals(customer.getName()));// they og values were not changed, therefore all these are false
        assertFalse(cust.getEmail().equals(customer.getEmail()));
        assertFalse(cust.getPhone().equals(customer.getPhone()));
    }

    @Test
    public void testGetDate(){
        setUp();
        Date newDate = new Date();// date instance 
        newDate.setYear(2000);// should not change og values
        newDate.setDay(20);
        newDate.setMonth(2);
        Date otherDate = new Date();// if the og values were changed then they will be assinged here 
        assertFalse(newDate.equals(otherDate));// they were not changed so they arent equal

    }

    @Test
    public void TestGetCart(){
        setUp();
        MenuItem mi = new MenuItem();// create a menu item      
        cart = order.getCart();     // call for cart
        order.addItem(mi);          // adds item to the cart/ changes it
        Order order2 = new Order(); // construct a cart from the default value to see if it changed
        assertFalse(order2.equals(order));// it did not change and these two carts are not equal


    }


}
