package rule;


import cell.AntForageAnt;
import cell.AntCell;
import cell.Cell;
import simulation.Grid;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Yunhao Qing
 * A specific Rule class for Ant Forage game,adapting rules from 
 * https://cs.gmu.edu/~eclab/projects/mason/publications/alife04ant.pdf.
 * Due to time constraint, this class is incomplete.
 */
public class AntRule extends Rule {
    private final double ANT_RATIO;
    private final double MAX_PHEROMONE;
    private final double EVAPORATION;
    private final double DIFFUSION;
    private final double K;
    private final double N;
    private Random r;
    private List<AntForageAnt> Ants;
    //Orientations
    public static final int NDir = 0;
    public static final int NE = 1;
    public static final int E = 2;
    public static final int SE = 3;
    public static final int S = 4;
    public static final int SW = 5;
    public static final int W = 6;
    public static final int NW = 7;

    /**
     * Constructor for SpreadingOfFireRule.
     * @param grid the grid with states number in each cell
     */
    public AntRule(Grid grid, List<Double> extraParameters) {
        super(grid, extraParameters);
        r = new Random();
        ANT_RATIO = extraParameters.get(0);
        MAX_PHEROMONE = extraParameters.get(1);
        EVAPORATION = extraParameters.get(2);
        DIFFUSION = extraParameters.get(3);
        K = extraParameters.get(4);
        N = extraParameters.get(5);
        this.getStateMap().put(AntCell.EMPTY, "EMPTY");
        this.getStateMap().put(AntCell.NEST, "NEST");
        this.getStateMap().put(AntCell.FOOD, "FOOD");
        initialiseAnts();
    }
    
    /** 
     * Initialise an arraylist of ants, the ants are randomly located on empty
     * fields based on the ANT_RATIO. Each ant is initialized with row and column
     * indices.
     */ 
    public void initialiseAnts(){
        Ants = new ArrayList<>();
        for (int i = 0; i < this.getGrid().getNumRow(); i++) {
            for (int j = 0; j < this.getGrid().getNumCol(); j++) {
                Cell cell = this.getGrid().item(i, j);
                if ((cell.getState() == AntCell.EMPTY) && (r.nextDouble() < ANT_RATIO))
                {
                    AntForageAnt temp = new AntForageAnt(i,j);
                    Ants.add(temp);
                }
            }
        }
    }
    
    /**
     * Determine new row and column for all ants in the ant arraylist and 
     * new states and pheromone amounts for cells in the grid.
     */
    @Override
    public void determineNextStates() {
        antsMoveAndDropPheromones();
        pheromonesEvaporateAndDiffuse();
    }
    
    /**
     *Iterate through the arraylist of ants and update ants and cells accordingly,
     * following instructions from
     * https://cs.gmu.edu/~eclab/projects/mason/publications/alife04ant.pdf.
     */
    public void antsMoveAndDropPheromones(){
        for (int i = 0; i < Ants.size();i++){
            AntForageAnt ant = Ants.get(i);
            if (ant.getHaveFood()){
                antReturnToNest(ant);
            }
            else{
                antFindFoodSource(ant);
            }
        }
    }
    
    /**
     * While the ant has food item, they will try to return to nest. This class
     * achieve them by finding the appropriate cell the ant should moved to based
     * on home pheromone comparison.
     */
    public void antReturnToNest(AntForageAnt ant){
        AntCell currentCell = (AntCell)this.getGrid().item(ant.getrowIndex(), ant.getcolIndex());
        List<Cell> neighbors = this.getGrid().getAllNeighbors(ant.getrowIndex(), ant.getcolIndex());
        dropFoodPheromones(currentCell,neighbors);
        if (!forwardLocations(ant).isEmpty()) neighbors = forwardLocations(ant);
        Cell moveToCell = this.getGrid().item(ant.getrowIndex()+1, ant.getcolIndex());
        double maxPhero = 0;
        for (Cell c : neighbors){
            AntCell antcell = (AntCell) c;
            if (antcell.getNestPheromones()>=maxPhero){
                moveToCell = c;
                maxPhero = antcell.getNestPheromones();
            }
        }
        ant.setOrientation(determineNewOrientation(moveToCell,ant));
        ant.setcolIndex(moveToCell.getColIndex());
        ant.setrowIndex(moveToCell.getRowIndex());
        if (moveToCell.getState() == AntCell.NEST){
            ant.changeHaveFood();
        }
    }
    
    /**
     * This class updates home pheronmone of a certain cell after the ant drops
     * home pheromones on it.
     */
    public void dropHomePheromones(AntCell currentCell,List<Cell> neighbors){
        if (currentCell.getState()== AntCell.NEST)
            currentCell.setNestPheromones(MAX_PHEROMONE);
        else{
            double maxPhero = 0;
            for (Cell cell : neighbors){
                AntCell thisCell = (AntCell)cell;
                maxPhero = Math.max(maxPhero,thisCell.getNestPheromones());
            }
            if (maxPhero - 2 - currentCell.getNestPheromones()>0)
                currentCell.setNestPheromones(currentCell.getNestPheromones()+1);
        }
    }

