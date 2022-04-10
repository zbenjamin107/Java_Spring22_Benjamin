
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Order{
    
    private Date date;
    private String invoice;
    private Customer customer;
    private ArrayList<OrderItem> cart;
    
    /* order constructor with no arguments. all of the values are default  */
    public Order(){
        this.date = new Date();// default date
        this.invoice ="unkown";// unkown id
        this.customer = new Customer();// default customer is made
        this.cart = new ArrayList<OrderItem>(); // empty list for the cart is created 

    }

    /* order cunstructor with a customer as an argument passed*/
    public Order(Customer customer){
        this.date = new Date();// make a default  date 
        this.invoice = "unkown";// immutable object can just be passed
        this.customer = new Customer(customer);// 'copy' of the customer passed as an argument
        this.cart = new ArrayList<OrderItem>();

    }

    /* this constructor creates an order from a argument order passed */
    public Order(Order order){
        this.date = order.date;
        this.invoice = order.invoice;
        this.customer = order.customer;
        this.cart = order.cart;
    }

    /*this will return the date as a copy to prevent privacy leaks */
    public Date getDate() {
        return new Date(this.date);
    }
    
    /*this will set the date by taking a copy of the argument first */ 
    public void setDate(Date date) {
        this.date = new Date(date);
    }
    
    /*returns the invoice number*/
    public String getInvoice() {
        return invoice;// string is immutable so no need to worry about privacy
    }

    /*returns a 'copy' of the customer */
    public Customer getCustomer() {
        return new Customer(this.customer);// customer is a mutable object so protection must be implemented
    }
   
    /* returns the array of the orderItems. cart can be considered an order */
    public ArrayList<OrderItem> getCart() {
        return new ArrayList<OrderItem>(cart);
    }

    /* this function is going add an item to the cart . if at any point the name of
       item matches the argument while looping through the cart, then the quantity of the order item 
       will increase by one instead of adding a new menu item */
    public void addItem( MenuItem MenuItem){
        boolean x = true;
        for (OrderItem item : this.cart){
            if (item.getMenuItem().getName().equalsIgnoreCase(MenuItem.getName())){// if the names of the food are equal
                item.increaseQuantity(1);
                x=false;// this will prevent the next statement from running. only one if statement will run
            }
        }
        if (x) {// this will run if the the other statement does not change the quantity
            OrderItem orderitem = new OrderItem(MenuItem,1);            
            cart.add(orderitem);
        }
    }

    /*this function is going to add a specified number of a specified menuItem to the cart by looping 
      through the cart first and seeing if the item already exist*/
    public void addItem( MenuItem MenuItem, int quantity){
        boolean x = true;
        for (OrderItem item : this.cart){// for item in cart
            if (item.getMenuItem().getName().equalsIgnoreCase(MenuItem.getName())){// if the names are equal..
                item.increaseQuantity(quantity);//.. increase the quantity by the specified amount
                x=false;// prevents the next statement from running
            }
        }
        if (x) {// if the other brach does not operate
            OrderItem orderitem = new OrderItem(MenuItem,quantity);
            cart.add(orderitem);
        }
    }

    /*this functions is going to take the list of menu items ordered and add to the order using add item */
    public void addMenuItems(ArrayList<MenuItem> menuItems){
        for (MenuItem menuItem: menuItems){
            this.addItem(menuItem);
        }
    }

   
    /*this function is going to loop through the cart and take the order items quantity and the price
    (which comes from menuItem) and use it to get the total. in this section, comments are lined up neatly
     for people with OCD */
    public double calculateTotal(){
        double total=0;                                 // total at the start
        for(OrderItem orderItem: this.cart){            // for orderItem in cart
            int quantity = orderItem.getQuantity();     // find the quantity of the item
            MenuItem menuItem = orderItem.getMenuItem();// get the menu item so that..
            double price = menuItem.getPrice();         // .. we can get the price of the item
            total += (quantity*price);                  // total is quantity times price
            }
        return total;                                   // retun total (NOTE: tax not included)
    }
   
    /* this section takes a total as an argument and adds tax to the total */
    public double calculateTax(double total){
        double tax = .08;               // make tax 8%
        double taxedTotal = total*tax;  // new total is total times tax
        return taxedTotal;              // return the new total
    }

    /* this is a invoice creator. the first two characters are the first the letters of the first name 
        capitolized followed by the first two letters of the last name capitolized then the initals are each
        seperately converted to aski valus and added together and multiplied by the lenghtof the name to get
        a special number. this special number is added to the invoice name followed by the month(int) day(int)
        and year(int..duh)
 */
    private String createInvoiceID(){
        Date date = this.date;
        int month = date.getMonth();// get month, day and year from date
        int day = date.getDay();
        int year = date.getYear();

        String name = this.getCustomer().getName();//full name of the cusomer is retreived
        String[] names = name.split(" ");           // first and last name are found by splitting them
        String firstName = names[0].toUpperCase();  
        String lastName = names[1].toUpperCase();
        char firstI = firstName.charAt(0);          //first initial
        char lastI = lastName.charAt(0);            // last initial
        int ord1 = (int) firstI;                    // askii value of first initial
        int ord2 = (int) lastI;                     // skii value of last   
        int sum = ord1 + ord2;                      // sum of the two values

        String first2 = firstName.substring(0,2);   // first two letters of the first name
        String first2OfLast = lastName.substring(0,2);// first two letters of the last name
        String initials = first2 + first2OfLast;    // initials are composed of the first two letters if the first ans last name
        int length = name.length();                  // length of the name
        int specialNum = sum*length;                 // no other name than a special number for the sum*length
        // and finaly..initials followed by special num,day,month,year make the invoice
        String invoice = initials + specialNum + day + month + year;
        return invoice;
    }

    
    /* this is a to string method that will format the order nicely by adding line for line */
    public String toString(){
        Calendar cal = Calendar.getInstance();  // create a calendar instance
        int month = cal.get(Calendar.MONTH);    // get the month
        int day = cal.get(Calendar.DAY_OF_MONTH);// get the day
        int year = cal.get(Calendar.MONTH);     // get the yeat
        String invoice = this.createInvoiceID();// call the invoice
        ArrayList<OrderItem> cart = this.cart;  // this is the cart. in a few line a for loop will print each item 
        String data = String.format ("");       // base for the receipt

        data+=String.format("\nInvoice number:                %s\n",invoice);
        data+=String.format("Date:                          %d/%d/%d\n",month,day,year);
        data+=String.format("Item                           Quantity    Price        Total\n");
        data+=String.format("=============================================================\n");
        int num =1;
        for (OrderItem orderItem: cart){// loop through the cart and print each item
            
            String name = orderItem.getMenuItem().getName();// NOTE: this is item name
            int quantity = orderItem.getQuantity();
            double price = orderItem.getMenuItem().getPrice();
            double ItemTotal = price*quantity;
            data+=String.format("(%d)%-30s %-10d  $%-10.2f  $%.2f\n",num,name,quantity,price,ItemTotal);
            num += 1;   
        }
        double subtotal = this.calculateTotal();
        double tax = subtotal*.08;
        double total = tax+subtotal;
        data+=String.format("=============================================================\n");
        data+=String.format("Subtotal:                                               $%.2f\n",subtotal);
        data+=String.format(".08 Sales tax:                                          $%.2f\n",tax);
        data+=String.format("Total:                                                  $%.2f\n",total);

        
        return data;// the receipt is returned as a long string

    }
    /*this function is going to go through the cart and print the order items in the cart to another
     file. it just takes the string from the tostring  */
    public void writeToFile(){// this refres to the order. 
        String invoice = this.createInvoiceID();// create the invoice by calling the method
        String data = this.toString();
        String fileName = invoice + ".txt";// name of the invoice is the file name 
        
        try{                                        // needed to write to a file
            FileWriter fw = new FileWriter(fileName);// new file writer
            fw.write(data);                          // write to file
            fw.close();                              // dont forget to close
        }
        catch(Exception e){
            System.out.println("theres a problem with the filewriting ");
        }   
    }

    /* this complexity of words is to change the order. it can add items to the cart or it can change
        the quantity of an item in a cart. input is converted to caps everytime for simplification*/
    public void changeOrder(Scanner scanner){
        
        System.out.println("Is there any change you would like to make to your order?(Y/N)");
        String confirm = scanner.nextLine().toUpperCase();// confirm is the yes or no response 
        
        while(!(confirm.equals("N")) && !(confirm.equals("Y"))){// as long as the response is invailid..
            System.out.println("please try again");             //..try again
            confirm = scanner.nextLine().toUpperCase();         // new respnse
            
        }
        if (confirm.equals("N")){// if no change is desired..
            System.out.println("NO CHANGE TO ORDER\n");
            return;// ...return
        }
        else{// if they didnt choose no they chose yes
            System.out.println("Would you like to add OrderItems or change quantity of orderItem?(add/change)");
            String Input = scanner.nextLine().toUpperCase();// either wrote 'add' or 'change'
            if (Input.equals("ADD")){// if they want to add items
                ArrayList<MenuItem> menuItems2 = Order.getOrder(scanner);// take a new list of menuitems..
                this.addMenuItems(menuItems2);                           //..and add them to the order

            }

            else{// if they dont add then they must want to channge the quantity of an item
                String format = this.toString();// returns the receipt in a neat string format
                System.out.println(format);
                System.out.println("Which item would you like to change the quantity of? please enter the item's number from the receipt ");
                int itemNum = Integer.parseInt(scanner.nextLine());// the numbered item from the list. referes to the item
                
                OrderItem orderItem = cart.get(itemNum-1);// order item is attained by taking the numbered item and subtraction one to get an index
                System.out.println("what would you like to set the quantity?");
                int quantitySet = Integer.parseInt(scanner.nextLine());// the number the user wants to set the quantity to 
                
                //MenuItem menuItem = orderItem.getMenuItem();
                orderItem.setQuantity(quantitySet);// set the quantity of the item to the desired select
                
            }
            String receiptPrint = this.toString();// create a new string after making changeto it..
            System.out.println(receiptPrint);      // and prints it
        }
       
    }

    /*this function returns a list of menuItems thea the user has selected. it asks which item the user
     wants based on the nnumbered items. it then takes the number and finds the the index by subtracting
     one from the number*/
    public static ArrayList<MenuItem> getOrder(Scanner scann){
        
        ArrayList itemsOrdered = new ArrayList();// an empty list to start with 
        System.out.println("What item(s) from the menu would you like? Enter the number of the item seperated by a comma");
        // since the numbers are bering input seperated by a comma, we can split at the comma to get the numbers
        String input =(String) scann.nextLine();// get the input of numbers. the numbers refer to the items in order
        String[] itemNumbers = input.split(",");// create an array of numbers by spliting at the commas
        int index;// create these objects to assign values later
        double price;
        int calories;
        
        try{// in case of an error. must be done
            ArrayList menu = application.loadMenuItems("products.txt"); // getting a copy of the menu
            
            for (String itemNumber: itemNumbers){ // item number is the number that represents the item and itemnumbers is the collection of orderd numbers
                itemNumber = itemNumber.trim();// dont want any spaces on the input  
                // item is found by converting the number orederd to the index of the item in products
                String item =(String) menu.get((Integer.parseInt(itemNumber)-1)*3);// since every third object is an item and the index starts at 0
                index = menu.indexOf(item);// actually could have been found by (itemnumber-1)*3...meh
                price = Double.parseDouble((String) menu.get(index+1));
                calories = Integer.parseInt((String) menu.get(index+2));
                MenuItem mi = new MenuItem(item,price,calories);// create a menu item and add it to the order
                itemsOrdered.add(mi);// add the menu item to the list
            } 
            
            return itemsOrdered;// return the the list
        }
        catch(Exception e){// case of an error..
            System.out.println("something went wrong");
            
            return itemsOrdered;//..return the empty or partially full order
        }  
    }

    /*Performs a deep comparison on two orders. the method will Call all of 
    the equals methods of the internal objects. this is the description i made this method from */
    public boolean equals(Order otherOrder){//date,invoice,customer,cart
        // for the next three lines: if not (this == other) return false
        if (!(this.date.equals(otherOrder.date))) return false;// note: equals method in date class
        if (!(this.invoice.equals(otherOrder.invoice))) return false;// default equals method on stringss
        if (!(this.customer.equals(otherOrder.customer))) return false;//Note: equals method in customer class
        for (OrderItem orderItem: otherOrder.cart){// for order item in other order
            if (this.cart.indexOf(orderItem)==-1) // if order item not found in this order..
                return false;// return false
            // if the order item is in this order. if the quantities are different..
            else if(this.cart.get(this.cart.indexOf(orderItem)).getQuantity()!= orderItem.getQuantity()) return false;
        }
        // if all else passes
        return true;
    }

    /*this method should do a date comparison between the two orders.  */
    public int compareTo(Order otherOrder){
        return this.date.compareTo(otherOrder.date);// compare to method found in date class
        
    }



}
