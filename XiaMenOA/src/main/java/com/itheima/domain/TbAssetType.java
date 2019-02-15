package com.itheima.domain;

import java.util.Date;

public class TbAssetType {
    private Integer typeId;

    private String typeName;

    private Integer parentId;

    private Integer usableFlag;

    private Date lastUpdateTime;

    @Override
    public String toString() {
        return "TbAssetType{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", parentId=" + parentId +
                ", usableFlag=" + usableFlag +
                ", lastUpdateTime=" + lastUpdateTime +
                '}';
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getUsableFlag() {
        return usableFlag;
    }

    public void setUsableFlag(Integer usableFlag) {
        this.usableFlag = usableFlag;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}