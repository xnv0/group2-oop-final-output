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

import javax.swing.JOptionPane;

public class Flashcard {
    private String term;
    private String definition;
    private String topic;

    public Flashcard(String term, String definition, String topic) {
        this.term = term; this.definition = definition; this.topic = topic;
    }
    public String getTerm() { return term; }
    public String getDefinition() { return definition; }
    public String getTopic() { return topic; }
    public void setTerm(String t) { this.term = t; }
    public void setDefinition(String d) { this.definition = d; }
    public void setTopic(String t) { this.topic = t; }
    public void show() {
        JOptionPane.showMessageDialog(null, "Term: " + term + "\nDefinition: " + definition, "Flashcard", JOptionPane.INFORMATION_MESSAGE);
    }
}