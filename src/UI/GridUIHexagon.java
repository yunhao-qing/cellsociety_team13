package UI;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Polygon;
import simulation.Grid;

import java.util.ResourceBundle;

/**
 * @author Haotian Wang
 * A GridUI subclass that implements a grid of hexangonal cells.
 */
public class GridUIHexagon extends GridUI {
    private double cellWidth;
    private double cellHeight;
    private double edge;

    public GridUIHexagon(Grid grid, ResourceBundle resource) {
        super(grid, resource);
    }

    @Override
    protected void calculateLengths() {
        cellHeight = getSimulationHeight() / (getMyGrid().getNumRow() + 1);
        edge = cellHeight / 2 / Math.sqrt(3);
        cellWidth = (getSimulationWidth() - edge) / getMyGrid().getNumCol() - edge;
    }

    @Override
    protected void addShape(int i, int j, int state) {
        Node temp = new Polygon();

        if (j % 2 == 0) {
            ((Polygon) temp).getPoints().addAll(new Double[] {
                    edge + j * (cellWidth + edge), i * cellHeight,
                    edge + j * (cellWidth + edge) + cellWidth, i * cellHeight,
                    edge + j * (cellWidth + edge) + cellWidth + edge, i * cellHeight + cellHeight / 2,
                    edge + j * (cellWidth + edge) + cellWidth, i * cellHeight + cellHeight,
                    edge + j * (cellWidth + edge), i * cellHeight + cellHeight,
                    edge + j * (cellWidth + edge) - edge, i * cellHeight + cellHeight / 2,
            });
        }
        else if (j % 2 == 1) {
            ((Polygon) temp).getPoints().addAll(new Double[] {
                    edge + j * (cellWidth + edge), i * cellHeight + cellHeight / 2,
                    edge + j * (cellWidth + edge) + cellWidth, i * cellHeight + cellHeight / 2,
                    edge + j * (cellWidth + edge) + cellWidth + edge, i * cellHeight + cellHeight,
                    edge + j * (cellWidth + edge) + cellWidth, i * cellHeight + cellHeight * 3 / 2,
                    edge + j * (cellWidth + edge), i * cellHeight + cellHeight * 3 / 2,
                    edge + j * (cellWidth + edge) - edge, i * cellHeight + cellHeight,
            });
        }
        ((Polygon) temp).setFill(getIntToPaintMap().get(state));
        getMyNodes().add(temp);
    }

    @Override
    protected void addImageView(int i, int j, int state) {
        Node temp = new ImageView(getIntToImageMap().get(state));
        ((ImageView) temp).setX(0.5 * edge + j * (cellWidth + edge));
        if (j % 2 == 0) {
            ((ImageView) temp).setY(i * cellHeight + cellHeight / 4);
        }
        else if (j % 2 == 1) {
            ((ImageView) temp).setY(i * cellHeight + 0.75 * cellHeight);
        }
        ((ImageView) temp).setFitWidth(cellHeight + edge);
        ((ImageView) temp).setFitHeight(0.5 * cellHeight);
        getMyNodes().add(temp);
    }
}
