package com.lindeng.system.dto;

import com.lindeng.common.util.DataUtil;
import com.lindeng.enums.StatusEnum;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Set;

@Table(name = "t_sys_department")
@Entity
public class Department {

    @Id
    @GenericGenerator(strategy = "uuid", name = "systemUUID")
    @GeneratedValue(generator = "systemUUID")
    private String id;

    @Column(name = "departName", nullable = false, length = 32, unique = true)
    private String deptName;

    @Column(name = "departNumber", nullable = false, length = 32, unique = true)
    private String deptNumber;

    @Column(name = "departDescription", nullable = true, length = 255)
    private String description;

    @Column(name = "departLevel", nullable = true, columnDefinition = "INT default 0")
    private int departLevel;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status", nullable = false)
    private StatusEnum status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department", fetch = FetchType.LAZY)
    private Set<User> users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId")
    private Department parentDepart;

    @OneToMany(targetEntity = Department.class, cascade = CascadeType.ALL, mappedBy = "parentDepart", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @OrderBy("departLevel")
    private Set<Department> childDeparts;

    @Column(name = "createTime", nullable = false)
    private Long createTime = DataUtil.getNowSecond();

    @Column(name = "updateTime", nullable = false)
    private Long updateTime = DataUtil.getNowSecond();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "t_sys_dept_role", joinColumns = {@JoinColumn(name ="deptId" )}, inverseJoinColumns = { @JoinColumn(name = "roleId") })
    private Set<Role> roles;

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public int getDepartLevel() {
        return departLevel;
    }

    public void setDepartLevel(int departLevel) {
        this.departLevel = departLevel;
    }

    public Department getParentDepart() {
        return parentDepart;
    }

    public void setParentDepart(Department parentDepart) {
        this.parentDepart = parentDepart;
    }

    public Set<Department> getChildDeparts() {
        return childDeparts;
    }

    public void setChildDeparts(Set<Department> childDeparts) {
        this.childDeparts = childDeparts;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", deptName='" + deptName + '\'' +
                ", deptNumber='" + deptNumber + '\'' +
                ", description='" + description + '\'' +
                ", departLevel=" + departLevel +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
