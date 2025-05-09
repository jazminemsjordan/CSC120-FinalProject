This file will contain documentation for all commands available in your game.

Note:  It's a good idea to also make this list available inside the game, in response to a `HELP` command.

## Available Commands

  - help / help [command]

  - sleep

  - go [direction] / [direction]

  - look / look [snack] / look [item]

  - take [snack] / take [item]

  - use [item]

  - hide [snack] [hiding place]

  - inventory



# SPOILER ALERT

If your game includes challenges that must be overcome to win, also list them below.

## Scoring!

Calculation:

Multiply raw scores by their hiding place values and add to get a base score, then multiply by diversity value.

base += for each hidden snack, (snack value * hiding place value) 

base * diversity value = score

          PLACES (HIDING SPOT VALUE)      |                       FOOD FOUND (POINTS)
          - - - - - - - - - - - - - - - - | - - - - - - - - - - - - - - - - - - - - -
          Capen: (1.5, 1.5, 1.25)         |           food found: (grilledCheese[10])
          - - - - - - - - - - - - - - - - | - - - - - - - - - - - - - - - - - - - - -
          Quad: (1, 0.75, 0.75)           |      food found: (bagel[10], chicken[10])
          - - - - - - - - - - - - - - - - | - - - - - - - - - - - - - - - - - - - - -
          Chapin: (1.25, 1, 0.75)         |       food found: (donut[12], cookie[10])
          - - - - - - - - - - - - - - - - | - - - - - - - - - - - - - - - - - - - - -
          Paradise: (1.5, 1.5, 1.25)      |       food found: (plum[8], raspberry[7])
          - - - - - - - - - - - - - - - - | - - - - - - - - - - - - - - - - - - - - -
          Burton: (1.5, 1, 1)             |                food found: (appleCore[5])
          - - - - - - - - - - - - - - - - | - - - - - - - - - - - - - - - - - - - - -
          Neilson: (1.25, 1, 0.75)        |               food found: (sushiRoll[15])
          - - - - - - - - - - - - - - - - | - - - - - - - - - - - - - - - - - - - - -
          Athletic: (1.25, 0.75, 0.75)    |              food found: (proteinBar[10])
          - - - - - - - - - - - - - - - - | - - - - - - - - - - - - - - - - - - - - -
          Mendenhall: (1.5, 1.25, 1)      |    food found: (peanut[3], spaghetti[20])

## Item Use Guide
  - The knife from Paradise Woods is used at the Great Quadrangle to obtain the chicken drumstick.
  
  - The screwdriver from Capen Garden is used at Mendenhall Courtyard to obtain the spaghetti.

  - The whistle from the Athletic Field is used in Paradise Woods to obtain the raspberries.

  - The hard hat from Mendenhall Courtyard is used at Burton Lawn to allow access to Neilson lawn.

  - The nail file from Neilson Lawn is used at Chapin Lawn to obtain the cookie.

## Diversity multiplier: Snacks in...
  - 4 different places: (0.8)

  - 5 different places: (0.9)

  - 6 different places: (1)

  - 7 different places: (1.1)

  - 8 different places: (1.2)

## Score ending sheet:

  - score > 200 = perfect

  - 200 > score > 180 = great

  - 180 > score > 150 = good job

  - 150 > score > 120 = not bad

  - 120 > score > 60 = rough winter

  - 60 > score > 0 = awful 

  - score == 0 = starved


**special ending**

  - hidden snacks == 12 and score < 90 = squirrel goes to college 


### One possible way to get best ending:

  - Hide plum at Chapin 1

  - Hide spaghetti at Capen 1

  - Hide cookie at Capen 2

  - Hide sushi roll at Burton 1

  - Hide apple core at Burton 2

  - Hide protein bar at Neilson 1

  - Hide peanut at Quad 1

  - Hide bagel at Mendenhall 1

  - Hide raspberries at Mendenhall 2

  - Hide chicken at Field 1

  - Hide donut at Woods 1

  - Hide grilled cheese at Woods 2

### One possible way to get secret ending:*
  - Hide peanut at Chapin 1

  - Hide plum at Chapin 2

  - Hide sushi roll at Chapin 3

  - Hide apple core at Neilson 1

  - Hide grilled cheese at Neilson 2

  - Hide cookie at Neilson 3

  - Hide raspberries at Field 1
  
  - Hide chicken at Field 2

  - Hide protein bar at Field 3

  - Hide bagel at Quad 1

  - Hide donut at Quad 2

  - Hide spaghetti at Quad 3


## MAP OF THE AREA
                            Capen                    
                              |                       
                              |                         
                              |                        
        Quad     — — —      Chapin                     
          |                   |                      
          |                   |                       
          |                   |                         
        Paradise   — — —    Burton   — — —    Neilson  
            |                 |                       
            |                 |                        
            |                 |                          
        Athletic  — — —   Mendenhall                        

