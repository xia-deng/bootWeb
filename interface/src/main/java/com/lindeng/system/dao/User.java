package com.lindeng.system.dao;


public class User {
    private long id;
    private String passWord;
    private String salt;
    private String userName;
    private long departmentId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", passWord='" + passWord + '\'' +
                ", salt='" + salt + '\'' +
                ", userName='" + userName + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}
