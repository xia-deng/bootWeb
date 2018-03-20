package com.lindeng.system.dto;

import com.lindeng.enums.UserStatusEnum;

import javax.persistence.*;

@Entity
@Table(name = "t_sys_user")
public class User {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "password",nullable = false)
    private String passWord;

    @Column(name = "salt", nullable = false)
    private String salt;

    @Column(name = "username", nullable = false,unique = true)
    private String userName;

    @Column(name = "deptId",nullable = false)
    private long departmentId;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private UserStatusEnum status;

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

    public UserStatusEnum getStatus() {
        return status;
    }

    public void setStatus(UserStatusEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", passWord='" + passWord + '\'' +
                ", salt='" + salt + '\'' +
                ", userName='" + userName + '\'' +
                ", departmentId=" + departmentId +
                ", status=" + status +
                '}';
    }
}
