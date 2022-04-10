public class MenuItem {
    private String name = "FoodName";
    private double price = 0.00;
    private int calories = 0;
    

    
    /*set the name,price and calories. constructors dont return*/
    public MenuItem(){
        this.name = getName();
        this.price = getPrice();
        this.calories = getCalories();
    }
    /* this constructor is to prevent any privacy leaks*/
    public MenuItem(MenuItem menuItem){
        this.name = menuItem.name;
        this.price = menuItem.price;
        this.calories = menuItem.calories;
    }
    /** set the provided info if valid */
    public MenuItem(String name, double price, int calories){
        setName(name);
        setPrice(price);
        setCalories(calories);

    }/* returns the name. strings are immutable no need to worry about privacy leaks*/
    public String getName(){
        return this.name;
    }
    /*returns the price of the menuIem */
    public double getPrice(){
        return this.price;
    }
    /*returns the calories of the menuItem */
    public int getCalories(){
        return this.calories;
    }
    /*returns the name if of the MenuItem */
    public void setName(String name){
        this.name = name;
    }
    /**if price is greater than zero than set it. sets the price that is given other wise */
    public void setPrice(double price){
        if (price >=0 ){    //if price is greater than zero
            this.price = price;
        }
       
    }
    /* sets the calories if calories are greater than zero then set it. if not then it now equals zero*/
    public void setCalories(int calories){
        if (calories>=0){// if calories is greater than zero..
            this.calories = calories;
        }
        else{           //..else just give it default 
            this.calories = 0;
        }    
    }
    /*makes an oh so neat string from the provided menuItem */
    public String toString(){
        String str = "Name: "+this.name+"\nPrice: "+this.price+"\nCalories: "+ this.calories;
        return str;
    }
    /**for a menu item to be equal name, price, and calories must match */
    public boolean equals(MenuItem menuItem){
        return this.name.equals(menuItem.name) &&
               this.price==menuItem.price &&
               this.calories==menuItem.calories;
        
    }
    /* compare calories of one menuItem to another menu items calories. */
    public int compareTo(MenuItem menuItem ){
        int num = 0;// we'll make the default zero 
        if (this.calories > menuItem.calories) num = 1;
        if (this.calories ==menuItem.calories) num = 0;
        if (this.calories < menuItem.calories) num=-1;
        return num;
    }


    
}
