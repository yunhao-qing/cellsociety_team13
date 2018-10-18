Julia
>I will be working on UIManager this morning
 we have to make a change in ReadXML - I will update you with what I change
 I made 2 changes I think it is working now - in readState method, stateNumber was not being read in, I changed this line so that it uses .getNamedItem like you use for stateName, instead of trying to get stateNumber with returnInt method which uses .getElementsByTagName
 2nd change - I was getting index out of bounds exceptions so I looked at how you were determining row and col from index and I changed it so you do not add 1 to the index anymore.. assuming the grid is supposed to look like this for 5x5 then this is working now. merging these changes with master branch. submitted a merge request with my current changes but did not accept it
                                                                                                                                                                                                                                                                                                                  all the animation function we need (pause/step/speed etc) is working but I did not build the actual grid of cells yet, we can discuss how we want to control the image view of each cell when we meet
                                                                                                                                                                                                                                                                                                                  also the version of the code in my merge request can be run if you want to see it for yourself, sorry if the code is not easily readable as I did not have time to completely clean it up before pushing!

Yunhao
>I see your changes, they are great!

Haotian
>@Julia Saveliff I don’t quite understand the not adding 1 part we’lol talk later. Also do you all think removing indexes from cell cause any problem?
 You can try to merge my code to master and see if there’s any problem

Julia
>Im not at my computer but will do later

Yunhao
>@王皓天 she fixed the bug in my XML shouldnt add 1 if add 1 the grid will not be constructed correctly
 I'm starting on writing codes for specific simulations. @Haotian Wang I see ur determineNextStates() method in Game of life clas that you update cells one by one.
 I am not sure whether we should check cell one by one or update simultaneously, we can discuss about that later.

Haotian
>This is done simultaneously
 We can’t update one by one, against the rule

Julia
>yeah i have it
 the current problem i am having is that the simulation grid does not change until about the 300th step, and after that the entire grid stays black
 that may require some debugging in Rule.determineNextStates() and Rule.updateGrid()

Haotian
>Hmmmm do you print the step to get the number three indeed? ok @Yunhao  Qing, we decided to change from using ImageView to Shape
                                                             ImageView eats up too much memory. and @Yunhao  Qing your setburningtime reports error
                                                                                                because now at the testing stage, we hardcorded gameoflifecell into Grid. so if you do grid.item(i, j), it returns a gameoflifecell. @Julia Saveliff how do you get the program to run with all the errors, I want to test whether shapes work

Julia
>I have just been commenting out lines that throw errors
 Since none of the errors are in code that is needed to run the simulation

Haotian
>and now run is not clickable
 is it because there are two packages?

Julia
>Hm
 Is your branch updated? I can take a look at it

Haotian
>yeah
 i managed to run even though intellij told me "simulation.ca doesn't exist"
 but i managed to run
 and
 with shapes it's super fast. you can pull master. and see why it doesn't run like a normal application

Julia
>trying to get reflection working, as soon as that's done i will make sure simulation works for every type of cell
 will do

Haotian
>yeah
 no
 in the window configuration
 nvm i'll ignore it for now
 are you doing reflection?
 and don't foget resoures ppl! haha

Julia
>Yes I’m trying reflection
 the problem with the method in the webpage we were looking at is that you cannot do any cell specific things to instance after because it is initialized as Object
 and we need to add it to cell[][]

Haotian
>Just do
 (Cell)
 Calling a subclass method from superclass
 also this article may be useful
 Calling a subclass method from superclass
 https://stackoverflow.com/questions/10021603/calling-a-subclass-method-from-superclass.

Julia
>Kk thanks will take a look

Haotian
>Class<?> clazz = Class.forName("com.foo.MyClass");
 Constructor<?> constructor = clazz.getConstructor(String.class, Integer.class);
 Object instance = constructor.newInstance("stringparam", 42);
 Cell cell = (Cell) instance
 the other problem we have is each cell will have this ugly list<Double> parameter in their constructor.

Julia
>right
 I am not sure how to get around that
 if we don't want it in the constructor we could have some set parameters function that takes a double list and sets whatever values that cell is expecting
 but that would need to happen as soon as each cell is created anyway
 we could keep those parameters in rule?
 since that has an empty constructor anyway right?
 never mind it takes grid

Haotian
>rule has the grid as constructor
 rule takes grid, grid creates cell[][]
 the pain is still in cell's constructor and grid's way of creating cell. rule has the grid as constructor
                                                                          rule takes grid, grid creates cell[][]
                                                                          the pain is still in cell's constructor and grid's way of creating cell
                                                                          so the best way to do this is  grid use reflection to create
                                                                          and frankly now cell does not need to have access to root btw
                                                                          we are adding them from UIManager. and we don't need to remove them when we update states. I'll just use setFill to change its color to show the state is empty or something

