package com.company;

// Example visualization
// 0 1 2 3 4
// _ _ _ _ _ 0
// 1 2 3 _ _ 1
// 4 R 5 _ _ 2
// 6 7 8 _ _ 3
// _ _ _ _ _ 4
// height = 5
// width = 5
// y -> yth row
// x -> xth column

public class GridTest {
    public static boolean testLook() {
        char[] correctResults = "12345678".toCharArray();
        char[] myResults = new char[8];
        int row = 2;
        int col = 1;
        int i;
        // char[][] myArr = ([
        //         ['_', '_', '_', '_', '_', '_'],
        //              ['1', '2', '3', '_', '_', '_'],
        //              ['4', 'R', '5', '_', '_', '_'],
        //              ['6', '7', '8', '_', '_', '_'],
        //              ['_', '_', '_', '_', '_', '_']
        //             ]);

        char[][] myArr = {{'_', '_', '_', '_', '_', '_'},
                {'1', '2', '3', '_', '_', '_'},
                {'4', 'R', '5', '_', '_', '_'},
                {'6', '7', '8', '_', '_', '_'},
                {'_', '_', '_', '_', '_', '_'}};

        Grid testGrid = new Grid(myArr);

        i = 1;
        myResults[i - 1] = testGrid.lookUpLeft(1, 2);

        i = 2;
        myResults[i - 1] = testGrid.lookUp(1, 2);

        i = 3;
        myResults[i - 1] = testGrid.lookUpRight(1, 2);
        i = 4;
        myResults[i - 1] = testGrid.lookLeft(1, 2);
        i = 5;
        myResults[i - 1] = testGrid.lookRight(1, 2);
        i = 6;
        myResults[i - 1] = testGrid.lookDownLeft(1, 2);
        i = 7;
        myResults[i - 1] = testGrid.lookDown(1, 2);
        i = 8;
        myResults[i - 1] = testGrid.lookDownRight(1, 2);

        boolean myFlag = true;
        for (int j = 0; j < myResults.length; j++) {
            if (myResults[j] != correctResults[j]) {
                myFlag = false;
                System.out.println("incorrect result at j = " + j);
            } else {
                System.out.println(myResults[j]);
            }
        }

        System.out.println("lookTest(): " + myFlag);
        return myFlag;

    }
}
