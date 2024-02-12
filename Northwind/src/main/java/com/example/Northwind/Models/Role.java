package com.example.Northwind.Models;

import java.util.Arrays;
import java.util.List;

public enum Role {
    CUSTOMER(Arrays.asList(Permission.READ_ALL_PRODUCTS)),
    ADMIN(Arrays.asList(Permission.SAVE_ONE_PRODUCTS, Permission.READ_ALL_PRODUCTS));

    private List<Permission> permissions;

    Role(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Role{" +
                "permissions=" + permissions +
                '}';
    }
}