// Import the correct Calendar class here
import java.util.Calendar;
import java.util.Scanner;

public class UTC{

    // constants for raw time conversion
    // these must be static because they will be called from a "static context" => main
    static final int MILLISECONDS  = 1000;
    static final int SECONDS       = MILLISECONDS  / 1000;
    static final int SEC_PER_MIN   = SECONDS       * 60;
    static final int MIN_PER_HOUR  = SEC_PER_MIN   * 60;
    // continue defining symbolic constants for the problem

    public static void main(String[] args) {
        long millis = System.currentTimeMillis();
        System.out.println("the number of milliseconds since the UNIX Epoch is "+millis); 
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        System.out.println("Method1 "+calendar.get(Calendar.HOUR_OF_DAY) + ":" +calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND));
        
        long seconds = millis/1000;
        long mins= seconds/60;
        long hours=mins/60;
        
        System.out.println("enter the hour offset ");
        Scanner input=new Scanner(System.in);
        int offsetNum= input.nextInt();

        int localHourOfDay = (int)(hours%12)+offsetNum;
        int hourOfDay= (int)hours%24;
        int minOfDay = (int)(mins%60);
        int secOfDay = (int)seconds%60;

        System.out.println("The current local time is "+localHourOfDay+":"+minOfDay+":"+secOfDay);
        System.out.println("The current GMT time is "+hourOfDay+":"+minOfDay+":"+secOfDay);
        
       
        // write Calendar code here. Research API for details

        // get the command line argument, convert to an integer

        // perform the math.
        input.close();
    }
}
