package com.tzsw.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.tzsw.api.service.Analysis_tjsubService;
import com.tzsw.api.utils.JsonResult;
import com.tzsw.api.utils.ResultCode;
import com.tzsw.provider.dao.AnalysisAllDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 11:51 2018/10/31
 */
@Service
public class AnalysisTjsubServiceImpl extends BaseService implements Analysis_tjsubService {

    @Autowired
    private AnalysisAllDao analysisAllDao;

    @Override
    public JsonResult query_analysis_tjsub(Map<String, String> map) {
        String type = map.get("type");
        String aae017 = map.get("aae017");
        try {
            if ("01".equals(type)) {
                List<Map<String, Object>> mapList1 = analysisAllDao.query_analysis_tjsub_01_by_provincialLevel(map);
                List<Map<String, Object>> mapList2 = analysisAllDao.query_analysis_tjsub_01_by_notProvincialLevel(map);
                if (aae017.length() == 2) {
                    return new JsonResult(ResultCode.SUCCESS, mapList1);
                } else {
                    return new JsonResult(ResultCode.SUCCESS, mapList2);
                }
            } else if ("02".equals(type)) {
                List<Map<String, Object>> mapList1 = analysisAllDao.query_analysis_tjsub_02_by_provincialLevel(map);
                List<Map<String, Object>> mapList2 = analysisAllDao.query_analysis_tjsub_02_by_notProvincialLevel(map);
                if (aae017.length() == 2) {
                    return new JsonResult(ResultCode.SUCCESS, mapList1);
                } else {
                    return new JsonResult(ResultCode.SUCCESS, mapList2);
                }
            } else if ("03".equals(type)) {
                List<Map<String, Object>> mapList1 = analysisAllDao.query_analysis_tjsub_03_by_provincialLevel(map);
                List<Map<String, Object>> mapList2 = analysisAllDao.query_analysis_tjsub_03_by_notProvincialLevel(map);
                if (aae017.length() == 2) {
                    return new JsonResult(ResultCode.SUCCESS, mapList1);
                } else {
                    return new JsonResult(ResultCode.SUCCESS, mapList2);
                }
            } else if ("04".equals(type)) {
                List<Map<String, Object>> mapList1 = analysisAllDao.query_analysis_tjsub_04_by_provincialLevel(map);
                List<Map<String, Object>> mapList2 = analysisAllDao.query_analysis_tjsub_04_by_notProvincialLevel(map);
                if (aae017.length() == 2) {
                    return new JsonResult(ResultCode.SUCCESS, mapList1);
                } else {
                    return new JsonResult(ResultCode.SUCCESS, mapList2);
                }
            }
        } catch (Exception e) {
            logger.error(type + "统计企业注册业务数据量接口出错" + e.getMessage());
            e.printStackTrace();
        }
        return new JsonResult(ResultCode.SUCCESS_FAIL);
    }
}
