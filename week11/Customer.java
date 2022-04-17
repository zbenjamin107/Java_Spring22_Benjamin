public class Customer {

    // ================================
    // || Private instance variables ||
    // ================================
    private String name;
    private String email;
    private String phone;

    // ==================
    // || Constructors ||
    // ==================

    // no argument constructor
    public Customer(){
        this.name   = "unknown";
        this.email  = "unknown";
        this.phone  = "unknown";
    }
    
    public Customer(Customer customer){
        this.name = customer.name;
        this.email = customer.email;
        this.phone = customer.phone;
    }

    // overloaded constructor
    public Customer(String name, String email, String phone){
        // call the set methods because that is where the domain
        // validation will be. No need to define it twice
        this.setName(name);
        this.setEmail(email);
        this.setPhone(phone);
    }

    // =============================
    // || "GETTERS" and "SETTERS" ||
    // =============================

    /**
     * Returns the name field
     * @return name (String)
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the customer's name
     * @param name The Customer's name
     */
    public void setName(String name) {
        if(name != null)
            this.name = name;
    }

    /**
     * 
     * @return email (String) The Customer's email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets and validates the Customer's email address
     * @param email
     */
    public void setEmail(String email) {
        // This logic does not validate every single requirement
        // for a real email address. Just the ones listed in the lab.
        // Validates explicitly without any fancy, magical, mysterious
        // Regular Expressions <= check it out, I know some of you have
        // It's also fun and good practice to write explicit logic . . .
        // especially while learning :)
        
        if(email == null) return;   // fail fastest

        int NOT_FOUND       = -1;   // reader friendly code symbols
        int PREFIX_LENGTH   = 64;

        int at_location = email.indexOf("@");       // find the "@"
        if(at_location == NOT_FOUND)       return;  // no '@' in email
        if(at_location > PREFIX_LENGTH)    return;  // prefix too long
        if(at_location == 0)               return;  // "@" is first symbol
        
        int dot_index = email.indexOf(".");
        if(at_location > dot_index) return;
        

        String prefix = email.substring(0, at_location); // deal with the prefix
        String domain = email.substring(at_location+1, email.length());

        if(domain.contains("@")) return;            // @ in domain name
        
        // dot restrictions. Can't be first or last character in prefix
        if('.' == prefix.charAt(0) || '.' == prefix.charAt(prefix.length() - 1))
            return;

        // are there any consecutive dots in the prefix?
        for(int index = 0; index < at_location - 1; ++index)
            if(prefix.charAt(index) == '.' && prefix.charAt(index + 1) == '.')
                return;

        // validate the prefix characters
        String emailCharacterSet = this.emailCharacterSet();
        for(int index = 0; index < prefix.length(); ++ index)
            // is there are prefix character NOT IN the character set?
            if(emailCharacterSet.contains(prefix.charAt(index) + ""))
                return;

        this.email = email; // PHEW, safe at last (I hope) Someone else has to test this
    }

    /**
     * 
     * @return phone (String) The Customer's phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets and validates the Customer's phone number
     * @param phone
     */
    public void setPhone(String phone) {
        // fail first, fail fast
        if(phone == null)           return;
        if(phone.length() != 10)    return;

        // is each character a digit?
        // could also try/catch a parse to Long. Why not int?
        for(int index = 0; index < phone.length(); ++index)
            if(!Character.isDigit(phone.charAt(index)))
                return;

        this.phone = phone; // no other option but it being valid
    }
    
    // ======================
    // || Expected Methods ||
    // ======================

    public String toString(){
        return  this.name   + "\n" +
                this.email  + "\n" +
                this.phone;
    }

    public boolean equals(Customer other) {
        if (this == other)  return true;    // identity check
        if (other == null)  return false;   // argument is null, can't be equal

        // Collection of fail first, fail fast conditions
        if (email == null)                  // email, with null checks
            if (other.email != null)
                return false;
        else if (!email.equals(other.email))// call String class equals
            return false;

        if (name == null)                   // name, with null checks               
            if (other.name != null)
                return false;
        else if (!name.equals(other.name))  // call String class equals
            return false;

        if (phone == null)                  // phone, with null checks
            if (other.phone != null)
                return false;
        else if (!phone.equals(other.phone))
            return false;

        return true; // all Fail conditions are false. Guaranteed equality
    }

    // ======================
    // || Private Helpers  ||
    // ======================
    private String emailCharacterSet(){
        StringBuilder sb = new StringBuilder();
        String special_characters = "#!%$'&+*-/=?^_`.{|}~";

        // build alphabet
        for(int ascii = (int)'A'; ascii < (int)'Z'; ++ascii)
            sb.append((char)ascii);
        // add special characters 
        sb.append(special_characters);

        return sb.toString();
    }
     
    public int compareTo(Customer person){
        int num;
        
        String[] thisNames = this.name.split(" ");
        String[] names = person.name.split(" ");
        String lastName1 = thisNames[1];
        String lastName2 = names[1];
        num = lastName1.compareTo(lastName2);
        if (num<0) return 1; 
        if (num==0)return 0; 
        else return  -1; 
        

    }
    
}


