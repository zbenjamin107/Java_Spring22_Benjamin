import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class savingsAccountTest {
    Person p1 = new Person("tim","allen","1234567890",new Date(12,24,1980));
    Person p2 = new Person("anakin", "solo","9876543210",new Date(4,1,1978));
    Customer c1 = new Customer(p1, new Date(1,15,2020),"1234");
    Customer c2 = new Customer(p2, new Date(6,23,2022), "56789");

    savingsAccount ca1 = new savingsAccount(123,c1,new Date(1,1,2022), 100000.00, .0575);
    savingsAccount ca2 = new savingsAccount(456,c2, new Date(10,10,2021),-30000.00,.080);
    savingsAccount copy1 = new savingsAccount(123,c1,new Date(1,1,2022), 100000.00, .0575);
    
    @Test
    public void testAddInterest(){
        assertTrue(ca1.equals(copy1));      // these two are equal

        ca1.addInterest();     // change the interest
        assertTrue(ca1.getBalance()==(100000.00*1.0575));// confirm the new amount
        assertFalse(ca1.equals(copy1));     // comfirm they dont equle each other anymore
    }

    @Test
    public void testGetInterest(){
        double interest1 = ca1.getInterest();//get interest for ca1
        assertTrue(interest1 == .0575);      // confirm its worth
 
        double interest2 = ca2.getInterest();// get interst for ca2
        assertTrue(interest2 == .080);       // confirm its value

        double interes = copy1.getInterest();// get intres for cop1
        assertTrue(interes == .0575);        // confirm its gain
    }

    @Test
    public void testEquals(){
        assertFalse(ca1.equals(ca2));   // ca1 and 2 dont match
        assertTrue(ca1.equals(copy1));  // ca1 and copy do macth

        ca1.deposit(20);            // change value if the ca1
        assertFalse(ca1.equals(copy1)); // confirm they dont match

        ca1.withdraw(20);           // change the value back
        assertTrue(ca1.equals(copy1));   // confirm equality of composition
    }
    
}
