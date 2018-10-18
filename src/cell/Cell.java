package cell;

/**
 * @author Haotian Wang
 * An abstract class for a cell that has the properties of a cell in a simulation, and also its row and column index in the grid class.
 */
public abstract class Cell {
    public static final int UNINITIALIZED = -1;

    private int rowIndex;
    private int colIndex;
    private int myState;
    private int myNextState;
    private double myOpacity; // NEW CODE

    public Cell(int state, int i, int j) {
        this.rowIndex = i;
        this.colIndex = j;
        this.myState = state;
        this.myNextState = UNINITIALIZED;
        this.myOpacity = 1.0;
    }

    // Getter and setter methods for all instance variables
    public int getNextState() {
        return myNextState;
    }

    public void setNextState(int state) { myNextState = state; }

    public int getState() { return myState; }

    public void setState(int state) { myState = state; }

    public void updateToNextState() { myState = myNextState; }

    public int getRowIndex() { return rowIndex; }

    public int getColIndex() { return colIndex; }

    public double getOpacity() { return myOpacity; } // NEW CODE

    public void setOpacity(double value) { myOpacity = value; } // NEW CODE
}

