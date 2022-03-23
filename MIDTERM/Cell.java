import java.awt.Color;
public class Cell{
    private states state;
    private Color color;
    public static enum states {EMPTY,TREE,BURNING};// states of a cell 
    public static Color[] colors = {Color.YELLOW, Color.GREEN, Color.RED};// colors that resemnble cell states
    
    public Cell(){// constructor of a cell. no  arguments sets the state and color as null 
        this.state = null;
        this.color = null;
    }
    public Cell(states state){// given an argument the color and state are set through setState
        setState(state);// call to set state
    }
    public void setState(states state ){
        this.state = state;// the instance is set a state
        this.color = colors[state.ordinal()];// since the states are enumerated they can be used to gete the color 
    }
    public void setState(){// no argument will be set to a tree
        this.state = Cell.states.TREE;// set state as tree 
        this.color = colors[state.ordinal()];// set color as green 
    }
    public states getState(){
        return this.state;// hard to follow, i know
    }
    public Color getColor(){
        try{
            color = colors[this.state.ordinal()];// this.state.ordinale() returns a number 0-2 representing the state..
        }
        catch(Exception e){// in case the color has not been set, it will be null
            color = null;
        }
        return color;// return color                 ..after number is retunred it can be used to get the color
    }
    
    
    

}
