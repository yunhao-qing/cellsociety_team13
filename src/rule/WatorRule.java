package rule;

import cell.Cell;
import simulation.Grid;
import cell.WatorCell;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yunhao Qing
 * A specific Rule class for Wator, rules are set based on
 * http://nifty.stanford.edu/2011/scott-wator-world/.

 */
public class WatorRule extends Rule {
    private final int REPRODUCTION_FISH;
    private final int REPRODUCTION_SHARK;
    
    /**
     * Constructor for WatorRule.
     */
    public WatorRule(Grid grid, List<Double> extraParameters) {
        super(grid, extraParameters);
        REPRODUCTION_FISH = (int) Math.floor(extraParameters.get(0));
        REPRODUCTION_SHARK = (int) Math.floor(extraParameters.get(1));
        this.getStateMap().put(WatorCell.FISH, "FISH");
        this.getStateMap().put(WatorCell.EMPTY, "EMPTY");
        this.getStateMap().put(WatorCell.SHARK, "SHARK");
    }
    
    /** 
     * This method move a fish/shark to a random neighbor if possible.
     * It returns true if the fish/shark has moved and return false if there is
     * no possible neighbor cell to move to, i.e. the fish/shark does not move.
     */
     
    private boolean moveCell(WatorCell cell, List<Cell> neighbors){
        List<Cell> possMoves = new ArrayList<>();
        for (Cell neighbor : neighbors) {
            if (neighbor.getState() == WatorCell.EMPTY &&
                    neighbor.getNextState() == Cell.UNINITIALIZED) {
                possMoves.add(neighbor);
            }
        }
        if (!possMoves.isEmpty()) {
            WatorCell move = (WatorCell) possMoves.get(Rule.rand.nextInt(possMoves.size()));
            move.setNextState(cell.getState());
            move.setSurviveTime(cell.getSurviveTime());
            cell.setNextState(WatorCell.EMPTY);
            cell.setSurviveTime(0);
            return true;
        }
        return false;
    }

    /** 
     * This method allows a fish/shark to a reproduce to a random neighbor cell
     * if possible. It returns true if the fish/shark has reproduced and return 
     * false if there is no possible neighbor cell to reproduce to, i.e. the 
     * fish/shark does not reproduce.
     */
     
    private boolean reprobCell(WatorCell cell,List<Cell> neighbors){
        if ((cell.getState() == WatorCell.SHARK && cell.getSurviveTime() >= REPRODUCTION_SHARK)
                || (cell.getState() == WatorCell.FISH && cell.getSurviveTime() >= REPRODUCTION_FISH)) {

            List<Cell> possReprobs = new ArrayList<>();
            for (Cell neighbor : neighbors) {
                if (neighbor.getState() == WatorCell.EMPTY &&
                        neighbor.getNextState() == Cell.UNINITIALIZED) {
                    possReprobs.add(neighbor);
                }
            }
            if (!possReprobs.isEmpty()) {
                cell.setSurviveTime(0);
                Cell reprob = possReprobs.get(Rule.rand.nextInt(possReprobs.size()));
                reprob.setNextState(cell.getState());
                return true;
            }
        }

        return false;
    }
    
    /** 
     * This method allows a shark to eat a fish in a neighbor cell if possible.
     * It returns true if the shark eats a fish and return false if there is no 
     * possible neighbor cell that has fish to be eaten to, i.e. the 
     * shark does not eat fish.
     */
     
    private boolean eatCell(List<Cell> neighbors){
        List<Cell> possFoods = new ArrayList<>();
        for (Cell neighbor : neighbors) {
            if (neighbor.getState() == WatorCell.FISH &&
                    neighbor.getNextState() == Cell.UNINITIALIZED) {
                possFoods.add(neighbor);
            }
        }
        if (!possFoods.isEmpty()) {
            WatorCell food = (WatorCell) possFoods.get(Rule.rand.nextInt(possFoods.size()));
            food.setNextState(WatorCell.EMPTY);
            food.setSurviveTime(0);
            return true;
        }
        return false;
    }
    /**
     * Tranverse the whole grid the first time to update the grid after shark's
     * actions.
     * Tranverse the second time for fish to move or reproduce if they are not
     * eaten by the sharks.
     * Tranverse the third time for all cells that are unchanged remain its
     * current state in the next state.
     */
    @Override
    public void determineNextStates() {
        sharkAction();
        fishAction();
        emptyAction();
    }

    private void sharkAction() {
        for (int i = 0; i < this.getGrid().getNumRow(); i++) {
            for (int j = 0; j < this.getGrid().getNumCol(); j++) {
                WatorCell cell = (WatorCell) this.getGrid().item(i, j);
                if (cell.getState() == WatorCell.SHARK) {
                    cell.setSurviveTime(cell.getSurviveTime() + 1);
                    List<Cell> neighbors = getGrid().getDirectNeighbors(i, j);
                    if (!reprobCell(cell,neighbors) && !eatCell(neighbors)) {
                        moveCell(cell,neighbors);
                    }
                }
            }
        }
    }

    private void fishAction() {
        for (int i = 0; i < this.getGrid().getNumRow(); i++) {
            for (int j = 0; j < this.getGrid().getNumCol(); j++) {
                WatorCell cell = (WatorCell) this.getGrid().item(i, j);
                if (cell.getState() == WatorCell.FISH && cell.getNextState() == Cell.UNINITIALIZED) {
                    cell.setSurviveTime(cell.getSurviveTime() + 1);
                    List<Cell> neighbors = getGrid().getDirectNeighbors(i, j);
                    if (!reprobCell(cell,neighbors)) {
                        moveCell(cell,neighbors);
                    }
                }
            }
        }
    }

    private void emptyAction() {
        for (int i = 0; i < this.getGrid().getNumRow(); i++) {
            for (int j = 0; j < this.getGrid().getNumCol(); j++) {
                WatorCell cell = (WatorCell) this.getGrid().item(i, j);
                if (cell.getNextState() == Cell.UNINITIALIZED) {
                    cell.setNextState(cell.getState());
                }
            }
        }
    }
}