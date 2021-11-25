package com.techreturners.cinnamoncinemas;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class SeatRequestValidatorTest {

    //test to check seat numbers requested between one and three
    @ParameterizedTest
    @CsvSource({"1,1", "2,2", "3,3"})

    public void validateSeatRequestBetweenOneAndThreeTest(int inputRequest, int expectedRequest) {
        //Arrange
        //Create a SeatRequestValidator
        SeatRequestValidator seatReqValidator = new SeatRequestValidator();

        //Act
        //check number between one and three has been input
        seatReqValidator.validSeatsRequestNumber(inputRequest);

        //Act and Assert
        Assertions.assertEquals(expectedRequest, seatReqValidator.getSeatsRequested());
    }

    //test to check if exception thrown with seat number requested less than zero or greater than three
    @ParameterizedTest
    @CsvSource({"-1", "4", "5"})

    public void validateSeatRequestLessThanZeroAndGreaterThanThreeTest(int inputRequest) {
        //Arrange
        //Create a SeatRequestValidator
        SeatRequestValidator seatReqValidator = new SeatRequestValidator();

        //Act and Assert
        assertThrows(IllegalArgumentException.class, () -> seatReqValidator.validSeatsRequestNumber(inputRequest), "Enter a request for seats between 1 and 3");
    }
}
