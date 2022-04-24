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
        bank[0] = new Account(123,c1,d1,100000.00);// Acount made and added to the array
        bank[1] = new checkingAccount(456,c1,d1,-30000.00,20000.00);// checking account made and added to the list
        bank[2] = new savingsAccount(789,c1,d1,50000.00,.085);//savings accout made and added to the array
        bank[3] = new Account(654,c2,d2,30000.00 );
        bank[4] = new checkingAccount(321,c2,d2,20000.00,20000.00);
        bank[5] = new savingsAccount(987,c2,d2,40000.00,.102);
        return bank;    // return the array
    }

    /*update method simply calls the action method for each account. each account type has its own method
      called action. this works because the the acount type(class) will call the action method from that class */
    public void update(){
       for (Account account : bank){// for account in bank
           account.Action();// depending on the account type(accout,savings or checking) Action can be
            //called from that class. was also told not to use type check so here it is
            System.out.println("\n"); // spce out the acations
        }
    }                           

}
