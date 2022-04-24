/**
   A class for bank accounts.

   This class provides the basic functionality of accounts.
   It allows deposits and withdrawals but not overdraft
   limits or interest rates.   

   @author Ken Whitener 2021
*/

public class Account
{
	private Customer	owner;			// the owner of the account
	private Employee	accountManager;	// the manager of the account
	private Date		dateCreated; 	// date the account was created
	private int 		accountNumber;  // The account number
    private double 		balance;  		// The current balance
    
	/**
	 * 
	 * @param accountNumber
	 * @param manager
	 */
	public Account(int accountNumber, Customer owner, Date created, double balance){
		this.accountNumber 	= accountNumber;
		this.owner 			= new Customer(owner);
		this.dateCreated 	= new Date(created);
		this.balance		= balance;
	}

	/**
	 * 
	 * @param accountNumber
	 * @param manager
	 * @param owner
	 * @param created
	 */
	public Account(int accountNumber, Employee manager, Customer owner, Date created){
		this(accountNumber, owner, created, 0);
		this.accountManager = new Employee(manager);
	}
    
	/**
	 * 
	 * @param sum
	 */
    public void deposit(double sum){
		if (sum > 0) 	this.balance += sum;    
		else 			System.err.println("Account.deposit(...): cannot deposit negative amount.");    
    }
    
	/**
	 * 
	 * @param sum
	 */
    public void withdraw(double sum){
		if (sum > 0) 	this.balance -= sum;    
		else			System.err.println("Account.withdraw(...): cannot withdraw negative amount.");    
    }

	public void transferTo(Account otherAccount, double amount){
		if(this.owner.equals(otherAccount.owner) && amount < this.balance)
			otherAccount.deposit(amount);
	}
    
	/**
	 * 
	 * @return the current balance
	 */
    public double getBalance(){
		return this.balance;
    }

	public void setBalance(double balance){
		this.balance = balance;
	}
    
	/**
	 * 
	 * @return the account number
	 */
    public int getAccountNumber(){
		return this.accountNumber;
    }

	/**
	 * 
	 * @param manager
	 */
	public void setManager(Employee manager){
		this.accountManager = new Employee(manager);
	}

	/**
	 * 
	 * @return The account manager for this account
	 */
	public Employee getManager(){
		return new Employee(this.accountManager);
	}

	/**
	 * 
	 * @return The date the account was created
	 */
	public Date getDateCreated(){
		return new Date(dateCreated);
	}

	/**
	 * 
	 * @return The account owner
	 */
	public Customer getCustomer(){
		return new Customer(this.owner);
	}


	@Override
	public String toString() {
		return 	"Account Number: " 	+ accountNumber + 
				"\nOpened: "		+ dateCreated   +		// calls Date.toString
				"\nOwner "			+ owner 		+ 		// calls Customer.toString
				"\nManager: "  		+ accountManager+		// calls Employee.toString
				"\nBalance: " 		+ balance;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)					return true;
		if (obj == null)					return false;
		if (getClass() != obj.getClass())	return false;

		Account other = (Account) obj;

		if (accountManager == null) {
			if (other.accountManager != null)
				return false;
		} else if (!accountManager.equals(other.accountManager))
			return false;
		if (accountNumber != other.accountNumber)
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		return true;
	}  

	/*action method will be called from the driver. in this class all it does is call to string. in the 
	  subclasses the action method is overriden and does something els */
	public void Action(){
		System.out.println(this);// call to string
	}
}
