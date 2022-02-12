// 
import java.util.Scanner;
public class Initials {
    public static void main(String[] args) {
        System.out.println("Enter your first and last name, please");
        Scanner input= new Scanner(System.in);
        
        //String fullName= input.nextLine();    
        String firstName=input.next();
        String lastName = input.next();
        char firstI= firstName.charAt(0);// firstI is first intial. same with lastI; it means last initial
        char lastI= lastName.charAt(0);
        
        int askiiOfFirst= (int)firstI;// gets the askii number from the initial 
        int askiiOfLast= (int)lastI;
        System.out.println( firstI+"."+lastI+".");
        System.out.println(firstI+" = "+askiiOfFirst+", "+lastI+" = "+askiiOfLast);
        
        int sum= askiiOfFirst+askiiOfLast;
        System.out.println(askiiOfFirst +" + " + askiiOfLast+" = "+sum);
        System.out.println(firstI+lastI);
        
        
        input.close();//close 'input'



    }
}