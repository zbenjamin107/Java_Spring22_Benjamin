import java.util.Calendar;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;


public class FoodTruck {
    public static void main(String[] args){
        
        try{
            // open and scan the menu 
            File f = new File("menu.txt");
            Scanner menu = new Scanner(f);
            
            // these arrays are going to hold the items and prices from the list            
            String[]items = new String[3];
            Double[] prices = new Double[3];
            
            int index =0; 
            // as long as the menu hasNext() the indexed item and price is added to the arrays 
            while(menu.hasNext()){
                String item = menu.nextLine();
                String priceStr = menu.nextLine();
                Double price = Double.parseDouble(priceStr);                
                items[index]=item;
                prices[index]=price; 
                index+=1; 
            }
            // greeting and name input 
            System.out.println("\nWelcome to the food truck");
            System.out.println("Enter your name:");                
            Scanner nameInput = new Scanner(System.in);
            String name = nameInput.nextLine();
            
            
            System.out.println("\nEnter the quantity of each item");
            System.out.println("===============================");
            
            
            int times=1;                
            String quantities_String ="";
            /* ok so this code might be hard to follow. so my wack idea was ill get the quantity for each 
            as a srring so im adding that quantity to the string above, along with a space, and ill
            have the three quantities in one string seperated by a space
            */
            Scanner input= new Scanner(System.in);
            while(times<=3){
                System.out.printf(items[times-1]+" - %.2f ",prices[times-1]);                
                String quantity= input.next();                
                quantities_String+=quantity+" ";
                times+=1;
            } 
            input.close();
            // im splittting the string that hold the quantites at the space and converting them to int
            String[] quantities =quantities_String.split(" ");            
            int first = Integer.parseInt(quantities[0]);
            int second = Integer.parseInt(quantities[1]);            
            int third = Integer.parseInt(quantities[2]);
            // calculating the subtotal, tax and total
            double subtotal = prices[0]*first + prices[1]*second + prices[2]*third;  
            double tax = subtotal*.0625;
            double total  = subtotal +tax;  
        
            // now i create the time and date
            Calendar calendar= Calendar.getInstance();             
            int sec = calendar.get(Calendar.SECOND); 
            int min= calendar.get(Calendar.MINUTE);
            int hour= (calendar.get(Calendar.HOUR_OF_DAY))%12;
            int day = calendar.get(Calendar.DAY_OF_MONTH);            
            int month = calendar.get(Calendar.MONTH)+1;
            int year = calendar.get(Calendar.YEAR);
            
            // theses next couple lines are all for the invoice number
            // splitting the name at the space to get the first two letters of the name 
            String[]names = name.split(" ");
            String firstI = names[0].substring(0,1).toUpperCase();
            String lastI = names[1].substring(0,1).toUpperCase();            
            String first2OfFirst = names[0].substring(0,2).toUpperCase();
            String first2OfLast = names[1].substring(0,2).toUpperCase();
            // now calculating the value of the two initials and adding them together
            int valueOfFirst= firstI.charAt(0);
            int valueOfSecond= lastI.charAt(0);            
            int valuesCombined= valueOfFirst+valueOfSecond;
            
            int lengthOfName= name.length();            
            int specialValue= valuesCombined*lengthOfName;
            // completed invoivce number                         
            String invoiceNum =first2OfFirst+first2OfLast+specialValue+""+month+""+day+""+hour+""+sec ;
        
            // putting the invoice togething by adding line for line
            String data = String.format ("");            
            data+=String.format("Invoice number:                %s\n",invoiceNum);
            data+=String.format("Date:                          %d/%d/%d\n",month,day,year);
            data+=String.format("Time:                          %d:%d:%d\n",hour,min,sec);
            data+=String.format("Item                           Quantity    Price        Total\n");
            data+=String.format("=============================================================\n");
            data+=String.format("%-30s %-10d  $%-10.2f  $%.2f\n",items[0],first, prices[0],first*prices[0]);
            data+=String.format("%-30s %-10d  $%-10.2f  $%.2f\n",items[1],second,prices[1],prices[1]*second);
            data+=String.format("%-30s %-10d  $%-10.2f  $%.2f\n",items[2],third,prices[2],prices[2]*third);
            data+=String.format("=============================================================\n");
            data+=String.format("Subtotal:                                               $%.2f\n",subtotal);
            data+=String.format("6.25 Sales tax:                                         $%.2f\n",tax);
            data+=String.format("Total:                                                  $%.2f\n",total);
            //print the invoice to the terminal 
            System.out.println("\n");
            System.out.printf(data);
            //print the invoice to a file
            String fileName = invoiceNum+".txt";
            try{
                FileWriter fileWriter = new FileWriter(fileName);
                fileWriter.write(data);   
                fileWriter.close();     
            }catch(IOException ioe){
                System.out.println("there was a problem writing to the file");
            }
            

            nameInput.close();           
            menu.close();
                
        }        
        catch(IOException ioe){
            System.out.println("There is a problem with the input/output operation");
        }
        

        
        

               
    } 

    
}
