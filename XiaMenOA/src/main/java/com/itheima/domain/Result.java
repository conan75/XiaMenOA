package com.itheima.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by geekhoon on 2019/1/16.
 */
public class Result implements Serializable {
    private Boolean success;//成功或失败的标志
    private List<String> message;//信息

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }


    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public Result(Boolean success, List<String> message) {
        this.success = success;
        this.message = message;
    }

    public Result() {
    }
}

