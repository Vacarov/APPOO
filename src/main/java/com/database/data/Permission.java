package com.database.data;

/**
 * Created by wergin on 24-Mar-17.
 */
public class Permission {
    private int idPermission;
    private String name;

    public Permission(int idPermission, String name) {
        this.idPermission = idPermission;
        this.name = name;
    }

    public int getIdPermission() {
        return idPermission;
    }

    public void setIdPermission(int idPermission) {
        this.idPermission = idPermission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
