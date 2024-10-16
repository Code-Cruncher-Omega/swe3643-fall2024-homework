package org.example;

import org.junit.jupiter.api.io.TempDirFactory;

public class StandardDeviation {

    private StandardDeviation() {}  // Made private so no object of this class can be instantiated

    public static double computeMean(double[] valuesList) throws Exception {
        if(valuesList == null || valuesList.length == 0) {
            throw new Exception("valuesList parameter cannot be null or empty");
        }

        double sumAccumulator = 0.0;
        for (double value : valuesList)
            sumAccumulator += value;
        return sumAccumulator / valuesList.length;
    }

    public static double computeSquareOfDifferences(double[] valuesList, double mean) throws Exception {
        if(valuesList == null || valuesList.length == 0) {
            throw new Exception("valuesList parameter cannot be null or empty");
        }

        double squareAccumulator = 0;
        for (double value : valuesList)
            squareAccumulator += (value * value) - 2 * (value * mean) + (mean * mean);  //fancy for (value - mean)^2
        return squareAccumulator;
    }

    public static double computeVariance(double squareOfDifferences, int numValues, boolean isPopulation) throws Exception {
        if (!isPopulation)
            numValues--;

        if (numValues < 1)
                throw new Exception("numValues is too low (sample size must be >= 2, population size must be >= 1)");

        return squareOfDifferences / numValues;
    }

    public static double computeStandardDeviation(double[] valuesList, boolean isPopulation) throws Exception {
        if(valuesList == null || valuesList.length == 0) {
            throw new Exception("valuesList parameter cannot be null or empty");
        }

        double mean = computeMean(valuesList);
        double squareOfDifference = computeSquareOfDifferences(valuesList, mean);
        double variance = computeVariance(squareOfDifference, valuesList.length, isPopulation);

        return Math.sqrt(variance);
    }

    public static double computeSampleStandardDeviation(double[] valuesList) throws Exception {
        return computeStandardDeviation(valuesList, false);
    }

    public static double computePopulationStandardDeviation(double[] valuesList) throws Exception {
        return computeStandardDeviation(valuesList, true);
    }

    public static String interpretStandardDeviation(double stdDev) {
        stdDev = Math.round(stdDev * 10.0) / 10.0; //rounds to the first decimal point

        if(stdDev > 2.0) {
            return "Above Average";
        }   else if(stdDev < -2.0) {
            return "Below Average";
        }   else if(stdDev == 0.0) {
            return "Exactly Average";
        }   else {
            return "Near Average";
        }
    }
}