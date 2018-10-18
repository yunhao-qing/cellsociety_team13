package simulation;

import java.io.File;
import java.util.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import UI.UIManager;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

/**
 * @author Julia Saveliff, Yunhao Qing, Haotian Wang
 */
public class ReadXML {
    private String name;
    private int row;
    private int column;
    private int[][] cellState;
    private List<Double> extraParameters;
    private final static Random rand = new Random();
    private Document document;
    private final static String XMLFileOpenException = "The system is unable to open the file, the file may be damaged." +
            "Please select a valid XML file";
    private final static String XMLFileSimException = "Invalid or no simulation type given.";
    private final static String XMLFileGridException = "Grid Configuration not given or incorrectly formatted.";
    private final static String XMLFileCellStateException = "The cell configuration in the XML is missing or " +
            "incorrect or not supported at this point of time.";
    private final static String XMLFileParaException = "The extra parameters in the XML files are missing or incorrectly" +
            "formatted.";
    private final static String XMLFileAuthorException ="The author is not found or incorrectly formatted.";
    private final static String XMLFileDescriptionException = "The description is not found or incorrectly formatted.";



    private String author;
    private String description;
    private Map<String, Double> myParameters;



    /**
     * Constructor for ReadXML with the file, the xml file.
     * It reads the type of simulation, grid and initial states configuration
     * and extra parameters for each specific simulation.
     */
    public ReadXML (File file) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();
        } catch (Exception e ) {
            UIManager.showWarningPopup(XMLFileOpenException);
        }
        try {
            this.name = returnString("name");
        }
        catch (Exception e ) {
            UIManager.showWarningPopup(XMLFileSimException);
        }
        this.extraParameters = new ArrayList<>();
        readGrid();
        readState();
        readExtraParameters();
        try{
        author = returnString("author");}
        catch (Exception e){
            UIManager.showWarningPopup(XMLFileAuthorException);
        }
        try{
        description = returnString("description"); }
        catch(Exception e){
            UIManager.showWarningPopup(XMLFileDescriptionException);
        }
    }
    
    /**
     * Read in initial state for each cell and update the 2D array cellState.
     */
    private void readState() {
        try {
            NodeList typeList = document.getElementsByTagName("cellState");
            String dataType = typeList.item(0).getAttributes().getNamedItem("dataType").getNodeValue();
            if (dataType.equals("list")) {
                readStateList();
            } else if (dataType.equals("ratio")) {
                readStateRatio();
            } else if (dataType.equals("random")) {
                readStateRandom();
            }
        }
        catch (Exception e){
            UIManager.showWarningPopup(XMLFileCellStateException);
        }
    }

    private void readStateList() {
        NodeList nodeList = document.getElementsByTagName("state");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            int stateNumber = Integer.parseInt(node.getAttributes().getNamedItem("stateNumber").getNodeValue());
            String temp = node.getTextContent();
            for (String s : temp.split(" ")){
                int index = Integer.parseInt(s);
                cellState[index/column][index%column] = stateNumber;
            }
        }
    }

    private void readStateRatio() {
        NodeList nodeList = document.getElementsByTagName("state");
        double[] myStateRatio = new double[nodeList.getLength()];
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            int stateNumber = Integer.parseInt(node.getAttributes().getNamedItem("stateNumber").getNodeValue());
            String temp = node.getTextContent();
            double stateRatio = Double.parseDouble(temp);
            if (stateNumber == 0){
                myStateRatio[stateNumber] = stateRatio;
            }
            else{
                myStateRatio[stateNumber] = stateRatio + myStateRatio[stateNumber - 1];
            }
        }

        for (int i = 0 ; i < row; i++){
            for (int j = 0; j < column; j++){
                double randNum  = rand.nextDouble();
                for (int k = 0; k < myStateRatio.length; k++){
                    if (randNum <= myStateRatio[k]){
                        cellState[i][j] = k;
                        break;
                    }
                }
            }
        }
    }

    private void readStateRandom() {
        NodeList nodeList = document.getElementsByTagName("state");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                cellState[i][j] = rand.nextInt(nodeList.getLength());
            }
        }
    }

    /**
     * Return the extra parameters specified in the XML file if there is any.
     */
    private void readExtraParameters() {
        try {
            myParameters = new HashMap<>();
            String parameters = returnString("extraParameters");
            if (!parameters.equals("")) {
                String[] parameterList = parameters.split(" ");
                for (String para : parameterList) {
                    double value = returnDouble(para);
                    this.extraParameters.add(value);
                    myParameters.put(para, value);
                }
            }
        }
        catch (Exception e){
            UIManager.showWarningPopup(XMLFileParaException);
        }
    }

    /**
     * Read in the grid configuration and initialise the 2D array cellState.
     */
    private void readGrid() {
        try{
        row = returnInt("row");
        column = returnInt("col");
        cellState = new int[row][column];}
        catch (Exception e){
            UIManager.showWarningPopup(XMLFileGridException);
        }
    }

    private int returnInt(String tag) {
        return Integer.parseInt(returnString(tag));
    }
    
    private double returnDouble(String tag) {
        return Double.parseDouble(returnString(tag));
    }

    private String returnString(String tag) {
        return document.getElementsByTagName(tag).item(0).getTextContent();
    }

    public List<Double> getExtraParameters() {
        return this.extraParameters;
    }

    public String getName(){return name;}

    public int getRow(){return row;}

    public int getColumn(){return column;}

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }
    public int[][] getCellState(){return cellState;}

    public String getMyParameters() { return "The extra parameters are " + myParameters.toString(); }
}


