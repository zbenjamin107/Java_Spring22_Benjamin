import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        Shape s1 = new Circle(5.5, "red", false); 
        System.out.println(s1); // which version?
        System.out.println(s1.getArea()); // which version?
        System.out.println(s1.getPerimeter()); // which version?
        System.out.println(s1.getColor());
        System.out.println(s1.isFilled());
        //System.out.println(s1.getRadius()); get radius is not defined for type shape. if it was lable type circle, instead of shape it would work 
                
        Circle c1 = (Circle)s1; // down cast 
        System.out.println(c1);
        System.out.println(c1.getArea());
        System.out.println(c1.getPerimeter());
        System.out.println(c1.getColor());
        System.out.println(c1.isFilled());
        System.out.println(c1.getRadius());
        
        //Shape s2 = new Shape(); cannot create a shape since it is an abstract class. a  shape can only be created through a subclass
        
        Shape s3 = new Rectangle(1.0, 2.0, "red", false); // Upcast
        System.out.println(s3);
        System.out.println(s3.getArea());
        System.out.println(s3.getPerimeter());
        System.out.println(s3.getColor());
        //System.out.println(s3.getLength()); since it is type shape it cannot call getlength since it is labeled shape. it is not defined in class shape
        
        Rectangle r1 = (Rectangle)s3; // downcast
        System.out.println(r1);
        System.out.println(r1.getArea());
        System.out.println(r1.getColor());
        System.out.println(r1.getLength());
        
        Shape s4 = new Square(6.6); // Upcast
        System.out.println(s4);
        System.out.println(s4.getArea());
        System.out.println(s4.getColor());
        //System.out.println(s4.getSide()); again.. not defined for type shape. shape could be a circle. if type is lable square it would work
        Rectangle r2 = (Rectangle)s4;
        System.out.println(r2);
        System.out.println(r2.getArea());
        System.out.println(r2.getColor());
        //System.out.println(r2.getSide()); this is closer but still not there. getside is not defined for type rectangle. it is in class square
        System.out.println(r2.getLength());
        
        // Downcast Rectangle r2 to Square
        Square sq1 = (Square)r2;
        System.out.println(sq1);
        System.out.println(sq1.getArea());
        System.out.println(sq1.getColor());
        System.out.println(sq1.getSide());
        System.out.println(sq1.getLength());

        Shape s2 = new Triangle(5,10);
        Shape s5 = new SemiCircle(5);

        ArrayList<Shape> shapes = new ArrayList<Shape>();
        shapes.add(s1);
        shapes.add(s2);// this one can easily be added since it is a shape, subclasses can be added
        shapes.add(s3);
        shapes.add(s4);
        shapes.add(s5);// also easily 
        // plymorphism will just call get area like normal on the two new subclasses and java will know which call to use based on which class its from
        System.out.println("largest shape in shapes: \n" + findLargest(shapes));
    }

    /*this funtion is going to loop through an array and return tha shape that has the largest area */
    public static Shape findLargest( ArrayList< Shape > shapes){
        Double largestArea = 0.0;
        Shape largest = new Rectangle();// couldnt make a new shape so i just made it a rectangle
        for (Shape shape: shapes){
            if (shape.getArea() > largestArea){
                largestArea = shape.getArea();
                largest = shape;
            }
        }
        return largest;
    }
}
