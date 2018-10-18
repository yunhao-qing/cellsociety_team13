cell society
====

This project implements a cellular automata simulator.

Authors (in alphabetical order):
* Haotian Wang (hw186),
* Julia Saveliff (jms247)
* Yunhao Qing (yq50)

### Timeline

Start Date: 09/15/2018

Finish Date: 10/01/2018

Hours Spent: 100+ hours for each person

### Primary Roles
* cell
    * Cell: Haotian Wang
        * GameOfLifeCell: Haotian Wang
        * LoopCell: Julia Saveliff
        * RockPaperScissorCell: Julia Saveliff
        * SegregationCell: Haotian Wang
        * SpreadingOfFireCell: Yunhao Qing
        * WatorCell: Yunhao Qing
        * AntCell: Yunhao Qing
            * AntForageAnt: Yunhao Qing
* controller
    * CA: Julia Saveliff, Haotian Wang
* simulation
    * Grid: Haotian Wang, Julia Saveliff
* rule
    * Rule: Haotian Wang
        * GameOfLifeRule: Haotian Wang
        * SegregationRule: Haotian Wang, Julia Saveliff
        * SpreadingOfFireRule: Yunhao Qing
        * WatorRule: Yunhao Qing
        * AntRule: Yunhao Qing
        * LoopRule: Julia Saveliff
        * RockPaperScissorRule: Julia Saveliff
* UI
    * UIManager: Julia Saveliff, Haotian Wang
    * GridUI: Haotian Wang
        * GridUIHexagon: Haotian Wang
        * GridUISquare: Haotian Wang
        * GridUITriangle: Haotian Wang
    * UI property files
        * UI_graphic.properties: Haotian Wang
        * UI_text.properties: Julia Saveliff
* ReadXML: Julia Saveliff, Yunhao Qing, Haotian Wang
* XML format: Yunhao Qing
* Error Handling Check: Yunhao Qing

### Resources Used

