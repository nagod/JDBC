package main.java.bdo;



public class User {

    private static User instance;
    private String username;
    private String password;

    private User() {}

    public static User getInstance() {
        if (instance == null)
            instance = new User();
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username){ this.username = username; }
    public void setPassword(String password){this.password = password; }

    public void setData(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
