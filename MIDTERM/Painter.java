/*
 * Painter is what paints each block in our World so we see color
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;      
import java.awt.event.ActionListener;   
import javax.swing.JPanel;              
import javax.swing.Timer;

public class Painter extends JPanel implements ActionListener{
    private World world = new World(); // CREATES THE WORLD (7 DAYS)

    Timer timer = new Timer(100, this); // CREATES AN INSTANCE

    public Painter() {// called from diver
        timer.start();// this sets/starts a timer                     
    }
	
    @Override
    public void actionPerformed(ActionEvent e) { // called with each click of the Timer
        world = world.applySpread();            // takes the current world and applies spread
        this.repaint();                         // calls for the painting                       
    }

	@Override
    public void paintComponent(Graphics g) {    // called by repaint
        super.paintComponent(g);                
        doDrawing(g);                           // calls the drawing 
    }

    private void doDrawing(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics; // turns the graphics to 2dimensional 
        int rectSide = 2;// size of the individual cell length and width 
        int x=1, y=1; // x,y corrdinates                    
        Cell[][] cellWorld=world.getGridFromWorld();// creates the cell world from the World world
        for(int i=0; i< cellWorld.length; ++i ){// for length of the rows for each row
            for (int j=0; j < cellWorld[i].length; ++j){// for length of the columns for each column
                Cell cell = cellWorld[i][j];    // cell equals
                g2d.setColor(cell.getColor());  // set color of rectangle in g2d to color of cell
                g2d.fillRect(x,y,rectSide,rectSide);// fill rectangle in g2d according to its location(x,y) and size(length,width)
                x+=rectSide;// next x coordinate. found by adding the length of the previous rectangel
            } 
            y+=rectSide;// next y coordinate. found by adding the length of the previous rectangel
            x=1;
        }
    }  
}    


    
