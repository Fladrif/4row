4row

A 4 in a row game on an 8x8 board.

Plays against the player in a 4 in a row game that aims
to place 4 pieces in a row, either horizontal or 
diagonal. The program has options for the computer to
limit the amount of time for it to take its turn, and
has an option for who to go first. 

Meant to play against other ai's.4row

Values:
----------------
caps : crit > val
----------------

0 : 0 > 5
0 : 1 > 12
0 : 2 > 40
0 : 3 > 40

1 : 0 > 3
1 : 1 > 4
1 : 2 > 10
1 : 3 > 40

2 : 0 > 1
2 : 1 > 3
2 : 2 > 8
2 : 3 > 40

Structure:

Node- each board position
Capsule- collection of nodes that can win
Board- Array of nodes and array of capsules
