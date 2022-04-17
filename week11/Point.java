public class Point{
    private int x;// x coordinate instance 
    private int y;// y coordinate instance
    
    //Note that the coodinates are also going to be used directly to get the distance of points 
    /*Point constructor will create a point at (x=0,y=0) */
    public Point(){
        setX(0); // using each setters for x and y
        setY(0); 
    }

    /* Point constructor will create a point at the given x,y coordinate */
    public Point(int x, int y){
        setXY(x,y);// using setter for both x and y 
    }

    /*this constructor is going to be used to generate a copy of the point to prevent privacy leaks. 
    takes the values of x and y from the other point ans assigns the value to this x and y  */
    public Point(Point otherPoint){
        this.x = otherPoint.x;// could also use setX(other.x)
        this.y = otherPoint.y;
    }

    /* generated getX method that returns the x coordinate */
    public int getX() {
        return x;
    }

    /*SetX method takes an int and sets its value as the new x coordinate */
    public void setX(int x) {
        this.x = x;
    }

    /* this getY method will return the integer value of the y coordinate  */
    public int getY() {
        return y;
    }

    /*this setY method will accept an integer and set that value as the new y coordinate  */
    public void setY(int y) {
        this.y = y;
    }

    /* setter method that will set the x and y coordinat at the same time, at least in the same method */
    public void setXY(int x, int y){
        setX(x); // using setters to set x and y 
        setY(y);    
    }

    /* returns an array containing the x and y coordinate */
    public int[] getXY(){
        int[] array = new int[10];
        array[0] = getX();// getting x using a getter. same as this.getX()
        array[1] = this.y;// getting y using composition
        return array; 


    }

    /*converts the point into a string by returning (x,y) formated nicely*/
    @Override
    public String toString(){
        int x = getX();
        int y = getY();
        String s = "Point Coordinate: (" + x + "," + y + ")";
        return s;

    }

    /*method that returns the distance between this point and the given coordinates. 
    √ [ (x₂ - x₁)² + (y₂ - y₁)² ]*/ 
    public double distance(int x1, int y1){
        double c = Math.sqrt(Math.pow((x1-this.x),2) + Math.pow((y1-this.y),2));
        return c;   
    }

    /*overloaded constructor that returns the distance from this point to the given point
    √ [ (x₂ - x₁)² + (y₂ - y₁)²*/
    public double distance(Point point){
        int x1 = point.getX();
        int y1 = point.getY();
        double c = Math.sqrt(Math.pow((this.x-x1),2) + Math.pow((this.y-y1),2));
        return c;
    }

    /* overloaded constructor that returns the distance from this point to the orgin. used pythagrean theory
    √ [ (x₁)² + ( y₁)²*/
    public double distance(){
        double c = Math.sqrt(Math.pow((this.x),2) + Math.pow((this.y),2));
        return c;
    }


    /*equals method to test if the two points are equals */
    @Override
    public boolean equals(Object other){
        if (other == null)                  return false;//null check 
        if ( getClass() != other.getClass())return false;// class check

        Point otherObj = (Point) other;                  // change class 

        if (getX() != otherObj.getX()) return false;     // check x coordinate
        if (getY() != otherObj.getY()) return false;     // check y coordinate
        return true;                                     // return true if all passes
    }

    
}