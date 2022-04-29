public class SemiCircle extends Circle {

    public SemiCircle() {
    }

    public SemiCircle(double radius) {
        super(radius);
    }

    public SemiCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }

    /*get area is an overrides an abstract method. it is also required in this class for that reason
    formula for area of a circle: a = .5 * pi * r^2      */
    @Override
    public double getArea(){
        double r = this.radius;     // radius
        double a = .5 * Math.PI * r * r; // area
        return a;// i could have made this one big line but 3 is asier to read
    }

    /**get perimeter will return a double. the perimeter, better known as the circumference, is the 
      measurement around the shape defined PI * r + (diamater)         */
    @Override
    public double getPerimeter(){
        return   Math.PI * this.radius + (2 * this.radius);
    }
    
}
