package org.projekt3_gruppe_3.model;

public class Forretningsudvikler extends SuperUser{

    public Forretningsudvikler(int id, String username, String password, String sysRole) {
        super(id, username, password, sysRole);
    }

    public Forretningsudvikler(String username, String password, String sysRole) {
        super(username, password, sysRole);
    }
}
