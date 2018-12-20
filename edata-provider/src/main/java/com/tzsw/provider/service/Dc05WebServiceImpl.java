package com.tzsw.provider.service;

import com.tzsw.api.service.Dc05WebService;
import com.tzsw.api.service.OperateLogService;
import com.tzsw.api.utils.*;
import com.tzsw.provider.dao.SynchronousAllDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 13:47 2018/10/31
 */
@Service
public class Dc05WebServiceImpl extends BaseService implements Dc05WebService {

    @Autowired
    private SynchronousAllDao synchronousAllDao;

    @Autowired
    private OperateLogService operateLogService;

    @Override
    public JsonResult synchronous_dc05_bdc050(String bdc050, String ipAddress) {
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            list = synchronousAllDao.synchronous_dc05_bdc050_query(bdc050);
            CommonUtil.changeDate(list);
            updateSynchronous_dc05_bdc050(bdc050, ipAddress);
            return new JsonResult(ResultCode.SUCCESS, list);
        } catch (Exception e) {
            logger.error("同步个人在dc05表格中查询数据接口出错" + e.getMessage());
            e.printStackTrace();
            return new JsonResult(ResultCode.SUCCESS_FAIL);
        }
    }

    @Transactional
    public void updateSynchronous_dc05_bdc050(String bdc050, String ipAddress) {
        try {
            int result = synchronousAllDao.synchronous_dc05_bdc050_update(bdc050);
            System.err.println(result);
            if (result > 0) {
                operateLogService.insertOperateLog(bdc050, ipAddress, "修改DC05表状态", "修改详细：sync_out=1,修改状态：成功", "");
            } else {
                operateLogService.insertOperateLog(bdc050, ipAddress, "修改DC05表状态", "修改详细：sync_out=1,修改状态：失败", "修改出现异常，详情参考错误日志,日志存放地址为：/home/logs/tzsw/edata-provider/error.log");
            }
        } catch (Exception e) {
            logger.error("同步个人在dc05表格中数据修改接口出错" + e.getMessage());
            e.printStackTrace();
        }
    }
}
