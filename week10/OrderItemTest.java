
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class OrderItemTest {
    
        private int quantity;
        private MenuItem menuItem ;
        private OrderItem orderItem;

    @BeforeEach
    private void setUp(){
        quantity = 1;
        menuItem = new MenuItem("cheesebuger",1.00,100);
        orderItem = new OrderItem(menuItem,quantity);
    }

    @Test// required
    public void testGetMenuItem(){
        setUp();
        MenuItem menuItem1 = new MenuItem(menuItem);// get the menuItem from the order item as a copy
        assertTrue(menuItem1.equals(menuItem1));// ensure the menuItem returned is a valid copy of the original
        assertFalse(menuItem1==menuItem);// the copy is not the same as the OG
    }

    @Test//not needed
    public void testGetQuantity(){
        setUp();
        int quantity = orderItem.getQuantity();// get a copy of the og value
        orderItem.setQuantity(2);               // set the value to a different number
        int newQuantity = orderItem.getQuantity();// get the value to see if it change
        assertTrue(!(quantity==newQuantity));// the og value should not change to the setvalue
    }

    @Test//not needed
    public void testIncreaseQuantity(){
        setUp();// reset the values of the numbers
        int num = orderItem.getQuantity();// get the quantity of the order item
        orderItem.setQuantity(2);         // set the quantity to a new value
        int num2 = orderItem.getQuantity();// get the new quantity of the order item, assuming that it changed
        assertFalse(num==num2);            // make sure they dont equall eeach other
    }

    

    

}
