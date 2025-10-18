/**

Object-Oriented Programming Final Project
Section/Course: NW-201 / 6OOP

Group Members:  

    Abrazado, Jin Gaila B.
    Bautista, Mark Anthony A.
    Costigan, Jennilyn Y.
    Feliciano, Angelo Iñigo D.

 **/

package classes;

public abstract class Question {
    protected Flashcard source;
    protected int difficulty;
    public Question(Flashcard source, int difficulty) {
        this.source = source; this.difficulty = difficulty;
    }
    public abstract void ask();
    // evaluate given string input; return true if correct
    public abstract boolean evaluate(String answer);
}