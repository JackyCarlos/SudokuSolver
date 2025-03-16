# Overview

A program for solving sudokus and watch the algorithm do its work.

# How to run

Open `App.java` and insert your own (solvable) sudoku into the `unsolvedSudoku` integer array. Then run the programm in one of the two following ways:

- `./gradlew run`
  this runs the program in a normal way. The algorithm waits for 100 milliseconds after "trying" a new number.
- `./gradlew run --args "visualize false"`
  this skips the waiting after "trying" a new number.