    /**
     * This class updates food pheronmone of a certain cell after the ant drops
     * home pheromones on it.
     */
    public void dropFoodPheromones(AntCell currentCell, List<Cell> neighbors){
        if (currentCell.getState()== AntCell.FOOD)
            currentCell.setNestPheromones(MAX_PHEROMONE);
        else{
            double maxPhero = 0;
            for (Cell cell : neighbors){
                AntCell thisCell = (AntCell)cell;
                maxPhero = Math.max(maxPhero,thisCell.getFoodPheromones());
            }
            if (maxPhero - 2 - currentCell.getFoodPheromones()>0)
                currentCell.setFoodPheromones(currentCell.getFoodPheromones()+1);
        }
    }
    
    /**
     * After the ant decides on which direction to move on, this class reset the
     * orientation based on the movement.
     * 0 = N,1 = NE,2 = E,3 = SE,4 = S,5 = SW,6 = W,7 = NW
     */
    public int determineNewOrientation(Cell cell, AntForageAnt ant){
        if (cell.getRowIndex() == ant.getrowIndex()+1){
            if (cell.getColIndex()==ant.getcolIndex()+1){return SE;}
            else if (cell.getColIndex()==ant.getcolIndex()-1){return NW;}
        }
        else if (cell.getRowIndex() == ant.getrowIndex()-1){
            if (cell.getColIndex()==ant.getcolIndex()+1){return E;}
            else if (cell.getColIndex()==ant.getcolIndex()){return NE;}
            else if (cell.getColIndex()==ant.getcolIndex()-1){return NDir;}
        }
        else if (cell.getRowIndex() == ant.getrowIndex()){
            if (cell.getColIndex()==ant.getcolIndex()+1){return S;}
            else if (cell.getColIndex()==ant.getcolIndex()){return SW;}
            else if (cell.getColIndex()==ant.getcolIndex()-1){return W;}
        }
        return -1;
    }

    /**
     * This method returns a list of forward direction cells that the ant may
     * possibly move to, i.e. the 3 forward direction cells, if any of them is
     * out of bound, it is removed from the list.
     */
    public List<Cell> forwardLocations(AntForageAnt ant){
        Grid grid = this.getGrid();
        List<Cell> neighbors = new ArrayList<>();
        int row = ant.getrowIndex();
        int col = ant.getcolIndex();
        int[] index = {row-1,col,row-1,col+1,row,col+1,row+1,col+1,row+1,col,
                row+1,col-1,row,col-1,row-1,col-1,row-1,col,row-1,col+1};
        //6 here is calculated by 3*2. Three pairs of rol, col indiced are used
        //for the 3 forwared direction neighbours.
        for (int i = ant.getOrientation()*2; i < ant.getOrientation()*2+6;){
            if (!grid.isOutOfBounds(index[i], index[i+1]))neighbors.add(grid.item(index[i], index[i+1]));
            i = i+2;
        }
        return neighbors;
    }

    /**
     * While the ant does not have food item, they will try to find food. This class
     * achieve them by finding the appropriate cell the ant should moved to based
     * on food pheromone comparison.
     */
    public void antFindFoodSource(AntForageAnt ant){
        AntCell currentCell = (AntCell)this.getGrid().item(ant.getrowIndex(), ant.getcolIndex());
        List<Cell> neighbors = this.getGrid().getAllNeighbors(ant.getrowIndex(), ant.getcolIndex());
        dropHomePheromones(currentCell,neighbors);
        if (!forwardLocations(ant).isEmpty()) neighbors = forwardLocations(ant);
        Cell moveToCell = this.getGrid().item(ant.getrowIndex()+1, ant.getcolIndex());
        double maxPhero = 0;
        for (Cell c : neighbors){
            AntCell antcell = (AntCell)c;
            if (antcell.getFoodPheromones()>=maxPhero){
                moveToCell = c;
                maxPhero = antcell.getFoodPheromones();
            }
        }
        ant.setOrientation(determineNewOrientation(moveToCell,ant));
        ant.setcolIndex(moveToCell.getColIndex());
        ant.setrowIndex(moveToCell.getRowIndex());
        if (moveToCell.getState() == AntCell.FOOD){
            ant.changeHaveFood();
            moveToCell.setNextState(AntCell.EMPTY);
        }
    }
    
    /**
     * This clas updates each cell as the pheromones evaporate and diffuse after
     * ants have moved.
     */
    
    public void pheromonesEvaporateAndDiffuse(){
        for (int i = 0; i < this.getGrid().getNumRow(); i++){
            for (int j = 0; j < this.getGrid().getNumCol(); j++) {
                AntCell cell = (AntCell) this.getGrid().item(i, j);
                cell.setFoodPheromones(cell.getFoodPheromones()*(1-EVAPORATION));
                //TODO:EVAPORATION
                if(cell.getNextState()==AntCell.UNINITIALIZED)
                    cell.setNextState(cell.getState());
            }
        }
    }
}
