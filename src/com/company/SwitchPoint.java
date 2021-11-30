package com.company;

public class SwitchPoint {
    // 0 -> up
    // 1 -> left
    // 2 -> right
    // 3 -> down
    int direction;

    // Coordinates for switch point
    int row;
    int column;

    // Previous switch point
    SwitchPoint previous;

    SwitchPoint(int d, int r, int c) {
        direction = d;
        row = r;
        column = c;
        previous = null;
    }

    SwitchPoint(int d, int r, int c, SwitchPoint prev) {
        direction = d;
        row = r;
        column = c;
        previous = prev;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public SwitchPoint getPrevious() {
        return previous;
    }
    
}

