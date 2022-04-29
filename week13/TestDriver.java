import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.Test;
//import org.junit.jupiter.api.BeforeEach;

public class TestDriver {

    @Test
    public void TestFindLargest(){
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        shapes.add(new Circle(5.5));               //95
        shapes.add(new Rectangle(5,7));     //35
        shapes.add(new Rectangle(1.0, 2.0));//2
        shapes.add(new Square(6));                  //36
        shapes.add(new Circle(6));                //113
        shapes.add(new Square(10));                 //100
        shapes.add(new Triangle(20,10));// 100
        shapes.add(new SemiCircle(5));

        Shape largest = Driver.findLargest(shapes);
        assertTrue(largest.equals(new Circle(6)));
    }
}
