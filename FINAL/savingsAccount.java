import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class savingsAccount extends Account {
    
    public static final double interest = .1;       // variable to add in our custructors
    public static final  int maxWithdraws = 50;     //max amount someone can withdraw in a month
    public static final double minBalance = 1;      // balance must be greater than 1 dollar or there is a penalty 
    
    double yearlyDepositLimit = .25;  
    double withdrawalLimit =.75;// maximum withdrawal amount in percentage
    int withdrawals = 0;        // the recorded quantity of withdrawal transactions in a month
    double balance=100;
    /*cunstructor to make a savings account */      //THIS ONE//
    public savingsAccount( Customer owner,Employee manager,  Date created,int accountNumber, double balance1, double yearlyDepositeLimit, double withdrawalLimit, int withdraws){
        super( accountNumber,manager, owner, created);
        this.yearlyDepositLimit = .01 * yearlyDepositeLimit;
        this.withdrawalLimit = .01 * withdrawalLimit;
        this.withdrawals = withdraws;
        setBalance(balance1);
    }

    /*returns a double of the yearly deposit limit */
    public double getYearlyDepositLimit() {
        return yearlyDepositLimit;
    }

    /*method to increase the withdraws after each use */
    public void increaseWithdrawals(){
        this.withdrawals += 1;// increase by one
    }

    /*returns the withdraws for the month */
    public int getWithdrawals(){
        return this.withdrawals;
    }

    /*takes a double and sets it as the limit */
    public void setYearlyDepositLimit(double yearlyDepositLimit) {
        this.yearlyDepositLimit = yearlyDepositLimit;
    }

    /*returns the double of the limit withdraw */
    public double getWithdrawalLimit() {
        return withdrawalLimit;
    }

    /*takes a double and sets it as the limit for the withdraw */
    public void setWithdrawalLimit(double withdrawalLimit) {
        this.withdrawalLimit = withdrawalLimit;
    }

    /*to string method for the savings account class */
    @Override
    public String toString(){
        return super.toString() + "\nyearly Deposit Limit: " + yearlyDepositLimit +
        "\nwithdrawal Limit: " + withdrawalLimit + "\nwithdrawals: " + withdrawals + "\n";
    }

    /*equals method for the savings account class. */
    @Override 
    public boolean equals(Object obj){
        if (this == obj)                        return true;// check identity
        if (obj == null)                        return false;// null check
        if (!super.equals(obj))                 return false;//super check
        if (this.getClass() != obj.getClass())  return false;

        savingsAccount other = (savingsAccount) obj;        //type cast

        if (this.yearlyDepositLimit != other.yearlyDepositLimit)return false;
        if (this.withdrawalLimit != other.withdrawalLimit)      return false;
        if (this.withdrawals != other.withdrawals)              return false;
                                                                return true; // if no falut is foud return true
    }

    /*action method is to add interest to the accout balance  */
    @Override// since the method exist and is inhereted, we must override the inhereted method
    public void update(){
       
        if (getBalance() < minBalance){ // if it is below the minimum.. 
            try{
                withdraw(penalty());// take the penalized amount out of the account
                }   
            catch( InvalidWithdrawalException e){}

           
        }
    }

    /*penalty will return a return a double, 1% of the balance*/
    @Override
    public double penalty(){
        return getBalance() *.01; //balance * 1% is the return
    }

    /*penalize will take money from an account that has to be penalized */
    public void penalize(){
        double penalty = penalty();
        setBalance(getBalance() - penalty);// i could have just withdrawn but that could have failed and i want to make sure the penalty goes through
    }

    /*withdraw will sunstrac the amount withdrwn from the account */
    @Override
    public void withdraw(double sum) throws InvalidWithdrawalException{
        if (getWithdrawals() == maxWithdraws) throw new  InvalidWithdrawalException("you have reached the maximum number of withdrawals");

        double limit = getBalance() * withdrawalLimit;  // find limit for the account
        if (getBalance() < 0)                   return; // if the account has less than zero
        if (sum > limit)                        return; // if the sum is greater than the limit
        setBalance(getBalance() - sum);
        increaseWithdrawals();// increases the number if withdrawals
    }

    /*deposit will check the yearly deposit limit first and then deposit if all is good*/
    public void deposit(double sum) throws  InvalidBalanceException{
        double limit = getBalance() * yearlyDepositLimit;
        if (getBalance() + sum > limit)     return;
        setBalance(getBalance() + sum);
    }

    /*writes info to  */
    public void write() throws IOException{
        File f = new File("savings accounts.txt");
        FileWriter fw = new FileWriter(f, true);                    // create filewriter with invoice as name
        fw.write("\n" + getCustomer().getName() + "," + getManager().getName() + "," + getDateCreated() + "," + getAccountNumber() + "," + getBalance() + "," + getYearlyDepositLimit() + "," + getWithdrawalLimit() + "," + getWithdrawals() );                                          //write to file this account  info
        fw.close();                                                         // close filewriter
    }

    /*
     /*another overloaded construtor /
     public savingsAccount(int accountNumber, Customer owner, Date created, double balance, double yearlyDepositeLimit, double withdrawalLimit,int withdraws){
        super( accountNumber, owner, created, balance);
        this.yearlyDepositLimit = .01 * yearlyDepositeLimit;
        this.withdrawalLimit = .01 * withdrawalLimit;
        this.withdrawals = withdraws;
    }
    
    /* copy constructor for the savings account/
    public savingsAccount(savingsAccount sa){
        super(sa.getAccountNumber(),sa.getManager(),sa.getCustomer(),sa.getDateCreated());
        this.yearlyDepositLimit = sa.yearlyDepositLimit;
        this.withdrawalLimit = sa.withdrawalLimit;
        this.withdrawals = sa.withdrawals;
    }*/
}
