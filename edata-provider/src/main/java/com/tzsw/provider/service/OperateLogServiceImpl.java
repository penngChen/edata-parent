package com.tzsw.provider.service;

import com.tzsw.api.service.OperateLogService;
import com.tzsw.api.utils.IDGen;
import com.tzsw.provider.dao.OperateLogDao;
import com.tzsw.provider.model.OperateLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 14:18 2018/11/5
 */
@Service
public class OperateLogServiceImpl extends BaseService implements OperateLogService {

    @Autowired
    private OperateLogDao operateLogDao;

    public void insertOperateLog(String user, String ipAdress, String operateType, String operateText, String errorReason) {
        try {
            OperateLog operateLog = new OperateLog();
            operateLog.setOperateId(IDGen.createUUID32());
            operateLog.setOperateType(operateType);
            operateLog.setOperateIp(ipAdress);
            operateLog.setOperateText(operateText);
            operateLog.setOperateUser(user);
            operateLog.setErrorReason(errorReason);
            operateLogDao.insertOperateLog(operateLog);
        } catch (Exception e) {
            logger.error("插入日志失败:" + e.getMessage());
            e.printStackTrace();
        }
    }
}
