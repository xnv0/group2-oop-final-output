// Members: 
// Abrazado, Jin Gaila B.
// Bautista, Mark Anthony A.
// Costigan, Jennilyn Y.
// Feliciano, Angelo Iñigo D.
// Section/Course: 
// NW-201 / 6-OOP

import javax.swing.JOptionPane;

class MultipleChoiceQuestion extends Question {
    private String[] options;
    private int correctIndex;

    public MultipleChoiceQuestion(Flashcard source, int difficulty, String[] options, int correctIndex) {
        super(source, difficulty);
        this.options = options;
        this.correctIndex = correctIndex;
    }

    @Override
    public void ask() {
    }

    public String askWithDialog() {
        StringBuilder sb = new StringBuilder();
        sb.append("Multiple Choice:\n\n");
        sb.append("Term: ").append(source.getTerm()).append("\n");
        sb.append("Choose the correct definition:\n\n");
        for (int i = 0; i < options.length; i++) {
            sb.append((i + 1)).append(". ").append(options[i]).append("\n");
        }
        
        if (difficulty == 1) {
            sb.append("\nHint: ");
            String def = source.getDefinition();
            if (def.length() > 30) def = def.substring(0, 30) + "...";
            sb.append("Definition starts with \"").append(def).append("\"");
        }
        
        return JOptionPane.showInputDialog(null, sb.toString(), "Quiz Question", JOptionPane.QUESTION_MESSAGE);
    }

    @Override
    public boolean evaluate(String answer) {
        try {
            int sel = Integer.parseInt(answer.trim()) - 1;
            return sel == correctIndex;
        } catch (Exception e) {
            return false;
        }
    }

    // hints (only for easy)
    public void showHint() {
        String def = source.getDefinition();
        if (def.length() > 30) def = def.substring(0, 30) + "...";
        JOptionPane.showMessageDialog(null, "Hint: Definition starts with \"" + def + "\"", "Hint", JOptionPane.INFORMATION_MESSAGE);
    }

    public String[] getOptions() {
    return options;
}

}