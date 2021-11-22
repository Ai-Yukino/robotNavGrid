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

    // public boolean testLook() {
    //     char[] correctResults = "12345678".toCharArray();
    //     char[] myResults = new char[8];
    //     int row = 2;
    //     int col = 1;
    //     char[][] myArr = [
    //                  ['_', '_', '_', '_', '_', '_'],
    //                  ['1', '2', '3', '_', '_', '_'],
    //                  ['4', 'R', '5', '_', '_', '_'],
    //                  ['6', '7', '8', '_', '_', '_'],
    //                  ['_', '_', '_', '_', '_', '_']
    //                 ];
    //
    //     i = 1;
    //     myResults[i - 1] = lookUpLeft(1, 2);
    //
    //     i = 2;
    //     myResults[i - 1] = lookUp(1, 2);
    //
    //     i = 3;
    //     myResults[i - 1] = lookUpRight(1, 2);
    //     i = 4;
    //     myResults[i - 1] = lookLeft(1, 2);
    //     i = 5;
    //     myResults[i - 1] = lookRight(1, 2);
    //     i = 6;
    //     myResults[i - 1] = lookDownLeft(1, 2);
    //     i = 7;
    //     myResults[i - 1] = lookDown(1, 2);
    //     i = 8;
    //     myResults[i - 1] = lookDownRigh(1, 2);
    //
    //     int myFlag = true;
    //     for (int j = 0; j < myResults.length; j++) {
    //         if (myResults[j] != correctResults[j]) {
    //             myFlag = false;
    //         }
    //     }
    //
    //     return myFlag;
    //
    // }
}
