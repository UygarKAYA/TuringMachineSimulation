# _Turing Machine Simulation_
***Turing Machine (TM) Simulation***

***TM Simulation provides information on whether the given string was accepted, rejected or looped and which states it visited. Also, after the program finishes running, it creates an OutputFile***

## _Input File_
***1 (number of variables in input alphabet)<br>
2 (number of variables in tape alphabet)<br>
7 (number of states)<br>
q1 q2 q3 q4 q5 qA qR (states)<br>
q1 (start state)<br>
qA (accept state)<br>
qR (reject state)<br>
b (blank symbol)<br>
0 X b (the tape alphabet)<br>
0 (the input alphabet)<br>
q1 0 b R q2<br>
q1 b b R qR<br>
q1 X X R qR<br>
q2 0 X R q3<br>
q2 X X R q2<br>
q2 b b R qA<br>
q3 X X R q3<br>
q3 0 0 R q4<br>
q3 b b L q5<br>
q4 X X R q4<br>
q4 0 X R q3<br>
q4 b b R qR<br>
q5 0 0 L q5<br>
q5 X X L q5<br>
q5 b b R q2<br>
00 (string to be detected)<br>
000 (string to be detected)<br>***

## _Output File_
***q1 q2 q3 q5 q5 q2 q2 qA<br>
Accepted<br>
q1 q2 q3 q4 qR<br>
Rejected***
