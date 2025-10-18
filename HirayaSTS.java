/**

Object-Oriented Programming Final Project
Section/Course: NW-201 / 6OOP

Group Members:  

    Abrazado, Jin Gaila B.
    Bautista, Mark Anthony A.
    Costigan, Jennilyn Y.
    Feliciano, Angelo Iñigo D.

 **/

// Import the implementation class
import classes.HirayaSTSImplementation;

/**
 * Main class for Hiraya Student Tutoring System (STS)
 * This class serves as the entry point to the application.
 * All implementation details are handled by the HirayaSTSImplementation class.
 */
public class HirayaSTS {
    
    /**
     * Main method - entry point of the application
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Create an instance of the implementation class and run the application
        HirayaSTSImplementation app = new HirayaSTSImplementation();
        app.run();
    }

}