/**
 * Course: Introduction to Object-Oriented Programming
 * File Name: GradeDriver.java
 * Assignment: 4
 * Due Date: 2021/11/07
 * Instructor: Mr. Schuessler
 */

 import java.io.File;
 import java.io.FileNotFoundException;
 import java.io.PrintStream;
 import java.util.Scanner;

 /**
  * This program reads from an input file, processes the data into
  * arrays, and sends the results to an output file.
  * @author Charmaine Dacones
  * @version 2021 01 December
  */
public class GradeDriver {
    
    /**
     * The main method initializes an array, reads the data from
     * the input file, then stores the results to an output file.
     * @param theArgs
     */
    public static void main (String[] theArgs) {
      Scanner input = null;
      PrintStream output = null;
      String inFileName = "in4.txt";
      String outFileName = "out4.txt";
      boolean fileFound = false;

      // A TestGrades array called testGrades is declared. The value
      // of the array will be assigned the names and test scores.
      TestGrades testGrades[];

      try {
        input = new Scanner(new File(inFileName));
        output = new PrintStream(new File(outFileName));
        fileFound = true;
      }
      catch (FileNotFoundException e) {
          System.out.println("Cannot open file: " + e);  
          System.out.println("Enter a file: ");               
      }

      if (fileFound) {
        // testGrades will receive an array from the getGrades
        // method.
        testGrades = getGrades(input);
        display(testGrades, output);            
      }
      input.close();
      output.close();
    }


    /**
     * The getGrades method receives the input file from main and 
     * creates a new instance for TestGrades. All of the scores
     * and student names are stored in a TestGrades array.
     * @param theInFile
     * @return The value of the results array is returned to main.
     */
    public static TestGrades[] getGrades(Scanner theInFile) {
      String firstName = "";
      String lastName = "";

      // An instance of the TestGrades class is initialized. The
      // first integer read from the input file represents the
      // size of the results array.
      TestGrades results[] = new TestGrades[theInFile.nextInt()];

      // For each index of the results array, the student's first
      // and last name is read;
      for (int index = 0; index <= results.length - 1; index++) {
        firstName = theInFile.next();
        lastName = theInFile.next();

        // For each element, a new array of size 4 is created.
        // Each student has 4 different test scores.
        int[] scores = new int[4];

        // Each index of the scores array is assigned a test score
        // from each student.
        for (int element = 0; element <= scores.length - 1; element++) {
          scores[element] = theInFile.nextInt();
        }

        // After assigning the 4 scores for each student, a TestGrade
        // object is assigned to each index of the results array;
        results[index] = new TestGrades(firstName, lastName, scores);
     
      }
      return results;   
    }
    

    /**
     * The display method writes the results of all the performed
     * operations on the data to an output file.
     * @param theTestResults[]
     */
    public static void display(TestGrades theTestResults[],
                               PrintStream theOutput) {

      int testAverage;
      int highestAverage = 0;
      int lowestAverage = 0;
      int overallAverage = 0;
      theOutput.println("Total number of students: " +
                         theTestResults[0].getStudentCount());
      
      // Each element of the theTestResults array is printed followed
      // by the student's average test score.
      for(int index = 0; index <= theTestResults.length - 1; index++) {
        theOutput.print(theTestResults[index]);
        testAverage = theTestResults[index].getTestsAverage();
        theOutput.println(testAverage);

        if (testAverage > highestAverage) {
          highestAverage = testAverage;
        } else {
          lowestAverage = testAverage;
        }        
      }     
      
      overallAverage = (highestAverage + lowestAverage) / 2;
      theOutput.println();
      theOutput.println("Highest Student Average = " + highestAverage);
      theOutput.println("Lowest Student Average = " + lowestAverage);
      theOutput.println("Overall Class Average = " + overallAverage);
    }
}
