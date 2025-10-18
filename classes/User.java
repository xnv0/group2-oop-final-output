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

public class User {
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
        boolean usernameMatch = this.username.equals(username);
        boolean passwordMatch = this.password.equals(password);
        System.out.println("DEBUG LOGIN: Attempting login for username: '" + username + "'");
        System.out.println("DEBUG LOGIN: Expected username: '" + this.username + "', Match: " + usernameMatch);
        System.out.println("DEBUG LOGIN: Expected password: '" + this.password + "', Match: " + passwordMatch);
        System.out.println("DEBUG LOGIN: Login result: " + (usernameMatch && passwordMatch));
        return usernameMatch && passwordMatch;
    }
    public String getRoleName() { return "User"; }
}