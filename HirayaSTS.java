import java.util.Scanner;

public class HirayaSTS {
    // ---------- System-wide constants ----------
    private static final String[] AVAILABLE_COURSES = {
        "Computer Science Fundamentals",
        "Cybersecurity Basics",
        "Object-Oriented Programming",
        "Data Structures and Algorithms"
    };
    private static final String[] TOPICS = {
        "Object-Oriented Programming",
        "Cybersecurity Basics",
        "Computer Science Fundamentals",
        "Data Structures and Algorithms"
    };
    // ---------- Storage arrays ----------
    private Flashcard[] flashcards;
    private int flashcardCount;
    private User[] users;
    private int userCount;

    private Scanner scanner;

    // Constructor initializes arrays and sample data
    public HirayaSTS() {
        flashcards = new Flashcard[200];
        flashcardCount = 0;
        users = new User[50];
        userCount = 0;
        scanner = new Scanner(System.in);

        populateSampleDataVariantA(); // primary sample dataset
        // Additional dataset can be loaded by calling populateSampleDataVariantB()
    }

    // Sample data variant A (more than one user and many flashcards)
    private void populateSampleDataVariantA() {
        // Add Students
        addUser(new Student(1, "Juan Dela Cruz", "student01", "password", "juan@student.edu", "Computer Science", "2001-05-12"));
        addUser(new Student(2, "Maria Santos", "student02", "pass123", "maria@student.edu", "Information Technology", "2002-10-01"));

        // Add Tutors
        addUser(new Tutor(11, "Prof. Santos", "tutor01", "tutorpass", "Software Engineering"));
        addUser(new Tutor(12, "Coach Reyes", "tutor02", "coachpw", "Cybersecurity"));

        // Add Admin
        addUser(new Admin(99, "Admin", "admin", "admin", "super"));

        // Add Flashcards (multiple topics)
        addFlashcard(new Flashcard("Exception Handling", "A mechanism to handle runtime errors and maintain normal application flow.", "Object-Oriented Programming"));
        addFlashcard(new Flashcard("Polymorphism", "The ability of an object to take on many forms.", "Object-Oriented Programming"));
        addFlashcard(new Flashcard("Array of Objects", "A collection of objects stored in a single array.", "Object-Oriented Programming"));
        addFlashcard(new Flashcard("SQL Injection", "An attack that injects malicious SQL into queries.", "Cybersecurity Basics"));
        addFlashcard(new Flashcard("Firewall", "A network security device that monitors traffic.", "Cybersecurity Basics"));
        addFlashcard(new Flashcard("Heap", "A region of memory for dynamic allocation.", "Computer Science Fundamentals"));
        addFlashcard(new Flashcard("Stack", "LIFO data structure used for function calls.", "Computer Science Fundamentals"));
        addFlashcard(new Flashcard("Linked List", "A collection of nodes where each node points to the next.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("Big O Notation", "A measure of algorithm time complexity.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("Abstraction", "Hiding implementation details while exposing essential features.", "Object-Oriented Programming"));
        addFlashcard(new Flashcard("Encapsulation", "Bundling data and methods and restricting direct access.", "Object-Oriented Programming"));

        // Initialize some performance tracking for students with mock attempts
        User u1 = findUserByUsername("student01");
        if (u1 instanceof Student) {
            Student s = (Student) u1;
            // record some mock attempts (topic indexes correspond to TOPICS)
            s.recordResult("Object-Oriented Programming", true);
            s.recordResult("Object-Oriented Programming", false);
            s.recordResult("Data Structures and Algorithms", false);
            s.recordResult("Data Structures and Algorithms", false);
            s.recordResult("Computer Science Fundamentals", true);
        }
    }

    // An alternative dataset (variant B) with at least 2 examples for each option
    // If you want to run variant B instead, call populateSampleDataVariantB() from constructor.
    private void populateSampleDataVariantB() {
        // Clear current arrays
        flashcards = new Flashcard[200];
        flashcardCount = 0;
        users = new User[50];
        userCount = 0;

        addUser(new Student(3, "Andres Bonifacio", "student03", "abc", "andres@school.edu", "Computer Science", "2000-12-30"));
        addUser(new Student(4, "Jose Rizal", "student04", "xyz", "jose@school.edu", "IT", "1999-06-19"));

        addUser(new Tutor(21, "Ma'am Cruz", "tutor03", "pw3", "Education"));
        addUser(new Tutor(22, "Sir Lopez", "tutor04", "pw4", "Algorithms"));

        addUser(new Admin(100, "SuperAdmin", "root", "toor", "root"));

        addFlashcard(new Flashcard("Binary Search", "Search algorithm working on sorted arrays by dividing search interval.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("Sandwich Sec", "Not a real concept (distractor).", "Cybersecurity Basics"));
        // ... add more to have at least two per topic
        addFlashcard(new Flashcard("OOP - Interface", "A contract that classes can implement.", "Object-Oriented Programming"));
        addFlashcard(new Flashcard("OOP - Abstract Class", "A partially implemented class to be extended.", "Object-Oriented Programming"));
    }

    // ---------- Adders and finders ----------
    public void addFlashcard(Flashcard f) {
        if (flashcardCount < flashcards.length) {
            flashcards[flashcardCount++] = f;
        } else {
            System.out.println("Flashcard storage full.");
        }
    }

    public void addUser(User u) {
        if (userCount < users.length) {
            users[userCount++] = u;
        } else {
            System.out.println("User storage full.");
        }
    }

    private User findUserByUsername(String username) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getUsername().equals(username)) return users[i];
        }
        return null;
    }

