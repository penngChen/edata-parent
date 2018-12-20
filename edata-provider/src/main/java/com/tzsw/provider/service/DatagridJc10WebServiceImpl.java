package com.tzsw.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.tzsw.api.service.Datagrid_jc10WebService;
import com.tzsw.api.utils.JsonResult;
import com.tzsw.api.utils.ResultCode;
import com.tzsw.provider.dao.UnemploymentqueryDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 13:45 2018/10/31
 */
@Service
public class DatagridJc10WebServiceImpl extends BaseService implements Datagrid_jc10WebService {

    @Autowired
    private UnemploymentqueryDao unemploymentqueryDao;

    @Override
    public JsonResult query_jc10web(Map<String, String> map) {
        try {
            return new JsonResult(ResultCode.SUCCESS, unemploymentqueryDao.query_jc10web(map));
        } catch (Exception e) {
            logger.error("查询及统计失业金申领业务接口出错" + e.getMessage());
            e.printStackTrace();
            return new JsonResult(ResultCode.SUCCESS_FAIL);
        }
    }
}
