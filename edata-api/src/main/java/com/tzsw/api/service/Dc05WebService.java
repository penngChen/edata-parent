package com.tzsw.api.service;

import com.tzsw.api.utils.JsonResult;

import java.util.List;
import java.util.Map;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 11:43 2018/10/31
 */
public interface Dc05WebService {

    /*
     * 同步个人在dc05表格中数据，并在数据同步后改条数据同步标记
     * @Param
     * @return
     **/

    public JsonResult synchronous_dc05_bdc050(String bdc050,String ipAddress);
}
