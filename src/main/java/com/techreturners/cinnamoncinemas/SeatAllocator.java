package com.techreturners.cinnamoncinemas;

import java.util.ArrayList;

public class SeatAllocator {

    private final Cinema CINEMA;

    public SeatAllocator(Cinema cinema) {
        this.CINEMA = cinema;
    }

    //method to allocate seat to cinema
    public void allocateSeats(int numSeatsRequested) {
        //number requested already validated between 1-3 in the SeatRequestValidator
        //SeatRequestValidator will also check there is availability so can just go ahead and allocate the seats when this method called

        //allocate seat according to number requested
        ArrayList seatsAllocated = CINEMA.getSeatsAllocated();

        for (int seatCounter = 0; seatCounter < numSeatsRequested; seatCounter++) {
            if (seatsAllocated.isEmpty()) {
                //Store the first seat in row A
                Seat firstSeat = new Seat('A', 1);
                CINEMA.allocateSeat(firstSeat);
            } else {
                int numSeatsAlreadyAllocated = seatsAllocated.size();
                int lastSeatArrayIndex = seatsAllocated.size() - 1;
                //check the lastseatindex if 5 then we have seats for rows A1-5, so need to store seat starting with row B
                if (numSeatsAlreadyAllocated == 5) {
                    Seat nextSeat = new Seat('B', 1);
                    CINEMA.allocateSeat(nextSeat);

                } else if (numSeatsAlreadyAllocated == 10) {
                    //check the lastseatindex if 10 then we have stored seats for rows A1-5, B1-5 so need to store seat starting with row C
                    Seat nextSeat = new Seat('C', 1);
                    CINEMA.allocateSeat(nextSeat);
                } else if (numSeatsAlreadyAllocated == 15) {
                    //There are no more seats if we have already stored 15, to implement availability method in the SeatRequestValidator
                    //as this will mean seat allocator will not be called if there is no availability
                    //would need to throw exception here
                } else {
                    //we can add the nextSeat with the same row but increment the seat number
                    Seat lastSeat = (Seat) seatsAllocated.get(lastSeatArrayIndex);
                    Seat nextSeat = new Seat(lastSeat.getRow(), lastSeat.getNumber() + 1);
                    CINEMA.allocateSeat(nextSeat);
                }
            }
        }
    }
}
