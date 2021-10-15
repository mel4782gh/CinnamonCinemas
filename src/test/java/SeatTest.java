



import com.techreturners.cinnamoncinemas.Seat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SeatTest {

    @Test
    public void createSeatTest() {
        //Arrange
        //Create a new seat that will store row and number
        Seat seat = new Seat('A', 1);
        //Create expected result for row and number of seat
        char expectedRow = 'A';
        int expectedNumber = 1;


        //Act and Assert
        Assertions.assertEquals(expectedRow, seat.getRow());
        Assertions.assertEquals(expectedNumber, seat.getNumber());
    }
}
