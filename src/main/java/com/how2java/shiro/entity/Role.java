package com.how2java.shiro.entity;

import java.util.HashSet;
import java.util.Set;

//User存在：1、唯一ID	2、用户名	3、密码	4、拥有的Role
public class Role {
    private Integer rid;

    private String rname;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    private Set<Permission> permissions = new HashSet<>();

    private Set<User> users = new HashSet<>();
}
