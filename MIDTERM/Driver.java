import javax.swing.JFrame;
//import javax.swing.JPanel;

public class Driver {
    
    //private World world = new World(); // NOT BEING USED

    
    private JFrame window;
    public Driver(){// called from main 
        window = new JFrame();// new frame 
        window.setSize(750,750);// set size length and width
        window.setLocationRelativeTo(null);// default location is in the center of the screen
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// close on exit
        window.setTitle("Burning It Down");// title name 
        window.add(new Painter());// call to painter 
        window.setVisible(true);// set visable
    }

    public static void main(String[] args){
        new Driver();// call for new driver 
    }
}
