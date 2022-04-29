public class Rectangle extends Shape {
    protected double width = 1; // keyword 'protected' allow subclasses to see this info
    protected double length = 1;

    /*sets default values -> color:"red", filled: true, width: 1.0, length: 1.0 */
    public Rectangle(){}

    /*takes argumetns for the overloaded constructor. hidden call super() that we cant see in there  */
    public Rectangle(double width, double length){ 
        this.length = length;
        this.width = width;
    }

    /*another overloaded consructor that gives arguments to pass in the super class. forced to write
     out super this time since there are argumetns for that class */
    public Rectangle(double width, double length, String color, boolean filled){
        super(color,filled);
        this.length = length;
        this.width = width;
    }

    /*get width method will return a double  */
    public double getWidth(){
        return this.width;
    }

    /*set width takes the argument and sets the width  */
    public void setWidth(double w){
        this.width = w;
    }

    /*get length returns the length of this rectangle */
    public double getLength() {
        return length;
    }

    /*set length sets the double passed as an argument  */
    public void setLength(double length) {
        this.length = length;
    }

    /*get area is an overriden method that is required as a subclass of shape. A = LW */
    public double getArea(){
        return this.length * this.width;
    }

    /*get perimeter is an overrien method that is required as a subclass of shape. P = 2L + 2W */
    @Override
    public double getPerimeter(){
        return 2 * this.length  +  2 * this.width;
    }

    /*to string method for the rectangel class will call super classes to string method and include
      the width and the length of this rectangle */
    @Override
    public String toString(){
        return super.toString() + "Length: " + length + "\nWidth: " + width +"\n";
    }

    /*equals method for the rectangle class will make a call to the super class and check the side 
        and width */
    @Override
    public boolean equals(Object obj){
        if (this == obj)                        return true;//ngl idk how this works for shapes and rectangles
        if (!super.equals(obj))                 return false;// super check
        if (this.getClass() != obj.getClass())  return false;// class check

        Rectangle other = (Rectangle) obj;      // type cast deemed safe after the class check

        if (this.width != other.width)          return false;// width check
        if (this.length != other.length)        return false;// length check
                                                return true;// if all passes then return true
    }

    
}
