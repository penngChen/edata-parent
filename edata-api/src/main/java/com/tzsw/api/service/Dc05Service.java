package com.tzsw.api.service;

import com.tzsw.api.utils.JsonResult;

import java.util.List;
import java.util.Map;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 11:41 2018/10/31
 */
public interface Dc05Service {

    /*
     * 以辖区为单位同步dc05表格数据，并在同步后改变该批数据同步标记
     * @Param
     * @return
     **/

    public JsonResult synchronous_dc05(String aae017);
}
