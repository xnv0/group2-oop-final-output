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

public class Admin extends User {
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