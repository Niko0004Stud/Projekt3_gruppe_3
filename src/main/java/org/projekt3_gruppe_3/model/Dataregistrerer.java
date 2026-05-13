package org.projekt3_gruppe_3.model;

public class Dataregistrerer extends SuperUser {
    public Dataregistrerer(int id, String username, String password, String sysRole) {
        super(id, username, password, sysRole);
    }

    public Dataregistrerer(String username, String password, String sysRole) {
        super(username, password, sysRole);
    }

}
