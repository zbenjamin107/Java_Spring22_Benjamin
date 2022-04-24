public class Person{

	private String 	firstName	= "unkown";
	private String 	lastName	= "unkown";
	private String 	phoneNumber	= "0000000000";
	private Date	DOB			= new Date();

	public Person(){}

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 */
	public Person(String firstName, String lastName) {
		this.firstName  = firstName;
		this.lastName   = lastName;
	}

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 */
	public Person(String firstName, String lastName, String phoneNumber) {
		this(firstName, lastName);
		this.setPhoneNumber(phoneNumber);
	}

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 * @param DOB
	 */
	public Person(String firstName, String lastName, String phoneNumber, Date DOB) {
		this(firstName, lastName);
		this.setPhoneNumber(phoneNumber);
		this.setDOB(DOB);
	}

	/**
	 * Copy Constructor
	 * @param toCopy Person object to copy
	 */
	public Person(Person toCopy){
		// uses "this" to call constructor in the same class
		this(toCopy.firstName, toCopy.lastName, toCopy.phoneNumber, toCopy.DOB);
	}

	/**
	 * 
	 * @param DOB
	 */
	public void setDOB(Date DOB){
		this.DOB = new Date(DOB);
	}

	/**
	 * 
	 * @return The Person's Date of Birth
	 */
	public Date getDOB(){
		return new Date(this.DOB);
	}

	/**
	 * 
	 * @return Person's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * 
	 * @return Person's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * 
	 * @return Person's full name
	 */
	public String getName(){
		return this.firstName + " " + this.lastName;
	}

	/**
	 * 
	 * @return Person's formatted phone number
	 */
	public String getPhoneNumber() {
		if (phoneNumber!= null){// added this to prevent null pointer exception
			String area     = phoneNumber.substring(0, 3);// null pointer if phonNumber does not exist
			String prefix   = phoneNumber.substring(3, 6);
			String route    = phoneNumber.substring(6);
			return "(" + area + ")" + prefix + "-" + route;
		}
		else return phoneNumber;// in case of null pointer just return null instead of crashing the system
	}

	/**
	 * 
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		if(phoneNumber.length() == 10)
			this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return  "Name: " 	+ firstName + " " + lastName + "\n" +
				"Phone: " 	+ getPhoneNumber() +// possible null pointer exception in this method
				"\nDOB: " 	+ DOB + "\n";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)    return true;					// identity check
		if (obj == null)    return false;					// null check
		if (getClass() != obj.getClass())   return false;	// origin check

		Person other = (Person) obj;						// down cast

		// check each field, be mindful of null pointers
		if (firstName == null){
			if (other.firstName != null)
				return false;
		}
		else if (!firstName.equals(other.firstName))
			return false;

		if (lastName == null){
			if (other.lastName != null)
				return false;
		}
		else if (!lastName.equals(other.lastName))
			return false;

		if (phoneNumber == null){
			if (other.phoneNumber != null)
				return false;
		}
		else if (!phoneNumber.equals(other.phoneNumber))
			return false;

		if (DOB == null){
			if (other.DOB != null)
				return false;
		}
		else if (!DOB.equals(other.DOB))
			return false;

		return true;
	}
}