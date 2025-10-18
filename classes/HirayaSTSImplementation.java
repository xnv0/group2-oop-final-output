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
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class HirayaSTSImplementation {
    // System-wide constants
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
    
    // Storage arrays 
    private Flashcard[] flashcards;
    private int flashcardCount;
    private User[] users;
    private int userCount;
    private String selectedCourse = null; // Keep track of selected course for filtering

    // Constructor initializes system
    public HirayaSTSImplementation() {
        flashcards = new Flashcard[200];
        flashcardCount = 0;
        users = new User[50];
        userCount = 0;
        
        userFlashcardDatabase(); 
    }

    // Contains all of the users and flashcards
    private void userFlashcardDatabase() {
        // Add Students
        addUser(new Student(1, "Juan Dela Cruz", "student01", "password", "juan@student.edu", "Computer Science", "2001-05-12"));
        addUser(new Student(2, "Maria Santos", "student02", "pass123", "maria@student.edu", "Information Technology", "2002-10-01"));

        // Add Tutors
        addUser(new Tutor(11, "Prof. Santos", "tutor01", "tutorpass", "Software Engineering"));
        addUser(new Tutor(12, "Coach Reyes", "tutor02", "coachpw", "Cybersecurity"));

        // Add Admin
        addUser(new Admin(99, "Admin", "admin", "admin", "super"));

        // Add Flashcards (Various Topics)
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

        // Add Flashcards (OOP)
        addFlashcard(new Flashcard("Inheritance", "A mechanism where one class acquires the properties of another.", "Object-Oriented Programming"));
        addFlashcard(new Flashcard("Class", "A blueprint for creating objects.", "Object-Oriented Programming"));
        addFlashcard(new Flashcard("Object", "An instance of a class.", "Object-Oriented Programming"));
        addFlashcard(new Flashcard("Constructor", "A special method used to initialize objects.", "Object-Oriented Programming"));
        addFlashcard(new Flashcard("Method Overloading", "Defining multiple methods with the same name but different parameters.", "Object-Oriented Programming"));
        addFlashcard(new Flashcard("Method Overriding", "Redefining a superclass method in a subclass.", "Object-Oriented Programming"));
        addFlashcard(new Flashcard("Interface", "A reference type in Java, similar to a class, that can contain only constants, method signatures, default methods, static methods, and nested types.", "Object-Oriented Programming"));
        addFlashcard(new Flashcard("Abstract Class", "A class that cannot be instantiated and may contain abstract methods.", "Object-Oriented Programming"));
        addFlashcard(new Flashcard("Final Keyword", "Used to restrict the user; can be applied to variables, methods, and classes.", "Object-Oriented Programming"));
        addFlashcard(new Flashcard("Static Keyword", "Indicates that a member belongs to the class, rather than to any instance.", "Object-Oriented Programming"));
        addFlashcard(new Flashcard("Super Keyword", "Refers to the immediate parent class object.", "Object-Oriented Programming"));
        addFlashcard(new Flashcard("This Keyword", "Refers to the current object in a method or constructor.", "Object-Oriented Programming"));

        // Add Flashcards (CyberSec Basics)
        addFlashcard(new Flashcard("Phishing", "A fraudulent attempt to obtain sensitive information by disguising as a trustworthy entity.", "Cybersecurity Basics"));
        addFlashcard(new Flashcard("Malware", "Software designed to disrupt, damage, or gain unauthorized access to a computer system.", "Cybersecurity Basics"));
        addFlashcard(new Flashcard("Encryption", "The process of converting information into code to prevent unauthorized access.", "Cybersecurity Basics"));
        addFlashcard(new Flashcard("Authentication", "The process of verifying the identity of a user or process.", "Cybersecurity Basics"));
        addFlashcard(new Flashcard("Authorization", "The process of giving someone permission to do or have something.", "Cybersecurity Basics"));
        addFlashcard(new Flashcard("Brute Force Attack", "A trial-and-error method used to decode encrypted data such as passwords.", "Cybersecurity Basics"));
        addFlashcard(new Flashcard("Two-Factor Authentication", "A security process in which the user provides two different authentication factors.", "Cybersecurity Basics"));
        addFlashcard(new Flashcard("Zero-Day Vulnerability", "A software security flaw that is unknown to those who should be interested in its mitigation.", "Cybersecurity Basics"));
        addFlashcard(new Flashcard("Denial of Service", "An attack meant to shut down a machine or network, making it inaccessible to users.", "Cybersecurity Basics"));
        addFlashcard(new Flashcard("Man-in-the-Middle Attack", "An attack where the attacker secretly intercepts and relays messages between two parties.", "Cybersecurity Basics"));
        addFlashcard(new Flashcard("Social Engineering", "Manipulating people into giving up confidential information.", "Cybersecurity Basics"));

        // Add Flashcards (ComSci Fundamentals)
        addFlashcard(new Flashcard("Algorithm", "A step-by-step procedure for solving a problem.", "Computer Science Fundamentals"));
        addFlashcard(new Flashcard("Variable", "A storage location paired with an associated symbolic name.", "Computer Science Fundamentals"));
        addFlashcard(new Flashcard("Constant", "A value that cannot be altered by the program during normal execution.", "Computer Science Fundamentals"));
        addFlashcard(new Flashcard("Data Type", "An attribute of data which tells the compiler or interpreter how the programmer intends to use the data.", "Computer Science Fundamentals"));
        addFlashcard(new Flashcard("Compiler", "A program that translates source code into executable code.", "Computer Science Fundamentals"));
        addFlashcard(new Flashcard("Interpreter", "A program that executes instructions written in a programming language.", "Computer Science Fundamentals"));
        addFlashcard(new Flashcard("Recursion", "The process in which a function calls itself directly or indirectly.", "Computer Science Fundamentals"));
        addFlashcard(new Flashcard("Iteration", "The repetition of a process in a computer program.", "Computer Science Fundamentals"));
        addFlashcard(new Flashcard("Boolean", "A data type that has one of two possible values (true or false).", "Computer Science Fundamentals"));
        addFlashcard(new Flashcard("Array", "A collection of elements identified by index or key.", "Computer Science Fundamentals"));
        addFlashcard(new Flashcard("Function", "A block of code that performs a specific task.", "Computer Science Fundamentals"));
        addFlashcard(new Flashcard("Parameter", "A variable used to pass information between functions or procedures.", "Computer Science Fundamentals"));
        addFlashcard(new Flashcard("Return Value", "The value that a function returns to the calling function.", "Computer Science Fundamentals"));

        // Add Flashcards (DSAL)
        addFlashcard(new Flashcard("Queue", "A FIFO (First-In-First-Out) data structure.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("Tree", "A hierarchical data structure with a root value and subtrees of children.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("Binary Tree", "A tree data structure in which each node has at most two children.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("Graph", "A collection of nodes connected by edges.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("Hash Table", "A data structure that implements an associative array, a structure that can map keys to values.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("Bubble Sort", "A simple sorting algorithm that repeatedly steps through the list, compares adjacent elements and swaps them if they are in the wrong order.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("Merge Sort", "A divide and conquer algorithm that was invented by John von Neumann in 1945.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("Quick Sort", "An efficient sorting algorithm, serving as a systematic method for placing the elements of an array in order.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("Depth-First Search", "An algorithm for traversing or searching tree or graph data structures.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("Breadth-First Search", "An algorithm for searching a tree or graph data structures, starting at the root and exploring all neighbors at the present depth prior to moving on to nodes at the next depth level.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("Priority Queue", "An abstract data type similar to a regular queue or stack data structure in which each element has a priority associated with it.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("AVL Tree", "A self-balancing binary search tree.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("Dijkstra's Algorithm", "An algorithm for finding the shortest paths between nodes in a graph.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("Greedy Algorithm", "An algorithmic paradigm that follows the problem-solving heuristic of making the locally optimal choice at each stage.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("Dynamic Programming", "A method for solving complex problems by breaking them down into simpler subproblems.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("Recursion Tree", "A tree representation of the recursive calls made by an algorithm.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("Hash Collision", "When two different keys hash to the same index in a hash table.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("Adjacency Matrix", "A 2D array used to represent a finite graph.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("Adjacency List", "A collection of lists or arrays used to represent a finite graph.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("Minimum Spanning Tree", "A subset of the edges of a connected, edge-weighted undirected graph that connects all the vertices together, without any cycles and with the minimum possible total edge weight.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("Kruskal's Algorithm", "An algorithm for finding a minimum spanning tree for a connected weighted graph.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("Prim's Algorithm", "An algorithm that finds a minimum spanning tree for a weighted undirected graph.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("Binary Search Tree", "A node-based binary tree data structure which has the following properties: the left subtree of a node contains only nodes with keys lesser than the node's key, the right subtree only nodes with keys greater.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("Trie", "A tree-like data structure used for efficient retrieval of a key in a large dataset of strings.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("Heap Sort", "A comparison-based sorting technique based on a binary heap data structure.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("Selection Sort", "A simple sorting algorithm that divides the input list into two parts: the sublist of items already sorted, and the sublist of items remaining to be sorted.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("Insertion Sort", "A simple sorting algorithm that builds the final sorted array one item at a time.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("Counting Sort", "An integer sorting algorithm that operates by counting the number of objects that possess distinct key values.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("Radix Sort", "A non-comparative integer sorting algorithm that sorts data with integer keys by grouping keys by the individual digits.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("Topological Sort", "A linear ordering of vertices of a directed acyclic graph.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("DFS", "Depth-First Search, an algorithm for traversing or searching tree or graph data structures.", "Data Structures and Algorithms"));
        addFlashcard(new Flashcard("BFS", "Breadth-First Search, an algorithm for searching a tree or graph data structures.", "Data Structures and Algorithms"));

        // Initializes performance tracking for students with practice quiz attempts
        User u1 = findUserByUsername("student01");
        if (u1 instanceof Student) {
            Student s = (Student) u1;
            s.recordResult("Object-Oriented Programming", true);
            s.recordResult("Object-Oriented Programming", false);
            s.recordResult("Data Structures and Algorithms", false);
            s.recordResult("Data Structures and Algorithms", false);
            s.recordResult("Computer Science Fundamentals", true);
        }
    }

    // Adders and finders
    public void addFlashcard(Flashcard f) {
        if (flashcardCount < flashcards.length) {
            flashcards[flashcardCount++] = f;
        } else {
            JOptionPane.showMessageDialog(null, "Flashcard storage full.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void addUser(User u) {
        if (userCount < users.length) {
            users[userCount++] = u;
        } else {
            JOptionPane.showMessageDialog(null, "User storage full.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private User findUserByUsername(String username) {
        System.out.println("DEBUG: Looking for username: '" + username + "'");
        System.out.println("DEBUG: Total users in system: " + userCount);
        for (int i = 0; i < userCount; i++) {
            System.out.println("DEBUG: User " + i + " - Username: '" + users[i].getUsername() + "', Role: " + users[i].getRoleName());
            if (users[i].getUsername().equals(username)) {
                System.out.println("DEBUG: Found matching user!");
                return users[i];
            }
        }
        System.out.println("DEBUG: No matching user found");
        return null;
    }

    // Flashcard review mode
    private void flashcardsMode() {
        // Get filtered flashcards based on selected course
        Flashcard[] filteredCards = getFilteredFlashcards();
        int filteredCount = filteredCards.length;
        
        if (filteredCount == 0) {
            String message = selectedCourse == null ? 
                "No flashcards available." : 
                "No flashcards available for the selected course: " + selectedCourse + "\n\nPlease select a different course or add flashcards for this topic.";
            JOptionPane.showMessageDialog(null, message, "Flashcards", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int pageSize = 3;
        int page = 0;
        boolean running = true;

        while (running) {
            int start = page * pageSize;
            if (start >= filteredCount) start = 0; // wrap
            int end = Math.min(start + pageSize, filteredCount);
            int totalPages = (filteredCount + pageSize - 1) / pageSize;
            
            // Load flashcards image
            ImageIcon flashcardsIcon = createResizedIcon("images/flashcards.png", 300, 200);
            
            StringBuilder sb = new StringBuilder();
            sb.append("FLASHCARDS MODE - REVIEW\n\n");
            if (selectedCourse != null) {
                sb.append("Selected Course: ").append(selectedCourse).append("\n");
            }
            sb.append("Showing ").append(end - start).append(" Flashcards (Page ").append(page + 1).append(" of ").append(totalPages).append("):\n\n");
            
            for (int i = start; i < end; i++) {
                Flashcard f = filteredCards[i];
                sb.append("[").append(i - start + 1).append("] Term: ").append(f.getTerm()).append("\n");
                sb.append("Definition: ").append(f.getDefinition()).append("\n");
                sb.append("Topic: ").append(f.getTopic()).append("\n\n");
            }
            
            sb.append("Options:\n");
            sb.append("1. Next Page\n");
            sb.append("2. Shuffle Flashcards\n");
            sb.append("3. Back Page\n");
            sb.append("4. Clear Course Filter\n");
            sb.append("5. Return to Main Menu");
            
            String choice = showCustomInputDialogLeftAligned(sb.toString(), "Flashcards Mode", flashcardsIcon);
            
            if (choice == null) {
                running = false;
            } else {
                choice = choice.trim();
                switch (choice) {
                    case "1": page = (page + 1) % totalPages; break;
                    case "2":
                        shuffleFilteredFlashcards(filteredCards);
                        JOptionPane.showMessageDialog(null, "Flashcards shuffled.", "Flashcards", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case "3": page = (page - 1 + totalPages) % totalPages; break;
                    case "4":
                        selectedCourse = null;
                        JOptionPane.showMessageDialog(null, "Course filter cleared. All flashcards will now be shown.", "Filter Cleared", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    case "5": running = false; break;
                    default: JOptionPane.showMessageDialog(null, "Invalid choice.", "Error", JOptionPane.ERROR_MESSAGE); break;
                }
            }
        }
    }
    
    // Method to get flashcards filtered by selected course
    private Flashcard[] getFilteredFlashcards() {
        if (selectedCourse == null) {
            // No filter, return all flashcards
            Flashcard[] result = new Flashcard[flashcardCount];
            for (int i = 0; i < flashcardCount; i++) {
                result[i] = flashcards[i];
            }
            return result;
        } else {
            // Filter by selected course
            Flashcard[] temp = new Flashcard[flashcardCount];
            int count = 0;
            for (int i = 0; i < flashcardCount; i++) {
                if (flashcards[i].getTopic().equalsIgnoreCase(selectedCourse)) {
                    temp[count++] = flashcards[i];
                }
            }
            // Create array with exact size
            Flashcard[] result = new Flashcard[count];
            for (int i = 0; i < count; i++) {
                result[i] = temp[i];
            }
            return result;
        }
    }
    
    // Method to shuffle filtered flashcards
    private void shuffleFilteredFlashcards(Flashcard[] cards) {
        for (int i = 0; i < cards.length; i++) {
            int j = (int) (Math.random() * cards.length);
            Flashcard tmp = cards[i];
            cards[i] = cards[j];
            cards[j] = tmp;
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

    // Quiz generation
    // difficulty: 1=Easy (Multiple choice w/ hints)
    // Difficulty 2: Medium (multiple choice no hints)
    // Difficulty 3: Hard (Identification)
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
            for (int i = 0; i < flashcardCount; i++) pool[poolCount++] = flashcards[i];
        }
        // Build questions by sampling from pool
        for (int i = 0; i < n; i++) {
            Flashcard source = pool[i % poolCount];
            if (difficulty == 3) {
                // Identification
                IdentificationQuestion iq = new IdentificationQuestion(source, difficulty, source.getTerm());
                questions[i] = iq;
            } else {
                // Multiple choice - build 3 options (1 correct + up to 2 wrong choices)
                String[] options = new String[3];
                options[0] = source.getDefinition();
                // pick wrong choices
                int d = 1;
                for (int k = 0; k < poolCount && d < 3; k++) {
                    Flashcard cand = pool[(i + k + 1) % poolCount];
                    if (!cand.getDefinition().equals(options[0])) {
                        options[d++] = cand.getDefinition();
                    }
                }
                // if not enough wrong choices, fill placeholders
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

    // Recommendations
    private void recommendLessons(Student s) {
        String[] weak = s.getWeakTopics(40.0);
        StringBuilder sb = new StringBuilder();
        sb.append("Recommended Lessons (based on weak topics):\n\n");
        
        if (weak.length == 0) {
            sb.append("Great job! No weak topics detected.");
        } else {
            for (String t : weak) {
                sb.append("- ").append(t).append("\n");
            }
        }
        
        ImageIcon recommendationsIcon = createResizedIcon("images/recommendations.png", 300, 200);
        showCustomMessageDialog(sb.toString(), "Recommendations", JOptionPane.PLAIN_MESSAGE, recommendationsIcon);
    }

    // Helper methods for custom dialogs with images
    private ImageIcon createResizedIcon(String imagePath, int maxWidth, int maxHeight) {
        try {
            // Try to load as resource first (for when running from JAR or classes directory)
            java.net.URL imageURL = getClass().getClassLoader().getResource(imagePath);
            ImageIcon originalIcon;
            
            if (imageURL != null) {
                originalIcon = new ImageIcon(imageURL);
            } else {
                // Fallback to file path (for direct file access)
                originalIcon = new ImageIcon(imagePath);
            }
            
            java.awt.Image img = originalIcon.getImage();
            
            // Check if image was loaded successfully
            if (img.getWidth(null) <= 0 || img.getHeight(null) <= 0) {
                System.err.println("Failed to load image: " + imagePath);
                return null;
            }
            
            // Calculate scaling to maintain aspect ratio
            int originalWidth = img.getWidth(null);
            int originalHeight = img.getHeight(null);
            
            double scaleX = (double) maxWidth / originalWidth;
            double scaleY = (double) maxHeight / originalHeight;
            double scale = Math.min(scaleX, scaleY);
            
            int newWidth = (int) (originalWidth * scale);
            int newHeight = (int) (originalHeight * scale);
            
            java.awt.Image scaledImg = img.getScaledInstance(newWidth, newHeight, java.awt.Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImg);
        } catch (Exception e) {
            System.err.println("Error loading image: " + imagePath);
            e.printStackTrace();
            return null;
        }
    }
    
    private String showCustomInputDialog(String message, String title, ImageIcon icon) {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        
        if (icon != null) {
            JLabel imageLabel = new JLabel(icon);
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            panel.add(imageLabel, BorderLayout.NORTH);
        }
        
        JLabel messageLabel = new JLabel("<html><div style='text-align: center;'>" + message.replace("\n", "<br>") + "</div></html>");
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(messageLabel, BorderLayout.CENTER);
        
        return JOptionPane.showInputDialog(null, panel, title, JOptionPane.PLAIN_MESSAGE);
    }
    
    private String showCustomInputDialogLeftAligned(String message, String title, ImageIcon icon) {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        
        if (icon != null) {
            JLabel imageLabel = new JLabel(icon);
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            panel.add(imageLabel, BorderLayout.NORTH);
        }
        
        JLabel messageLabel = new JLabel("<html><div style='text-align: left;'>" + message.replace("\n", "<br>") + "</div></html>");
        messageLabel.setHorizontalAlignment(JLabel.LEFT);
        panel.add(messageLabel, BorderLayout.CENTER);
        
        return JOptionPane.showInputDialog(null, panel, title, JOptionPane.PLAIN_MESSAGE);
    }
    
    private void showCustomMessageDialog(String message, String title, int messageType, ImageIcon icon) {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        
        if (icon != null) {
            JLabel imageLabel = new JLabel(icon);
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            panel.add(imageLabel, BorderLayout.NORTH);
        }
        
        JLabel messageLabel = new JLabel("<html><div style='text-align: center;'>" + message.replace("\n", "<br>") + "</div></html>");
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(messageLabel, BorderLayout.CENTER);
        
        JOptionPane.showMessageDialog(null, panel, title, JOptionPane.PLAIN_MESSAGE);
    }

    // Main run / login / dashboards
    public void run() {
        // Prepare login / invalid icons
        ImageIcon loginIcon = createResizedIcon("images/main.png", 300, 200);
        ImageIcon logoutIcon = createResizedIcon("images/logout.png", 300, 200);
        ImageIcon invalidIcon = createResizedIcon("images/invalid-login.png", 300, 200);
        ImageIcon successIcon = createResizedIcon("images/login-successful.png", 300, 200);

        User u = null;

        // Loop until successful login or user cancels
        while (true) {
            String username = showCustomInputDialog("Enter Username:", "Login", loginIcon);
            if (username == null) {
                // user cancelled
                return;
            }

            String password = showCustomInputDialog("Enter Password:", "Login", loginIcon);
            if (password == null) {
                // user cancelled
                return;
            }

            // Lookup user and verify credentials
            User candidate = findUserByUsername(username.trim());
            if (candidate != null && candidate.login(username.trim(), password.trim())) {
                u = candidate;
                // show successful login message and break out
                showCustomMessageDialog(
                    "Login successful!\nWelcome, " + u.getName() + " (" + u.getRoleName() + ").",
                    "Welcome", JOptionPane.PLAIN_MESSAGE, successIcon
                );
                break;
            } else {
                // invalid credentials show message and let them try again
                showCustomMessageDialog(
                    "Invalid username or password. Please try again.",
                    "Login Failed", JOptionPane.PLAIN_MESSAGE, invalidIcon
                );
            }
        }

        // After successful login, direct user to the correct dashboard
        if (u instanceof Student) {
            studentDashboard((Student) u);
        } else if (u instanceof Tutor) {
            tutorDashboard((Tutor) u);
        } else if (u instanceof Admin) {
            adminDashboard((Admin) u);
        }

        // When they log out, show goodbye message or exit gracefully
        showCustomMessageDialog("You have been logged out.\nGoodbye!", "Logout", JOptionPane.PLAIN_MESSAGE, logoutIcon);
    }

    // Student dashboard
    private void studentDashboard(Student s) {
        boolean running = true;
        while (running) {
            ImageIcon dashboardIcon = createResizedIcon("images/student-dashboard.png", 300, 200);

            StringBuilder sb = new StringBuilder();
            sb.append("STUDENT DASHBOARD\n\n");
            if (selectedCourse != null) {
                sb.append("Current Course: ").append(selectedCourse).append("\n\n");
            } else {
                sb.append("No course selected (showing all flashcards)\n\n");
            }
            sb.append("1. Course Selection\n");
            sb.append("2. Flashcards Mode (Review)\n");
            sb.append("3. Practice Quiz Mode\n");
            sb.append("4. View Recommendations\n");
            sb.append("5. Logout");

            String choice = showCustomInputDialog(sb.toString(), "Student Dashboard", dashboardIcon);
            if (choice == null) {
                // user cancelled -> exit dashboard
                running = false;
                break;
            }

            switch (choice.trim()) {
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
                case "5":
                    running = false; // logout
                    break;
                default:
                    ImageIcon invalidIcon = createResizedIcon("images/invalid-choice.png", 300, 200);
                    showCustomMessageDialog("Invalid choice. Please try again.", "Error", JOptionPane.PLAIN_MESSAGE, invalidIcon);
                    break;
            }
        }
    }

    private void courseSelection() {
        // Load course selection image
        ImageIcon courseSelectionIcon = createResizedIcon("images/course-selection.png", 300, 200);
        
        StringBuilder sb = new StringBuilder();
        sb.append("COURSE SELECTION\n\n");
        sb.append("Available Courses:\n");
        for (int i = 0; i < AVAILABLE_COURSES.length; i++) {
            sb.append((i + 1)).append(". ").append(AVAILABLE_COURSES[i]).append("\n");
        }
        sb.append("\nEnter the number of the course you want to study:");
        
        String selection = showCustomInputDialog(sb.toString(), "Course Selection", courseSelectionIcon);
        
        if (selection != null) {
            try {
                int idx = Integer.parseInt(selection.trim()) - 1;
                if (idx >= 0 && idx < AVAILABLE_COURSES.length) {
                    selectedCourse = AVAILABLE_COURSES[idx];
                    
                    // Show appropriate course selected image
                    ImageIcon selectedIcon = null;
                    switch (idx) {
                        case 0: 
                            selectedIcon = createResizedIcon("images/course-selected-computersciencefundamentals.png", 300, 200);
                            break;
                        case 1: 
                            selectedIcon = createResizedIcon("images/course-selected-cybersecurity.png", 300, 200);
                            break;
                        case 2:
                            selectedIcon = createResizedIcon("images/course-selected-oop.png", 300, 200);
                            break;
                        case 3:
                            selectedIcon = createResizedIcon("images/course-selected-dsal.png", 300, 200);
                            break;
                    }
                    
                    showCustomMessageDialog("You have selected: " + AVAILABLE_COURSES[idx] + "\n\nFlashcards will now be filtered to this course.", "Course Selected", JOptionPane.PLAIN_MESSAGE, selectedIcon);
                } else {
                    ImageIcon invalidIcon = createResizedIcon("images/invalid-choice.png", 300, 200);
                    showCustomMessageDialog("Invalid selection.", "Error", JOptionPane.PLAIN_MESSAGE, invalidIcon);
                }
            } catch (NumberFormatException e) {
                ImageIcon invalidIcon = createResizedIcon("images/invalid-choice.png", 300, 200);
                showCustomMessageDialog("Invalid input.", "Error", JOptionPane.PLAIN_MESSAGE, invalidIcon);
            }
        }
    }

    // Practice quiz mode menu for students
    private void practiceQuizMode(Student s) {
        // Load practice quiz image
        ImageIcon practiceQuizIcon = createResizedIcon("images/practice-quiz.png", 300, 200);
        
        StringBuilder sb = new StringBuilder();
        sb.append("PRACTICE QUIZ MODE\n\n");
        sb.append("Select Difficulty Level:\n");
        sb.append("1. Easy (Multiple Choice with Hints)\n");
        sb.append("2. Medium (Multiple Choice without Hints)\n");
        sb.append("3. Hard (Identification with Progressive Hints)");
        
        String choice = showCustomInputDialog(sb.toString(), "Practice Quiz Mode", practiceQuizIcon);
        if (choice == null) return; // User cancelled
        
        int diff = 1;
        if (choice.equals("1")) diff = 1;
        else if (choice.equals("2")) diff = 2;
        else if (choice.equals("3")) diff = 3;
        else {
            ImageIcon invalidIcon = createResizedIcon("images/invalid-choice.png", 300, 200);
            showCustomMessageDialog("Invalid choice. Defaulting to Easy.", "Warning", JOptionPane.PLAIN_MESSAGE, invalidIcon);
        }
        
        sb = new StringBuilder();
        sb.append("Available Topics:\n");
        for (int i = 0; i < TOPICS.length; i++) {
            sb.append((i + 1)).append(". ").append(TOPICS[i]).append("\n");
        }
        sb.append("\nEnter the number of the topic:");
        
        String topicChoice = showCustomInputDialog(sb.toString(), "Topic Selection", practiceQuizIcon);
        if (topicChoice == null) return; // User cancelled
        
        int tidx = 0;
        try {
            tidx = Integer.parseInt(topicChoice.trim()) - 1;
            if (tidx < 0 || tidx >= TOPICS.length) tidx = 0;
        } catch (NumberFormatException e) {
            tidx = 0;
        }
        String topic = TOPICS[tidx];
        
        String numQuestionsStr = showCustomInputDialog("Enter number of questions (e.g., 3):", "Number of Questions", practiceQuizIcon);
        if (numQuestionsStr == null) return; // User cancelled
        
        int n = 3;
        try {
            n = Integer.parseInt(numQuestionsStr.trim());
            if (n <= 0) n = 3;
        } catch (Exception e) { n = 3; }
        
        showCustomMessageDialog("Starting Quiz... Good luck!", "Quiz Starting", JOptionPane.PLAIN_MESSAGE, practiceQuizIcon);
        Quiz quiz = generateQuiz(topic, n, diff);
        quiz.administer(s);
    }

    // Tutor dashboard
    private void tutorDashboard(Tutor t) {
        boolean running = true;
        while (running) {
            ImageIcon tutorIcon = createResizedIcon("images/tutor-dashboard.png", 300, 200);

            StringBuilder sb = new StringBuilder();
            sb.append("TUTOR DASHBOARD\n\nWelcome, ").append(t.getName()).append(" (Tutor)\n\n");
            sb.append("Options:\n");
            sb.append("1. Create Flashcard\n");
            sb.append("2. Edit Flashcard\n");
            sb.append("3. Delete Flashcard\n");
            sb.append("4. Review Flashcards\n");
            sb.append("5. Logout");

            String choice = showCustomInputDialog(sb.toString(), "Tutor Dashboard", tutorIcon);
            if (choice == null) {
                running = false;
                break;
            }

            switch (choice.trim()) {
                case "1":
                    addFlashcard(null);
                    break;
                case "2":
                    editFlashcard();
                    break;
                case "3":
                    deleteFlashcard();
                    break;
                case "4":
                    flashcardsMode(); // review mode
                    break;
                case "5":
                    running = false;
                    break;
                default:
                    ImageIcon invalidIcon = createResizedIcon("images/invalid-choice.png", 300, 200);
                    showCustomMessageDialog("Invalid choice. Please try again.", "Error", JOptionPane.PLAIN_MESSAGE, invalidIcon);
                    break;
            }
        }
    }
    
    // Allows the tutor to edit the contents of the flashcards
    private void editFlashcard() {
        if (flashcardCount == 0) { 
            JOptionPane.showMessageDialog(null, "No flashcards to edit.", "Error", JOptionPane.ERROR_MESSAGE); 
            return; 
        }
        
        int pageSize = 10;
        int page = 0;
        int totalPages = (flashcardCount + pageSize - 1) / pageSize;
        boolean selecting = true;
        
        while (selecting) {
            int start = page * pageSize;
            int end = Math.min(start + pageSize, flashcardCount);
            
            // Asks the Tutor which flashcard to edit
            StringBuilder sb = new StringBuilder();
            sb.append("Edit which flashcard? (Page ").append(page + 1).append(" of ").append(totalPages).append(")\n\n");
            
            for (int i = start; i < end; i++) {
                sb.append((i + 1)).append(". ").append(flashcards[i].getTerm()).append(" (").append(flashcards[i].getTopic()).append(")\n");
            }
            
            sb.append("\nEnter flashcard number to edit, 'N' for next page, 'P' for previous page, or 'C' to cancel:");
            
            String choice = JOptionPane.showInputDialog(null, sb.toString(), "Edit Flashcard", JOptionPane.QUESTION_MESSAGE);
            if (choice == null || choice.trim().equalsIgnoreCase("C")) return;
            
            choice = choice.trim();
            
            if (choice.equalsIgnoreCase("N")) {
                page = (page + 1) % totalPages;
                continue;
            } else if (choice.equalsIgnoreCase("P")) {
                page = (page - 1 + totalPages) % totalPages;
                continue;
            }
            
            try {
                int idx = Integer.parseInt(choice) - 1;
                if (idx < 0 || idx >= flashcardCount) { 
                    JOptionPane.showMessageDialog(null, "Invalid index.", "Error", JOptionPane.ERROR_MESSAGE); 
                    continue;
                }
                
                // Term name change
                String term = JOptionPane.showInputDialog(null, "Enter new Term (leave blank to keep current: \"" + flashcards[idx].getTerm() + "\"):", "Edit Flashcard", JOptionPane.QUESTION_MESSAGE);
                if (term == null) return;
                
                // Definition change
                String def = JOptionPane.showInputDialog(null, "Enter new Definition (leave blank to keep current):", "Edit Flashcard", JOptionPane.QUESTION_MESSAGE);
                if (def == null) return;
                
                // Topic change
                String topic = JOptionPane.showInputDialog(null, "Enter new Topic (leave blank to keep current: \"" + flashcards[idx].getTopic() + "\"):", "Edit Flashcard", JOptionPane.QUESTION_MESSAGE);
                if (topic == null) return;
                
                if (!term.trim().equals("")) flashcards[idx].setTerm(term.trim());
                if (!def.trim().equals("")) flashcards[idx].setDefinition(def.trim());
                if (!topic.trim().equals("")) flashcards[idx].setTopic(topic.trim());
                JOptionPane.showMessageDialog(null, "Flashcard updated.", "Success", JOptionPane.INFORMATION_MESSAGE);
                selecting = false;
            } catch (Exception e) { 
                JOptionPane.showMessageDialog(null, "Invalid input.", "Error", JOptionPane.ERROR_MESSAGE); 
            }
        }
    }

    // Allows the user to delete a flashcard
    private void deleteFlashcard() {
        if (flashcardCount == 0) { 
            JOptionPane.showMessageDialog(null, "No flashcards to delete.", "Error", JOptionPane.ERROR_MESSAGE); 
            return; 
        }

        int pageSize = 10;
        int page = 0;
        int totalPages = (flashcardCount + pageSize - 1) / pageSize;
        boolean selecting = true;

        while (selecting) {
            int start = page * pageSize;
            int end = Math.min(start + pageSize, flashcardCount);

            StringBuilder sb = new StringBuilder();
            sb.append("Delete which flashcard? (Page ").append(page + 1).append(" of ").append(totalPages).append(")\n\n");

            for (int i = start; i < end; i++) {
                sb.append((i + 1)).append(". ")
                  .append(flashcards[i].getTerm())
                  .append(" (").append(flashcards[i].getTopic()).append(")\n");
            }

             // Asks the user to choose which flashcard to delete
            sb.append("\nEnter flashcard number to delete, 'N' for next page, 'P' for previous page, or 'C' to cancel:");

            String choice = JOptionPane.showInputDialog(null, sb.toString(), "Delete Flashcard", JOptionPane.QUESTION_MESSAGE);
            if (choice == null || choice.trim().equalsIgnoreCase("C")) return;

            choice = choice.trim();

            if (choice.equalsIgnoreCase("N")) {
                page = (page + 1) % totalPages;
                continue;
            } else if (choice.equalsIgnoreCase("P")) {
                page = (page - 1 + totalPages) % totalPages;
                continue;
            }

            try {
                int idx = Integer.parseInt(choice) - 1;
                if (idx < 0 || idx >= flashcardCount) { 
                    JOptionPane.showMessageDialog(null, "Invalid index.", "Error", JOptionPane.ERROR_MESSAGE); 
                    continue; 
                }

                int confirm = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to delete this flashcard?\n\n" +
                    "Term: " + flashcards[idx].getTerm() +
                    "\nTopic: " + flashcards[idx].getTopic(),
                    "Confirm Delete",
                    JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    // Shift left
                    for (int i = idx; i < flashcardCount - 1; i++) flashcards[i] = flashcards[i + 1];
                    flashcards[--flashcardCount] = null;
                    JOptionPane.showMessageDialog(null, "Flashcard deleted.", "Success", JOptionPane.INFORMATION_MESSAGE);
                }

                selecting = false;
            } catch (NumberFormatException e) { 
                JOptionPane.showMessageDialog(null, "Invalid input.", "Error", JOptionPane.ERROR_MESSAGE); 
            }
        }
    }

    // Admin dashboard
    private void adminDashboard(Admin a) {
        boolean run = true;
        while (run) {
            // Load admin dashboard image
            ImageIcon adminDashboardIcon = createResizedIcon("images/admin-dashboard.png", 300, 200);
            
            StringBuilder sb = new StringBuilder();
            sb.append("ADMIN DASHBOARD\n\n");
            sb.append("Options:\n");
            sb.append("1. Backup Data\n");
            sb.append("2. View Users\n");
            sb.append("3. Logout");
            
            String choice = showCustomInputDialog(sb.toString(), "Admin Dashboard", adminDashboardIcon);
            
            if (choice == null) {
                run = false;
            } else {
                choice = choice.trim();
                switch (choice) {
                    case "1":
                        a.backupData();
                        break;
                    case "2":
                        StringBuilder userList = new StringBuilder();
                        userList.append("Users:\n\n");
                        for (int i = 0; i < userCount; i++) {
                            userList.append("- ").append(users[i].getName()).append(" (").append(users[i].getRoleName()).append(")\n");
                        }
                        JOptionPane.showMessageDialog(null, userList.toString(), "Users List", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case "3": run = false; break;
                    default: JOptionPane.showMessageDialog(null, "Invalid choice.", "Error", JOptionPane.ERROR_MESSAGE); break;
                }
            }
        }
    }
}