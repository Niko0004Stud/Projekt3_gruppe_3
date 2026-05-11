package org.projekt3_gruppe_3.model;

public class BilTech extends SuperUser{
    String sysRoleType;

    public BilTech(int id, String username, String password, String sysRole, String sysRoleType) {
        super(id, username, password, sysRole);
        this.sysRoleType = sysRoleType;
    }

    public BilTech(String username, String password, String sysRole, String sysRoleType) {
        super(username, password, sysRole);
        this.sysRoleType = sysRoleType;
    }
}
