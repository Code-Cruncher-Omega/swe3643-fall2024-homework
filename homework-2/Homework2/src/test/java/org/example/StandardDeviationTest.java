package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
//open module settings -> add+ -> org.junit.jupiter:junit-jupiter-version -> scope set to test

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StandardDeviationTest {

    @Test
    void StandardDeviation_ReceiveNullValueList_ThrowException() {
        Exception e = assertThrows(Exception.class, () -> StandardDeviation.COMPUTE_STANDARD_DEVIATION(null, true));

        String expectedMessage = "valuesList parameter";
        String actualMessage = e.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void SquareDifferences_ReceiveNullValueList_ThrowException() {
        Exception e = assertThrows(Exception.class, () -> StandardDeviation.COMPUTE_SQUARE_OF_DIFFERENCES(null, 1.0));

        String expectedMessage = "valuesList parameter";
        String actualMessage = e.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void Mean_ReceiveNullValueList_ThrowException() {
        Exception e = assertThrows(Exception.class, () -> StandardDeviation.COMPUTE_MEAN(null));

        String expectedMessage = "valuesList parameter";
        String actualMessage = e.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void Variance_ReceiveZeroLengthList_ThrowException() {
        Exception e = assertThrows(Exception.class, () -> StandardDeviation.COMPUTE_VARIANCE(1.0, 0, true));

        String expectedMessage = "numValues is too low";
        String actualMessage = e.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void SampleStandardDeviation_ReceiveListOfInts_ReturnsDouble() {
        int[] valuesList = {9, 6, 8, 5, 7};
        double expectedResult = 1.5811388300841898;
        try {
            assertEquals(expectedResult, StandardDeviation.COMPUTE_SAMPLE_STANDARD_DEVIATION(valuesList));
        }   catch(Exception e) {
            fail();
        }
    }

    @Test
    void PopulationStandardDeviation_ReceiveTestList_ReturnsDouble() {
        int[] valuesList = {9, 2, 5, 4, 12, 7, 8, 11, 9, 3, 7, 4, 12, 5, 4, 10, 9, 6, 9, 4};
        double expectedResult = 2.9832867780352594;
        try {
            assertEquals(expectedResult, StandardDeviation.COMPUTE_POPULATION_STANDARD_DEVIATION(valuesList));
        }   catch(Exception e) {
            fail();
        }
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
    void InterpretStdDeviation_StreamOfStdValues_ReturnLabel(double input, String expected) {
        assertEquals(expected, StandardDeviation.INTERPRET_STANDARD_DEVIATION(input));
    }
}