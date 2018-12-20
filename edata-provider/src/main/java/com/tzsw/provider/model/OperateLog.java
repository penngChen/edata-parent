package com.tzsw.provider.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 11:44 2018/11/5
 */
public class OperateLog implements Serializable {

    private String operateId;
    private String operateType;
    private String operateText;
    private String operateUser;
    private Date operateTime;

    public String getErrorReason() {
        return errorReason;
    }

    public void setErrorReason(String errorReason) {
        this.errorReason = errorReason;
    }

    private String operateIp;
    private String errorReason;

    public String getOperateId() {
        return operateId;
    }

    public void setOperateId(String operateId) {
        this.operateId = operateId;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public String getOperateText() {
        return operateText;
    }

    public void setOperateText(String operateText) {
        this.operateText = operateText;
    }

    public String getOperateUser() {
        return operateUser;
    }

    public void setOperateUser(String operateUser) {
        this.operateUser = operateUser;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperateIp() {
        return operateIp;
    }

    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp;
    }
}
