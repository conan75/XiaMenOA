package com.itheima.utils;

import com.itheima.domain.TbExceptionMsg;
import com.itheima.domain.TbPeriod;

public class BugMsgs {
    private TbExceptionMsg exceptionMsg;
    private TbPeriod period;

    public TbExceptionMsg getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(TbExceptionMsg exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public TbPeriod getPeriod() {
        return period;
    }

    public void setPeriod(TbPeriod period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "BugMsgs{" +
                "exceptionMsg=" + exceptionMsg +
                ", period=" + period +
                '}';
    }
}
