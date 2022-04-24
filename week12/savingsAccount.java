public class savingsAccount extends Account {
    
    private double interest;// variable to add in our custructors

    /*cunstructor to make a savings account */
    public savingsAccount(int accountNumber, Employee manager, Customer owner, Date created, double interest){
        super( accountNumber,manager, owner, created);
        this.interest = interest;
    }

    /*another overloaded construtor */
    public savingsAccount(int accountNumber, Customer owner, Date created, double balance, double interest){
        super( accountNumber, owner, created, balance);
        this.interest = interest;
    }
    
    /* copy constructor for the savings account*/
    public savingsAccount(savingsAccount sa){
        super(sa.getAccountNumber(),sa.getManager(),sa.getCustomer(),sa.getDateCreated());
        this.interest = sa.interest;
    }

    /*add interest is a method that adds interest to the balance */
    public void addInterest(){
        double balance = getBalance();  // gets the current balance
        double interst = getInterest(); // gets interest 
        double newBalance = balance * (1 + interst);// gets new balance by multiplying it by interest+1 (if its .08 multiply balance by 1.08)
        setBalance(newBalance);         // set the new balance
    }

    /**return interest returns a double */
    public double getInterest(){
        return this.interest;
    }

    /*to string method for the savings account class */
    @Override
    public String toString(){
        return super.toString() + "\ninterest: " + this.interest;
    }

    /*equals method for the savings account class. */
    @Override 
    public boolean equals(Object obj){
        if (this == obj)                        return true;// check identity
        if (obj == null)                        return false;// null check
        if (!super.equals(obj))                 return false;//super check
        if (this.getClass() != obj.getClass())  return false;

        savingsAccount other = (savingsAccount) obj;        //type cast

        if (this.interest != other.interest)    return false;// check interest
                                                return true; // if no falut is foud return true
    }

    /*action method is to add interest to the accout balance  */
    @Override// since the method exist and is inhereted, we must override the inhereted method
    public void Action(){
        addInterest();          // calls the method in this class
        System.out.println(this);// now print it to confirm the made change
    }
}
