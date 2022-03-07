import java.lang.Math;
public class Fraction {
    
    

    
    private int numerator;
    private int denominator;  

   /* in the fraction method, a numerator and denominator are 
      given and are assigned their value
   */
    
    public Fraction(int numerator, int denominator){
        setNumerator(numerator);
        setDenominator(denominator); 
    }
    /* this method is the same as the first except it onlt takes
       the numerator and makes it a fraction
    */
    public Fraction(int numerator){
        setNumerator(numerator);
        this.denominator = 1;
    }
    /* this method will set the numerator value. this is public so it can 
       change the value from out side the program
     */
    public void setNumerator(int numerator){       
        this.numerator=numerator;
        
    }
    /* this method sets the value of the denominator. the value of the denominator 
       cannot be negative. this is public so the value of the denominator can be changed 
       from out side the program */
    public void setDenominator(int denominator){
        if(denominator<0){ // if the denominator is negative 
            denominator *= -1;// make the denominator positive
            this.numerator *=-1;//... and make the numerator negative
        }
        this.denominator=denominator;
        
    }
    /* this method returns the value of the denominator. probably going to be used by
       another file in the same folder*/
    public int getDenominator(){
        return this.denominator;
    }
    /* this function allows the user from other files within the folder to see  the 
      numerator value by retunring the value*/
    public int getNumerator(){
        return this.numerator;
    }
    /* this method is to present our fraction in a nice format. retuns a string of the
    fraction*/
    public String toString(){
        this.reduce();
        String string = this.numerator+"/"+this.denominator;
        return string;
    }
    /* this method returns true if the fraction are equal or false if they are not equal*/
    public boolean equals(Fraction fraction){
        this.reduce();
        fraction.reduce();
        if (this.numerator==fraction.numerator && this.denominator==fraction.denominator){
            return true;// true if the numerator and denominator of both fractions are equal
        }
        else{
            return false;
        }
    }
    /* this returns 1 if this fraction is greater, 0 if this this fraction is equal
       to or -1 if this fraction is less than the argument*/
    public int compareTo(Fraction fraction){
        double frac1 = this.numerator/this.denominator;// just using double to compare values...its faster
        double frac2 = fraction.numerator/fraction.denominator;
        int num;// create the variable
        if (frac1 > frac2) num = 1;
        else if (frac1 == frac2) num = 0; 
        else num = -1;        
        return num;  
    }
    /*this method will return the greatest common factor of two numbers. while the
      the number is less than both numbers..if the number goes into both nnumbers evenly 
      it is the new gcd.  */
    private int gcd(int denom, int otherDenom){
        denom = Math.abs(denom);
        otherDenom = Math.abs(otherDenom);
        int num = 1;
        int gcd = num;        
        while (num<=denom && num<=otherDenom){
            if ((denom%num==0)&&(otherDenom%num==0)) gcd = num;
            num+=1;
        }        
        return gcd;
    }
    /*this method will return the lowest common multiple of the two
       arguments. just gave the num a value of the denominator to skip the 
       the first few numbers. while the number is not evenly dividible by both 
       the denominator and numerator add one to the num. as soon as the first 
       number that the denominator and numerator both go into is found, return 
       that num. made this myself   */
    private int lcm(int denom,int otherDenom){
        denom = Math.abs(denom);
        otherDenom = Math.abs(otherDenom);

        int num = denom;                                        
        while(!(num%denom==0 && num%otherDenom==0) ){
            num+=1;
        }
        return num ;                    
    }
    /*this function will reduce 'this' fraction. using the gcd function(HA!) we can
      divide the numerator and denominato by the gcd() to get a reduced fraction */
    private void reduce(){
        int gcd = gcd(this.denominator,this.numerator);
        this.denominator = this.denominator/gcd;
        this.numerator = this.numerator/gcd;       
    }
    /*add() will add the argument to this fraction. first the common demoninator 
      is found by using the lcm. then multiply numertors by the lcm and then add
      after that the denominator is multiplied by the lcm to and then reduce */
    public void add(Fraction fraction){
        int lcm = lcm(this.denominator, fraction.denominator);
        int num1 = lcm/this.denominator;
        int num2 = lcm/fraction.denominator;
        this.numerator *= num1;
        this.denominator *= num1;
        fraction.numerator *= num2;
        fraction.denominator *= num2; 
        this.numerator = this.numerator +fraction.numerator;
        this.reduce();
    }
    /* subtract will subtract the argument from this fraction.first the common demoninator 
      is found by using the lcm. then multiply numertors by the lcm and then subtract
      after that the denominator is multiplied by the lcm to and then reduce */
    public void subtract(Fraction fraction){
        int lcm = lcm(this.denominator, fraction.denominator);
        int num1 = lcm/this.denominator;
        int num2 = lcm/fraction.denominator;
        this.numerator *= num1;// num1 = number to multiply this by to get common denominator as the other
        this.denominator *= num1;
        fraction.numerator *= num2;// num2 is number to multiply fraction by to get common denominator
        fraction.denominator *= num2; 
        this.numerator = this.numerator - fraction.numerator;// because there is a common denominator we can add 
        this.reduce();
    }
    /* multiply will multiply this fraction by the argument. simple enough to follow  */
    public void multiply(Fraction fraction){
        this.numerator *= fraction.numerator;
        this.denominator *= fraction.denominator;
        this.reduce();
        setDenominator(this.denominator);// convert the denominator to positive if needed
    }
    /*divide will divide the argument from this fraction. since it is division, 
       the this.numerator is multiplied by the denominator and this.denominator is
       multiplied by numerator. see 5th grade math book for more details on fraction
       multiplication and division*/
    public void divide(Fraction fraction){
        this.numerator *= fraction.denominator;
        this.denominator *= fraction.numerator;
        this.reduce();
        setDenominator(this.denominator);
    }
    
    
}
