/*
 * Cell class is used to fill our World
 */
import java.awt.Color;
public class Cell{
    private states state;
    private Color color;
    public static enum states {EMPTY,TREE,BURNING};// states of a cell 
    public static Color[] colors = {Color.YELLOW, Color.GREEN, Color.RED};// colors that resemnble cell states
    // constructor of a cell. no  arguments sets the state and color as null
    public Cell(){ 
        this.state = null;
        this.color = null;
    }
    // given an argument the color and state are set through setState
    public Cell(states state){
        setState(state);
    }
    //getters and setters for state and color
    public void setState(states state ){
        this.state = state;
        this.color = colors[state.ordinal()];// since the states are enumerated they can be used to gete the color 
    }
    
    public states getState(){
        return this.state;
    }

    public Color getColor(){
        try{
            color = colors[this.state.ordinal()];// this.state.ordinale() returns a number 0-2 representing the state..
        }
        catch(Exception e){// in case the color has not been set, it will be null
            color = null;
        }
        return color;// return color                 
    }
