package com.tzsw.api.service;

import com.tzsw.api.utils.JsonResult;

import java.util.List;
import java.util.Map;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 11:48 2018/10/31
 */
public interface Datagrid_dc05Service {

    /*
     * 查询及统计技能提升补贴申领业务
     * @Param
     * @return
     **/

    public JsonResult query_dc05(Map<String,String> map);
}
