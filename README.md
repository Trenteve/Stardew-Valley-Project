# Project #2: Stardew Valley

* Author: Trent Everard
* Class: CS321 Section #4001
* Semester: Fall 2023

## Overview

This project is designed to simulate part of the game, Stardew Valley,
using a Priority Queue ADT and a MaxHeap data structure filled with Task objects.

## Reflection

This project really helped me understand how to use multiple different 
classes together. I also learned and sharpening my skills as a programmer,
the main skill being using JUnit testing instead of writing my own tests
in the main class of MaxHeapTest. The pseudocode was fairly easy to follow,
I made a few mistakes along the way but I feel like my ability to understand
pseudocode has gotten better. This project helped me understanding the 
importance of a testing class and how to write an efficient one, using JUnit
testing. My understanding of inheritance also improved.

The main problem I ran into was debugging my code. The mistake was in the 
method IncreaseKey(). This mistake led my tests to only pass on tests 1 and
5 somehow, from the test file. After looking over my code multiple times,
trying to use the debugger, and more testing. It turned out that the problem
was not dynamically changing the parent in the method. I set an integer to the
parent formula from the pseudocode outside of the while loop. This caused
my parent to never dynamically change and would stay the same parent. After
fixing this mistake all of the tests finally passed after hours of debugging. The other issue I ran into that I was unable to fix was when I compile all the .java files. When I do, I get error messages for my testing class, where it says the package doesn't exist or it can't find a symbol. I know this is from not having a main method but I'm not sure how to fix those errors.
This project was a great help to my understanding of multiple important skills
within programming.

## Compiling and Using

From the terminal containing all source files, compile the driver class (and all dependencies) with the command:

    $ javac *.java

Run the compiled class file with the command:

    $ java MyLifeInStarDew <max-priority> <time-to-increment-priority> <total simulation-time in days> <task-generation-probability> [<seed>]

The program requires user input for all of the following in the usage message. This being the max priority, time to increment priority, total simulation time in days, task generation probability and an optional seed.

In order to run the test class, I used the Testing module provided by VSCode, where your can run all of your tests there.

## Results 

All 6 of the tests from ./run-tests.sh passed and all of my tests from the test class passes as well. The tests from my test class take approximately 2.2 seconds to run. 

## Sources used

Only used materials from class.

----------

## Notes