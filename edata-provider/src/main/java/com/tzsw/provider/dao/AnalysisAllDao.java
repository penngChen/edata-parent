package com.tzsw.provider.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 14:44 2018/10/24
 */
public interface AnalysisAllDao {

    /*
     * 统计企业注册业务数据量
     * @Param
     * @return
     **/

    public List<Map<String, Object>> query_analysis_tjsub_01_by_provincialLevel(Map<String, String> map);

    public List<Map<String, Object>> query_analysis_tjsub_01_by_notProvincialLevel(Map<String, String> map);

    /*
     * 统计稳岗补贴业务数据量
     * @Param
     * @return
     **/

    public List<Map<String, Object>> query_analysis_tjsub_02_by_provincialLevel(Map<String, String> map);

    public List<Map<String, Object>> query_analysis_tjsub_02_by_notProvincialLevel(Map<String, String> map);


    /*
     * 统计失业金申领业务数据量
     * @Param
     * @return
     **/

    public List<Map<String, Object>> query_analysis_tjsub_03_by_provincialLevel(Map<String, String> map);

    public List<Map<String, Object>> query_analysis_tjsub_03_by_notProvincialLevel(Map<String, String> map);


    /*
     * 统计技能提升补贴业务数据量
     * @Param
     * @return
     **/

    public List<Map<String, Object>> query_analysis_tjsub_04_by_provincialLevel(Map<String, String> map);

    public List<Map<String, Object>> query_analysis_tjsub_04_by_notProvincialLevel(Map<String, String> map);
}
