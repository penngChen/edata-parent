package com.tzsw.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.tzsw.api.service.Datagrid_ab01Service;
import com.tzsw.api.utils.JsonResult;
import com.tzsw.api.utils.ResultCode;
import com.tzsw.provider.dao.UnemploymentqueryDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 13:42 2018/10/31
 */

@Service
public class DatagridAb01ServiceImpl extends BaseService implements Datagrid_ab01Service {

    @Autowired
    private UnemploymentqueryDao unemploymentqueryDao;

    @Override
    public JsonResult query_ab01(Map<String, String> map) {
        try {
            List<Map<String, Object>> list = unemploymentqueryDao.query_ab01(map);
            return new JsonResult(ResultCode.SUCCESS, list);
        } catch (Exception e) {
            logger.error("查询及统计单位注册业务接口出错" + e.getMessage());
            e.printStackTrace();
            return new JsonResult(ResultCode.SUCCESS_FAIL);
        }
    }
}
