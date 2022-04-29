public abstract class Shape {
    
    protected String color = "red";     // protected is makes it accesible to the subclasses
    protected boolean filled = true;   

    /**no argumetn constructor for the shape class */
    public Shape(){}

    /*overloaded constructor with values to pass for color and filled status */
    public Shape(String color, boolean filled){
        this.color = color;
        this.filled = filled;
    }

    //shouldnt need a copy constructor since this class is marked as abstract; i cant have a shape unless called from subclass

    /*method to get the color. returns shape color(String)  */
    public String getColor() {
        return color;
    }

    /*method to set color. takes a color(string) as argumetn and sets it */
    public void setColor(String color) {
        this.color = color;
    }

    /* also could have named this isFilled(). returns a boolean. is it filled?*/
    public boolean isFilled() {
        return filled;
    }

    /*sets if its filled. takes boolean as argument */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /*toString method for the shape class */
    @Override
    public String toString() {
        return "Shape color: " + color + "\nis it filled? " + filled + "\n";
    }
    
    /*abstract method getArea() is used to force the subclasses to have this method. at this 
    level the method does nothing since shape instances connot be created without super call */
    public abstract double getArea();

    /*abstract method getPerimeter() requres all the sub-class to have the same method. the mehtod 
    in this class does nothing since a shape instance connot be constructed without a call from a sub 
    class constructor */
    public abstract double getPerimeter();
    
    /*equalse method for the class shape */
    @Override
    public boolean equals(Object obj){
        //if (obj == null)  return false;// no need to check if its null because of default values 
        
        if (this == obj)                        return true;// identity check
        if (this.getClass() != obj.getClass())  return false;// class check

        Shape other = (Shape) obj;              // type cast

        if (this.color != other.color)          return false;// color check
        if (this.filled != other.filled)        return false;// filled check. default is false; no need for null check 
                                                return true;// everything passed!                         
    }

}