import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.TestFactory;

public class MovablePointTest {
    float xSpeed = 5;
    float ySpeed = 7;

    MovablePoint mp = new MovablePoint(-2,-3,xSpeed, ySpeed);

    /*Test setxSpeed() fot the movablepoint class */
    @Test
    public void testSetXSpeed(){
        mp.setXSpeed(10);               // set the x speed from 5 to 10
        assertTrue(mp.getXSpeed()==10);// test that the x speed was set to 10
    }

    /*test setySpeed for the class movable point */
    @Test 
    public void testSetYSpeed(){
        mp.setYSpeed(20);               // set the y speed to 20
        assertTrue(mp.getYSpeed()==20); // test that the y speed was set to 20
    }
    
    /*test the setSpeeds method for the movable class. */
    @Test 
    public void testSetSpeeds(){
        mp.setSpeeds(0,1);              //set x and y speeds
        assertTrue(mp.getXSpeed()==0);  // test the x speed
        assertTrue(mp.getYSpeed()==1);  // test y speed
    }

    /*method move will take the x coordinate and add it to the x speed to get the final speed. same for y
      the y speed will be the current y speed plus the y coordinate */
    @Test
    public void testMove(){
        float oldXSpeed = mp.getXSpeed();   // get the original speed and coordinate for x and y 
        float oldYSpeed = mp.getYSpeed();
        int oldx = mp.getX();// inherited methods for x and y 
        int oldy = mp.getY();
        mp.move();
        assertTrue(mp.getXSpeed() == (oldXSpeed + oldx));// new speed is x + xSpeed
        assertTrue(mp.getYSpeed() == (oldy + oldYSpeed));// new speed is y + ySpeed
    }

    /*test the getXSpeed method */
    @Test 
    public void testGetXSpeed(){
        float x = mp.getXSpeed();
        assertTrue(x==5);
    }

    /*test the getYSpeed method  */
    @Test 
    public void testGetySpeed(){
        float y = mp.getYSpeed();
        assertTrue(y==7);
    }

    /*test the get speeds method */
    @Test
    public void testGetSpeeds(){
        float[] speeds = mp.getSpeeds();
        float x = speeds[0];// x = xSpeed
        float y = speeds[1];// y = ySpeed
        assertTrue(x==5);// make sure that the speed equals the returned speed
        assertTrue(y==7);
    }

    /*test the equals method */
    @Test
    public void testEquals(){                            // first create a series of movable point objects
        Point point = new Point(1,2);                   // create a point to create a movable point
        MovablePoint mp1 = new MovablePoint(0,0,3,4);
        MovablePoint mp2 = new MovablePoint(3,4);       //should be same as mp1 since coordinates will be set to 0,0
        MovablePoint mp3 = new MovablePoint(point,3,4); // use point to crate the movable point
        MovablePoint mp4 = new MovablePoint(1,2,3,4);
        MovablePoint mp5 = new MovablePoint(1,2,-3,-4);
        
        assertTrue(mp1.equals(mp2));// compare movable points with same characters
        assertTrue(mp3.equals(mp4));
        assertFalse(mp1.equals(mp4));// compare movable points with different characters
        assertFalse(mp4.equals(mp5));
    }
}
