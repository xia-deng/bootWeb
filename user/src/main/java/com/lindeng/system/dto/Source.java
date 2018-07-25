package com.lindeng.system.dto;

import com.lindeng.common.util.DataUtil;
import com.lindeng.enums.SourceTypeEnum;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * 系统资源，用来描述权限
 */
@Table(name = "t_sys_source")
@Entity
public class Source {

    @Id
    @GenericGenerator(name = "systemUUID", strategy = "uuid")
    @GeneratedValue(generator = "systemUUID")
    private String id;

    @Column(name = "sourceName", nullable = false, unique = true)
    private String sourceName;

    @Column(name = "sourceUrl", nullable = false, unique = true)
    private String sourceUrl;

    @Column(name="description",nullable = true,length = 128)
    private String description;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "sourceType", nullable = false)
    private SourceTypeEnum sourceType;

    @Column(name = "createTime", nullable = false)
    private Long createTime;

    @Column(name = "updateTime", nullable = false)
    private Long updateTime = DataUtil.getNowSecond();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId")
    private Source parentSource;

    @OneToMany(targetEntity = Source.class, cascade = CascadeType.ALL, mappedBy = "parentSource")
    @Fetch(FetchMode.SUBSELECT)
    private Set<Source> childSource;

    public Source(){}
    public Source(String sourceName, String sourceUrl, String description, SourceTypeEnum sourceType, Long createTime) {
        this.sourceName = sourceName;
        this.sourceUrl = sourceUrl;
        this.description = description;
        this.sourceType = sourceType;
        this.createTime = createTime;
    }

    public Source(String sourceName, String sourceUrl, String description, SourceTypeEnum sourceType, Long createTime, Source parentSource) {
        this.sourceName = sourceName;
        this.sourceUrl = sourceUrl;
        this.description = description;
        this.sourceType = sourceType;
        this.createTime = createTime;
        this.parentSource = parentSource;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public SourceTypeEnum getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceTypeEnum sourceType) {
        this.sourceType = sourceType;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Source getParentSource() {
        return parentSource;
    }

    public void setParentSource(Source parentSource) {
        this.parentSource = parentSource;
    }

    public Set<Source> getChildSource() {
        return childSource;
    }

    public void setChildSource(Set<Source> childSource) {
        this.childSource = childSource;
    }

    @Override
    public String toString() {
        return "Source{" +
                "id='" + id + '\'' +
                ", sourceName='" + sourceName + '\'' +
                ", sourceUrl='" + sourceUrl + '\'' +
                ", description='" + description + '\'' +
                ", sourceType=" + sourceType +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
