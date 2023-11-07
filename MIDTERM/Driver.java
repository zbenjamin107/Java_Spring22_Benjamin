import javax.swing.JFrame;
/*
 * zach benjamin
 * Driver class calls for a new painter within our JFrame window
 */
public class Driver {    
    private JFrame window;
    public Driver(){        
        window = new JFrame();    // create new frame and customize it
        window.setSize(750,750);// set size length and width
        window.setLocationRelativeTo(null);// default location is in the center of the screen
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// close on exit
        window.setTitle("Burning It Down");// title name 
        window.add(new Painter());// call to painter 
        window.setVisible(true);// set visable
    }

    public static void main(String[] args){
        new Driver(); 
    }
}
