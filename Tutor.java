// Members: 
// Abrazado, Jin Gaila B.
// Bautista, Mark Anthony A.
// Costigan, Jennilyn Y.
// Feliciano, Angelo Iñigo D.
// Section/Course: 
// NW-201 / 6-OOP

class Tutor extends User {
    private String expertise;
    public Tutor(int id, String name, String username, String password, String expertise) {
        super(id, name, username, password); this.expertise = expertise;
    }
    @Override
    public String getRoleName() { return "Tutor"; }

    public Flashcard createFlashcard(String term, String def, String topic) {
        return new Flashcard(term, def, topic);
    }
}