package com.incubationplatform.entity;

import java.io.Serializable;

/**
 * Created by GMUK on 2018/10/19 0019.
 */
public class Role implements Serializable{
    private String roleId;
    private String role;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
