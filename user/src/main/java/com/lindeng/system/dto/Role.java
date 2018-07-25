package com.lindeng.system.dto;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * 系统角色类，用来描述用户和部门的权限集合
 */
@Entity
@Table(name = "t_sys_role")
public class Role {

    @Id
    @GenericGenerator(name = "systemUUID", strategy = "uuid")
    @GeneratedValue(generator = "systemUUID")
    private String id;

    @Column(name = "roleName",nullable = false,length = 32,unique = true)
    private String roleName;

    @Column(name="description",nullable = true,length = 128)
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "t_sys_role_source", joinColumns = {@JoinColumn(name ="roleId" )}, inverseJoinColumns = { @JoinColumn(name = "sourceId")})
    private Set<Source> sources;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Source> getSources() {
        return sources;
    }

    public void setSources(Set<Source> sources) {
        this.sources = sources;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
