import java.io.IOException;

/**
   A class for bank accounts.

   This class provides the basic functionality of accounts.
   It allows deposits and withdrawals but not overdraft
   limits or interest rates.   

   @author Ken Whitener 2021
*/

public abstract class Account implements Comparable<Account>
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
		try{setAccountNumber(accountNumber);}	//since this can now throw the exception it must be caught
		catch( InvalidAccountNumberException e){// and we know the exact exception that will take place
			System.out.println(e.getMessage());
		}

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
    public abstract void deposit(double sum) throws Exception; 
    
	/**
	 * 
	 * @param sum
	 */
    
	public abstract void withdraw(double sum) throws Exception ;

	public abstract double penalty();

	public void transferTo(Account otherAccount, double amount){
		if(this.owner.equals(otherAccount.owner) && amount < this.balance)
			try{
				otherAccount.deposit(amount);
			}
			catch( Exception e){	
			}
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

	/*set the account number. if the number is not 5 digits it will throw the exception. this will pretty
	much put the responsibility on the caller not the method  */
	public void setAccountNumber(int num) throws  InvalidAccountNumberException{
		String number = "" + num;// convert number to int for ease
		if (number.length() != 5) throw new  InvalidAccountNumberException(" Invalid Account Number. must be 5 in length. num passed:" + num);
		
		this.accountNumber = num;// if it isnt thrown then we can set it
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
	public void update(){}

	/*compare two accounts to each other. ordered alphabetically by last name and sub ordered by balance  */
	@Override
	public int compareTo(Account account){
	 	String thisName = this.getCustomer().getName();            // get the name of the customer
		String[] names = thisName.split(" ");               // get the names as an array
		char lInitial = names[1].charAt(0);                 // get the initial of the last name
	 
		String otherName = account.getCustomer().getName();       // get the name of the customer
		String[] otherNames = otherName.split(" ");         // get the names as an array
		char otherLInitial = otherNames[1].charAt(0);       // get the initial of the last name
		 
		if (lInitial < otherLInitial)                   return 1; // if the ord of this initial is less than(before) other initial return 1
		else if (lInitial > otherLInitial)              return -1;// if the ord of this initial is greater than(after) other initial return -1
																   // else their the same initials
		if (this.getBalance() > account.getBalance())   return 1; // if this account is greatere than other account return 1
		else                               return -1;             // if this acccount if less than other accout return -1
	 }
	public abstract void write() throws IOException;
}


