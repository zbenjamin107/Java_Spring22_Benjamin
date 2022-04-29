public class Square extends Rectangle {

    /*constructor for square with no arguments. very complex, stay with me */
    public Square(){}

    /*overloaded constructor for the square class. accepts the side(double)*/
    public Square(double side){
        super(side,side);
    }

    /*another overloaded square constructor. takes the side, color and filled */
    public Square(double side, String color, boolean filled){
        super(side,side,color,filled);// just gonna let the super class handle this one
    }

    /*get side is going to return the side of the square as a double */
    public double getSide(){
        return this.length; // guess it could be getwidth or getlength
    }

    /*set side is going to set the double provided as the side */
    public void setSide(double side){
        this.length = side;
        this.width = side;
    }

    /*set length must be redefined for this class since it must change the length and width */
    public void setLength(double side){
        this.length = side;
        this.width = side;
    }

    /*set width must be redefined as well. it has to change the length and the width so it remains a
    square */
    public void setWidth(double side){
        this.length = side;
        this.width = side;
    }

    /*to string method is going to print the info about the shape square */
    public String toString(){
        return super.toString();
    }

    //equals method from the super class is sufficient. since square has no new value doesnt need ..
    //.. anything special. the super class will compare the length and width wich are the same but thats ok 

}
