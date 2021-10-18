package com.techreturners.cinnamoncinemas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class SeatAllocatorTest {

    //Test to allocate a seat to cinema
    @Test
    public void allocateOneSeatTest() {
        //Arrange

        //Create cinema and seat allocator

        Cinema cinema = new Cinema();
        SeatAllocator seatAllocator = new SeatAllocator(cinema);

        //Expected result is seat A1 allocated
        Seat expectedSeat = new Seat('A', 1);
        char expectedRow = expectedSeat.getRow();
        int expectedNumber = expectedSeat.getNumber();

        //Act - allocate seat
        seatAllocator.allocateSeats(1);

        Seat seat = (Seat) cinema.getSeatsAllocated().get(0);
        //Assert
        //Get the seats allocated from the cinema object
        //Hi Kim/James is this the best way to do this, with two assert statements rather than one?
        Assertions.assertEquals(expectedRow, seat.getRow());
        Assertions.assertEquals(expectedNumber, seat.getNumber());
    }


    //Hi Kim/James, Please could you advise how to test using parameterizedtest that seat row and number correct for number of seats stored.
    //I can check that 2 seats have been allocated, but how do I use parameters to check seats A1 and A2 stored. Do I need to pass in an enum object for the seat row and number, e.g. A1,A2,A3?
    //Test to allocate multiple seats
    @ParameterizedTest
    @CsvSource({"2,2", "3,3", "5,5", "11,11"})
    public void allocateMultipleSeatsTest(int numSeatsRequested, int expectedNumSeatsAllocated) {
        //Arrange
        //Create cinema and seat allocator
        Cinema cinema = new Cinema();
        SeatAllocator seatAllocator = new SeatAllocator(cinema);

        //Act - allocate seat
        seatAllocator.allocateSeats(numSeatsRequested);

        int numSeatsAllocated = cinema.getSeatsAllocated().size();
        //Assert
        //Check the number of seats allocated is as expected
        Assertions.assertEquals(expectedNumSeatsAllocated, cinema.getSeatsAllocated().size());


    }
}
