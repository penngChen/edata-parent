package com.tzsw.provider.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 17:17 2018/10/18
 */
public interface SynchronousAllDao {

    /*
     * 以辖区为单位同步jc10_web格数据，并在同步后改变该批数据同步标记
     * @Param
     * @return
     **/

    public List<Map<String, Object>> synchronous_jc10Web(String aae017);

    /*
     * 同步个人在jc10_web表格中数据，并在数据同步后改变条数据的同步标记
     * @Param
     * @return
     **/

    public List<Map<String, Object>> synchronous_jc10Web_bjc100_query(String bjc100);

    public int synchronous_jc10Web_bjc100_update(String bjc100);


    /*
     * 以辖区为单位同步dc05表格数据，并在同步后改变该批数据同步标记
     * @Param 
     * @return 
     **/

    public List<Map<String, Object>> synchronous_dc05(String aae017);


    /*
     * 同步个人在dc05表格中数据，并在数据同步后改条数据同步标记
     * @Param
     * @return
     **/

    public List<Map<String, Object>> synchronous_dc05_bdc050_query(String bdc050);

    public int synchronous_dc05_bdc050_update(String bdc050);
}
