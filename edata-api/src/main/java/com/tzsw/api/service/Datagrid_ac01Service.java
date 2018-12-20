package com.tzsw.api.service;

import com.tzsw.api.utils.JsonResult;

import java.util.Map;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 11:48 2018/10/31
 */
public interface Datagrid_ac01Service {

    /*
     * 查询及统计个人注册业务
     * @Param
     * @return
     **/

    public JsonResult query_ac01(Map<String,String> map);


    /*
     * 查询个人注册业务及失业金申领及技能提升等身份证正反面照片
     * @Param
     * @return
     **/
    public JsonResult goAllDownload(String id1,String id2);
}
