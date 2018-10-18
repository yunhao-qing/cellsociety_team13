package rule;

import cell.Cell;
import cell.GameOfLifeCell;
import simulation.Grid;

import java.util.List;

/**
 * @author Haotian Wang
 * A specific Rule class for GameOfLife game, adapting from https://en.wikipedia.org/wiki/Conway's_Game_of_Life#Rules.
 */
public class GameOfLifeRule extends Rule {
    private final int UNDERPOPULATION_THRESHOLD;
    private final int OVERPOPULATION_THRESHOLD;

    public GameOfLifeRule(Grid grid, List<Double> extraParameters) {
        super(grid, extraParameters);
        UNDERPOPULATION_THRESHOLD = (int) Math.floor(extraParameters.get(0));
        OVERPOPULATION_THRESHOLD = (int) Math.floor(extraParameters.get(1));
        this.getStateMap().put(GameOfLifeCell.ALIVE, "ALIVE");
        this.getStateMap().put(GameOfLifeCell.DEAD, "DEAD");
    }

    @Override
    public void determineNextStates() {
        for (int i = 0; i < this.getGrid().getNumRow(); i++) {
            for (int j = 0; j < this.getGrid().getNumCol(); j++) {
                Cell cell = this.getGrid().item(i, j);
                List<Cell> neighbors = getGrid().getAllNeighbors(i, j);
                checkCell(cell, neighbors);
            }
        }
    }
    
    private void checkCell(Cell cell, List<Cell> neighbors){
        int numAliveNeighbors = 0;
        for (Cell neighbor : neighbors) {
            if (neighbor != null && neighbor.getState() == GameOfLifeCell.ALIVE) {
                numAliveNeighbors++;
            }
        }
        if (cell.getState() == GameOfLifeCell.DEAD && numAliveNeighbors == OVERPOPULATION_THRESHOLD) {
            cell.setNextState(GameOfLifeCell.ALIVE);
        } else if (cell.getState() == GameOfLifeCell.ALIVE &&
                (numAliveNeighbors < UNDERPOPULATION_THRESHOLD || numAliveNeighbors > OVERPOPULATION_THRESHOLD)) {
            cell.setNextState(GameOfLifeCell.DEAD);
        } else {
            cell.setNextState(cell.getState());
        }
    }
}
