public class Point3D extends Point{
    private int z;

    /*no argumetns constructor. default values [0,0,0]..([x,y,z])*/
    public Point3D(){
        super();
        this.z = 0;
    }

    /*constructor for given coordinates. call to super constructor and add the third coordinate */
    public Point3D(int x, int y, int z){
        super(x,y);
        this.z = z;
    }

    /*returns the z coordinate of the point */
    public int getZ() {
        return z;
    }

    /*sets the z coordinate for the point */
    public void setZ(int z) {
        this.z = z;
    }

    /* sets the x,y and z coordinate for the point*/
    public void setXYZ(int x, int y, int z){
        setX(x);// found in base/super class
        setY(y);// found in base/super class
        setZ(z);// method located in current class
    }

    /*returns the xyz coordinate of the point */
    public int[] getXYZ(){
        int[] array = new int[3];
        array[0] = getX();// inherited method
        array[1] = getY();// inherited
        array[2] = getZ();
        return array;
    }

    /*returns a neat and orderly string. (x,y,z) */
    @Override
    public String toString(){
        String s = "3d coordinate: (" + getX() + "," + getY() + "," + getZ() + ")";
        return s;
    }

    /*equals method that compares the coordinates of this to coordinates of other  */
    @Override
    public boolean equals(Object other){
        if(other == null)           return false;// null check
        if(!super.equals(other))    return false;// super check. calls equals from class point
        if(getClass() != other.getClass()) return false;// class check

        Point3D otherObj = (Point3D) other;     // type cast

        if (getZ() != otherObj.getZ()) return false;// z coordinate check
        return true;                            // else return true
    }
}