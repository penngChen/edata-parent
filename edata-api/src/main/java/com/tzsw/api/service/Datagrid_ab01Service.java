package com.tzsw.api.service;

import com.tzsw.api.utils.JsonResult;

import java.util.List;
import java.util.Map;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 11:48 2018/10/31
 */
public interface Datagrid_ab01Service {

    /*
     * 查询及统计单位注册业务
     * @Param
     * @return
     **/

    public JsonResult query_ab01(Map<String,String> map);
}
