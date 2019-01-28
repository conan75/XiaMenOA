package com.itheima.domain;

import java.io.Serializable;
import java.util.Date;

public class TbExceptionMsg implements Serializable{
    private Integer messageId;

    private Integer periodId;

    private String exceptionDesc;

    private String exceptionReason;

    private String resolveWay;

    private String relatePic;

    private Integer usableFlag;

    private String createPerson;

    private String updatePerson;

    private Date createTime;

    private Date lastUpdateTime;

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Integer periodId) {
        this.periodId = periodId;
    }

    public String getExceptionDesc() {
        return exceptionDesc;
    }

    public void setExceptionDesc(String exceptionDesc) {
        this.exceptionDesc = exceptionDesc == null ? null : exceptionDesc.trim();
    }

    public String getExceptionReason() {
        return exceptionReason;
    }

    public void setExceptionReason(String exceptionReason) {
        this.exceptionReason = exceptionReason == null ? null : exceptionReason.trim();
    }

    public String getResolveWay() {
        return resolveWay;
    }

    public void setResolveWay(String resolveWay) {
        this.resolveWay = resolveWay == null ? null : resolveWay.trim();
    }

    public String getRelatePic() {
        return relatePic;
    }

    public void setRelatePic(String relatePic) {
        this.relatePic = relatePic == null ? null : relatePic.trim();
    }

    public Integer getUsableFlag() {
        return usableFlag;
    }

    public void setUsableFlag(Integer usableFlag) {
        this.usableFlag = usableFlag;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson == null ? null : createPerson.trim();
    }

    public String getUpdatePerson() {
        return updatePerson;
    }

    @Override
    public String toString() {
        return "TbExceptionMsg{" +
                "messageId=" + messageId +
                ", periodId=" + periodId +
                ", exceptionDesc='" + exceptionDesc + '\'' +
                ", exceptionReason='" + exceptionReason + '\'' +
                ", resolveWay='" + resolveWay + '\'' +
                ", relatePic='" + relatePic + '\'' +
                ", usableFlag=" + usableFlag +
                ", createPerson='" + createPerson + '\'' +
                ", updatePerson='" + updatePerson + '\'' +
                ", createTime=" + createTime +
                ", lastUpdateTime=" + lastUpdateTime +
                '}';
    }

    public void setUpdatePerson(String updatePerson) {
        this.updatePerson = updatePerson == null ? null : updatePerson.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}