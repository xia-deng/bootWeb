package com.lindeng.system.dto;

import com.lindeng.common.util.DataUtil;
import com.lindeng.enums.StatusEnum;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "t_sys_user")
public class User {
    @Id
    @GenericGenerator(name = "systemUUID", strategy = "uuid")
    @GeneratedValue(generator = "systemUUID")
    private String id;

    @Column(name = "password", nullable = false, length = 128)
    private String passWord;

    @Column(name = "salt", nullable = false)
    private String salt;

    @Column(name = "username", nullable = false, unique = true)
    private String userName;

    @ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "deptId")
    private Department department;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private StatusEnum status;

    @Column(name = "createTime", nullable = false)
    private Long createTime;

    @Column(name = "updateTime", nullable = false)
    private Long updateTime = DataUtil.getNowSecond();

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", passWord='" + passWord + '\'' +
                ", salt='" + salt + '\'' +
                ", userName='" + userName + '\'' +
                ", department=" + department +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
