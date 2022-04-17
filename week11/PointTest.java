import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class PointTest {
    int x = 5;
    int y = x;
    Point point = new Point(-5,10);
    
    /* test that the set method actually sets the x value of point*/
    @Test
    public void testSetX(){
        point.setX(x);// x is 5 
        assertEquals(point.getX(), 5);// 5 should equall x
    }

    /*getX() should return x */
    @Test
    public void testGetX(){
        int x1 = point.getX();
        assertEquals(x1,-5);
    }

    /* test that the set method actually sets the y value of point*/
    @Test
    public void testSetY(){
        point.setY(y);// x is 5 
        assertEquals(point.getY(), 5);// 5 should equall x
    }

    /*getY() should return y. test to see the return results*/
    @Test
    public void testGetY(){
        int y = point.getY();
        assertEquals(y, 10);
    }

    /*test the getXY method by calling the method and comparing the results  */
    @Test
    public void testGetXY(){
        int[] xy = point.getXY();// call method to test
        int x = xy[0];// get x by looking at the call methods retunr
        int y = xy[1];// get y 
        assertEquals(y,10);// check x
        assertEquals(x,-5);// check y 
    }

    /*setXY method will test that the x and y values are set to the argument provided */
    @Test
    public void TestSetXY(){
        point.setXY(5,5);
        int x = point.getX();
        int y = point.getY();
        assertEquals(5,x);
        assertEquals(5,y);
    }

    /*test toString for point type*/
    @Test 
    public void TestToString(){
        int x = point.getX();
        int y = point.getY();
        String s = "Coordinate: (" + x + "," + y + ")";
        String str = point.toString();
        assertEquals(s,str);
    }

    /*test that the distance method returns the proper  */
    @Test
    public void TestDistance(){
        int x1 = 0;
        int y1 = 0;
        Point point1 = new Point(3,4);// create a point to compare to 
        double d = point1.distance(x1,y1);// should be like finding c if a= 3, b= 4, c would equal 5...pythagean triple
        assertTrue(d==5);
    }
    /*test that the overloaded distance method works */
    @Test
    public void TestDistance2(){
        Point point2 = new Point();         // make the origin a point
        Point point1 = new Point(3,4);      
        double d = point1.distance(point2);// compare the distance from the orgin to 
        assertTrue(d==5);
    }

    /**test another overloaded distance method */
    @Test
    public void TestDistance3(){
        Point point1 = new Point(3,4);      
        double d = point1.distance();// compare the distance from the orgin since there is no argument
        assertTrue(d==5);           // should be 5. 
    }

    /*test that the equals operator for class point is accurate */
    @Test
    public void testEquals(){
        Point point1 = new Point(1,2);  // create a point instance
        Point copy1 = new Point(point1);// create a copy. should still be equals based off method
        Point point2 = new Point(2,1);  // another instance to compare to
        Point point3 = new Point(-1,2); // yet another instance

        assertTrue(point1.equals(copy1));  // check that the compare equalse methods are accurate
        assertFalse(point1.equals(point2));
        assertFalse(point1.equals(point3));
    }


}
