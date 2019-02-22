package com.itheima.utils;

import java.util.Date;

public class AssetSearch {
    private String assetCode;
    private String assetName;
    private String useDepartment;
    private String usePerson;
    private String typeName;
    private Date startDate;
    private Date endDate;

    @Override
    public String toString() {
        return "AssetSearch{" +
                "assetCode='" + assetCode + '\'' +
                ", assetName='" + assetName + '\'' +
                ", useDepartment='" + useDepartment + '\'' +
                ", usePerson='" + usePerson + '\'' +
                ", typeName='" + typeName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", modelNum='" + modelNum + '\'' +
                ", useStatus=" + useStatus +
                ", searchFlag=" + searchFlag +
                '}';
    }

    private String modelNum;
    private Integer useStatus;
    //搜索标记,页面搜索分页展示时区分的标志,等于1的时候表示具有搜索条件
    private Integer searchFlag=-1;

    public Integer getSearchFlag() {
        return searchFlag;
    }

    public void setSearchFlag(Integer searchFlag) {
        this.searchFlag = searchFlag;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getUseDepartment() {
        return useDepartment;
    }

    public void setUseDepartment(String useDepartment) {
        this.useDepartment = useDepartment;
    }

    public String getUsePerson() {
        return usePerson;
    }

    public void setUsePerson(String usePerson) {
        this.usePerson = usePerson;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getModelNum() {
        return modelNum;
    }

    public void setModelNum(String modelNum) {
        this.modelNum = modelNum;
    }

    public Integer getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(Integer useStatus) {
        this.useStatus = useStatus;
    }
}
