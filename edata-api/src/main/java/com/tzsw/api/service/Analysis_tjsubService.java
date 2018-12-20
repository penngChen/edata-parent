package com.tzsw.api.service;

import com.tzsw.api.utils.JsonResult;

import java.util.List;
import java.util.Map;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 11:51 2018/10/31
 */
public interface Analysis_tjsubService {

    /*
     * 统计企业注册业务数据量
     * @Param
     * @return
     **/

    public JsonResult query_analysis_tjsub(Map<String,String> map);
}
