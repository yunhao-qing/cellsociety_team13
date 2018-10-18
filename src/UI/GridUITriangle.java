package UI;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Polygon;
import simulation.Grid;

import java.util.ResourceBundle;

/**
 * @author Haotian Wang
 * A GridUI subclass that implements a grid of triangular cells.
 */
public class GridUITriangle extends GridUI {
    private double sideLength;
    private double cellHeight;
    private double edge;
    private double imageWidth;
    private double imageHeight;

    public GridUITriangle(Grid grid, ResourceBundle resource) {
        super(grid, resource);
    }

    @Override
    protected void calculateLengths() {
        sideLength = getSimulationWidth() / (getMyGrid().getNumCol() * 0.5 + 0.5);
        cellHeight = getSimulationHeight() / getMyGrid().getNumRow();
        edge = sideLength / 4;
        imageWidth = 0.5 * sideLength;
        imageHeight = 0.5 * cellHeight;
    }

    @Override
    protected void addShape(int i, int j, int state) {
        Node temp = new Polygon();

        if (i % 2 == 0 && j % 2 == 0) {
            ((Polygon) temp).getPoints().addAll(new Double[] {
                    j / 2 * sideLength, i * cellHeight,
                    j / 2 * sideLength + sideLength, i * cellHeight,
                    j / 2 * sideLength + sideLength / 2, i * cellHeight + cellHeight,
            });
        }
        else if (i % 2 == 0 && j % 2 == 1) {
            ((Polygon) temp).getPoints().addAll(new Double[] {
                    0.5 * sideLength + j / 2 * sideLength, cellHeight + i * cellHeight,
                    1.5 * sideLength + j / 2 * sideLength, cellHeight + i * cellHeight,
                    sideLength + j / 2 * sideLength, i * cellHeight,
            });
        }
        else if (i % 2 == 1 && j % 2 == 0) {
            ((Polygon) temp).getPoints().addAll(new Double[] {
                    j / 2 * sideLength, i * cellHeight + cellHeight,
                    j / 2 * sideLength + sideLength, i * cellHeight + cellHeight,
                    j / 2 * sideLength + sideLength / 2, i * cellHeight,
            });
        }
        else if (i % 2 == 1 && j % 2 == 1) {
            ((Polygon) temp).getPoints().addAll(new Double[] {
                    0.5 * sideLength + j / 2 * sideLength, i * cellHeight,
                    1.5 * sideLength + j / 2 * sideLength, i * cellHeight,
                    sideLength + j / 2 * sideLength, i * cellHeight + cellHeight,
            });
        }
        ((Polygon) temp).setFill(getIntToPaintMap().get(state));
        getMyNodes().add(temp);
    }

    @Override
    protected void addImageView(int i, int j, int state) {
        Node temp = new ImageView(getIntToImageMap().get(state));
        ((ImageView) temp).setFitHeight(imageHeight);
        ((ImageView) temp).setFitWidth(imageWidth);
        if (i % 2 == 0 && j % 2 == 0) {
            ((ImageView) temp).setX(j / 2 * sideLength + edge);
            ((ImageView) temp).setY(i * cellHeight);
        }
        else if (i % 2 == 0 && j % 2 == 1) {
            ((ImageView) temp).setX(0.5 * sideLength + j / 2 * sideLength + edge);
            ((ImageView) temp).setY(cellHeight + i * cellHeight - imageHeight);
        }
        else if (i % 2 == 1 && j % 2 == 0) {
            ((ImageView) temp).setX(j / 2 * sideLength + edge);
            ((ImageView) temp).setY(i * cellHeight + cellHeight - imageHeight);
        }
        else if (i % 2 == 1 && j % 2 == 1) {
            ((ImageView) temp).setX(0.5 * sideLength + j / 2 * sideLength + edge);
            ((ImageView) temp).setY(i * cellHeight);
        }
        getMyNodes().add(temp);
    }
}
