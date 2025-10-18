// Members: 
// Abrazado, Jin Gaila B.
// Bautista, Mark Anthony A.
// Costigan, Jennilyn Y.
// Feliciano, Angelo Iñigo D.
// Section/Course: 
// NW-201 / 6-OOP

import javax.swing.JOptionPane;

class IdentificationQuestion extends Question {
    private String expected;
    private int attempts;

    public IdentificationQuestion(Flashcard source, int difficulty, String expected) {
        super(source, difficulty);
        this.expected = expected;
        this.attempts = 0;
    }

    @Override
    public void ask() {
    }

    public String askWithDialog() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fill in the blank:\n\n");
        sb.append(source.getDefinition()).append("\n\n");
        sb.append("Enter your answer:");
        
        return JOptionPane.showInputDialog(null, sb.toString(), "Quiz Question", JOptionPane.QUESTION_MESSAGE);
    }

    @Override
    public boolean evaluate(String answer) {
        attempts++;
        return expected.trim().equalsIgnoreCase(answer.trim());
    }

    public String getHint() {
        // progressive hint based on attempts
        if (attempts == 0) return "Hint: " + expected.charAt(0);
        else if (attempts == 1) {
            int len = Math.min(3, expected.length());
            return "Hint: " + expected.substring(0, len);
        } else {
            return "Hint: The answer starts with \"" + expected.substring(0, Math.min(5, expected.length())) + "\"";
        }
    }

    public String getExpected() {
    return expected;
    }
}