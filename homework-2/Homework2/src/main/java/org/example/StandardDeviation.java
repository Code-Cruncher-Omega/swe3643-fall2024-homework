package org.example;

public class StandardDeviation {

    public static int COMPUTE_MEAN(int[] valuesList) throws Exception {
        if(valuesList == null || valuesList.length == 0) {
            throw new Exception("valuesList parameter cannot be null or empty");
        }

        int sumAccumulator = 0;
        for (int value : valuesList)
            sumAccumulator += value;
        return sumAccumulator / valuesList.length;
    }

    public static double COMPUTE_SQUARE_OF_DIFFERENCES(int[] valuesList, double mean) throws Exception {
        if(valuesList == null || valuesList.length == 0) {
            throw new Exception("valuesList parameter cannot be null or empty");
        }

        double squareAccumulator = 0;
        for (int value : valuesList)
            squareAccumulator += (value * value) - 2 * (value * mean) + (mean * mean);  //fancy for (value - mean)^2
        return squareAccumulator;
    }

    public static double COMPUTE_VARIANCE(double squareOfDifferences, int numValues, boolean isPopulation) throws Exception {
        if (!isPopulation)
            numValues--;

        if (numValues < 1)
                throw new Exception("numValues is too low (sample size must be >= 2, population size must be >= 1)");

        return squareOfDifferences / numValues;
    }

    public static double COMPUTE_STANDARD_DEVIATION(int[] valuesList, boolean isPopulation) throws Exception {
        if(valuesList == null || valuesList.length == 0) {
            throw new Exception("valuesList parameter cannot be null or empty");
        }

        double mean = COMPUTE_MEAN(valuesList);
        double squareOfDifference = COMPUTE_SQUARE_OF_DIFFERENCES(valuesList, mean);
        double variance = COMPUTE_VARIANCE(squareOfDifference, valuesList.length, isPopulation);

        return Math.sqrt(variance);
    }

    public static double COMPUTE_SAMPLE_STANDARD_DEVIATION(int[] valuesList) throws Exception {
        return COMPUTE_STANDARD_DEVIATION(valuesList, false);
    }

    public static double COMPUTE_POPULATION_STANDARD_DEVIATION(int[] valuesList) throws Exception {
        return COMPUTE_STANDARD_DEVIATION(valuesList, true);
    }

    public static String INTERPRET_STANDARD_DEVIATION(double stdDev) {
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
/*  Old
    public static void main(String[] args) throws Exception {
        int[] sampleValuesList = {9, 6, 8, 5, 7};
        double sampleStdDev = COMPUTE_SAMPLE_STANDARD_DEVIATION(sampleValuesList);
        System.out.println("Sample StdDev = " + sampleStdDev);
    // Writes "Sample StdDev=1.5811388300841898"
    // From https://www.cuemath.com/sample-standard-deviation-formula/

        int[] populationValuesList = {9, 2, 5, 4, 12, 7, 8, 11, 9, 3, 7, 4, 12, 5, 4, 10, 9, 6, 9, 4};
        double popStdDev = COMPUTE_POPULATION_STANDARD_DEVIATION(populationValuesList);
        System.out.println("Population StdDev = " + popStdDev);
    // Writes "Population StdDev=2.9832867780352594"
    // From https://www.thoughtco.com/population-standard-deviation-calculation-609522
    }
 */
}