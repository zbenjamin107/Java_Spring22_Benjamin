import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class savingsAccountTest {
    Person p1 = new Person("tim","allen","1234567890",new Date(12,24,1980));
    Person p2 = new Person("anakin", "solo","9876543210",new Date(4,1,1978));
    Customer c1 = new Customer(p1, new Date(1,15,2020),"1234");
    Customer c2 = new Customer(p2, new Date(6,23,2022), "56789");

    savingsAccount sa1 = new savingsAccount(123,c1,new Date(1,1,2022), 100000.00, .05,.25,.75,0);
    savingsAccount sa2 = new savingsAccount(456,c2, new Date(10,10,2021),-30000.00,.080,.25,.75,0);
    savingsAccount copy1 = new savingsAccount(123,c1,new Date(1,1,2022), 100000.00, .05,.25,.75,0);

    /*this method also checks the deposit and withdraw methods */
    @Test
    public void testEquals(){
        assertFalse(sa1.equals(sa2));   // ca1 and 2 dont match
        assertTrue(sa1.equals(copy1));  // ca1 and copy do macth

        try{
            sa1.deposit(20);        // change value if the ca1. possible cause of an invalid balance exception
        }   
        catch(InvalidBalanceException e){
            assertTrue(sa1.equals(copy1));// if it throws an exception then this should still be true
        }
        assertFalse(sa1.equals(copy1)); // confirm they dont match

        try{
            sa1.withdraw(20);           // change the value back. 
        }
        catch(InvalidWithdrawalException e){
            assertFalse(sa1.equals(copy1));// this should still be true if the exception is thrown
        }
        assertTrue(sa1.equals(copy1));   // confirm equality of composition
    }

    @Test
    public void testPenalize(){
        double oldBalance = sa1.getBalance();
        double penalty = sa1.penalty(); // 1% of the balance is the penalty for each accout. hsould be 1k
        sa1.penalize();                 // takes that 1 percent out of the account balance
        assertTrue(sa1.getBalance()==(oldBalance- penalty));// confirm they equal each other
    }
}
