import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class application {
    public static void main(String[] args) {
        System.out.println("please enter your name, email and cellphone");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();  // take the input line 
        String[] words = input.split(" ");  // seperate the words by space
        Customer customer;                  // customer onject made
        
        try{                                // taking the words from input and making a customer instance 
            String name = words[0] +" "+ words[1];// first and last name are probaly seperated by a space
            String email = words[2];        
            String cellphone = words[3];
            customer = new Customer(name,email,cellphone);// create a customer 
        }   
        catch(Exception e){                             //..or just go default
            customer = new Customer();
        }
        Order order = new Order(customer);// create an order from the customer instance

        Calendar calendar = Calendar.getInstance();//create a calendar and get month, day, year
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH)+1;
        int year = calendar.get(Calendar.YEAR);
        Date date = new Date(month,day,year);// date instace
        order.setDate(date);                // set order date to the date   
        
        try{// read the items from the menu and store them as 'menu'
            ArrayList menu = loadMenuItems("products.txt");
            printMenu(menu);    
        }
        catch(Exception e){// reads: "IN CASE OF EMERGENCY"
            System.out.println("file not found");
        }
        
        ArrayList<MenuItem> menuItems = Order.getOrder(scanner);// call the order as an arraylist of menuItems
        order.addMenuItems(menuItems);                          // add the Menuitems the order 
        
        String format = order.toString();// get the receipt as a string
        System.out.println(format);     // print the receipt                             
        order.changeOrder(scanner);     // ask if change is required. you know the good customers have indecisive kids. print statent will happen in this function afer changing the order
        order.writeToFile();            // write to a file  
    }

    /*function is going to return the menu items. it loops throuhg the given menu 'products.txt' or 
      whatever the file name is and copies the values into an array list.  */
    public static ArrayList<MenuItem> loadMenuItems(String fileName) throws FileNotFoundException{
        File f = new File(fileName);// pull up the file
        ArrayList menuItems = new ArrayList();// create the list to store menuItems
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
        catch(Exception e){// if something tragic happens..
            System.out.println("no worky");
            return menuItems;// return the empty lits or whatever is in it
        }
        
    }


    /*this is going to print the menu by looping throuhg products and taking the item, price, 
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
            //MenuItem thing = new MenuItem(item,price,calories);
            System.out.printf("Item(%d): %s\nPrice: %.2f\nCalories: %d\n\n",num,item,price,calories);
            ++num;// the number only goes up once because number represents the number of items including the price and calories
        }
    }
    
        
}
