package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StandardDeviationTest {

    @Test
    void computeStandardDeviation_ReceiveNullValueList_ThrowException() {

        // Arrange
        String expectedMessage = "valuesList parameter";
        Exception result = null;

        // Act
        try {
            StandardDeviation.computeStandardDeviation(null, true);
            fail();
        } catch (Exception e) {
            result = e;
        }
        String resultMessage = result.getMessage();

        // Assert
        assertTrue(resultMessage.contains(expectedMessage));
    }

    @Test
    void computeSquareDifferences_ReceiveNullValueList_ThrowException() {

        // Arrange
        String expectedMessage = "valuesList parameter";
        Exception result = null;

        // Act
        try {
            StandardDeviation.computeSquareOfDifferences(null, 1.0);
            fail();
        } catch (Exception e) {
            result = e;
        }
        String resultMessage = result.getMessage();

        // Assert
        assertTrue(resultMessage.contains(expectedMessage));
    }

    @Test
    void computeMean_NullList_ThrowException() {

        // Arrange
        String expectedMessage = "valuesList parameter";
        Exception result = null;

        // Act
        try {
            StandardDeviation.computeMean(null);
            fail();
        } catch (Exception e) {
            result = e;
        }
        String resultMessage = result.getMessage();

        // Assert
        assertTrue(resultMessage.contains(expectedMessage));
    }

    @Test
    void computeVariance_EmptyList_ThrowException() {

        // Arrange
        String expectedMessage = "numValues is too low";
        Exception result = null;

        // Act
        try {
            StandardDeviation.computeVariance(1.0, 0, true);
            fail();
        } catch (Exception e) {
            result = e;
        }
        String resultMessage = result.getMessage();

        // Assert
        assertTrue(resultMessage.contains(expectedMessage));
    }

    @Test
    void computeSampleStandardDeviation_ValidList_ReturnsDouble() {

        // Arrange
        double [] valuesList = {9.0, 6.0, 8.0, 5.0, 7.0};
        double expectedResult = 1.5811388300841898;
        double result = 0.0;

        // Act
        try {
            result = StandardDeviation.computeSampleStandardDeviation(valuesList);
        }   catch(Exception e) {
            fail();
        }

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    void computePopulationStandardDeviation_ValidList_ReturnsDouble() {

        // Arrange
        double[] valuesList = {9.0, 2.0, 5.0, 4.0, 12.0, 7.0, 8.0, 11.0, 9.0, 3.0, 7.0, 4.0, 12.0, 5.0, 4.0, 10.0, 9.0, 6.0, 9.0, 4.0};
        double expectedResult = 2.9832867780352594;
        double result = 0.0;

        // Act
        try {
            result = StandardDeviation.computePopulationStandardDeviation(valuesList);
        }   catch(Exception e) {
            fail();
        }

        // Assert
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> inputsAndResults() {
        return Stream.of(
                Arguments.of(2.5, "Above Average"),
                Arguments.of(2.05, "Above Average"),
                Arguments.of(30.0, "Above Average"),

                Arguments.of(-3.0, "Below Average"),
                Arguments.of(-2.08, "Below Average"),
                Arguments.of(-55.0, "Below Average"),

                Arguments.of(0.0, "Exactly Average"),
                Arguments.of(-0.0, "Exactly Average"),
                Arguments.of(0.045, "Exactly Average"),

                Arguments.of(0.1, "Near Average"),
                Arguments.of(-1.4, "Near Average"),
                Arguments.of(1.94, "Near Average")
        );
    }
    @ParameterizedTest
    @MethodSource("inputsAndResults")
    void interpretStandardDeviation_StreamOfStandardValues_ReturnSpecificLabel(double input, String expected) {
        assertEquals(expected, StandardDeviation.interpretStandardDeviation(input));
    }
}