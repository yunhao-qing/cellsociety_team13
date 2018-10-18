package cell;

/**
 * @author Yunhao Qing
 * This is a class specific for WatorCell, cell behaviours are set based on
 * http://nifty.stanford.edu/2011/scott-wator-world/.
 * The WatorCell can have 3 states, being empty, a fish or a shark.
 */
public class WatorCell extends Cell {
    public static final int EMPTY = 0;
    public static final int FISH = 1;
    public static final int SHARK = 2;

    private int mySurviveTime;
    
    /**
     * Constructor for WatorCell.
     */
    public WatorCell(int state, int i, int j) {
        super(state, i, j);
        this.mySurviveTime = 0;
    }
    
    /**
     * @return mySurviveTime how long the fish/shark has survived from last
     * reproduction.
     */
    public int getSurviveTime() {
        return mySurviveTime;
    }
    
    /**
     * @param time the new time that the fish/shark has survived from last
     * reproduction.
     */
    public void setSurviveTime(int time) {
        mySurviveTime = time;
    }

}
