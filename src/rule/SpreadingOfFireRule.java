package rule;


import cell.Cell;
import cell.SpreadingOfFireCell;
import simulation.Grid;

import java.util.List;

/**
 * @author Yunhao Qing
 * A specific Rule class for SpreadingOfFire game,
 * adapting rules from http://nifty.stanford.edu/2007/shiflet-fire/.
 */
public class SpreadingOfFireRule extends Rule {
    private final int MY_BURNING_COUNT;
    private final double PROB_GROWTH;
    private final double PROB_CATCH;
    
    /**
     * Constructor for SpreadingOfFireRule.
     * @param grid the grid with states number in each cell
     * @param extraParameters MY_BURNING_COUNT, PROB_GROWTH and PROB_CATCH
     */
    public SpreadingOfFireRule(Grid grid, List<Double> extraParameters) {
        super(grid, extraParameters);
        PROB_CATCH = extraParameters.get(0);
        PROB_GROWTH = extraParameters.get(1);
        MY_BURNING_COUNT = (int) Math.floor(extraParameters.get(2));
        this.getStateMap().put(SpreadingOfFireCell.NORMAL, "NORMAL");
        this.getStateMap().put(SpreadingOfFireCell.BURNING, "BURNING");
        this.getStateMap().put(SpreadingOfFireCell.EMPTY, "EMPTY");
    }
    
    private void determineNextStatesBurning(SpreadingOfFireCell cell) {
        cell.setBurningTime(cell.getBurningTime() + 1);
        if (cell.getBurningTime() == MY_BURNING_COUNT) {
            cell.setBurningTime(0);
            cell.setNextState(SpreadingOfFireCell.EMPTY);
        } else {
            cell.setNextState(cell.getState());
        }
    }
    
    private void determineNextStatesNormal(Cell cell, List<Cell> neighbors){
        boolean check = false;
        for (Cell neighbor : neighbors) {
            if (neighbor != null && neighbor.getState() == SpreadingOfFireCell.BURNING) {
                check = true;
            }
        }
        if (check && rand.nextDouble() < PROB_CATCH) {
            cell.setNextState(SpreadingOfFireCell.BURNING);
        } else {
            cell.setNextState(cell.getState());
        }
    }
    
    private void determineNextStatesEmpty(SpreadingOfFireCell cell) {
        if (rand.nextDouble() < PROB_GROWTH){
            cell.setNextState(SpreadingOfFireCell.NORMAL);
        } else {
            cell.setNextState(cell.getState());
        }
    }
    
    /**
     * Transver the grid and determine the next state for each cell.
     */
    @Override
    public void determineNextStates() {
        for (int i = 0; i < this.getGrid().getNumRow(); i++) {
            for (int j = 0; j < this.getGrid().getNumCol(); j++) {
                SpreadingOfFireCell cell = (SpreadingOfFireCell) this.getGrid().item(i, j);
                if (cell.getState() == SpreadingOfFireCell.BURNING) {
                    determineNextStatesBurning(cell);
                }
                else if (cell.getState() == SpreadingOfFireCell.NORMAL) {
                    List<Cell> neighbors = getGrid().getDirectNeighbors(i, j);
                    determineNextStatesNormal(cell, neighbors);
                }
                else if (cell.getState() == SpreadingOfFireCell.EMPTY) {
                    determineNextStatesEmpty(cell);
                }
            }
        }
    }
}