    // ---------- Flashcard review mode ----------
    private void flashcardsMode() {
        System.out.println("\nFLASHCARDS MODE - REVIEW\n");
        if (flashcardCount == 0) {
            System.out.println("No flashcards available.");
            return;
        }

        int pageSize = 3;
        int page = 0;
        boolean running = true;

        while (running) {
            int start = page * pageSize;
            if (start >= flashcardCount) start = 0; // wrap
            int end = Math.min(start + pageSize, flashcardCount);
            int totalPages = (flashcardCount + pageSize - 1) / pageSize;
            System.out.println("Showing " + (end - start) + " Flashcards (Page " + (page + 1) + " of " + totalPages + "):\n");
            for (int i = start; i < end; i++) {
                Flashcard f = flashcards[i];
                System.out.println("[" + (i - start + 1) + "] Term: " + f.getTerm());
                System.out.println("Definition: " + f.getDefinition() + "\n");
            }
            System.out.println("Options:");
            System.out.println("1. Next Page");
            System.out.println("2. Shuffle Flashcards");
            System.out.println("3. Back Page");
            System.out.println("4. Return to Main Menu");
            System.out.print("Enter choice: ");
            String c = scanner.nextLine().trim();
            System.out.println();
            switch (c) {
                case "1": page = (page + 1) % totalPages; break;
                case "2":
                    shuffleFlashcards();
                    System.out.println("Flashcards shuffled.\n");
                    break;
                case "3": page = (page - 1 + totalPages) % totalPages; break;
                case "4": running = false; break;
                default: System.out.println("Invalid choice."); break;
            }
        }
    }

    private void shuffleFlashcards() {
        for (int i = 0; i < flashcardCount; i++) {
            int j = (int) (Math.random() * flashcardCount);
            Flashcard tmp = flashcards[i];
            flashcards[i] = flashcards[j];
            flashcards[j] = tmp;
        }
    }

