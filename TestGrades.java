/**
 * Course: Introduction to Object-Oriented Programming
 * File Name: GradeDriver.java
 * Assignment: 4
 * Due Date: 2021/11/07
 * Instructor: Mr. Schuessler
 */

import java.util.Arrays;

/**
* This Java class called TestGrades contains all of the methods and 
* attributes for the TestGrades objects.
* @author Charmaine Dacones
* @version 2021 01 December
*/
public class TestGrades {

    /**
     * The myStudents private field is used as a counter for the
     * number of students read from the input file.
     */
    private static int myStudents = 0;


    /**
     * The myFirstName private filed is used to store the student's
     * first name.
     */
    private String myFirstName;


    /**
     * The myLastName private field is used to store the student's
     * last name.
     */
    private String myLastName;


    /**
     * The array myTestScores stores the students' test scores in
     * an array.
     */
    private int[] myTestScores;


    /**
     * The TestGrades constructor receives a student's first name,
     * last name, and test scores. This constructor is called when
     * the getGrades methods creates a new object for each index of
     * the results array.
     * 
     * @param theFirst
     * @param theSec
     * @param score
     */
    public TestGrades(String theFirst, String theSec,
                      int[] theScore) {

        myFirstName = theFirst;
        myLastName = theSec;

        // The private field myTestScores is initialized to the size
        // of the array theScore.
        myTestScores = new int[theScore.length];
        
        // Each index of the array myTestScores is assigned the value
        // of the same index from the array score.
        for (int index = 0; index <= theScore.length - 1; index++) {
            myTestScores[index] = theScore[index];
        }
        myStudents++;
    }


    /**
     * The getFirstName method returns the student's first name
     * 
     * @return myFirstName returns the student's first name
     */
    public String getFirstName() {
        return myFirstName;
    }


    /**
     * The getLastName method returns the student's last name
     * 
     * @return myLastName returns the student's last name
     */
    public String getLastName() {
        return myLastName;
    }


    /**
     * The getStudentCount method returns the total number of students
     * 
     * @return
     */
    public int getStudentCount() {
        return myStudents++;
    }


    /**
     * The getTestsAverage method calculates the average score for
     * each student and returns the average.
     * 
     * @return myTestScores returns the third score in each array
     * for every student.
     */    
     public int getTestsAverage() {
         return myTestScores[2];
    }

    
    /**
     * The toString method is called on whenever the TestGrades object
     * is printed.
     * 
     * @return the studentName returns the student's first name, last
     * name, and the test scores.
     */
    public String toString() {
        String studentName = myFirstName + " " + myLastName + " " +
                             Arrays.toString(myTestScores) +
                             " Average = ";
        return studentName;
    }   
}


