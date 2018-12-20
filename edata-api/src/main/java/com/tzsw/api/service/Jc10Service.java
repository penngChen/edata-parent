package com.tzsw.api.service;

import com.tzsw.api.utils.JsonResult;

import java.util.List;
import java.util.Map;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 11:36 2018/10/31
 */
public interface Jc10Service {

    /*
     * 以辖区为单位同步jc10_web格数据，并在同步后改变该批数据同步标记
     * @Param
     * @return
     **/

    public JsonResult synchronous_jc10Web(String aae017);
}