###### Images
* [alive.gif](https://commons.wikimedia.org/wiki/File:Solid_white.png)
* [dead.gif](https://commons.wikimedia.org/wiki/File:Solid_black.png)

###### Articles
* [Schelling's Model of Segregation](http://nifty.stanford.edu/2014/mccown-schelling-model-segregation/)
* [Oracle documentation on Circle](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Circle.html)
* [Java: Self for static method calls within the same class](https://stackoverflow.com/questions/22700944/java-self-for-static-method-calls-within-the-same-class)
* [Calling a subclass method from superclass](https://stackoverflow.com/questions/10021603/calling-a-subclass-method-from-superclass)
* [Is there a way to instantiate a class by name in Java?](https://stackoverflow.com/questions/9886266/is-there-a-way-to-instantiate-a-class-by-name-in-java)
* [Conway's Game of Life](https://en.wikipedia.org/wiki/Conway's_Game_of_Life#Rules)
* [Oracle documentation on Class](https://docs.oracle.com/javase/7/docs/api/java/lang/Class.html#getConstructor(java.lang.Class...))
* [Initialize a static final field in the constructor](https://stackoverflow.com/questions/5093744/initialize-a-static-final-field-in-the-constructor)
* [Integer.class vs int.class](https://l.messenger.com/l.php?u=https%3A%2F%2Fstackoverflow.com%2Fquestions%2F22470985%2Finteger-class-vs-int-class&h=AT0oxh3T6S7cgm3CMzhRzM-bvukfJYa5z3dXlGkvSAJkB-cd-ucubCPXM4pLevC69Rc95Srq_DW-I0h1FdTZsHNwYd470REraRFeRU-z1YK_47OpJFGXvmkI6ulIDw)
* [How to permanently remove few commits from remote branch](https://stackoverflow.com/questions/3293531/how-to-permanently-remove-few-commits-from-remote-branch)
* [Split() String method in Java with examples](https://www.geeksforgeeks.org/split-string-java-examples/)
* [Is there a way to instantiate a class by name in Java?](https://stackoverflow.com/questions/9886266/is-there-a-way-to-instantiate-a-class-by-name-in-java)
* [How to convert Double to int directly?](https://stackoverflow.com/questions/5404149/how-to-convert-double-to-int-directly)
* [Oracle documentation on Random](https://docs.oracle.com/javase/7/docs/api/java/util/Random.html)
* [Location-Independent Access to Resources](https://docs.oracle.com/javase/8/docs/technotes/guides/lang/resources.html).
* [How do I invoke a Java method when given the method name as a string?](https://stackoverflow.com/questions/160970/how-do-i-invoke-a-java-method-when-given-the-method-name-as-a-string)
* [Oracle documentation on Shape](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Shape.html)
* [Oracle documentation on InvocationTargetException](https://docs.oracle.com/javase/7/docs/api/java/lang/reflect/InvocationTargetException.html)
* [Oracle documentation on JavaFx Color](https://docs.oracle.com/javafx/2/api/javafx/scene/paint/Color.html)
* [The Java ternary operator examples](https://alvinalexander.com/java/edu/pj/pj010018)
* [Line Chart Documentation](https://docs.oracle.com/javafx/2/charts/line-chart.htm#CIHGBCFI)
* [More on Self Replication CA](https://www.asa3.org/ASA/PSCF/1989/PSCF3-89Byl.html)
* [More on Byl's CA](http://cafaq.com/apps/index.php)
* [Langton's Loop](https://en.wikipedia.org/wiki/Langton's_loops)
* [Byl's Loop](https://en.wikipedia.org/wiki/Byl%27s_loop)
* [Self Replication CA](http://lslwww.epfl.ch/pages/embryonics/thesis/Chapter3.html)
* [Rock, Paper, Scissor CA](https://www.gamedev.net/blogs/entry/2249737-another-cellular-automaton-video/)
* [Line Chart Live Updates](https://stackoverflow.com/questions/22089022/line-chart-live-update)
* [JavaFX Dialogs](https://code.makery.ch/blog/javafx-dialogs-official/)
* [How to Handle Jave Exception](https://stackify.com/specify-handle-exceptions-java/)
* [Designing with Interfaces](https://www.artima.com/designtechniques/interfaces.html)
* [Designing with Exceptions](https://www.javaworld.com/article/2076721/core-java/designing-with-exceptions.html)
* [OO in one Sentence](https://media.pragprog.com/articles/may_04_oo1.pdf)


### Running the Program

Main class: CA

Data files needed: 

* `simulation/UI_text.properties` required to set all user interface text

* XML files to run simulation with:

    * `data/Wator.xml`
    * `data/WatorBig.xml`
    * `data/WatorLonelyShark.xml`
    * `data/WatorRatio.xml`
    * `data/antFixedStartingPoints.xml`
    * `data/fire.xml`
    * `data/fireNoRegrowth.xml`
    * `data/fireRandom.xml`
    * `data/gameOfLife.xml`
    * `data/gameOfLifeBig.xml`
    * `data/gameOfLifeFlicker.xml`
    * `data/gameOfLifeReappear.xml`
    * `data/loopTest.xml`
    * `data/rockPaperScissor.xml`
    * `data/rockPaperScissorBig.xml`
    * `data/rockPaperScissorLargeProbability.xml`
    * `data/segregation.xml`
    * `data/segregationBig.xml`

Interesting data files:

* `data/gameOfLifeFlicker.xml` oscillates between two states
* `data/gameOfLifeReappear.xml` involves a reappearing pattern of states
* `data/WatorLonelyShark.xml` shows what happens when there's only one non-reproducing shark

Assumptions or Simplifications:

* Simulation automatically stops after 500 generations 

* If a cell is listed as two different states in the XML file, it will be assigned whichever 
state is read last

* To avoid potential collisions in simulations where cells are to "move" about the grid, 
the current state and next state of different cells may be compared

Known Bugs:

* There are certain cases for invalid XML values that are not checked. For example, if a cell is assigned outside
of the grid's dimensions or if a cell goes unassigned

* If during a simulation, the user presses the `Load new simulation` button, but then just
presses `Start simulation` without loading a file, the simulation screen will not clear

* The Ant Foraging is not finished.


### Notes

XML tage and Display information on GUI

* In an effort to help you verify your project's design, add a tag to the XML configuration file format that notes a description for the simulation (i.e, what it is trying to test, its source, or why you think it is interesting) and a way in the GUI to see all the information about a simulation (author, description, and initial parameter values).<\br><\br>
* We accomplished this by adding a description tag in each xml file. The parameters, description and author can be displayed on the GUI for the user to easily understand the nature of the XML file and what it is testing specifically.

Simulation:

* Allow different numbers and arrangements of neighbors instead of assuming it will always be the total possible neighbors. <br /><br />
Achieved by writing different getNeighbour method for different cell shape in Grid Class and use the appropriate getNeighbour method
for specific simuation with different requirements. One can also easiler overwrite the getNeigbour method in a new simulation if there is
specific requirement. For example, in the ant simulation, there is forwared location cells and all cells. The specific getNieghbour method
can be easily written as the row and column indexes of each cell is easily accessible. These features make our code extremely flexible and easy
to implement new simulations.

* Allow a variety of grid location shapes (here is a discussion of how these variations might work for the game of life). <br /><br />
Yes, our code works for all 3 shapes - square, triangualr and hexagonal. This is fone not by hard coding in many classes, but all set
in the Grid clas. The specific simulation rule class works regardless of the grid location shape.

* Allow a variety of grid edge types. <br /><br />
Our code allows both finite and toroidal types. Toroidal type is implemented by introducing a new funcion in the grid class that wraps the
cells that are originally out of bounds. In the future, if new grid edge type is required, we can simply write new functions that apply
wrapping accorrfingly.

* Implement additional simulations (any simulations should work on any kinds of grid or neighborhood types) <br /><br />
We successfully implement the Rock, Paper, Scissors Game and finished most parts of Foraging Ants.

Configuration:

* Implement error checking for incorrect file data, such as (but not necessarily limited to)invalid or no simulation type given, invalid cell state values given, 
cell locations given that are outside the bounds of the grid's size appropriate default values when parameter values are invalid or not given. <br /><br />
Yes.We have 6 types of XML file error checking, and our XML reader throws the appropriate exception when there is an error.
The 6 types of errors are XMLFileOpenException ("The system is unable to open the file, the file may be damaged.Please select a valid XML file"),
    XMLFileSimException ("Invalid or no simulation type given."),
    XMLFileGridException (Grid Configuration not given or incorrectly formatted."),
    XMLFileCellStateException (The cell configuration in the XML is missing or incorrect or not supported at this point of time."),
    XMLFileParaException (The extra parameters in the XML files are missing or incorrectly formatted."),
    XMLFileAuthorException ("The author is not found or incorrectly formatted."),
    XMLFileDescriptionException (The description is not found or incorrectly formatted.").


* Allow simulations initial configuration to be set by list of specific locations and states, completely randomly based on a total number of 
locations to occupy, randomly based on probability/concentration distributions. <br /><br />
Yes.We are able to read in three types of data. First being list, we are given states of each cell and we just put in their state values in each cell.
The second data type being ratio, we are given ratio of the states, in XML reader, we decide state for each cell based on the ratio and record the state
accordingly.
The third data type being completely random.In XML reader, we decide state for each cell randomly and record the states accordingly.

* Allow simulations to be "styled", such as (but not necessarily limited to):kind of grid to use, by shapes, neighbors, or edges with appropriate error checking
(e.g., hexagonal grids do not have cardinal directions), size of each grid location (instead of it being calculated, requires that scrolling is implemented) 
whether or not grid locations should be outlined (i.e., to be able to "see" the grid or not) color of cell or patch states (at least support empty to represent
a water world or space world, etc.) shape of cells or patches within the grid's shape (i.e., circles, rectangles, or arbitrary images like sharks or fire). <br /><br />
Yes.Our code is extremely flexible in this perspective. We spent a lot of time making the backend code and UI interface as separate as possible.
The color, kind of grid, size of each grid location and shape of cell can all be altered as the user wants as they do not appear anywhere in the backend code.


Visualization

* Display a graph of the populations of all of the "kinds" of cells over the time of the simulation. <br /><br />
Yes, we include a graph that shows the the change of each population over time below the simulation grid. Each state has one specific line
showing how its amount changes over time. The user can also do comparison between states easily.



### Impressions

Haotian Wang

* I have been working on separating backend and the UI. I enjoyed the process a lot, it is so fun to see how much changes I made and how
flexible our codes become after I re-construct the structure of our project. I feel I understand the 'Open For Extension,Closed for Modification' much more
after this project.

Yunhao Qing

* The project is very time-consuming. I get much more used to using Git as a part of a team through doing this project. I am responsible for mostly backend coding and I am very satisfied with working on backend.I learn about how flexibility of codes is important as making changes on flexible codes is much easier and changing codes is what we do all the time.

Julia Saveliff

* I have been working on the GUI and I really like the experience. Learning how all the UI components work, how the UI components are connected to the back-end and learning how to handle user input were
challenging but fun as well. I have also been doing a lot of testing and debugging, it feels great to see how the UI becomes more perfect and beautiful over time.

