public class Date{

    // Class Level Instance Variables
    private int month   = 1;
    private int day     = 1;
    private int year    = 1000;

    // static class variables
    public static final String[] months = { "January", "February", "March", "April",
                                            "May", "June", "July", "August",
                                            "September", "October", "November", "December"
                                          };

    public Date(){}                                 // no argument constructor

    public Date(int year){                          // constructor to accept just the year
        setYear(year);                              // call the set method containing validation
    }

    public Date(String Year){
        String[] i = Year.split("/");
        int month = Integer.parseInt(i[0]);
        int day = Integer.parseInt(i[1]);
        int year = Integer.parseInt(i[2]);
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    public Date(String month, int day, int year){   // constructor to accept month as String
        setMonth(month);                            // call overloaded setMonth(String)
        setDay(day);
        setYear(year);
    }

    public Date(int month, int day, int year){      // constructor with all ints
        setMonth(month);
        setDay(day);
        setYear(year);
    }

    // Copy Constructor. Use this to prevent prvacy leaks
    public Date(Date toClone){
        this(toClone.month, toClone.day, toClone.year);
    }

    // instance methods
    public void setMonth(int m){
        if(m >= 1 && m <= 12)                        // perform some domain validation
            this.month = m;
        else month = 1;
    } // end setMonth

    // overloaded setMonth
    public void setMonth(String month){
        int month_num = getMonthNumber(month);      // call helper method
        if(month_num > 0)                           // is it valid?
            this.month = month_num;                 // if so, set it. If not, leave it
    }

    public int getMonth(){
        return month;
    } // end getMonth

    public void setDay(int d){                      // naive day validation
        if(d >= 1 && d <= 31)
            this.day = d;
        else day = 1;
    } // end setDay

    public int getDay(){
        return day;
    } // end getDay

    public void setYear(int y){                     // 4 digit years
        if(y >= 1000 && y <= 9999)
            year = y;
        else year = 1000;
    } // end setYear

    public int getYear(){
        return year;
    } // end getYear

    // nicely formatted string
	@Override
    public String toString(){
        return month + "/" + day + "/" + year;
    }

    // deep comparison
	@Override
    public boolean equals(Object other){
		if( this == other )			return true;
		if( other == null )			return false;
		if( this.getClass() != other.getClass() ) return false;

		Date d = (Date)other;

        return  this.day    == d.day    &&
                this.month  == d.month  &&
                this.year   == d.year;
    }

    // method to determine ordering
    public int compareTo(Date otherDate){
        if(this.year < otherDate.year)      return -1;  // compare the year
        if(this.year > otherDate.year)      return  1;

        if(this.month < otherDate.month)    return -1;  // compare the month
        if(this.month > otherDate.month)    return  1;

        if(this.day < otherDate.day)        return -1;  // compare the day
        if(this.day > otherDate.day)        return  1;

        return 0;                                       // they must be equal   
    }

    // private helper method
    private int getMonthNumber(String month){ 
        for(int i = 0; i < months.length; ++i){    // loop through months array
            if(month.equalsIgnoreCase(months[i]))  // test for equality
                return i + 1;                      // found it, return index + 1
        }
        return 0;                                  // didn't find it, return 0
    }
} // end class

