
import java.io.FileWriter;
import java.io.IOException;


public class checkingAccount extends Account{
    public static final double overdraftLimit = .5;//percentage of balance in decimal
    public static final double maxBalance = 100000;// balance cannot exceed max balance without penalty
    //final-cant change, static-shared in the class, public- not private;accesed by the outside world
    double monthlyFee = 50.00;// the account fee per month. we want this factor to be able to change, like in penalty
    private double overdraft;
    
    /*checking accout costructor */         
    public checkingAccount( int accountNumber, Customer owner, Date created, double balance, double overdraft, double monthlyFee){
        super(accountNumber,owner, created,balance);
        this.overdraft = overdraft;
        this.monthlyFee = monthlyFee;
    }

    /*another constructor to create a checking account =======this one=======   */
    public checkingAccount(  Customer owner,Employee manager, Date created,int accountNumber, double balance, double monthlyFee){
        super(accountNumber, manager, owner, created);
        this.overdraft = .25;
        setBalance(balance);
        this.monthlyFee = monthlyFee;
    }

    /*copy constructor for the checking account */
    public checkingAccount(checkingAccount ca){
        super(ca.getAccountNumber(),ca.getManager(),ca.getCustomer(),ca.getDateCreated());
        this.overdraft = ca.overdraft;
        this.monthlyFee = ca.monthlyFee;
    }

    /*is in overdraft will return true or false based on if its in overdraft or not. if the account has
    less than 0 dollars then it will return true if not it will return false */
    public boolean isInOverdraft(){
        double balance = getBalance();
        if (balance < 0){
            return true;
        }
        return false;
    }

    /*returns the double monthly fee  */
    public double getMonthlyFee() {
        return monthlyFee;
    }

    /*takes a double as a parameter and sets it as the monthly fee */
    public void setMonthlyFee(double monthlyFee) {
        if (monthlyFee < 0) monthlyFee *= -1;// if the fee is negative, change to positive
        this.monthlyFee = monthlyFee;
    }

    /**returns overdraft..a double*/
    public double getOverdraft(){
        return overdraft;
    }

    /*to string method for the checking account */
    @Override
    public String toString(){
        return super.toString() + "\nOverdraft: " + this.overdraft;
    }

    /*equals method for the cheking account class */
    @Override
    public boolean equals(Object obj){
        if (this == obj)        return true; // identity check
        if (obj == null)        return false;// null check
        if (!super.equals(obj)) return false;// super check
        if (this.getClass() != obj.getClass()) return false;// class check

        checkingAccount other = (checkingAccount) obj;      // type cast
        
        if (this.overdraft != other.overdraft) return false;// check the overdraft

        return true; // if no difference is found
    }

    /*action method is overriden and will print a warning if the checking account is in overdraft. if not
      it will say what the balance */
    @Override // since there is an inherited method we must override. slight adjustment to this method
    public void update(){
        
        if (getBalance()>= maxBalance) {    // balance is greater than or equal
            double penalty = penalty();     // get ppenalty
            try{withdraw(penalty);}         //take that money 
            catch( InvalidWithdrawalException e){}// if the exception is throw
        }
    }

    /*penalty will override then penalty method. it will double the monthly fee */
    @Override
    public double penalty(){
        return this.getMonthlyFee() * 2;
    }

    /*withdraw will allow withdrawal amounts up to overdraft limit.  */
    public void withdraw(double sum) throws  InvalidWithdrawalException{
        if (sum < 0 ) sum *= -1;    // if it is negative make it positive
        if (isInOverdraft()) return;// if the account is already in overdraft, return.
        double balance = getBalance();//get the current balance.
        if (sum > getBalance() *(1+ overdraftLimit)) {// if the sum taken out is greater than the current balance + current balance * overdraft limit
            setBalance(balance - sum);
            throw new  InvalidWithdrawalException("the balance has gone below the limit by withdrawing " + sum);
        } //if the next lines happen then the withdraw amount is valid/allowed
           
        setBalance(balance - sum);      // new balance is old minus the sum
        
    }

    /*deposit add money to an accout ignoring any negative inputs */
    @Override
    public void deposit(double sum) throws  InvalidBalanceException{
        if (sum < 0)    sum *= -1; // if negative then make positive
        if (this.getBalance() + sum > maxBalance){// if it exceeds max balance then do nothing
            setBalance(getBalance() + sum);
            throw new InvalidBalanceException("max balance has been exceeded. exceeded from deposit of " + sum); 
        } // the next line will only happen if the exception is not thrown
        setBalance(getBalance() + sum); // add sum to the balance
        }

    /*write method for the checking class writes to a file the account info and names the file. name 
of the file will be first and second letters of first name, first and second of last name, month,day,year */
    @Override
    public void write() throws IOException {      
        
        FileWriter fw = new FileWriter( "checking_accounts.txt",true); 
        fw.write("\n" + getCustomer().getName() + "," + getManager().getName() + "," + getDateCreated() + "," +getAccountNumber() + "," + getBalance() + "," + getMonthlyFee() );                                          //write to file this account  info
        fw.close();                                                         // close filewriter
    }
}
