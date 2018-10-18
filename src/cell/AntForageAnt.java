package cell;

import java.util.*;

public class AntForageAnt{

    private int rowIndex;
    private int colIndex;
    private int orientation;//0 = N,1 = NE,2 = E,3 = SE,4 = S,5 = SW,6 = W,7 = NW
    private boolean haveFood;
    
    /**
     * This is a class for individual ant, ant behaviours are set based on
     * https://cs.gmu.edu/~eclab/projects/mason/publications/alife04ant.pdf.
     */
    public AntForageAnt(int rowIndex, int colIndex){
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
        this.orientation = new Random().nextInt(8);//get 1 of the 8 random orientation;

        this.haveFood = false;
    }

    public int getOrientation(){
        return orientation;
    }

    public void setOrientation(int i){
        orientation = i;
    }

    public boolean getHaveFood(){
        return haveFood;
    }
    
    /**
     * This method reverse the haveFood, i.e. if previously the ant has food,
     * after changeHaveFood(), it will not have food, if it previously does not,
     * it will after changeHaveFood().
     */
    public void changeHaveFood(){
        haveFood = !haveFood;
    }

    public int getrowIndex(){
        return rowIndex;
    }

    public int getcolIndex(){
        return colIndex;
    }

    public void setrowIndex(int x){
        rowIndex = x;
    }

    public void setcolIndex(int y){
        colIndex = y;
    }

}