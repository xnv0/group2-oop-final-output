// Members: 
// Abrazado, Jin Gaila B.
// Bautista, Mark Anthony A.
// Costigan, Jennilyn Y.
// Feliciano, Angelo Iñigo D.
// Section/Course: 
// NW-201 / 6-OOP

import javax.swing.JOptionPane;

class Admin extends User {
    private String adminLevel;
    public Admin(int id, String name, String username, String password, String adminLevel) {
        super(id, name, username, password); this.adminLevel = adminLevel;
    }
    @Override
    public String getRoleName() { return "Admin"; }

    public void backupData() {
        JOptionPane.showMessageDialog(null, "Backing up data... (simulated)\nBackup complete.", "Backup", JOptionPane.INFORMATION_MESSAGE);
    }
}