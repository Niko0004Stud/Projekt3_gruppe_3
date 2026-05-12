package org.projekt3_gruppe_3.model;

public class Admin extends SuperUser {

    public Admin(int id, String username, String password, String sysRole) {
        super(id, username, password, sysRole);
    }

    public Admin(String username, String password, String sysRole){
        super(username, password, sysRole);
    }


}
