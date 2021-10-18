package com.techreturners.cinnamoncinemas;

public class SeatRequestValidator {
    private int seatsRequested;

    public SeatRequestValidator() {
        seatsRequested = 0;
    }

    public void validSeatsRequestNumber(int seatsRequested) throws IllegalArgumentException {
        if (seatsRequested > 0 && seatsRequested <= 3) {
            this.seatsRequested = seatsRequested;
        } else {
            throw new IllegalArgumentException("Enter a request for seats between 1 and 3");
        }
    }

    public int getSeatsRequested() {
        return seatsRequested;
    }
}
