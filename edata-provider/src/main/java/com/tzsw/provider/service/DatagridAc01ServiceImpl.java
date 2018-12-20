package com.tzsw.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.tzsw.api.service.Datagrid_ac01Service;
import com.tzsw.api.utils.CommonUtil;
import com.tzsw.api.utils.JsonResult;
import com.tzsw.api.utils.ResultCode;
import com.tzsw.provider.dao.UnemploymentqueryDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 13:43 2018/10/31
 */
@Service
public class DatagridAc01ServiceImpl extends BaseService implements Datagrid_ac01Service {

    @Autowired
    private UnemploymentqueryDao unemploymentqueryDao;

    @Override
    public JsonResult query_ac01(Map<String, String> map) {
        try {
            List<Map<String,Object>> mapList=unemploymentqueryDao.query_ac01(map);
//            CommonUtil.removeOneList(mapList);
//            CommonUtil.sortListByAae036(mapList);
            return new JsonResult(ResultCode.SUCCESS, mapList);
        } catch (Exception e) {
            logger.error("查询及统计个人注册业务接口出错" + e.getMessage());
            e.printStackTrace();
            return new JsonResult(ResultCode.SUCCESS_FAIL);
        }
    }

    @Override
    public JsonResult goAllDownload(String id1, String id2) {
        try {
            return new JsonResult(ResultCode.SUCCESS, unemploymentqueryDao.goAllDownload(id1, id2));
        } catch (Exception e) {
            logger.error("查询身份证正反面照片接口出错" + e.getMessage());
            e.printStackTrace();
            return new JsonResult(ResultCode.SUCCESS_FAIL);
        }
    }
}
