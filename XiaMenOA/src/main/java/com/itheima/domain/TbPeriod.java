package com.itheima.domain;

import java.util.Date;

public class TbPeriod {
    private Integer periodId;

    private String periodName;

    private String modifyPerson;

    private Integer usableFlag;

    private Date lastUpdateTime;

    public Integer getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Integer periodId) {
        this.periodId = periodId;
    }

    public String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName == null ? null : periodName.trim();
    }

    public String getModifyPerson() {
        return modifyPerson;
    }

    @Override
    public String toString() {
        return "TbPeriod{" +
                "periodId=" + periodId +
                ", periodName='" + periodName + '\'' +
                ", modifyPerson='" + modifyPerson + '\'' +
                ", usableFlag=" + usableFlag +
                ", lastUpdateTime=" + lastUpdateTime +
                '}';
    }

    public void setModifyPerson(String modifyPerson) {
        this.modifyPerson = modifyPerson == null ? null : modifyPerson.trim();
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