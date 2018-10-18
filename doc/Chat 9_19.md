Haotian
>[git the simple guide](http://rogerdudler.github.io/git-guide/). If you find any good ui articles you can put here as well

Julia
>Good plan will do

Haotian
>So just to note down some key discussions. We will have one cell and four specific cells. One rule and four specific rules. Cell has getNeighbors, updateNextState, updateState. Rule defines all the changes to the grid and game logic. Cell has root and grid. Rule has grid. XMLReader can return a String array that relates the index to quantities like “Fish”. UI no idea how to do, need to search for how various buttons prompt scene changes. And Rule works in such a way that each cell checks other cells’ current state and next state for availability. And there is actually a giant problem I just realized. When we jnitliaze a simulation, when we call Rule myRule = new Rule(myGrid), actually that’s not sufficient. Because we don’t want to create a Rule object. We want Rule myRule = new GOLRule(myGrid) for example. But this is done in main class. That means main class has to get the simulation type before initilaizong root. Then I’d rather have a method that reads all kinds of data from XML file first in main. Which is essentially not that important, but I had already typed so much, so I just finished typing this whole thing

Julia
>What did you mean about that last part? Having a method that reads all kinds of data from XML file first in main?

Haotian
>Because I need to create a specific kind of Rule

Julia
>Right I get that
But that change only affects how XML reader needs to give you data?
So that is something else you could do with reflection if that works out right?

Haotian
>Yep
But I really need to get the file reader thing to work
Otherwise I can’t test anything, because reader is not called before user clicks import XML, or set non-default screen width or non-default screen height, or non-default frame-rate

Yunhao
>i just pushed the xmlreader and XML example files
i will read on UI tomorrow before class

Haotian
>Sorry I didn’t mean file reader. I meant UI

Yunhao
>haha

Julia
>haha i will also look into ui tonight and update if I make any changes

Haotian
>Also pull before add then everything should be fine
Should be
I don’t totally understand it
There’s an easy thing you can try out and see if it works. The initial scene will have a root, which has only one button. That button.setOnAction or something similar to trigger scene.setRoot()