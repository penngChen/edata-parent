package com.tzsw.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.tzsw.api.service.Datagrid_dc04Service;
import com.tzsw.api.utils.JsonResult;
import com.tzsw.api.utils.ResultCode;
import com.tzsw.provider.dao.UnemploymentqueryDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 13:44 2018/10/31
 */
@Service
public class DatagridDc04ServiceImpl extends BaseService implements Datagrid_dc04Service {

    @Autowired
    private UnemploymentqueryDao unemploymentqueryDao;

    @Override
    public JsonResult query_dc04(Map<String, String> map) {
        try {
            return new JsonResult(ResultCode.SUCCESS, unemploymentqueryDao.query_dc04(map));
        } catch (Exception e) {
            logger.error("查询及统计稳岗补贴业务接口出错" + e.getMessage());
            e.printStackTrace();
            return new JsonResult(ResultCode.SUCCESS_FAIL);
        }
    }
}
