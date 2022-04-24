public class checkingAccount extends Account{
    private double overdraft;
    
    /*checking accout costructor */
    public checkingAccount( int accountNumber, Customer owner, Date created, double balance, double overdraft){
        super(accountNumber,owner, created,balance);
        this.overdraft = overdraft;
    }

    /*another constructor to create a checking account */
    public checkingAccount(int accountNumber, Employee manager, Customer owner, Date created, double overdraft){
        super(accountNumber, manager, owner, created);
        this.overdraft = overdraft;
    }

    /*copy constructor for the checking account */
    public checkingAccount(checkingAccount ca){
        super(ca.getAccountNumber(),ca.getManager(),ca.getCustomer(),ca.getDateCreated());
        this.overdraft = ca.overdraft;
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

    /**returns overdraft */
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
    public void Action(){
        System.out.println(this);//call the to string
        if (isInOverdraft()) {  // if it is in overdraft...
            System.out.println("\t\t\tWARNING: OVERDRAFT REACHED!!");
        }
        else{
            System.out.println("\t\t\tOVERDRAFT NOT YET REACHED :)");
        }
      }


}
