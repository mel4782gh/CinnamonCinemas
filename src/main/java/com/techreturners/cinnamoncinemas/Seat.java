package com.techreturners.cinnamoncinemas;

public class Seat {
    private char row;
    private int number;

    public Seat(char row, int number){
        this.row =row;
        this.number = number;
    }
    public char getRow() {
        return row;
    }

    public void setRow(char row) {
        this.row = row;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
