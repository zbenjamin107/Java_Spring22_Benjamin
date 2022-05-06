import java.io.IOException;
import java.util.Arrays;

public class Bank {

    Account[] bank;// bank is an array of accouts

    /*constructor for bank */
    public Bank(){
        Account[] bank = createBank();
        this.bank = bank;
    }

    /*method to create the array of account objects */
    public Account[] createBank(){
        Account[] bank = new Account[6];//create an array
        Customer c1 = new Customer();   // create a customer. is used to create the accounts
        Date d1 = new Date();           // create a date. used to create the accounts
        Date d2 = new Date(1,1,2022);
        Customer c2 = new Customer("Larry","Boy","9874563210",new Date(8,13,1999),d2,"1a2b3c");
        bank[0] = new savingsAccount(123,c1,d1,100000.00,.08,.25, .75, 0);// Acount made and added to the array
        bank[1] = new checkingAccount(456,c1,d1,-30000.00,20000.00,50.0);
        bank[2] = new savingsAccount(789,c1,d1,50000.00,.08,.25, .75, 0);//savings accout made and added to the array
        bank[3] = new checkingAccount(654,c2,d2,30000.00,200.00,50.0);
        bank[4] = new checkingAccount(321,c2,d2,20000.00,0.00,50.0);
        bank[5] = new savingsAccount(987,c2,d2,40000.00,.08,.25, .75, 0);
        return bank;    // return the array
    }

    public void update(){
        HouseKeeping hk = new HouseKeeping(new Bank());
        hk.update();
    }

    public void wite()throws IOException{
        HouseKeeping hk = new HouseKeeping(new Bank());
        hk.write();
    }

    public void sort(){
        Arrays.sort(this.bank);// calls the sort method from arrays
    }
    
}
