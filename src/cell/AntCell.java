package cell;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yunhao Qing
 * This is a class specific for Ant Forage, cell behaviours are set
 * based on https://cs.gmu.edu/~eclab/projects/mason/publications/alife04ant.pdf.
 * The AntForageCell can have 3 states, being empty, nest or food.
 */
 
public class AntCell extends Cell {
    public static final int EMPTY = 0;
    public static final int NEST = 1;
    public static final int FOOD = 2;
    private double foodPheromones;
    private double nestPheromones;

    /**
     * Constructor for AntForageCell.
     */
    public AntCell(int state, int i, int j) {
        super(state, i, j);
        this.foodPheromones = 0.0;
        this.nestPheromones = 0.0;
    }

    public double getFoodPheromones(){
        return foodPheromones;
    }

    public void setFoodPheromones(double d){
        foodPheromones = d;
    }

    public double getNestPheromones(){
        return nestPheromones;
    }

    public void setNestPheromones(double d){
        nestPheromones = d;
    }

}
