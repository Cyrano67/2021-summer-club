package com.cestc.vspace.pojo;

import java.io.Serializable;

public class UserList implements Serializable{
    private Integer uid;

    private String uname;

    private String password;

    private String email;

    private String phone;

    private byte[] role;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public byte[] getRole() {
        return role;
    }

    public void setRole(byte[] role) {
        this.role = role;
    }
}