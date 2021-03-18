package com.example.XamineRIS_RE_JAVA;

public class User {
    String username, password;
    int groupId;

    public User(String username, String password, int groupId) {
        this.groupId = groupId;
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}
