public class Customer extends Person {

    // ================================
    // || Private instance variables ||
    // ================================

    private Date dateJoined;
    private String custID;

    // ==================
    // || Constructors ||
    // ==================

    /* no argument constructor. calls to super with no arguments*/
    public Customer(){
        super();
        this.dateJoined = new Date();
        this.custID = "unknown";
    }

    /* overloaded constructor. consist of first name, last name, phone, DOB, date joined, and ID*/
    public Customer( String firstName, String lastName, String phone, Date DOB, Date dateJoined, String custID){
        super(firstName,lastName, phone, DOB);// call to super class 
        this.setDateJoined(dateJoined);       // set the date joined
        this.custID = custID;                 // assign ID to custID
    }

    /*overloaded constructor to accept a person, dateJoined and customerID*/
    public Customer(Person person, Date dateJoined, String custID){
        super(person);              // copt constructor from the base class
        setDateJoined(dateJoined);  // set the date joined
        setCustID(custID);          // set the ID
    }

    /*should be simple, but its not, instead of throwing everything in the super constructor i have
    to set each value because of get phone number. it returns (xxx)xxx-xxxx, i need xxxxxxxxxx. so 
    i work to get just the number because the called setter wont take it if it isnt exactly 10 in length*/
    public Customer(Customer toCopy){
        super();                                // create an instance
        setFirstName(toCopy.getFirstName());    // set f name
        setLastName(toCopy.getLastName());      // set l name
        setDOB(toCopy.getDOB());                // set DOB
        this.dateJoined = toCopy.dateJoined;    // date joined(non inherited)
        this.custID = toCopy.custID;            // cust id (non inherited)
        
        String p = toCopy.getPhoneNumber();// returns (xxx) xxx - xxxx
        String area = p.substring(1,4);
        String prefix = p.substring(5,8);
        String route = p.substring(9,13);
        setPhoneNumber(area+prefix+route);
    }

    // =============================
    // || "GETTERS" and "SETTERS" ||
    // =============================

    /*get customer id method. returns a string */
    public String getCustID(){
        return this.custID;
    }

    /*/set method for the customer id. takes a string*/
    public void setCustID(String ID){
        this.custID = ID;
    }

   /*method to set the date joined. accepts a date  */
   public void setDateJoined(Date date){
       this.dateJoined = new Date(date);
   }

   /*method that returns the date joined. returns a date */
   public Date getDateJoined(){
       return new Date(this.dateJoined);
   }

    
    
    // ======================
    // || Expected Methods ||
    // ======================

    /*creates a string from the customer class */
    @Override
    public String toString(){
        return  super.toString() +
                "ID: " + this.custID   + "\n"
              + "Date joined: " + this.dateJoined;
    }
    /*equals method that test if the if two objects are both customers with the same characteristics */
    @Override
    public boolean equals(Object object) {
        if (this == object)         return true;    // identity check
        if (object == null)         return false;   // argument is null, can't be equal
        if(!super.equals(object))   return false;   // call to super class

        if(this.getClass() != object.getClass()) return false;// test if the obj is of class customer..
        
        Customer other = (Customer) object;         //..so that we can type cast 

        if (dateJoined == null){                    // name, with null checks               
            if (other.dateJoined != null)
                return false;
        }
        else if (!dateJoined.equals(other.dateJoined))// call String class equals
            return false;

        if (custID == null){                    // phone, with null checks
            if (other.custID != null)
                return false;
        }
        else if (!custID.equals(other.custID))
            return false;

        return true; // all Fail conditions are false. Guaranteed equality
    }

    // ======================
    // || Private Helpers  ||
    // ======================
    
}


