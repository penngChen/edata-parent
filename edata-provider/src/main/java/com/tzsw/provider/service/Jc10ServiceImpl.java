package com.tzsw.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.tzsw.api.service.Jc10Service;
import com.tzsw.api.utils.CommonUtil;
import com.tzsw.api.utils.DateUtil;
import com.tzsw.api.utils.JsonResult;
import com.tzsw.api.utils.ResultCode;
import com.tzsw.provider.dao.SynchronousAllDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 13:48 2018/10/31
 */
@Service
public class Jc10ServiceImpl extends BaseService implements Jc10Service {

    @Autowired
    private SynchronousAllDao synchronousAllDao;

    @Override
    public JsonResult synchronous_jc10Web(String aae017) {
        try {
            List<Map<String, Object>> list = synchronousAllDao.synchronous_jc10Web(aae017);
            CommonUtil.changeDate(list);
            return new JsonResult(ResultCode.SUCCESS, list);
        } catch (Exception e) {
            logger.error("以辖区为单位同步jc10_web格数据" + e.getMessage());
            e.printStackTrace();
            return new JsonResult(ResultCode.SUCCESS_FAIL);
        }
    }
}