Julia
>use reflection to create what? a specific grid?

Haotian
>no grid use reflection to create cell in that for loop
 in other words, modify populateCells. no grid use reflection to create cell in that for loop
                                       in other words, modify populateCells
                                       Class<?> clazz = Class.forName(simulationType + "Cell");
                                       Constructor<?> constructor = clazz.getConstructor(Double.class, Double.class, Double.class, Double.class, List.interface);
                                       Cell cell = (Cell) constructor.newInstance(x, y, width, height, listOfOtherProperties);

Julia
>ok yes i think that's what we should do

Haotian
>I'm not sure if "List.interface" is legal though

Julia
>and just figure out how to deal with other properties list

Haotian
>i don't even know what Double.class means. like, this thing Double class
                                            doesn't have a static instance variable called class

Julia
>i think it's just some kind of placeholder

Haotian
>another place we are using reflection is in UIManager, when we want to create Rule, that's straight and easy

Julia
>yep got that

Haotian
>trying to read Oracle's Class class doc
 still confused. ok i'll evaporate for the next few hours, have fun with reflectionz

Julia
>haha ok
 are all your changes on master?

Haotian
>soon
 also we may have this new convention. Since each simulation will different weird variables.
 Those that largely stay the same such as threshold, we put in SomeRule
 those that change a lot such as FishEnerge goes to their cell class

Julia
>yeah that makes sense
 but i think all the constants read in from the file can go just to SpecificRule
 and cell only has the variable that differs for each cell? which will not have values read in from file

Haotian
>yep

Julia
>ok
 i can make those changes

Haotian
>wow no conflicts, magical
 😆
 1
 ok, pushed to master, remember to pull before you merge with master
 or resolve painful conflicts later on.
 byebye everyone

Julia
>good night!
 got it
 22:28
 make sure to update your branches based on current master before you start working again.. i have modified many classes to get the extraParameters working

Haotian
>They work??
 Wow

Julia
>it's working but not all rule classes are done so the simulations don't work as expected
 but they run

Haotian
>wait how can this run? shouldn't it be Integer.class instead of int.class

Julia
>hm
 i would think you are right about that but it is running fine

Haotian
>you mean not throwing error, or the simulation actually appears
 and we do need simulation. to signify it's from this package?
 oh and we don't have the List<Object> otherVariables yet right
 according to stack masters, Interface is also called List.class and not List.interface
 and we can remove root from cell, i'll start working on that. any objection?

Julia
>go ahead
 both, it is not throwing error and the simulation appears
 and yes simulation. specifies package so it can locate the class
 not sure what you mean by your 3rd message, readXML is modified to get those variables to each cell type

Haotian
>ok now i kind of know why the simulation runs
you have the new GameOfLifeCell before the reflection part
which already guarantees it works
I'm experimenting

Julia
>ahh missed that
 ok

Haotian
>it's still working
https://stackoverflow.com/questions/22470985/integer-class-vs-int-class ok according to this article, even primitive types have associated class objects

Julia
>who knew
 should use Integer.class instead? not sure if int is trustworthy?

Haotian
>nononon int.classs
 it works
 i see you insert list<Double> extra into rule
 i'm seeing how to implement. is it better to be in rule than in cell
                              @Yunhao  Qing did you remove your own firespreading?

Julia
>i think so
 there's no reason for each cell to have a copy of it if each individual cell doesn't care about its value

Haotian
>what if the cell cares about its value
such as energy of the fish

Julia
>oh hm
 well one thing is yunhao said the nifty version of wator only cared about reproduction cycles of shark and fish (not energy cyles), but i guess they still need those values
 i guess if the cell had values like numCycle
 then in rule, you could compare the reproduction to fishcell.getnumcycle
 because the only logic we really need to do there is if numcycle%reproductioncycle == 0 then create new fish
 right?
 but numcycle would be initialized to 0 and updated every generation
 numcycle doesnt depend on xml file

Haotian
>ok
 do you feel it's good to add very arbitrary methddos to ReadXML
 when theres a new simulation
 buyt i dont have a solution anw
 i'm done with segregation
 for some reason
 people die away
 that's not supposed to happen

Julia
>Ok I can take a look in the morning

Haotian
>thx
@Yunhao  Qing i'm done with segregation
but people are commiting suicide for some reason
and do we really want state class
