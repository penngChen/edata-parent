package com.tzsw.api.service;

import com.tzsw.api.utils.JsonResult;

import java.util.List;
import java.util.Map;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 11:48 2018/10/31
 */
public interface Datagrid_jc10WebService {

    /*
     * 查询及统计失业金申领业务
     * @Param
     * @return
     **/

    public JsonResult query_jc10web(Map<String,String> map);
}
