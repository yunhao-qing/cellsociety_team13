package cell;

/**
 * @author Yunhao Qing
 * This is a class specific for SpreadingOfFireCell, cell behaviours are set 
 * based on http://nifty.stanford.edu/2011/scott-wator-world/.
 * The SpreadingOfFireCell can have 3 states, being empty, a normal tree or 
 * a burning tree.
 */
public class SpreadingOfFireCell extends Cell {
    public static final int EMPTY = 0;
    public static final int NORMAL = 1;
    public static final int BURNING = 2;

    private int myBurningTime;

    /**
     * Constructor for SpreadingOfFireCell.
     */
    public SpreadingOfFireCell(int state, int i, int j) {
        super(state, i, j);
        this.myBurningTime = 0;
    }

    /**
     * @return mySurviveTime how long a burning tree has been burning.
     */
    public int getBurningTime() {
        return myBurningTime;
    }

    /**
     * @param time the new time that the burning tree has been burning.
     */
    public void setBurningTime(int time) {
        myBurningTime = time;
    }

}
