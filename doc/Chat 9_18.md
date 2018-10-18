Julia
>What if we had a class called grid?
 There could be an abstract super class
 And one subclass could be squareGrid
 And the abstract class could have a parameter Collection<Cell> because I think arrays and lists both implement/extend collection
 And there could be methods like getAllCells, getAllMiddleCells, createGrid, etc (and anything else we need, not looking at the design md right now) and then in the case that we ever wanted to design the grid differently we could make a new subclass?
 Then the design of the grid is encapsulated in the grid class so it is more flexible and all other classes just refer to Grid not to Cell[][]

Haotian
>Just finished class, give a minute to read through
 So essentially we still can’t deal with the triangular and circular case.
 I’m thinking about using collections instead of array though
 But arrays don’t extend collections. I think arrays extend object directly
 And it’s hard to create a 2D collection thing
 And back then I proposed using arrays because collection is slower than array, and the merit of collection over array, which is stuff like pop, add, modify size , collection.sort etc is not relevant in our case

Julia
>Those are some valid points. I don't totally understand the reasoning for why arrays are bad to use in this case and what better alternatives are. Maybe duvall will discuss that today in lecture, or I could email my ta and ask for some clarification if you think that's a good idea
 But I do think it's worthwhile to create a grid class to encapsulate these decisions in its own class because I feel we are lacking in terms of taking advantage of dividing behaviors among smaller classes