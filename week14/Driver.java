import java.io.IOException;


public class Driver {
    public static void main(String[] args) {
        HouseKeeping hk = new HouseKeeping(new Bank());// creating an instance of housekeeping from a bank
        hk.sort();              // sort the array   
        hk.update();            // update/print it
        try{
            hk.write();         // uses a file writer so the exception is passed to the driver instead
        }
        catch(IOException e){}  // catch the problem if it were to come up
        
    }
    

    
}
