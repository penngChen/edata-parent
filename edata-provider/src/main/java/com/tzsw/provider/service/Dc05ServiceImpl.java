package com.tzsw.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.tzsw.api.service.Dc05Service;
import com.tzsw.api.utils.CommonUtil;
import com.tzsw.api.utils.JsonResult;
import com.tzsw.api.utils.ResultCode;
import com.tzsw.provider.dao.SynchronousAllDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 13:47 2018/10/31
 */
@Service
public class Dc05ServiceImpl extends BaseService implements Dc05Service {

    @Autowired
    private SynchronousAllDao synchronousAllDao;


    @Override
    public JsonResult synchronous_dc05(String aae017) {
        try {
            List<Map<String, Object>> list = synchronousAllDao.synchronous_dc05(aae017);
            CommonUtil.changeDate(list);
            return new JsonResult(ResultCode.SUCCESS, list);
        } catch (Exception e) {
            logger.error("以辖区为单位同步dc05表格数据接口出错" + e.getMessage());
            e.printStackTrace();
            return new JsonResult(ResultCode.SUCCESS_FAIL);
        }
    }
}
