package cell;

/**
 * @author Julia Saveliff
 */
public class LoopCell extends Cell {
    private static final int EMPTY = 0;
    private static final int DATA = 1;
    private static final int WALL = 2;
    private static final int LEADER = 3;
    private static final int TURNER = 4;
    private static final int DISCONNECT = 5;

    public static final int UP = -1;
    public static final int DOWN = 1;
    public static final int RIGHT= 2;
    public static final int LEFT = -2;

    private int myDirection;

    public LoopCell(int state, int i, int j) {
        super(state,i,j);
        myDirection = UP;

    }

    public void setDirection(int dir) { myDirection = dir; }

    public int getDirection() { return myDirection; }


}
