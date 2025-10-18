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

public class Quiz {
    private Question[] questions;
    private int score;
    private String topic;

    public Quiz(Question[] questions, String topic) {
        this.questions = questions; this.topic = topic; this.score = 0;
    }

    public void administer(Student s) {
        for (int i = 0; i < questions.length; i++) {
            Question q = questions[i];
            
            if (q instanceof MultipleChoiceQuestion) {
                MultipleChoiceQuestion mc = (MultipleChoiceQuestion) q;
                String ans = mc.askWithDialog();
                
                if (ans == null) break; // User cancelled
                
                boolean correct = mc.evaluate(ans);
                if (correct) {
                    JOptionPane.showMessageDialog(null, "Correct!", "Result", JOptionPane.INFORMATION_MESSAGE);
                    score++;
                    s.recordResult(topic, true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect!", "Result", JOptionPane.ERROR_MESSAGE);
                    s.recordResult(topic, false);
                }
            } else if (q instanceof IdentificationQuestion) {
                IdentificationQuestion iq = (IdentificationQuestion) q;
                boolean correct = false;
                int tries = 0;
                while (!correct && tries < 3) {
                    String ans = iq.askWithDialog();
                    if (ans == null) break; // User cancelled
                    
                    correct = iq.evaluate(ans);
                    if (correct) {
                        JOptionPane.showMessageDialog(null, "Correct!", "Result", JOptionPane.INFORMATION_MESSAGE);
                        score++;
                        s.recordResult(topic, true);
                    } else {
                        String message = "Incorrect! Try again.\n\n" + iq.getHint();
                        JOptionPane.showMessageDialog(null, message, "Incorrect", JOptionPane.ERROR_MESSAGE);
                        tries++;
                        s.recordResult(topic, false);
                    }
                }
                if (!correct) {
                    JOptionPane.showMessageDialog(null, "The correct answer was: " + iq.getExpected(), "Answer", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Unsupported question type.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        JOptionPane.showMessageDialog(null, "Quiz complete! Score: " + score + " out of " + questions.length, "Quiz Complete", JOptionPane.INFORMATION_MESSAGE);
    }
}