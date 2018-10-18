Author
------
* Haotian Wang (hw186)
* Priyanka Purohit (pkp9)

Part 1
------
1. What is an implementation decision that your design is encapsulating (i.e., hiding) for other areas of the program?
   * Instance variables of many classes are hidden from other classes.
   * Vincent encapsulates the GUI and rule from the main class. People can only add JavaFx nodes from the GUI class.
   * Priyanka's group, the main does not have access to screen dimensions and cell dimensions. The interface class handles that.
   * Our UI class at this point just load the initial button and user interfaces into the stage.
2. What inheritance hierarchies are you intending to build within your area and what behavior are they based around?
   * The UI class has access to the XMLReader class.
   * There is an abstract simulation class. Each specific game extends the simulation class. The simulation class has general update, reset methods. Visualization is responsible for adding all the cells to the initial view.
   * There is no cell class yet.
3. The UI does not to need to care about the specific game type. Priyanka's UI class cares about the specific cell type, for example red and green types. The color codes are written in UI class.
   * For us, the change of appearances of cells are done in the cells themselves.
4. What exceptions (error cases) might occur in your area and how will you handle them (or not, by throwing)?
   * FileNotFoundException. The user will type in the file path to the file, or the name of the XML file. Check whether the capitalization affects the situation. Print file not found.
   * WrongFormatException. JavaFx FileChooser class. Print a message saying the format of XML file is wrong.
   * ImplementationNotFoundException. Print a message saying what classes are needed to run that simulation.
   * FileNotFoundException, when one tries to create an ImageView object from a file that does not exist.
5. Why do you think your design is good (also define what your measure of good is)?
   * Abstract cell and simulation. That is good because extension of new features does not require user to understand or add new code to existing classes.
   * Having an XMLParser class is good, because it can focus on extracting all the details, and any updates on XML file format can be done by editing the parser class only.

Part 2
------
1. How is your area linked to/dependent on other areas of the project?
   * Visualization class has to know which simulation, colors, cell and grid dimensions from the XMLParser. It needs to know which cells to update, depending on what states that simulation classes change.
2. Are these dependencies based on the other class's behavior or implementation?
   * Yes. If Visualization handles the updating of cells' appearance. it's based on the actual simulation.
3. How can you minimize these dependencies?
   * By letting simulation class handle the updating of cells.
4. Go over one pair of super/sub classes in detail to see if there is room for improvement.
   Focus on what things they have in common (these go in the superclass) and what about them varies (these go in the subclass).
   * We both have an abstract simulation class, and four specific subclasses extending that class. Their methods like updateCells, reset, etc.