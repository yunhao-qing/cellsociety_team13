### Inheritance Review

> Date: Thursday 9/20/18
>
> Author:  Julia Saveliff (jms247)
>
> Partner:  Michael Glushakov (mg367)

#### Part 1

What is an implementation decision that your design is encapsulating (i.e., hiding) for other areas of the program?

* The logic that is affected by different simulations is split up in only one hierarchy

What inheritance hierarchies are you intending to build within your area and what behavior are they based around?

* One inheritance hierarchy that seems necessary is a cell hierarchy to differentiate between the types of cells that 
need to be handled, and the differences between simulations could be encapsulated here 

* Another idea would be to have multiple hierarchies that differentiate based on simulation type, like what our team 
has currently with the rule logic being applied with the Rule hierarchy and the simulation-specific variables are 
kept track of within the Cell hierarchy

What parts within your area are you trying to make closed and what parts open to take advantage of this polymorphism you are creating?

* Closed for modification, open for extension

* Means that any modifications or extensions to the current functionality of the game would only affect the code
by writing additional subclasses, but not needing to change how the rest of the classes interact with this type of class

What exceptions (error cases) might occur in your area and how will you handle them (or not, by throwing)?

* Exceptions thrown by the XML parsing as this would affect the ability to read in parameters from the file 

* Error checking for file name passed in by the user, type of file would need to be thrown 

* If file has an incorrect values, these could be overridden by default values to handle these problems

Why do you think your design is good (also define what your measure of good is)?

* Functions and behaviors are split up into several distinct classes 

* This allows for better readability and better understanding of the single purpose of each short class 

* If any additional simulations, rules, or states are to be added, that will not require changes to the current code


#### Part 2

How is your area linked to/dependent on other areas of the project?

* Involves waiting around for other people to finish their parts because the UI cannot be truly finished until 
the XML and cell logic is done 

* The program's functionality could not actually be tested until the UI was created so that there was some visual 
behavior that could be checked

* This means that when other bugs began to show themselves in other dependent classes (like the XML reading classes), 
these had to be fixed before the UI could be tested further 

* Because these areas of behavior were separated between different team members, that required more communication
and troubleshooting before being able to make changes

Are these dependencies based on the other class's behavior or implementation?

* Yes, in our program there is a general sense of confusion between what aspects of the user interface will be implemented
within the main class and what aspects will be implemented internally to the UIManager class 

* Until these kinks are worked out, it will be unclear which dependencies are actually necessary and which depend only
on the current implementation 

* What the XML reader needs to parse 

How can you minimize these dependencies?

* Abstraction of cells 

* Reflection to instantiate classes 

Go over one pair of super/sub classes in detail to see if there is room for improvement. 

* Deciding to move the logic of edge, corner, middle subclasses out of the hierarchy and check that logic in some other way

* Then the cell hierarchy is less redundant between each type of cell location-wise and also each type of cell 
simulation-wise 

* Keep the variation between cell subclasses to only differ based on simulation 

Focus on what things they have in common (these go in the superclass) and what about them varies (these go in the subclass).

* Neighbors are determined exactly the same, but just an extra if statement to check if those values are outside the bounds 

* At the highest level our cell class, there will be a default way for finding your neighbors (4 neighbors, NESW), and 
in the lower subclasses that have a different way of defining neighbors this method would be overridden 

#### Part 3

Come up with at least five use cases for your part (most likely these will be useful for both teams).

1. Load a new simulation 

2. Creating a new type of simulation would require create a new cell subclass, writing a new XML file, and (for our team), a new Rule subclass

3. Stopping the animation would require interacting with the animation object or encapsulating the step functionality 
in a boolean, then changing the value of that boolean when you want to stop

4. Step through the simulation would require somehow called the step method just once 

5. Changing the speed of the simulation would require changing the value of frames per second 

What feature/design problem are you most excited to work on?

* Putting the entire simulation together and making all the components work seamlessly as one whole

What feature/design problem are you most worried about working on?

* Writing enough code to be able to test the current functionality, because the code we currently have written, we have 
not been able to test all the way through yet 
