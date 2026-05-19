package org.projekt3_gruppe_3.model;

public class User {
    private int id;
    private String username;
    private String password;
    private String sysRole;

    public User(int id, String username, String password, String sysRole) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sysRole = sysRole;
    }

    public User(String username, String password, String sysRole) {
        this.username = username;
        this.password = password;
        this.sysRole = sysRole;
    }

    public User(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getSysRole() {
        return sysRole;
    }

    public void setSysRole(String sysRole) {
        this.sysRole = sysRole;
    }
}
