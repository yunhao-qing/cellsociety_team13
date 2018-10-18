package rule;

import cell.Cell;
import cell.RockPaperScissorCell;
import simulation.Grid;

import java.util.List;
import java.util.Random;

/**
 * @author Julia Saveliff
 */
public class RockPaperScissorRule extends Rule {
    private Random rand = new Random();

    private final double OPACITY_INCREMENT; // TODO: Read in from XML file

    public RockPaperScissorRule(Grid grid, List<Double> extraParameters) {
        super(grid, extraParameters);
        OPACITY_INCREMENT = extraParameters.get(0);
        this.getStateMap().put(RockPaperScissorCell.EMPTY, "EMPTY");
        this.getStateMap().put(RockPaperScissorCell.PAPER, "PAPER");
        this.getStateMap().put(RockPaperScissorCell.ROCK, "ROCK");
        this.getStateMap().put(RockPaperScissorCell.SCISSOR, "SCISSOR");
    }

    @Override
    public void determineNextStates() {
        for (int i = 0; i < this.getGrid().getNumRow(); i++) {
            for (int j = 0; j < this.getGrid().getNumCol(); j++) {
                Cell cell = this.getGrid().item(i, j);
                List<Cell> neighbors = this.getGrid().getAllNeighbors(i, j);
                Cell neighbor = neighbors.get(rand.nextInt(neighbors.size()));

                if (cell.getState() != RockPaperScissorCell.EMPTY) {
                    if (neighbor.getState() != RockPaperScissorCell.EMPTY) {
                        if (cell.getState() == neighbor.getState()){
                            cell.setNextState(cell.getState());
                        } else if (((RockPaperScissorCell) cell).beats(neighbor) ) {
                            cell.setNextState(cell.getState());
                            if (cell.getOpacity()<1) {
                                cell.setOpacity(cell.getOpacity()+OPACITY_INCREMENT);
                            }
                        } else {
                            cell.setNextState(neighbor.getState());
                            if (cell.getOpacity()>0) {
                                cell.setOpacity(cell.getOpacity()-OPACITY_INCREMENT);
                            }
                        }
                    } else {
                        cell.setNextState(cell.getState());
                    }
                } else {
                    if (neighbor.getState() != RockPaperScissorCell.EMPTY) {
                        if (neighbor.getOpacity()>0) {
                            cell.setNextState(neighbor.getState());
                            cell.setOpacity(cell.getOpacity()-OPACITY_INCREMENT);
                        } else {
                            cell.setNextState(cell.getState());
                        }
                    }
                    else {
                        cell.setNextState(cell.getState());
                    }
                }
            }
        }
    }

}
