package rule;

import cell.Cell;
import simulation.Grid;

import java.util.*;

/**
 * @author Haotian Wang
 * An abstract class that defines the rules for updating the states of cells in a grid. Determine what the next states
 */
public abstract class Rule {

    public final static Random rand = new Random();
    private Grid myGrid;
    private Map<Integer,String> myStateMap = new HashMap<>();

    /**
     * Construct a Rule object using grid as the only parameter.
     * @param grid: the Grid object containing the information of the grid of cells.
     */
    public Rule (Grid grid, List<Double> extraParameters) {
        this.myGrid = grid;
    }

    /**
     * Update all the Cells in the grid to their next states.
     */
    public void updateGrid() {
        for (int i = 0; i < this.getGrid().getNumRow(); i++) {
            for (int j = 0; j < this.getGrid().getNumCol(); j++) {
                this.getGrid().item(i, j).updateToNextState();
                this.getGrid().item(i, j).setNextState(Cell.UNINITIALIZED);
            }
        }
    }

    /**
     * Calculate and set the next states of all the cells in the grid.
     */
    public abstract void determineNextStates();

    /**
     * Allow access for the subclasses of rule to the abstract Rule class' Grid object.
     * @return myGrid: a Grid object.
     */
    protected Grid getGrid () {
        return myGrid;
    }

    public Map<Integer,String> getStateMap() {
        return myStateMap;
    }
}
