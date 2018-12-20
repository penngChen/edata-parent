package com.tzsw.api.service;

import com.tzsw.api.utils.JsonResult;

import java.util.List;
import java.util.Map;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 11:37 2018/10/31
 */
public interface Jc10WebService {

    /*
     * 同步个人在jc10_web表格中数据，并在数据同步后改变条数据的同步标记
     * @Param
     * @return
     **/

    public JsonResult synchronous_jc10Web_bjc100(String bjc100,String ipAdress);
}
