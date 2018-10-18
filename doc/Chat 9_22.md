Yunhao
>why suicide, life is good
 I will work on wator tmr and also when and where are we meeting tmr?

Haotian
>No not me
 The segregation little cells are committing suicide

Julia
>I have a meeting 12-1 but free otherwise
 I could do 130? Or we could meet earlier and I’ll just disappear for an hour

Yunhao
>lets do 130

Haotian
>I can’t come at 130
 But I’ll come later
 12:34
 @Julia Saveliff for the ReadXML, I’m thinking each  XML directly below the title there is a line describing what extra variables to read, how many there are.
 Or else each time we add a new XML, we have to change READ class a lot
 @Yunhao Qing when I relocate cells, I tried to randomly move them and to move them primarily from the left to right, from top to bottom. Both result in death of cells. I don’t quite understand
 You can have a look at the bug it helps with your wator as well

Yunhao
>sure
 i will br there at 145

Julia
>im in the kitchen-like area in the middle of the edge where that group of tables is
 i am going to debug segregation now

Haotian
>Thx sorry I can’t come now

Julia
>no worries

Yunhao
>@Haotian Wang nextstate value is not initialised, so its 0

Haotian
>And what is EMPTY set to
 2?

Julia
>empty is 2
 now satisfied blocks are not disappearing, but dissatisfied blocks still are
 looking into how you update color

Haotian
>I realize that’s a problem with all Rule classes
 When we set their state to nextState
 Their nextState is 0 for the first round, and lags one round for the following rounds
 There should be a state called UNINITIALIZED for all cells actually

Julia
>will try that

Haotian
>We can set that in the abstract class
 Set to Integer.MAX
 Easy and swift

Yunhao
>can we set nextstate to state value at the beginning?

Haotian
>Now in retrospect that should not be the problem

Yunhao
>so if we do not do anything about the cell It will remain unchanged

Julia
>some problems are fixed some are remaining
 trying some more changes

Haotian
>Ok try this
 Change the condition in segregationRule
 The part that says nextState != EMPTY
 to == TYPE_A || == TYPE_B

Julia
>yeah ive tried that

Haotian
>And add the initializer thing
 Oh, that’s not right. I need to get this logic right

Julia
>it is working now!

Haotian
>What changes?!

Julia
>i did all the above and i had to fix one if statement from && to ||
 i think the blue blocks were hiding underneath the happy red blocks

Haotian
>Hmmmmmnn
 I’ll come now
 Where are you all

Julia
>same place
 middle of edge

Haotian
>Coming from east
 😢
 👍
 2
 18:10
 we ' re done
 neondonoe

Yunhao
>we made It

Haotian
>@Julia Saveliff I added clearnextstates to updateToNextState

Yunhao
>wator works

Haotian
>so we don't need to call them
explicity
this cost one fewer loop

Julia
>Woooo! Nice
