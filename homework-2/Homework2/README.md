# Homework 2

### 1. Performed Branch Analysis

   *Studied a block of pseudocode and converted it to a graph showing every possible path*
   
   [Branch Diagram](BranchDiagram.png "BranchDiagram.png")

   [plantuml Code](plantumlDiagramCode.txt "plantumlDiagramCode.txt")
   
   ![Diagram](https://github.com/Code-Cruncher-Omega/swe3643-fall2024-homework/blob/main/homework-2/Homework2/BranchDiagram.png)
### 2. Converted Pseudocode to Operational Code

   *Converted the pseudocode to operational, well-structured Java*
   
   [Pseudocode Text](psuedocode.txt "psuedocode.txt")

```
   #######
# Start Application
Function MAIN():

    sampleValuesList = [9, 6, 8, 5, 7]
    sampleStdDev = COMPUTE_SAMPLE_STANDARD_DEVIATION(sampleValuesList)
    Print("Sample StdDev =", sampleStdDev)
    # Writes "Sample StdDev=1.5811388300841898"
    # From https://www.cuemath.com/sample-standard-deviation-formula/

    populationValuesList = [9, 2, 5, 4, 12, 7, 8, 11, 9, 3, 7, 4, 12, 5, 4, 10, 9, 6, 9, 4]
    popStdDev = COMPUTE_POPULATION_STANDARD_DEVIATION(populationValuesList)
    Print("Population StdDev =", popStdDev)
    # Writes "Population StdDev=2.9832867780352594"
    # From https://www.thoughtco.com/population-standard-deviation-calculation-609522


#######
# Function to compute the mean (average) of a list of values
Function COMPUTE_MEAN(valuesList:

    If valuesList is empty:
        Raise Error "valuesList parameter cannot be null or empty"

    sumAccumulator = 0
    For each value in valuesList:
        sumAccumulator = sumAccumulator + value

    # Return the average (sum divided by the number of values we accumulated)
    Return sumAccumulator / (Number of values in valuesList)


#######
# Function to compute the sum of squared differences from the mean
Function COMPUTE_SQUARE_OF_DIFFERENCES(valuesList, mean):

    If valuesList is empty:
        Raise Error "valuesList parameter cannot be null or empty"

    squareAccumulator = 0
    For each value in valuesList:
        difference = value - mean
        squareOfDifference = difference * difference
        squareAccumulator = squareAccumulator + squareOfDifference

    Return squareAccumulator


#######
# Function to compute the variance based on squared differences
#   Set isPopulation to true to compute a population standard deviation in COMPUTE_VARIANCE
#   Set isPopulation to false to compute a sample standard deviation in COMPUTE_VARIANCE
Function COMPUTE_VARIANCE(squareOfDifferences, numValues, isPopulation):

    # Adjust number of values by minus one if sample where sample is indicated by (not isPopulation)
    # https://www.quora.com/On-the-sample-standard-deviation-why-do-we-subtract-N-by-1

    If not isPopulation:
        numValues = numValues - 1

    # Test numValues after adjusting for change to numValues
    #    We cannot allow numValues to be a 0 denominator (division by zero / undefined)
    If numValues < 1:
        Raise Error "numValues is too low (sample size must be >= 2, population size must be >= 1)"

    Return squareOfDifferences / numValues


#######
# Function to compute the population or sample standard deviation from a list of values
Function COMPUTE_STANDARD_DEVIATION(valuesList, isPopulation):

    If valuesList is empty:
        Raise Error "valuesList parameter cannot be null or empty"

    mean = COMPUTE_MEAN(valuesList)
    squareOfDifferences = COMPUTE_SQUARE_OF_DIFFERENCES(valuesList, mean)
    variance = COMPUTE_VARIANCE(squareOfDifferences, (Number of values in valuesList), isPopulation)

    Return SquareRoot(variance)
    # where SquareRoot is a math function to compute the square root of the variance


#######
# Function to compute the sample standard deviation from a list of values
Function COMPUTE_SAMPLE_STANDARD_DEVIATION(valuesList):

		# (false) in the following statement indicates we are computing a sample variance
    Return COMPUTE_STANDARD_DEVIATION(valuesList, false)


#######
# Function to compute the population standard deviation from a list of values
Function COMPUTE_POPULATION_STANDARD_DEVIATION(valuesList):

		# (true) in the following statement indicates we are computing a population variance
    Return COMPUTE_STANDARD_DEVIATION(valuesList, true)
    
```
### 3. Wrote Unit Tests

   *Wrote 18 Junit unit tests and achieved 100% coverage of every branch*
### 4. Performed Coverage Analysis

   *Achieved 100% coverage of all branches*
   
   [Coverage Analysis](CoverageAnalysis.png "CoverageAnalysis.png")
   
   ![Coverage](https://github.com/Code-Cruncher-Omega/swe3643-fall2024-homework/blob/main/homework-2/Homework2/CoverageAnalysis.png)
