public class Circle extends Shape {
    protected double radius = 1.0;

    /*no argument constructor */
    public Circle(){}

    /*constructor with a radius passed as an argument */
    public Circle(double radius) {
        // call super() is hidden from our eyes here
        this.radius = radius;
    }

    /*ocerloaded constructor  */
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);// call to super constructor
        this.radius = radius;
    }

   /*return the radius of a circle */
   public double getRadius(){
       return this.radius;  
   }

   /*takes a double to set as the radius for a circle */
   public void setRadius(double rad){
       this.radius = rad;
   }
   
    /*get area is an overrides an abstract method. it is also required in this class for that reason
    formula for area of a circle: a = pi * r^2      */
    @Override
    public double getArea(){
        double r = this.radius;     // radius
        double a = Math.PI * r * r; // area
        return a;// i could have made this one big line but 3 is asier to read
    }

    /**get perimeter will return a double. the perimeter, better known as the circumference, is the 
      measurement around the shape defined 2PI * r          */
    @Override
    public double getPerimeter(){
        return 2 * Math.PI * this.radius;
    }

    /*toString method for the circle class. returns a string that calls the super toString and adds 
      the radius to the mix*/
    @Override
    public String toString(){
        return super.toString() + "radius: " + this.radius + "\n";
    }

    /*equals method check each characteristic of both shapes. private instances in shape have default 
      values as well as circle wich means there is no need for null check. the constructor will set values
      if none are provided */
    @Override
    public boolean equals(Object obj){
        if (this == obj)                        return true;// idenity 
        if (!super.equals(obj))                 return false;// check in super class
        if (this.getClass() != obj.getClass())  return false;// class

        Circle other = (Circle) obj;            // type cast is safe after class check passes

        if (this.radius != other.radius)        return false;// radius check
                                                return true;// if all passes then return true
    }  
}
