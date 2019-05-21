# Coin-Game-Strategy
Optimal Strategy for Coin Game using Dynamic Programming
<h2> Coin Game </h2>
In “Coin Game” 2 people play against each other. In front of players there are bowls standing in a horizontal line. Every bowl contains a number of Coins. In their round the players can either take the bowl on the right side or the left side, but not the inner bowls. After taking a bowl, player puts the coins inside the bowl on his side. Game continues until there are no more bowls left. Winner is the player with the most coins at the end.

<h2> Program </h2>

There are two important methods here. One is naiveGame(Integer[] bowls) and uses a naive approach to finish the game. Other is dynGame(Integer[] bowls) which uses Dynamic Programming to approach the overlapping subproblems and their optimal solution. bowls is an unsorted array which every array index is a bowl and contains number of coins.

-Running the test class begins a command prompt which asks for user to choose one of available .csv datas to run and test the algorithm.

-Own datas can be put into the folder "instances".

-After finishing testing, program saves the .csv solution in "solutions" folder.

-To evaluate the solution, simply open the plot.html file under "evaluation" folder and upload the solution file there.

-Evaluation function compares solutions Naive Approach and Dynamic Programming Approach.
