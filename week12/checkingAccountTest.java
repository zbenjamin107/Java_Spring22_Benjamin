import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class checkingAccountTest {
    Person p1 = new Person("tim","allen","1234567890",new Date(12,24,1980));
    Person p2 = new Person("anakin", "solo","9876543210",new Date(4,1,1978));
    Customer c1 = new Customer(p1, new Date(1,15,2020),"1234");
    Customer c2 = new Customer(p2, new Date(6,23,2022), "56789");

    checkingAccount ca1 = new checkingAccount(123,c1,new Date(1,1,2022), 100000.00, 30000.00);
    checkingAccount ca2 = new checkingAccount(456,c2, new Date(10,10,2021),-30000.00,20000.00);
    checkingAccount copy1 = new checkingAccount(123,c1,new Date(1,1,2022), 100000.00, 30000.00);
    
    @Test
    public void testIsInOverdraft(){    
        // for ca2 balance is -30000. overdraft is 20000, so its in overdraft for sure
        boolean t = true;                       // we know its in overdraft
        assertEquals(t,ca2.isInOverdraft());    // confirm it returns true

        //for ca2 balance is a lot. definately not in overdraft
        boolean f = false;
        assertEquals(f,ca1.isInOverdraft());    //confirm it doesnt say it is
    }

    @Test
    public void testEquals(){
        assertFalse(ca1.equals(ca2));   // test inequality
        assertFalse(ca2.equals(copy1)); // again
        assertTrue(ca1.equals(copy1));  // test checking accouts with same atributes

        ca1.deposit(50);            // change ca1
        assertFalse(ca1.equals(copy1));  // confrim it doesnt equal the copy anymore
        ca1.withdraw(50);           // change it back
        assertTrue(ca1.equals(copy1));   // confirm they are the same again
        
    }
    
}
