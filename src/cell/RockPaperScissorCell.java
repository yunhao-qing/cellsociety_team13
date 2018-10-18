package cell;

/**
 * @author Julia Saveliff
 */
public class RockPaperScissorCell extends Cell {
    public static final int EMPTY = 0;
    public static final int ROCK = 1;
    public static final int PAPER = 2;
    public static final int SCISSOR = 3;

    public RockPaperScissorCell(int state, int i, int j) {
        super(state,i,j);
    }

    public boolean beats(Cell other) {
        return (this.getState() == ROCK && other.getState() == SCISSOR) ||
                (this.getState() == SCISSOR && other.getState() == PAPER) ||
                (this.getState() == PAPER && other.getState() == ROCK);
    }

}
