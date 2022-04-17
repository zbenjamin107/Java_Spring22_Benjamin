public class Driver {
    public static void main(String[] args) {
        
    
    int x = 4;          // instance of x coordinate 
    int y = 3;          // instance of y coordinate
    int z = 5;          // instance of z coordinate
   
    float xSpeed = 5;   // instance of x speed
    float ySpeed = 5;   // instance of y speed
    float xSpeed2 = 7;  // another instance of x speed
    float ySpeed2 = 7;  // another instance of y speed
    
    Point point1 = new Point();             // point constructor will set the coordinates to 0,0 with no arguments
    Point originalPoint = new Point(x,y);   // point constructor setting the coordinates to x,y
    Point point2 = new Point(originalPoint);// point constructor creating a point from the point object passed
    Point point3 = new Point(-5,-5);

    MovablePoint mp1 = new MovablePoint(xSpeed2,ySpeed2);                      // constructor that will set the coordinate to 0,0 and speed to 0,0
    MovablePoint mp2 = new MovablePoint(-5,-5,xSpeed,ySpeed);   // constructor that will set the coordinate to 5,5 and speed to xSpeed, ySpeed
    MovablePoint mp3 = new MovablePoint(point3, xSpeed,ySpeed); // set the coordinate point1 coordinate and speed to passed arguments
    MovablePoint mp4 = new MovablePoint();

    Point3D point3d1 = new Point3D();     // default coordinates 0,0,0
    Point3D point3d2 = new Point3D(x,y,z);// coordinates set to x,y,x
    // print statement
    System.out.println("point1-> " + point1 + "\npoint2-> " + point2 + "\nmoving point1-> " + mp2 +
                       "\nmoving point2-> " + mp3 +"\n3dpoint-> " + point3d1 + "\n3dpoint2-> " + point3d2);
       
    double distance1 = point2.distance(10,-7);  // arguments can even be negative 
    double distance2 = point2.distance();       // distance from point2 to center
    // some examples of equals method in all classes
    System.out.printf("\ndistance form (3,4) to (10,-7) is %.2f\ndistance from (3,4) to center is " + distance2, distance1);
    System.out.println("\n\ndoes point1 equal point2? "+point1.equals(point2));
    System.out.println("does moving point3 equal moving point2? " + mp3.equals(mp2));
    System.out.println("since point object can be compared to 3d point objects unsuccesfully, does point1 equal 3d point1? " + point1.equals(point3d1));

        System.out.println();
    /*experiment here. adding 9 elemenet to an array of type point. 3 point, 3d point and 3 movable point 
        then print them all. each toString method will be called apropriately*/
    Point[] pointArray = new Point[9];
    pointArray[0] = point1;// point objects
    pointArray[1] = point2;
    pointArray[2] = point3;
    pointArray[3] = mp1;    // movable point objects
    pointArray[4] = mp2;
    pointArray[5] = mp3;
    pointArray[6] = mp4;
    pointArray[7] = point3d1;
    pointArray[8] = point3d2;
    
    for (Point point : pointArray){
        System.out.println(point);
    }
    /*another experiment. here i fill an array of type object with many types. point,3dpoint, movable point
     customer,date, orderItem and menuItem. then loop through and print all of them. the proper toString
     will be called for each type  */
     System.out.println();
    Object[] objectArray = new Object[9];
    objectArray[0] = point1;
    objectArray[1] = point2;
    objectArray[2] = mp1;
    objectArray[3] = mp3;
    objectArray[4] = point3d1;
    objectArray[5] = point3d2;
    objectArray[6] = new Customer("dismantho","a@b.com", "0123456789");
    objectArray[7] = new Date();
    objectArray[8] = new MenuItem();

    for (Object obj: objectArray){
        System.out.println(obj);
    }
    

}
}
