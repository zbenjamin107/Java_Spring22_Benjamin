public class MovablePoint extends Point {
    float xSpeed;
    float ySpeed;

    /*Movable point constuctor with zero arguments passed */
    public MovablePoint(){
        super(0,0);     // creates a point at 0,0 from the super class point
        this.xSpeed = 0;// sets the speed of the x coordinate as 0
        this.ySpeed = 0;// sets the speed of the y coordinate as 0 
    }

    /*movable point costructor that accepts arguments */
    public MovablePoint(float xSpeed, float ySpeed){
        super(0,0);
        this.xSpeed = xSpeed; 
        this.ySpeed = ySpeed;
    }

    /*movable point constructor that accepts coordinates and x and y speed */
    public MovablePoint(int x, int y, float xSpeed, float ySpeed){
        super(x,y);// calls constructor from class point
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    /*movable point constructor that accepts an XY or Point, xSpeed and ySpeed */
    public MovablePoint(Point point, float xSpeed, float ySpeed){
        super(point);// calls the constructor from class point 
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    /* setX speed sets the speed of x by passing the argument */
    public void setXSpeed(float xSpeed){
        this.xSpeed = xSpeed;
    }

    /*setYSpeed will set the speed to the argument passed for the y speed */
    public void setYSpeed(float ySpeed){
        this.ySpeed = ySpeed;
    }

    /*SetXYSpeed will set the x and y speed for the movable point */
    public void setSpeeds(float xSpeed, float ySpeed){
        setYSpeed(ySpeed);
        setXSpeed(xSpeed);
    }

    /*Move() will move the x and y coordinate acording to their associated speed. when move is called 
      x will equal x+xSpeed  */
    public void move(){
        int x = getX(); // call from super/base class
        int y = getY();
        setXSpeed(x + getXSpeed());// new speed is xSpeed + x coordinarte
        setYSpeed(y + getYSpeed());// same with ySpeed
    }
    /*getXSpeed returns the speed in the x direction. */
    public float getXSpeed() {
        return xSpeed;
    }
 
    /*getYSpeed will return the speed of in the y direction  */
    public float getYSpeed() {
        return ySpeed;
    }


    /*get speeds will return an array of the speeds. [xSpeed, ySpeed] */
    public float[] getSpeeds(){
        float[] array = new float[2];// create the array
        array[0] = getXSpeed();      // set first index as x speed
        array[1] = getYSpeed();      // set second index as y speed
        return array;
    }

    /* toString method to return a nicely formatted string of the movablePoint*/
    @Override
    public String toString(){
        float[] speeds = getSpeeds();
        float xSpeed = speeds[0];
        float ySpeed = speeds[1];
       
        String s = super.toString() + ": speed: [" + xSpeed + "," + ySpeed + "]";
        return s;
    }

    /* compares a two movable points. calls the super classes equals method to make sure the coordinates are 
    the same as well */
    @Override
    public boolean equals(Object other){
        if (other == null)                  return false;// null
        if(!super.equals(other))            return false;// call to base class
        if (getClass() != other.getClass()) return false;// class check

        MovablePoint otherObj = (MovablePoint) other;   // if class check passes then we can type cast
        if (otherObj.getXSpeed() != this.getXSpeed()) return false;// check the speeds(x and y direction)
        if (otherObj.getYSpeed() != this.getYSpeed()) return false;
        return true;
    }

}
