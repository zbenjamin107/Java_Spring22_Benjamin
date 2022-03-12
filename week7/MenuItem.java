public class MenuItem {
    private String name;
    private double price;
    private int calories;
    public Object item;

    
    public void setUp(){
        name = "FoodName";
        price = 0.00;
        calories = 0;
    }
    /*set the name,price and calories. constructors dont return*/
    public MenuItem(){
        this.name = getName();
        this.price = getPrice();
        this.calories = getCalories();
    }
    /** set the provided info if valid */
    public MenuItem(String name, double price, int calories){
        setName(name);
        setPrice(price);
        setCalories(calories);

    }
    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public int getCalories(){
        return this.calories;
    }

    public void setName(String name){
        this.name = name;
    }
    /**if price is greater than zero than set it  */
    public void setPrice(double price){
        if (price >=0 ){
            this.price = price;
        }
       
    }
    // if calories are greater than zero then set it. if not the it now equals zero
    public void setCalories(int calories){
        if (calories>=0){    
            this.calories = calories;
        }
        else{
            this.calories = 0;
        }    
    }

    public String toString(){
        String str = "Name: "+name+"\nPrice: "+price+"\nCalories: "+ calories;
        return str;
    }
    /**for a menu item to be equal name, price, and calories must match */
    public boolean equals(MenuItem menuItem){
        return this.name==menuItem.name &&
               this.price==menuItem.price &&
               this.calories==menuItem.calories;
        
    }
    // compare calories to another menu item. 
    public int compareTo(MenuItem menuItem ){
        int num=123;
        if (this.calories > menuItem.calories) num = 1;
        if (this.calories ==menuItem.calories) num = 0;
        if (this.calories < menuItem.calories) num=-1;
        return num;
    }


    
}
