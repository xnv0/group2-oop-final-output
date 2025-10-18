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

public class Student extends User {
    private String email;
    private String course;
    private String dateOfBirth;
    private String[] trackedTopics;
    private int[] attempts;
    private int[] correct;

    public Student(int id, String name, String username, String password, String email, String course, String dateOfBirth) {
        super(id, name, username, password);
        this.email = email; this.course = course; this.dateOfBirth = dateOfBirth;
        this.trackedTopics = new String[] { "Object-Oriented Programming", "Cybersecurity Basics", "Computer Science Fundamentals", "Data Structures and Algorithms" };
        this.attempts = new int[trackedTopics.length];
        this.correct = new int[trackedTopics.length];
        for (int i = 0; i < trackedTopics.length; i++) { attempts[i] = 0; correct[i] = 0; }
    }

    @Override
    public String getRoleName() { return "Student"; }

    // record result by topic name
    public void recordResult(String topic, boolean isCorrect) {
        int idx = indexOfTopic(topic);
        if (idx == -1) {
            // expand arrays to include this topic
            int old = trackedTopics.length;
            String[] nt = new String[old + 1];
            int[] na = new int[old + 1];
            int[] nc = new int[old + 1];
            for (int i = 0; i < old; i++) { nt[i] = trackedTopics[i]; na[i] = attempts[i]; nc[i] = correct[i]; }
            nt[old] = topic; na[old] = 0; nc[old] = 0;
            trackedTopics = nt; attempts = na; correct = nc;
            idx = old;
        }
        attempts[idx]++;
        if (isCorrect) correct[idx]++;
    }

    private int indexOfTopic(String topic) {
        for (int i = 0; i < trackedTopics.length; i++) if (trackedTopics[i].equalsIgnoreCase(topic)) return i;
        return -1;
    }

    // accuracy for a topic in percent
    public double accuracy(String topic) {
        int idx = indexOfTopic(topic);
        if (idx == -1 || attempts[idx] == 0) return 100.0;
        return ((double) correct[idx] / (double) attempts[idx]) * 100.0;
    }

    // return weak topics below threshold (percent)
    public String[] getWeakTopics(double threshold) {
        int count = 0;
        for (int i = 0; i < trackedTopics.length; i++) {
            double acc = (attempts[i] == 0) ? 100.0 : ((double) correct[i] / attempts[i]) * 100.0;
            if (acc < threshold) count++;
        }
        String[] res = new String[count];
        int k = 0;
        for (int i = 0; i < trackedTopics.length; i++) {
            double acc = (attempts[i] == 0) ? 100.0 : ((double) correct[i] / attempts[i]) * 100.0;
            if (acc < threshold) res[k++] = trackedTopics[i] + " (" + String.format("%.0f", acc) + "%)";
        }
        return res;
    }
}