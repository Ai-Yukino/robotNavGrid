package com.company;

public class Grid {
    // grid holds all the state
    // just one class xdd

    //Design process:
    // Broad idea: have grid, specify for each instance of the grid: dimensions.
        //each grid square, grid point
        //wether obstacle or roboto
        //How to move robot: concern: tracking the robot
            //either the grid tracks robot or.. i.e. the robot interacts with the grid
            //(grid mothership/US-Big-Bird iraq relationship)

    //input length and width to make a 2d array



    // initialize variables
    int width;
    int height;
    char[][] space;

    //constructor
    Grid(int height, int width) {
        // initial variables = parameter/"instance" variables
        this.width = width;
        this.height = height;
        space = new char[height][width];

        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                space[i][j] = '_';
            }
        }
    }

    public void printGrid() {
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                System.out.printf(" %c ",space[i][j]);
            }
            System.out.print('\n');
        }
    }
    // output space to console
    // System.out.print(space);

    // Robot position: top left
    // Blockage parameter: number of blocks? random obstacles?





    // movement within = valid and vice versa

}
