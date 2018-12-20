package com.tzsw.api.service;

import com.tzsw.api.utils.JsonResult;

import java.util.List;
import java.util.Map;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 11:48 2018/10/31
 */
public interface Datagrid_dc04Service {

    /*
     * 查询及统计稳岗补贴业务
     * @Param
     * @return
     **/

    public JsonResult query_dc04(Map<String,String> map);
}
