package com.itheima.domain;

import java.math.BigDecimal;
import java.util.Date;

public class TbAsset {
    private Integer id;

    private String assetCode;

    private String serialNum;

    private Integer typeId;

    private String typeName;

    @Override
    public String toString() {
        return "TbAsset{" +
                "id=" + id +
                ", assetCode='" + assetCode + '\'' +
                ", serialNum='" + serialNum + '\'' +
                ", typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", assetName='" + assetName + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", modelNum='" + modelNum + '\'' +
                ", purchaseNumber=" + purchaseNumber +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", totalMoney=" + totalMoney +
                ", useDepartment='" + useDepartment + '\'' +
                ", usePerson='" + usePerson + '\'' +
                ", useStatus=" + useStatus +
                ", depositPlace='" + depositPlace + '\'' +
                ", remarks='" + remarks + '\'' +
                ", usableFlag=" + usableFlag +
                ", lastUpdateTime=" + lastUpdateTime +
                '}';
    }

    private String assetName;

    private Date purchaseDate;

    private String modelNum;

    private Integer purchaseNumber;

    private String unit;

    private BigDecimal price;

    private BigDecimal totalMoney;

    private String useDepartment;

    private String usePerson;

    private Integer useStatus;

    private String depositPlace;

    private String remarks;

    private Integer usableFlag;

    private Date lastUpdateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode == null ? null : assetCode.trim();
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum == null ? null : serialNum.trim();
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

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName == null ? null : assetName.trim();
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getModelNum() {
        return modelNum;
    }

    public void setModelNum(String modelNum) {
        this.modelNum = modelNum == null ? null : modelNum.trim();
    }

    public Integer getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(Integer purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getUseDepartment() {
        return useDepartment;
    }

    public void setUseDepartment(String useDepartment) {
        this.useDepartment = useDepartment == null ? null : useDepartment.trim();
    }

    public String getUsePerson() {
        return usePerson;
    }

    public void setUsePerson(String usePerson) {
        this.usePerson = usePerson == null ? null : usePerson.trim();
    }

    public Integer getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(Integer useStatus) {
        this.useStatus = useStatus;
    }

    public String getDepositPlace() {
        return depositPlace;
    }

    public void setDepositPlace(String depositPlace) {
        this.depositPlace = depositPlace == null ? null : depositPlace.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
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