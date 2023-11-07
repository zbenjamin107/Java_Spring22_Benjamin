
/*
 * World is contains 2d array called word and int size which is length and.. 
 * ..width for the array
 */
public class World{
    int size; 
    private Cell[][] world; 

    // creates new World given 2d array(matrix)
    public World(Cell[][] matrix){
        world = matrix;
        size = 350;
    }
    //creates new World
    public World(){
        size =350;
        world = createGrid();
        
    }
    //returns the data member world
    public Cell[][] getGridFromWorld(){
        return this.world;
    }
    //creates a 2d array of Cells
    public Cell[][] createGrid(){
         
         Cell[][] gridMatrix = new Cell[size][size]; 
         for(int i=0 ; i < gridMatrix.length ; ++i){// for index in the gridmatrix(which is the row)
             for (int j= 0; j< gridMatrix[i].length; ++j){// for index in the gridmatrix row(which is the column)
                 if (i==0 || i ==(size-1)){//if the index is in the matrix side edge..
                     gridMatrix[i][j] = new Cell();// make a cell out of the object
                     gridMatrix[i][j].setState(Cell.states.EMPTY) ; // make it empty
                 }
                 else if(j==0 || j == (size-1)) {// if the index is a matrix top or bottom edge..
                     gridMatrix[i][j] = new Cell();// make a cell out of it ..
                     gridMatrix[i][j].setState(Cell.states.EMPTY) ; // make it empty
                 }
                 else{// any other index
                    gridMatrix[i][j] = new Cell();// make the object a type cell
                    gridMatrix[i][j].setState(Cell.states.TREE) ; // set it as tree 
                 }
             }
        }
        int quarter = size/4;// quarter of the size                     SET FIRE TO THE BLOCK IN..
        gridMatrix[quarter][quarter].setState(Cell.states.BURNING);         // the NE quarter 
        gridMatrix[quarter][size-quarter].setState(Cell.states.BURNING);    // the NW quarter 
        gridMatrix[size-quarter][quarter].setState(Cell.states.BURNING);    // the SE quarter
        gridMatrix[size-quarter][size-quarter].setState(Cell.states.BURNING);// the SW quarter
         
       return gridMatrix;// return the matrix
    }  

    public World applySpread(){
        Cell[][] newGrid = createGrid();// new grid
        int size = newGrid.length;
        for (int i=0; i < size; ++i)    // loops throught the rows
            for (int j=0; j< this.world[i].length;++j){// loops throgh the columns in the rows
                
                if( (this.world[i][j].getColor()==Cell.colors[2])){// if the color is red(its burning)..
                    newGrid[i][j].setState(Cell.states.EMPTY);// the next tick of the time the cell will be empty
                }
                else if(this.world[i][j].getColor()==Cell.colors[0]){// if the color of the cell is yellow(empty)..
                    newGrid[i][j].setState(Cell.states.EMPTY);// the next tick of the time it will be empty, still 
                }
                else{// else the color must be green(tree) if this branch operates
                    double probCatch = probSpread( this.world, i, j);// find the chance this tree will burn 
                    double randomNum = Math.random();// random number
                    if (randomNum<=probCatch){      // if random number is less than probability.. 
                        newGrid[i][j].setState(Cell.states.BURNING);// burn it down
                    }
                    else{// if not
                        newGrid[i][j].setState(Cell.states.TREE);// the tree has escaped with its life
                    }
                }
            }
        World newWorld = new World(newGrid);// make a world out of this array of cells
        return newWorld;
     }

     public double probSpread(Cell[][] world, int i, int j){// arguments are the array , i index, j index
        double probCatch = .28;// chance an adjacent tree spreads fire
        int firesNear=0;// fires near
        
        
        /* this next section is going to test each direction for adjacent fires. If a tree
        is on fire +1 to firesNear. try statement for when it comes to the edge of the matrix. */
        if (i > 0){ 
            if (world[i-1][j].getState().equals(Cell.states.BURNING)) firesNear +=1;// N cord
            if(j > 0){
                if (world[i-1][j-1].getState().equals(Cell.states.BURNING)) firesNear +=1;// NE cord
            }
            if (j < size){
                if (world[i-1][j+1].getState().equals(Cell.states.BURNING)) firesNear +=1;// NW cord
            }
        }
        if(i < size){
            if (world[i+1][j].getState().equals(Cell.states.BURNING)) firesNear +=1; // S cord
            if(j > 0){
                if (world[i+1][j-1].getState().equals(Cell.states.BURNING)) firesNear +=1;// SE cord
            }
            if(j < size){
                if (world[i+1][j+1].getState().equals(Cell.states.BURNING)) firesNear +=1;// SW cord
            }

        }
        if(j > 0){
            if (world[i][j-1].getState().equals(Cell.states.BURNING)) firesNear +=1;// E cord
        }
        if(j < size){
            if (world[i][j+1].getState().equals(Cell.states.BURNING)) firesNear +=1;// W cord
        }

        double probSpread = 1-(Math.pow((1-probCatch),firesNear)); // P= 1-(1-chance)^number tries. found on the internet 
        return probSpread;

    }

}
