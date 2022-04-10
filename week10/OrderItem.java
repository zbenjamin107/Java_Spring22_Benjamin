public class OrderItem {
    
    private MenuItem menuItem= new MenuItem();
    private int quantity = 0;
    
    // zero argument constructor
    public OrderItem(){}

    // another constructor to accept arguments
    public OrderItem(MenuItem menuItem, int quantity){
        this.menuItem = new MenuItem(menuItem);// call for a new menuItem or 'copy' for privacy leak prevention
        this.quantity = quantity;
    }

    // returns a copy of the menu item so there is no privacy leak
    public MenuItem getMenuItem() {
        return new MenuItem(this.menuItem);// creates a new menuitem that is equal to the old but does not share the same adress
    }


    // returns the quantity of a orderItem
    public int getQuantity() {
        return this.quantity;
    }

    // sets the quantity of a order item
    public void setQuantity(int quantity) {
        if (quantity>=0)    // as long as the number set isnt less than zero
        this.quantity = quantity;
    }

    // increases the quantity by the num provided
    public void increaseQuantity(int num ){
        if  (num>0)     // as long as the increse is greater than 0...if not its a decrease..
        this.quantity += num;
    }

    // creates a neat string format
    public String ToString(){
        String string= "Item name: "+this.getMenuItem().getName()+"\nPrice: "+ this.getMenuItem().getPrice();
        return string;
    }


}
