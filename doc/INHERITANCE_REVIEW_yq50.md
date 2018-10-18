Inheritance Review


Date: Thursday 9/20/18

Author:  Yunhao Qing (yq50)

Partner:  Inchain Hwang (ih33)


**Part 1**
*What is an implementation decision that your design is encapsulating (i.e., hiding) for other areas of the program?*

In our current design, we have a cell class and a grid class. The grid class has a parameter 2D cell array. When the grid is used in the main CA class, it will return the 2D array. However, there are also other possible ways of doing it, such as using a Hashmap that records each cell and its neighbour as a list for its value. This way, we can easily deal with the case of edge and corner cells and also getting neighbour cells will be very easy.


 
*What inheritance hierarchies are you intending to build within your area and what behavior are they based around?*

Currently, we have a Cell class as a super class and we have specific cell classes as sub classes extened the Cell class for each simulation. In the specific simulation, we define our getNeighbour method based on the simulation type and requirement. The specific cell classes inherent basic methods and parameters from the cell class and oveerrides only the getNeightbour class.

*What parts within your area are you trying to make closed and what parts open to take advantage of this polymorphism you are creating?*

We may want to make our Cell Class and the Main class closed because modification of these two classes will significantly affect other classes. The specific cell classes for each simulation will be open, since they do not affect other classes and and open for extension in the future is needed. I am also considering whether we should use Shape instead of image for each cell. Because by using shape, our program is much more flexible if we want to change the cell shape in the future, for example, making the cell into rectangle cells. Besides, if we adopt the map way of storing cells instead of using the grid way, we can do more weird shapes (such as ring shape or sphere).



*What exceptions (error cases) might occur in your area and how will you handle them (or not, by throwing)?

XML file error, states not updating at the same time and maybe grid construction unsuccessful.


*Why do you think your design is good (also define what your measure of good is)?*

I think our design is good as each simulation is clearly separated into different classes. However, tehy are based on the same cell class which aligns with the value 'Open for extension and close for modification'.

**Part 2**
*How is your area linked to/dependent on other areas of the project?*

The Cell Class and the Grid Class depends on the parameters read in the XMLReader class. The UI class will also need the Grid's information, i.e. the configuration of the Grid to decide the size of the scene.

*Are these dependencies based on the other class's behavior or implementation?*

Yes. The construct on the cell Class and the Grid Class severely affects each other. For exmaple, the getNeighbour method can either exist in the cell Class or the Grid Class. Besides, how well these two classes are written will also determine whether other classes specific to each simulation.



*How can you minimize these dependencies?
Go over one pair of super/sub classes in detail to see if there is room for improvement.
Focus on what things they have in common (these go in the superclass) and what about them varies (these go in the subclass).*

I will minimize the dependencies by making paramters private and other classes will only have access to these paramters by get method. Besides, our cell class currently do not have access to the grid, so each cell class is pretty independent and cannot change the behaviour of other cells by itself. Only with the grid can the states of other cells be changed.

**Part 3**
*Come up with at least five use cases for your part (most likely these will be useful for both teams).*

*animation start, stop, end
*update cell states
*change steep, change parameters based on user input
*step function
*splashpage design


*What feature/design problem are you most excited to work on?*

I am excited to improve the project continuously throughout the development process. Also, I am excited about constantly trying to make the project more flexible. Besides, I am also excited to work on the UI part to make the UI very pretty.



*What feature/design problem are you most worried about working on?*

I am worried about UI interface because i do not have prior UI experience and neither do my teammates. I am also worried about debugging process after we complete the project.