    // ---------- Quiz generation ----------
    // difficulty: 1=Easy (MC w/ hints), 2=Medium (MC no hints), 3=Hard (Identification)
    private Quiz generateQuiz(String topic, int n, int difficulty) {
        Question[] questions = new Question[n];
        // Collect flashcards of that topic
        Flashcard[] pool = new Flashcard[flashcardCount];
        int poolCount = 0;
        for (int i = 0; i < flashcardCount; i++) {
            if (flashcards[i].getTopic().equalsIgnoreCase(topic)) {
                pool[poolCount++] = flashcards[i];
            }
        }
        if (poolCount == 0) {
            // fallback: use all flashcards
            for (int i = 0; i < flashcardCount; i++) pool[poolCount++] = flashcards[i];
        }
        // Build questions by sampling from pool (with wrap)
        for (int i = 0; i < n; i++) {
            Flashcard source = pool[i % poolCount];
            if (difficulty == 3) {
                // Identification
                IdentificationQuestion iq = new IdentificationQuestion(source, difficulty, source.getDefinition());
                questions[i] = iq;
            } else {
                // Multiple choice - build 3 options (1 correct + up to 2 distractors)
                String[] options = new String[3];
                options[0] = source.getDefinition();
                // pick distractors
                int d = 1;
                for (int k = 0; k < poolCount && d < 3; k++) {
                    Flashcard cand = pool[(i + k + 1) % poolCount];
                    if (!cand.getDefinition().equals(options[0])) {
                        options[d++] = cand.getDefinition();
                    }
                }
                // if not enough distractors, fill placeholders
                while (d < 3) {
                    options[d++] = "No further options available.";
                }
                // shuffle options but keep track of correct index
                int correctIndex = 0;
                // simple shuffle
                for (int s = 0; s < options.length; s++) {
                    int r = (int) (Math.random() * options.length);
                    String tmp = options[s]; options[s] = options[r]; options[r] = tmp;
                }
                for (int ix = 0; ix < options.length; ix++) {
                    if (options[ix].equals(source.getDefinition())) { correctIndex = ix; break; }
                }
                MultipleChoiceQuestion mcq = new MultipleChoiceQuestion(source, difficulty, options, correctIndex);
                questions[i] = mcq;
            }
        }
        return new Quiz(questions, topic);
    }

    // ---------- Recommendations ----------
    private void recommendLessons(Student s) {
        System.out.println("\nRecommended Lessons (based on weak topics):");
        String[] weak = s.getWeakTopics(40.0); // threshold 40% accuracy
        if (weak.length == 0) {
            System.out.println("Great job! No weak topics detected.");
        } else {
            for (String t : weak) {
                System.out.println("- " + t);
            }
        }
    }

