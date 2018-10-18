Julia
>i'm going to make some simple changes to the program like just create the main class and module-info.java file... just want to make sure neither of you have done that yet so i dont mess anything up!

Haotian
>We will have only one class right <br/>
>One packaage*

Julia
>as of now, yes
 i had my TA meeting today and he said we do not need to strictly stick to our plan, we can make changes to design.md as needed

Haotian
>Okay. I’m wondering about the programmatically check project progress with plan
 Sounds high-tech
 Did your ta say anything else useful

Julia
>yeah kind of weird.. he said ta's don't grade based off the plan but that the head ta or duvall might look at it.. that might just be the way this one ta grades not sure
 and yeah he got me thinking about some changes we might have to make
 for example, he was talking about how duvall kind of teaches us things we need to know for the project during the week we're working on it (as opposed to before the project starts), and one thing he's going to talk about in lecture is why arrays are bad.. and my TA gave the example of how if the cells were not blocks, like if they were triangles or something, a 2d array would not be a good way of representing that because the way triangles would fit into a grid is very different
 he also said that the main class should have little code in it and it's better to have more classes

Haotian
> yeah i think our main class is indeed quite simple
  that's one of our principles
  regarding the triangular setup thing
  hmm
  There's basically no data structure that do arbitrary patterns

Julia
>one example he gave was that if we are going to be iterating over the entire grid several times, that should be done within some manager class, like how when you have a map and you call map.keySet, you don't actually have to iterate through the whole map to get all the keys, that is done behind the scenes in the keySet method. so if there was a case where we wanted to get all cells of a certain type from the grid, the grid should have a method that does that for us
 sorry this is so much information i am spewing!!!!

Haotian
>it's okay
 you can finish spewing first

Julia
>basically he was just emphasizing how important it is to encapsulate behavior in classes when you only need the result and you don't care how that result is found
 basically, i think we will end up needing to make more classes than we originally planned to divide up the work more
 like for breakout game, i had classes ball, paddle, block, etc. but he was saying that you should try to think of making classes like blockmanager, ballmanager, as well so that logic is encapsulated in a separate class and not part of a huge long main class
 ok im done with the info!

Haotian
>there will be more classes that look like rule,
 which has only one method???
 I'll reply after I m done with this history homework!
 around 10!

Julia
>yes no worries!
 just some things to think about over the next few days as we start writing coding

Haotian
>I' ll copy all messenger discussion to doc as well

Julia
>cool

Yunhao
>how to do without 2d array._,
 im meeting with my TA something this week as well

Julia
>im not sure.. another data structure?
 list of lists?
 not sure how that would be better
 also maybe don't add these messages verbatim to the doc because it's mostly "my ta said this.." lol

Haotian
>Even if cells are triangles
 They would still fit into a 2d array?
 it's basically whether their x-coordinate is even or odd, which may determine the orientation of their imageview object
 any other data structure is somehow based off an array anyway?