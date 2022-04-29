public class Triangle extends Shape{
    double length = 1.0;
    double width = 1.0;

    /*no argumetn constructor */
    public Triangle(){}

    /*overloaded constructor for the triangle class */
    public Triangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    /*another overloaded method for the triangle class */
    public Triangle(String color, boolean filled, double length, double width) {
        super(color,filled);
        this.length = length;
        this.width = width;
    }

    /*returns a double. the length of the triangle is returned */
    public double getLength() {
        return length;
    }

    /*sets the length to the double that was provided as an argument */
    public void setLength(double length) {
        this.length = length;
    }

    /*returns a double. the wodth of the triangle is returned */
    public double getWidth() {
        return width;
    }

    /*takes a double as an argument and sets the width  */
    public void setWidth(double width) {
        this.width = width;
    }

    /*gets the area of the triangle. area is .5LW   */
    @Override
    public double getArea(){
        return .5 * this.length * this.width;
    }

    /*method that finds the perimeter of the triangle. perimeter of a triangle is l + w + c. c^2 = L^2 + W^2  */
    @Override
    public double getPerimeter(){
        return this.length + this.width + Math.sqrt(Math.pow(this.width,2) + Math.pow(this.length,2));
    }

    /*generated equals method */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)                return true;
        if (!super.equals(obj))         return false;
        if (getClass() != obj.getClass())return false;
        Triangle other = (Triangle) obj;
        if ((length) != (other.length)) return false;
        if ((width) !=(other.width))    return false;
                                        return true;
    }

    /*tostring method for the triangle class */
    @Override
    public String toString(){
        return super.toString() + "\nLength: " + length + "\nWidth: " + width + "\n";
    }

    

    
    

    
    
}
