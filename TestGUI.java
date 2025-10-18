import javax.swing.JOptionPane;

public class TestGUI {
    public static void main(String[] args) {
        System.out.println("About to show dialog...");
        JOptionPane.showMessageDialog(null, "If you see this, GUI is working!", "Test", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("Dialog closed.");
    }
}
