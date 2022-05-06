import java.io.IOException;


public class HouseKeeping {
    Bank hk;
    public HouseKeeping(Bank bank){
       hk =  bank;
    }
    
    /*update method simply calls the action method for each account. each account type has its own method
    called action. this works because the the acount type(class) will call the action method from that class */
    public void update(){
        for (Account account : hk.bank){// for account in bank
            account.update();// depending on the account type(accout,savings or checking) Action can be
             //called from that class. was also told not to use type check so here it is
             System.out.println("\n"); // spce out the acations
        }
    }  
     
    /*write method will write an account to a file based on which write method must be called */
    public void write() throws IOException{
        for (Account account : hk.bank){//acount in bank
            account.write();            // the correct write call will be called appropriately
        }
    }

    public void sort(){
        this.hk.sort();
    }
 
}
