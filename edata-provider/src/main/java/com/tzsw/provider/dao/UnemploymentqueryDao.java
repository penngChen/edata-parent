package com.tzsw.provider.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 14:59 2018/10/22
 */
public interface UnemploymentqueryDao {

    /*
     * 查询及统计个人注册业务
     * @Param 
     * @return 
     **/

    public List<Map<String, Object>> query_ac01(Map<String, String> map);


    /*
     * 查询及统计单位注册业务
     * @Param
     * @return
     **/

    public List<Map<String, Object>> query_ab01(Map<String, String> map);

    /*
     * 查询及统计稳岗补贴业务
     * @Param
     * @return
     **/

    public List<Map<String, Object>> query_dc04(Map<String, String> map);


    /*
     * 查询及统计失业金申领业务
     * @Param
     * @return
     **/

    public List<Map<String, Object>> query_jc10web(Map<String, String> map);


    /*
     * 查询及统计技能提升补贴申领业务
     * @Param
     * @return
     **/

    public List<Map<String, Object>> query_dc05(Map<String, String> map);


    /*
     * 查询个人注册业务及失业金申领及技能提升等身份证正反面照片
     * @Param
     * @return
     **/
    public List<Map<String, Object>> goAllDownload(@Param("id1") String id1, @Param("id2") String id2);

}
