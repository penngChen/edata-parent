package com.tzsw.provider.service;

import com.tzsw.api.service.Jc10WebService;
import com.tzsw.api.service.OperateLogService;
import com.tzsw.api.utils.CommonUtil;
import com.tzsw.api.utils.JsonResult;
import com.tzsw.api.utils.ResultCode;
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
 * @Date: Created in 13:48 2018/10/31
 */
@Service
public class Jc10WebServiceImpl extends BaseService implements Jc10WebService {

    @Autowired
    private SynchronousAllDao synchronousAllDao;

    @Autowired
    private OperateLogService operateLogService;


    @Override
    public JsonResult synchronous_jc10Web_bjc100(String bjc100, String ipAdress) {
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            list = synchronousAllDao.synchronous_jc10Web_bjc100_query(bjc100);
            CommonUtil.changeDate(list);
            updateSynchronous_jc10Web_bjc100(bjc100, ipAdress);
            return new JsonResult(ResultCode.SUCCESS, list);
        } catch (Exception e) {
            logger.error("同步个人在jc10_web表格中查询接口出错" + e.getMessage());
            e.printStackTrace();
            return new JsonResult(ResultCode.SUCCESS_FAIL);
        }
    }

    @Transactional
    public void updateSynchronous_jc10Web_bjc100(String bjc100, String ipAdress) {
        try {
            int result = synchronousAllDao.synchronous_jc10Web_bjc100_update(bjc100);
            if (result > 0) {
                operateLogService.insertOperateLog(bjc100, ipAdress, "修改JC10_WEB表状态", "修改详细：sync_out=1,修改状态：成功", "");
            } else {
                operateLogService.insertOperateLog(bjc100, ipAdress, "修改JC10_WEB表状态", "修改详细：sync_out=1,修改状态：失败", "修改出现异常，详情参考错误日志,日志存放地址为：/home/logs/tzsw/edata-provider/error.log");
            }
        } catch (Exception e) {
            logger.error("同步个人在jc10_web表格中数据修改接口" + e.getMessage());
            e.printStackTrace();
        }
    }
}
