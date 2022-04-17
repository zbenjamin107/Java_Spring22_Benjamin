import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class Point3DTest {
    Point3D point3d = new Point3D();

    /*test getZ from the point3d class */
    @Test
    public void testGetZ(){
        int z = point3d.getZ();// get z, which is zero
        assertEquals(z,0);     // compare the returned z value to 0
    }

    /*test setZ in the point3d class */
    @Test
    public void testSetZ(){
        point3d.setZ(5);        // set z to 5
        int z = point3d.getZ(); // get z
        assertEquals(z,5);      // xonfirm that z was set to 5
    }

    /*test the method setXYZ from the point3d class */
    @Test
    public void testSetXYZ(){   
        point3d.setXYZ(1,2,3);  //set the xyz values
        int x = point3d.getX(); // get x
        int y = point3d.getY(); // get y
        int z = point3d.getZ(); // get z
        assertEquals(x,1);      // confirm x was properly set 
        assertEquals(y,2);      // confirm y was properly set
        assertEquals(z,3);      // confirm z was properly set
    }

    /**test the get xyz method */
    @Test
    public void testGetXYZ(){
        int[] xyz = point3d.getXYZ();// get xyz
        int x = xyz[0];     // get x
        int y = xyz[1];     //get y
        int z = xyz[2];     // get z
        assertEquals(x,0);  // compare the returned x to its expected value
        assertEquals(y,0);  // compare the returned y to the expected value
        assertEquals(z,0);  // compare the returned z to the expected value
    }

    /*test the equals method for the class point 3d */
    @Test
    public void testEquals(){// point3d = p3d
        Point3D p3d1 = new Point3D(1,2,3);
        Point3D p3d2 = new Point3D(-1,2,-3);
        Point3D p3d3 = new Point3D();       // values 0,0,0 by default
        Point3D p3d4 = new Point3D(0,0,0);  // should be same as p3d3

        assertTrue(p3d3.equals(p3d4));      // confirm the 3d points of same properties are equal
        assertFalse(p3d1.equals(p3d2));
        assertFalse(p3d1.equals(p3d3));
    }
}
