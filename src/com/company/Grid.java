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

    // current cursor coordinates
    int curX;
    int curY;

    // current direction in path search
    int curDir;

    // Top of the switch point linked list,
    // i.e. the last switch point added
    SwitchPoint peak;

    // Constructor for testing
    Grid(
            char[][] testArray) {
        this.space = testArray;
        this.height = testArray.length;
        this.width = testArray[0].length;
    }

    //constructor
    Grid(int height, int width) {
        // initial variables = parameter/"instance" variables
        this.width = width;
        this.height = height;
        int maxTrapsTotal = (height * width) / 5;
        int maxTrapsRow = (maxTrapsTotal / height) + 1;
        int trapsThisRow = maxTrapsRow;
        peak = null;

        space = new char[height][width];

        for (int i = 0; i < height; i++) {
            trapsThisRow = maxTrapsRow;
            for (int j = 0; j < width; j++) {
                if (layTrap() && trapsThisRow > 0 && maxTrapsTotal > 0) {
                    space[i][j] = 'x';
                    trapsThisRow--;
                    maxTrapsTotal--;
                } else {
                    space[i][j] = '_';
                }
            }
        }
        space[0][0] = 'R';
        space[height - 1][width - 1] = 'O';
    }

    // Set bombs in specific locations
    // Grid(int h, int w, int... x) {
    //     width = w;
    //     height = h;
    //     space = new char[height][width];
    //     peak = null;
    //
    //     // Fill entire grid with '_'
    //     for (int i = 0; i < height; i++) {
    //         for (int j = 0; j < width; j++) {
    //             space[i][j] = '_';
    //         }
    //     }
    //
    //     // Set bombs
    //     if (x.length % 2 == 0) {
    //         int j = 0;
    //         for (int i : x) {
    //             j++;
    //             if (j % 2 == 1) {
    //                 space[i][i + 1] = 'x';
    //             }
    //         }
    //     }
    //
    //     // Set robot 'R' and goal 'O'
    //     space[0][0] = 'R';
    //     space[height - 1][width - 1] = 'O';
    //
    // }

    public boolean findPath() {
        boolean hasPath = false;

        peak = new SwitchPoint(1, height - 1, width - 1);
        peak.previous = null;

        boolean keepGoing = true;
        curX = peak.column;
        curY = peak.row;
        curDir = 1;

        trackLeft();
        if (curX == peak.column) {
            // Move switch point to the right
            SwitchPoint previousPeak = peak;
            peak = new SwitchPoint(0, curX, curY);
        }

        // Mark switch point
        SwitchPoint previousPeak = peak;
        peak = new SwitchPoint(curDir, curX, curY);

        // Going as far left as possible
        // while (keepGoing) {
        //     if (lookLeft(x, y) != '_') {
        //         keepGoing = false;
        //     } else {
        //         x--;
        //     }
        // }

        // Going as far up as possible
        // keepGoing = true;
        // while (keepGoing) {
        //     if (lookUp(x, y) != '_') {
        //         keepGoing = false;
        //     } else {
        //         y--;
        //     }
        // }

        return hasPath;
    }

    public void trackLeft() {
        boolean keepGoing = true;
        while (keepGoing) {
            if (lookLeft(curX, curY) != '_') {
                keepGoing = false;
            } else {
                curX--;
            }
        }
    }

    public void trackUp() {
        boolean keepGoing = true;
        while (keepGoing) {
            if (lookUp(curX, curY) != '_') {
                keepGoing = false;
            } else {
                curY--;
            }
        }
    }

    // Change switch point
    public void changeSwitchPoint() {
    }

    // if (curX == peak.column) {
    //     // Move switch point to the right
    //     SwitchPoint previousPeak = peak;
    //     peak = new SwitchPoint(0, curX, curY);
    // }

    // public void harveyDent() {
    //     boolean coinFlip = Math.random() > 0.5;
    //     // Current position of robot 'R'
    //     int x = 0;
    //     int y = 0;
    //
    //     // State machine (0, starting), (1, done),
    //     // (2, done), (3, none), (4,)
    //
    //     // Things which change state:
    //     // coin flip:
    //     // true -> prefer right
    //     // false -> prefer left
    //
    //
    //     if (coinFlip && (lookRight(x, y) != 'x') || lookRight(x, y) != '#') {
    //     }
    //
    //     if (!coinFlip && (lookDown(x, y) != 'x') || lookDown(x, y) != '#') {
    //     }
    // }
    //
    // public boolean isTrap(int x, int y) {
    //     return space[y][x] == 'x';
    // }

    public void markPath(int x, int y) {
        space[y][x] = '*';
    }

    public void printGrid() {
        // Top boundary
        for (int i = 0; i < width + 2; i++) {
            System.out.print("#  ");
        }
        System.out.print('\n');
        for (int i = 0; i < height; i++) {
            // Left boundary
            System.out.print("# ");
            for (int j = 0; j < width; j++) {
                System.out.printf(" %c ", space[i][j]);
            }
            // Right boundary
            System.out.print(" #\n");
        }
        // Bottom boundary
        for (int i = 0; i < width + 2; i++) {
            System.out.print("#  ");
        }
    }

    public boolean layTrap() {
        if (Math.random() > 0.65) {
            return true;
        } else {
            return false;
        }
    }

    // Use cases for checking for traps
    // Assign obstacles without trapping robot
    // Checking whether robot can move to a space
    //
    // Tracking robot path

    // Example visualization
    // 0 1 2 3 4
    // _ _ _ _ _ 0
    //  * * _ _ 1
    // * R * _ _ 2
    // * * * _ _ 3
    // _ _ _ _ _ 4
    // height = 5
    // width = 5
    // y -> yth row
    // x -> xth column

    public char lookLeft(int x, int y) {
        if (x - 1 > -1) {
            return space[y][x - 1];
        } else {
            return '#';
        }
    }

    public char lookRight(int x, int y) {
        if (x + 1 < this.width) {
            return space[y][x + 1];
        } else {
            return '#';
        }
    }

    public char lookDown(int x, int y) {
        if (y + 1 < this.height) {
            return space[y + 1][x];
        } else {
            return '#';
        }
    }

    public char lookUp(int x, int y) {
        if (y - 1 > -1) {
            return space[y - 1][x];
        } else {
            return '#';
        }
    }

    public char lookUpRight(int x, int y) {
        if (x + 1 < this.width && y - 1 > -1) {
            return space[y - 1][x + 1];
        } else {
            return '#';
        }
    }

    public char lookUpLeft(int x, int y) {
        if (x - 1 > -1 && y - 1 > -1) {
            return space[y - 1][x - 1];
        } else {
            return '#';
        }
    }

    public char lookDownRight(int x, int y) {
        if (x + 1 < this.width && y + 1 < this.height) {
            return space[y + 1][x + 1];
        } else {
            return '#';
        }
    }

    public char lookDownLeft(int x, int y) {
        if ((x - 1 > -1) && (y + 1 < height)) {
            return space[y + 1][x - 1];
        } else {
            return '#';
        }
    }


    // Done: left, right
    // Remaining: up, down, up-left, up-right,
    //  down-left, down-right
    // Cal: down
    // Kevin Nguyen: up-left
    // Andrew: down-left
    // Allison: down-right
    // Daniel: up-right

    // output space to console
    // System.out.print(space);

    // Robot position: top left
    // Blockage parameter: number of blocks? random obstacles?

    // movement within = valid and vice versa

}
