# CSC120-FinalProject

## Deliverables:
 - Your final codebase
 - Your revised annotated architecture diagram
 - Design justification (including a brief discussion of at least one alternative you considered)
 - A map of your game's layout (if applicable)
 - `cheatsheet.md`
 - Completed `rubric.md`
  
## Additional Reflection Questions
 - What was your **overall approach** to tackling this project?

My overall approach to approach such a big project was to really emphasize the object oriented programming aspect. Sounds obvious (it is the name of the course, after all!), but it was a lot easier to approach a large project by breaking it into its smallest objects. Building a whole game sounds big and scary, but it was less intimidating broken up into classes. I made the game loop itself as small as possible so I could keep the classes divided up. I also found that using previous assignments as a base was a good way to start. I already know how to build a building from A7 and A8, and I can modify that easily into an outdoor place for my squirrel. Once I build enough buildings and put them together, suddenly I have map! Instead of going at the project all at once, I started with small things to build my confidence and gradually branched out.


 - What **new thing(s)** did you learn / figure out in completing this project?

Most of what I learned during the course of this project was less new skills and more, new ways to implements skills I already have. The best example of this is figuring out how to compare lists for my CommandReader class. I've experienced a lot of frustration with text adventure games being incredibly picky with what you type, so I wanted to allow for a variety of input. To do this, I created two collections of strings: an arraylist of words in the user input and an array of forms the hiding spot value can take. Then I nested two for loops that would compare every item in both lists with each other at least once. If there was a match anywhere, the command would still run. So, "hide spaghetti 1" and "hide spaghetti in spot one" will both have the same result. For loops are something we've worked with before, but I learned to use them in different, creative ways. As for a completely new thing, I researched and learned how to use the Arrays.asList() method, which let me initialize a large array in one line and then convert it to a list. This is much more efficient than creating an ArrayList and adding elements one by one.


 - Is there anything that you wish you had **implemented differently**?

While I tried to make use of inheritance with my Thing, Snack, and Item classes, I think I still ended up with a lot of similar or duplicate code. I wish I had used overloaded methods or generics to make a method work for both. For instance, instead of takeItem and takeSnack, I could just have Take<T> for both. However, splitting up items and snacks so much did allow me to have more specific exception error methods, which I am happy with.


 - If you had **unlimited time**, what additional features would you implement?

 With unlimited time, I would implement more interaction with the world and more specific 'error' messages. In my own experience with text based adventure games, the most fun part isn't playing the game right: it's playing the game wrong and seeing what happens. It breaks the immersion when you enter a command and get a simple "you can't do that" message, and I could have a lot creating a more in-depth world and more ways to fail. Using the knife at Chapin Lawn, for instance, might tell the player that there are too many students there, and they would be concerned upon seeing a squirrel holding a weapon. I would also like to switch up the hiding spot names so 1 isn't always the best and 3 isn't always the worst, and I would absolutely LOVE to include a randomly-generated aspect. I love games that can be replayed differently every time, so I would love to experiment with the random class to make the snacks appear in different locations every time.


 - What was the most helpful **piece of feedback** you received while working on your project? Who gave it to you?

The most helpful piece of feedback I recieved came from a classmate, and it wasn't even a direct piece of feedback to me. A pair of students I hadn't met came to try my game during demo day, and while one was playing through it, she kept missing snacks. She would enter a place and leave without collecting it. When her teammate pointed it out, she said a simple "oops, I didn't see that". It's a little thing, but it made me realize that even with all of my efforts to make my game user friendly, I had completely neglected readbility. I guess I had just assumed that visuals didn't matter at all in a text adventure game, but when someone with fresh eyes played it who didn't already know where the snacks were, the dense blocks of text made it really difficult to pick out what information is important. It was easy to just skim over it and continue on. I added some simple formatting to the game, nothing major: the edits took maybe ten minutes total. But they completely changed the user experience, and it was so much easier to read instructions.


 - If you could go back in time and give your past self some **advice** about this project, what hints would you give?

I would give the advice not to get too caught up in the story and text. I really enjoyed letting my inner creative writer out a little and mimicking clever narrators from other text based games, but I got way too caught up in the details. I would halt working on the code just to sit and try and think of a good description for a place or object, or I would spend too long deciding what items made the most sense to be found in which areas. The story aspects are fun, but I think it would've been way more efficient to build up the codebase first. Along the same lines, I would in general advise myself not to get stuck on little things. Sometimes when you feel stagnant trying to fix a bug, you just need to move on to a different part of the code and come back to it later.


 - _If you worked with a team:_ please comment on how your **team dynamics** influenced your experience working on this project.

N/A



## Design Justification:

I think my most significant design principle was making as much use as possible out of the static variable. I ended up with multiple classes with empty constructors, and used the class framework itself rather than creating object instances. At first when I was considering the 'extensible' part of the rubric, I thought that having at least one constructed would be best. Maybe a possible future modification would be turning the game into a multiplayer game, which would need to make more than one Player, or I want different starting attribute values for different game modes. However, I ran into so many roadblocks when I was trying to make that work. Every time I tried to add something to my main method, I'd run into the dreaded "cannot make a static reference to the non-static field" (and yes, the exact error message text was from memory, that's how many times I saw it). I'd have to create objects to reference for everything and make my Game loop big and unwieldy, when the first thing I knew when I started my project organization was that I wanted a light game loop with strong classes. Even more importantly, I can't reference an object before running the code and creating it: it was going to be really hard to attach specific hiding spots to specific places when I can't name and reference the place without running the code. So, for the things I knew I'd only have one of (the game, the place, the list of assets and the map itself), I made everything static, so the entire class could share variables. This was better for me as I was able to organize everything much better, and I could tie specific objects and locations together as I pleased. I can reference any location on the map from any file at any time. This also gave me extensibility in another way: for a lot of my methods, I used a loop as such:


    For (int i = 0; i < ArrayList.size(), i++ ) {ArrayList.get(i)}


All I have to do is add an object to the ArrayList. Whenever I added something to the command list in the Player class, I don't have to touch any of the print help methods. It will just go through the updated list and print the name and description. 