    // ---------- Main run / login / dashboards ----------
    public void run() {
        System.out.println("HIRAYA SMART TUTORING SYSTEM\n");
        System.out.println("Please log in:\n");
        System.out.print("Enter Username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine().trim();
        User u = findUserByUsername(username);
        if (u == null || !u.login(username, password)) {
            System.out.println("\nLogin failed. Exiting.");
            return;
        }
        System.out.println("\nLogin successful!");
        System.out.println("Welcome, " + u.getName() + " (" + u.getRoleName() + ").");
        System.out.println("\n————————————————————————————\n");

        if (u instanceof Student) {
            studentDashboard((Student) u);
        } else if (u instanceof Tutor) {
            tutorDashboard((Tutor) u);
        } else if (u instanceof Admin) {
            adminDashboard((Admin) u);
        } else {
            System.out.println("Unknown role.");
        }
        System.out.println("\nGoodbye!");
    }

    // Student dashboard
    private void studentDashboard(Student s) {
        boolean loop = true;
        while (loop) {
            System.out.println("STUDENT DASHBOARD\n");
            System.out.println("1. Course Selection");
            System.out.println("2. Flashcards Mode (Review)");
            System.out.println("3. Practice Quiz Mode");
            System.out.println("4. View Recommendations");
            System.out.println("5. Logout");
            System.out.print("\nEnter choice: ");
            String ch = scanner.nextLine().trim();
            System.out.println();
            switch (ch) {
                case "1":
                    courseSelection();
                    break;
                case "2":
                    flashcardsMode();
                    break;
                case "3":
                    practiceQuizMode(s);
                    break;
                case "4":
                    recommendLessons(s);
                    break;
                case "5": loop = false; break;
                default: System.out.println("Invalid choice."); break;
            }
            System.out.println("\n————————————————————————————\n");
        }
    }

    private void courseSelection() {
        System.out.println("COURSE SELECTION\n");
        System.out.println("Available Courses:");
        for (int i = 0; i < AVAILABLE_COURSES.length; i++) {
            System.out.println((i + 1) + ". \u200B\u200B\u200B\u200B" + AVAILABLE_COURSES[i]);
        }
        System.out.print("Enter the number of the course you want to study: ");
        String sel = scanner.nextLine().trim();
        try {
            int idx = Integer.parseInt(sel) - 1;
            if (idx >= 0 && idx < AVAILABLE_COURSES.length) {
                System.out.println("You have selected: " + AVAILABLE_COURSES[idx]);
            } else {
                System.out.println("Invalid selection.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }

    // Practice quiz mode menu (student)
    private void practiceQuizMode(Student s) {
        System.out.println("PRACTICE QUIZ MODE\n");
        System.out.println("Select Difficulty Level:");
        System.out.println("1. Easy (Multiple Choice with Hints)");
        System.out.println("2. Medium (Multiple Choice without Hints)");
        System.out.println("3. Hard (Identification with Progressive Hints)");
        System.out.print("\nEnter choice: ");
        String ch = scanner.nextLine().trim();
        int diff = 1;
        if (ch.equals("1")) diff = 1;
        else if (ch.equals("2")) diff = 2;
        else if (ch.equals("3")) diff = 3;
        else {
            System.out.println("Invalid choice. Defaulting to Easy.");
        }
        System.out.println("\nAvailable Topics:");
        for (int i = 0; i < TOPICS.length; i++) {
            System.out.println((i + 1) + ". " + TOPICS[i]);
        }
        System.out.print("Enter the number of the topic: ");
        String tsel = scanner.nextLine().trim();
        int tidx = 0;
        try {
            tidx = Integer.parseInt(tsel) - 1;
            if (tidx < 0 || tidx >= TOPICS.length) tidx = 0;
        } catch (NumberFormatException e) {
            tidx = 0;
        }
        String topic = TOPICS[tidx];
        System.out.print("Enter number of questions (e.g., 3): ");
        int n = 3;
        try {
            n = Integer.parseInt(scanner.nextLine().trim());
            if (n <= 0) n = 3;
        } catch (Exception e) { n = 3; }
        System.out.println("\nStarting Quiz... Good luck!\n");
        Quiz quiz = generateQuiz(topic, n, diff);
        quiz.administer(s, scanner);
    }

    // Tutor dashboard
    private void tutorDashboard(Tutor t) {
        System.out.println("TUTOR DASHBOARD\n");
        System.out.println("Welcome, " + t.getName() + " (Tutor)\n");
        boolean run = true;
        while (run) {
            System.out.println("Options:");
            System.out.println("1. Create Flashcard");
            System.out.println("2. Edit Flashcard");
            System.out.println("3. Delete Flashcard");
            System.out.println("4. Review Flashcards");
            System.out.println("5. Logout");
            System.out.print("\nEnter choice: ");
            String c = scanner.nextLine().trim();
            System.out.println();
            switch (c) {
                case "1":
                    System.out.println("--- CREATE FLASHCARD ---");
                    System.out.print("Enter Term: ");
                    String term = scanner.nextLine().trim();
                    System.out.print("Enter Definition: ");
                    String definition = scanner.nextLine().trim();
                    System.out.print("Enter Topic: ");
                    String topic = scanner.nextLine().trim();
                    Flashcard nf = t.createFlashcard(term, definition, topic);
                    addFlashcard(nf);
                    System.out.println("\nFlashcard successfully added under " + topic + "!");
                    break;
                case "2":
                    editFlashcard();
                    break;
                case "3":
                    deleteFlashcard();
                    break;
                case "4":
                    flashcardsMode();
                    break;
                case "5": run = false; break;
                default: System.out.println("Invalid choice."); break;
            }
            System.out.println("\n—————————————————————————————————\n");
        }
    }

    private void editFlashcard() {
        if (flashcardCount == 0) { System.out.println("No flashcards to edit."); return; }
        System.out.println("Edit which flashcard? (enter index)");
        for (int i = 0; i < flashcardCount; i++) {
            System.out.println((i + 1) + ". " + flashcards[i].getTerm() + " (" + flashcards[i].getTopic() + ")");
        }
        System.out.print("Choice: ");
        try {
            int idx = Integer.parseInt(scanner.nextLine().trim()) - 1;
            if (idx < 0 || idx >= flashcardCount) { System.out.println("Invalid index."); return; }
            System.out.print("Enter new Term (leave blank to keep): ");
            String term = scanner.nextLine();
            System.out.print("Enter new Definition (leave blank to keep): ");
            String def = scanner.nextLine();
            System.out.print("Enter new Topic (leave blank to keep): ");
            String topic = scanner.nextLine();
            if (!term.trim().equals("")) flashcards[idx].setTerm(term.trim());
            if (!def.trim().equals("")) flashcards[idx].setDefinition(def.trim());
            if (!topic.trim().equals("")) flashcards[idx].setTopic(topic.trim());
            System.out.println("Flashcard updated.");
        } catch (Exception e) { System.out.println("Invalid input."); }
    }

    private void deleteFlashcard() {
        if (flashcardCount == 0) { System.out.println("No flashcards to delete."); return; }
        System.out.println("Delete which flashcard? (enter index)");
        for (int i = 0; i < flashcardCount; i++) {
            System.out.println((i + 1) + ". " + flashcards[i].getTerm() + " (" + flashcards[i].getTopic() + ")");
        }
        System.out.print("Choice: ");
        try {
            int idx = Integer.parseInt(scanner.nextLine().trim()) - 1;
            if (idx < 0 || idx >= flashcardCount) { System.out.println("Invalid index."); return; }
            // shift left
            for (int i = idx; i < flashcardCount - 1; i++) flashcards[i] = flashcards[i + 1];
            flashcards[--flashcardCount] = null;
            System.out.println("Flashcard deleted.");
        } catch (Exception e) { System.out.println("Invalid input."); }
    }

    // Admin dashboard
    private void adminDashboard(Admin a) {
        System.out.println("ADMIN DASHBOARD\n");
        boolean run = true;
        while (run) {
            System.out.println("Options:");
            System.out.println("1. Backup Data");
            System.out.println("2. View Users");
            System.out.println("3. Logout");
            System.out.print("\nEnter choice: ");
            String c = scanner.nextLine().trim();
            System.out.println();
            switch (c) {
                case "1":
                    a.backupData();
                    break;
                case "2":
                    System.out.println("Users:");
                    for (int i = 0; i < userCount; i++) {
                        System.out.println("- " + users[i].getName() + " (" + users[i].getRoleName() + ")");
                    }
                    break;
                case "3": run = false; break;
                default: System.out.println("Invalid choice."); break;
            }
            System.out.println("\n————————————————————————————\n");
        }
    }

    // ---------- Main ----------
    public static void main(String[] args) {
        HirayaSTS app = new HirayaSTS();
        app.run();
    }
}

/* ------------------------------
   User and subclasses
   ------------------------------ */
class User {
    protected int id;
    protected String name;
    protected String username;
    protected String password;

    public User(int id, String name, String username, String password) {
        this.id = id; this.name = name; this.username = username; this.password = password;
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public String getUsername() { return username; }
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
    public String getRoleName() { return "User"; }
}

class Student extends User {
    private String email;
    private String course;
    private String dateOfBirth;

    // For performance tracking: parallel arrays keyed by TOPICS in main app.
    // We'll store pairs as two arrays with topic names. To be simple, we'll collect counts per topic string.
    private String[] trackedTopics;
    private int[] attempts;
    private int[] correct;

    public Student(int id, String name, String username, String password, String email, String course, String dateOfBirth) {
        super(id, name, username, password);
        this.email = email; this.course = course; this.dateOfBirth = dateOfBirth;
        // initialize tracking with a default list of topics
        this.trackedTopics = new String[] { "Object-Oriented Programming", "Cybersecurity Basics", "Computer Science Fundamentals", "Data Structures and Algorithms" };
        this.attempts = new int[trackedTopics.length];
        this.correct = new int[trackedTopics.length];
        for (int i = 0; i < trackedTopics.length; i++) { attempts[i] = 0; correct[i] = 0; }
    }

    @Override
    public String getRoleName() { return "Student"; }

    // record result by topic name (increment attempts and correct if true)
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

class Admin extends User {
    private String adminLevel;
    public Admin(int id, String name, String username, String password, String adminLevel) {
        super(id, name, username, password); this.adminLevel = adminLevel;
    }
    @Override
    public String getRoleName() { return "Admin"; }

    public void backupData() {
        System.out.println("Backing up data... (simulated)");
        System.out.println("Backup complete.");
    }
}

/* ------------------------------
   Flashcard
   ------------------------------ */
class Flashcard {
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
        System.out.println("Term: " + term);
        System.out.println("Definition: " + definition);
    }
}

/* ------------------------------
   Question (abstract) and subclasses
   ------------------------------ */
abstract class Question {
    protected Flashcard source;
    protected int difficulty;
    public Question(Flashcard source, int difficulty) {
        this.source = source; this.difficulty = difficulty;
    }
    public abstract void ask();
    // evaluate given string input; return true if correct
    public abstract boolean evaluate(String answer);
}

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
        System.out.println("Multiple Choice:");
        System.out.println("Term: " + source.getTerm());
        System.out.println("Choose the correct definition:");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
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
        System.out.println("Hint: Definition starts with \"" + def + "\"");
    }

    public String[] getOptions() {
    return options;
}

}

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
        System.out.println("Fill in the blank:\n");
        System.out.println(source.getDefinition());
        System.out.print("Enter your answer: ");
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

/* ------------------------------
   Quiz class
   ------------------------------ */
class Quiz {
    private Question[] questions;
    private int score;
    private String topic;

    public Quiz(Question[] questions, String topic) {
        this.questions = questions; this.topic = topic; this.score = 0;
    }

    public void administer(Student s, Scanner scanner) {
        for (int i = 0; i < questions.length; i++) {
            Question q = questions[i];
            System.out.println("Question " + (i + 1) + ":\n");
            q.ask();
            if (q instanceof MultipleChoiceQuestion) {
                MultipleChoiceQuestion mc = (MultipleChoiceQuestion) q;
                // If difficulty is 1 (Easy), show hint before answer
                if (mc.difficulty == 1) {
                    mc.showHint();
                }
                System.out.print("\nEnter your choice (1-" + mc.getOptions().length + "): ");
                String ans = scanner.nextLine().trim();
                boolean correct = mc.evaluate(ans);
                if (correct) {
                    System.out.println("\nCorrect!");
                    score++;
                    s.recordResult(topic, true);
                } else {
                    System.out.println("\nIncorrect!");
                    s.recordResult(topic, false);
                }
            } else if (q instanceof IdentificationQuestion) {
                IdentificationQuestion iq = (IdentificationQuestion) q;
                boolean correct = false;
                int tries = 0;
                while (!correct && tries < 3) {
                    System.out.print("\nEnter your answer: ");
                    String ans = scanner.nextLine().trim();
                    correct = iq.evaluate(ans);
                    if (correct) {
                        System.out.println("\nCorrect!");
                        score++;
                        s.recordResult(topic, true);
                    } else {
                        System.out.println("\nIncorrect! Try again.");
                        System.out.println(iq.getHint());
                        tries++;
                        s.recordResult(topic, false);
                    }
                }
                if (!correct) {
                    System.out.println("\nThe correct answer was: " + iq.getExpected());
                }
            } else {
                System.out.println("Unsupported question type.");
            }
            System.out.println("\n--------------------------------\n");
        }
        System.out.println("Quiz complete! Score: " + score + " out of " + questions.length);
    }
}
