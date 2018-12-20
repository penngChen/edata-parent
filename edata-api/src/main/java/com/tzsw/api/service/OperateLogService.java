package com.tzsw.api.service;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 14:23 2018/11/5
 */
public interface OperateLogService {

    public void insertOperateLog(String user,String ipAdress,String operateType,String operateText,String errorReason);
}
