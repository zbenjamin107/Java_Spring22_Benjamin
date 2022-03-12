import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;


public class Driver {
    public static void main(String[] args){ 
        System.out.println("please enter your name, email and cellphone");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();// take the input line 
        String[] words = input.split(" ");// seperate the words by space
        Customer customer;// customer onject made
        try{   // taking the words from input and making a customer instance 
            String name = words[0];
            String email = words[1];
            String cellphone = words[2];
            customer = new Customer(name,email,cellphone);
        }// or just go default
        catch(Exception e){
            customer = new Customer();
        
        }

        try{// read the items and store them 
            ArrayList menu=loadMenuItems("products.txt");
            printMenu(menu);    
        }
        catch(Exception e){
            System.out.println("file not found");
        }
        Calendar calendar = Calendar.getInstance();//create a calendar  and get month, day, year
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH)+1;
        int year = calendar.get(Calendar.YEAR);
        Date date = new Date(day,month,year);// date instace
           
        ArrayList order = getOrder();// call the order as an arraylist
        System.out.printf("\nName: %21s%s\n","",customer.getName());// neat reciept printed
        System.out.printf("Email: %20s%s\n","",customer.getEmail());// the space "" is so the words all line up
        System.out.printf("Phone: %20s%s\n","",customer.getPhone());
        System.out.printf("Custom Date: %14s%d/%d/%d\n","",month,day,year);
        System.out.printf("Date Call: %16s%s\n","",date);
        System.out.printf("Item                       Price\n");
        System.out.printf("=====================================\n");
        double total = 0;
        for( Object item: order){
            MenuItem mi = (MenuItem) item;
            System.out.printf("%-27s%.2f\n",mi.getName(),mi.getPrice());// print the name and price 
            total += mi.getPrice();// add price to the total. 
        }
        System.out.printf("Total: %20s%.2f","",total);// print the total
        scanner.close();
    }/*this function is going to create an array that contains the MenuItem objects by looping through
    the items in the list line by line and taking the item, price and calories from each line  */
    public static ArrayList<MenuItem> loadMenuItems(String fileName) throws FileNotFoundException{
        File f = new File(fileName);
        ArrayList menuItems = new ArrayList();
        try{
            Scanner data = new Scanner(f);// scann the file
            while (data.hasNextLine()){// as long as the file has a line to be scanned..
                String line = data.nextLine();//.. scann each line
                String[] items = line.split(",");//..and split the words(words being item, price,calories)
                for (String item: items){//.. and add it to the arraylist
                    menuItems.add(item);
                }
            }
        data.close();
        return menuItems; // return the array of menu items   
        }
        catch(Exception e){
            System.out.println("no worky");
            return menuItems;// return the empty lits or whatever is in it
        }
        
    }/*this is going to print the menu by looping throuhg products and taking the item, price, 
    and calories from each line and printing it in a neat fashion */
    public static void printMenu(ArrayList MenuItems){
        System.out.println("FOOD TRUCK MENU");
        String item;// create the variables
        double price;
        int calories;
        int index = 0;
        int length = MenuItems.size();
        int num = 1;
        while(index<length){// while the index is not at the end(at the length)
            item =(String) MenuItems.get(index);// every third object is of the same type..item, price, calorie
            index+=1;
            price = Double.parseDouble((String) (MenuItems.get(index)));
            ++index;
            calories = Integer.parseInt((String) MenuItems.get(index));
            index+=1;
            MenuItem thing = new MenuItem(item,price,calories);
            System.out.printf("Item(%d): %s\nPrice: %.2f\nCalories: %d\n\n",num,item,price,calories);
            ++num;// the number only goes up once because number represents the number of items including the price and calories
        }
    }/*this is the fun one. we will get the order of the custommer by
     accepting the number that goes with the item*/
    public static ArrayList<MenuItem> getOrder(){
        
        ArrayList itemsOrdered = new ArrayList();
        System.out.println("What item(s) from the menu would you like? Enter the number of the item seperated by a comma");
        Scanner scanner = new Scanner(System.in);
        String input =(String) scanner.nextLine();// get the input of numbers
        String[] itemNumbers = input.split(",");
        int index;
        double price;
        int calories;
        
        try{
            ArrayList menu = loadMenuItems("products.txt"); 
            
            for (String itemNumber: itemNumbers){ // item number is the number that represents the item and itemnumbers is the collection of orderd numbers
                itemNumber = itemNumber.trim();// dont want any spaces on the input  
                // item is found by converting the number orederd to the index of the item in products
                String item =(String) menu.get((Integer.parseInt(itemNumber)-1)*3);// since every third object is an item and the index starts at 0
                index = menu.indexOf(item);// actually could have been found by (itemnumber-1)*3...meh
                price = Double.parseDouble((String) menu.get(index+1));
                calories = Integer.parseInt((String) menu.get(index+2));
                MenuItem mi = new MenuItem(item,price,calories);// create a menu item and add it to the order
                itemsOrdered.add(mi);
            } 
            scanner.close();
            return itemsOrdered;
        }
        catch(Exception e){
            System.out.println("something went wrong");
            scanner.close();
            return itemsOrdered;// return the empty or partially full order
        }  
        

        

        
        
        
    }
}
