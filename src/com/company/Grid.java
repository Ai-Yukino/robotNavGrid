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
    // int traps;
    char[][] space;

    //constructor
    Grid(int height, int width) {
        // initial variables = parameter/"instance" variables
        this.width = width;
        this.height = height;
        int maxTrapsTotal = (height * width) / 5;
        int maxTrapsRow = (maxTrapsTotal / height) + 2;
        int trapsThisRow = maxTrapsRow;

        space = new char[height][width];

        for (int i = 0; i < height; i++){
            trapsThisRow = maxTrapsRow;
            for (int j = 0; j < width; j++){
                if(isTrap() && trapsThisRow > 0 && maxTrapsTotal > 0){
                    space[i][j] = 'x';
                    trapsThisRow--;
                    maxTrapsTotal--;
                } else {space[i][j] = '_';}
            }
        }
        space[0][0] = 'R';
    }

    public void printGrid() {
        // Top boundary
        for(int i = 0; i < width + 2; i++){
            System.out.print("#  ");
        }
        System.out.print('\n');
        for (int i = 0; i < height; i++){
            // Left boundary
            System.out.print("# ");
            for (int j = 0; j < width; j++){
                System.out.printf(" %c ",space[i][j]);
            }
            // Right boundary
            System.out.print(" #\n");
        }
        // Bottom boundary
        for(int i = 0; i < width + 2; i++){
            System.out.print("#  ");
        }
    }

    public boolean isTrap()
    {
        if(Math.random() > 0.65) {return true;}
        else
        {return false;}
    }

    // Use cases for checking for traps
    // Assign obstacles without trapping robot
    // Checking whether robot can move to a space
    //
    // Tracking robot path

    public char lookLeft(int x, int y) {
        if (x -1 > -1) {
            return space[y][x - 1];
        } else
        { return '#';}
    }
    //        R _ _ _
    //        x x _ _
    //        _ _ x _
    //        _ _ x _

    // output space to console
    // System.out.print(space);

    // Robot position: top left
    // Blockage parameter: number of blocks? random obstacles?

    // movement within = valid and vice versa

}
