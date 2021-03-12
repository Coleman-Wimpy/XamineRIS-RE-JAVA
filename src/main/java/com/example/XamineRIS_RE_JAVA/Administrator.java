package com.example.XamineRIS_RE_JAVA;

// Administrator class that has a constructor and setter and getters for a Administrator object
public class Administrator {
    String username, password;

    // constructor for admin object
    public Administrator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // getters and setters for all params
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
