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


    //Check seats correctly allocated over 2 rows
    @ParameterizedTest
    @CsvSource({"1,A,1", "2,A,2", "3,A,3", "4,A,4","5,A,5","6,B,1","7,B,2","8,B,3","9,B,4","10,B,5",})
    public void allocateSeatsOverTwoRowsTest(int numSeatsRequested, String seatRow, int seatNum) {
        //Arrange
        //Create cinema and seat allocator
        Cinema cinema = new Cinema();
        SeatAllocator seatAllocator = new SeatAllocator(cinema);
        char expectedSeatRow = seatRow.charAt(0);
        int expectedSeatNum = seatNum;

        //Act - allocate seat
        seatAllocator.allocateSeats(numSeatsRequested);

        //Assert
        Seat seat = (Seat) cinema.getSeatsAllocated().get(numSeatsRequested-1);
        Assertions.assertEquals(expectedSeatRow, seat.getRow());
        Assertions.assertEquals(expectedSeatNum, seat.getNumber());
    }

    //Check can allocate all seats
    @ParameterizedTest
    @CsvSource({"2,2", "3,3", "5,5", "11,11", "15,15"})
    public void allocateAllSeatsTest(int numSeatsRequested, int expectedNumSeatsAllocated) {
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
