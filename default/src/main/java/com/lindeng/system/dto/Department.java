package com.lindeng.system.dto;

import com.lindeng.enums.StatusEnum;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Table(name = "t_sys_department")
@Entity
public class Department {

    @Id
    @GenericGenerator(strategy = "uuid",name = "systemUUID")
    @GeneratedValue(generator = "systemUUID")
    private String id;

    @Column(name = "departName", nullable = false, length = 32, unique = true)
    private String deptName;

    @Column(name = "departNumber",nullable = false, length = 32, unique = true)
    private String deptNumber;

    @Column(name = "departDescription", nullable = true,length = 255)
    private String description;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status",nullable = false)
    private StatusEnum status;

    @OneToMany(cascade =CascadeType.ALL,mappedBy = "department",fetch = FetchType.LAZY)
    private List<User> users;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptNumber() {
        return deptNumber;
    }

    public void setDeptNumber(String deptNumber) {
        this.deptNumber = deptNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", deptName='" + deptName + '\'' +
                ", deptNumber='" + deptNumber + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", userSize=" + users.size() +
                '}';
    }
}
