package com.tzsw.consumer.api;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tzsw.api.service.*;
import com.tzsw.api.utils.JsonResult;
import com.tzsw.api.utils.NetworkUtil;
import com.tzsw.api.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 14:33 2018/10/31
 */
@RestController
@RequestMapping("/api")
public class ApiController extends ApiBaseController {

    @Reference
    private Datagrid_ab01Service datagrid_ab01Service;

    @Reference
    private Analysis_tjsubService analysis_tjsubService;

    @Reference
    private Datagrid_ac01Service datagrid_ac01Service;

    @Reference
    private Datagrid_dc04Service datagrid_dc04Service;

    @Reference
    private Datagrid_dc05Service datagrid_dc05Service;

    @Reference
    private Datagrid_jc10WebService datagrid_jc10WebService;

    @Reference
    private Dc05Service dc05Service;

    @Autowired
    private Dc05WebService dc05WebService;

    @Reference
    private Jc10Service jc10Service;

    @Autowired
    private Jc10WebService jc10WebService;

    @RequestMapping(value = "synchronous_jc10Web", method = RequestMethod.POST)
    public JsonResult synchronous_jc10Web(String aae017) {
        logger.info("以辖区为单位同步jc10_web格数据接口开始调用");
        if (isValidateParams(aae017)) {
            JsonResult jsonResult = jc10Service.synchronous_jc10Web(aae017);
            logger.info("接口调用完毕");
            return jsonResult;
        } else {
            logger.warn("aae017=" + aae017 + "，参数错误，跳过处理。");
            return new JsonResult(ResultCode.PARAMS_ERROR);
        }

    }

    @RequestMapping(value = "synchronous_jc10Web_bjc100", method = RequestMethod.POST)
    public JsonResult synchronous_jc10Web_bjc100(String bjc100, HttpServletRequest request) {
        logger.info("同步个人在jc10_web表格中数据接口开始调用");
        String ipAddress = NetworkUtil.getIpAddress(request);
        if (isValidateParams(bjc100)) {
            JsonResult jsonResult = jc10WebService.synchronous_jc10Web_bjc100(bjc100, ipAddress);
            logger.info("接口调用完毕");
            return jsonResult;
        } else {
            logger.warn("bjc100=" + bjc100 + "，参数错误，跳过处理。");
            return new JsonResult(ResultCode.PARAMS_ERROR);
        }
    }


    @RequestMapping(value = "synchronous_dc05", method = RequestMethod.POST)
    public JsonResult synchronous_dc05(String aae017) {
        logger.info("以辖区为单位同步dc05表格数据接口开始调用");
        if (isValidateParams(aae017)) {
            JsonResult jsonResult = dc05Service.synchronous_dc05(aae017);
            logger.info("接口调用完毕");
            return jsonResult;
        } else {
            logger.warn("aae017=" + aae017 + "，参数错误，跳过处理。");
            return new JsonResult(ResultCode.PARAMS_ERROR);
        }
    }


    @RequestMapping(value = "synchronous_dc05_bdc050", method = RequestMethod.POST)
    public JsonResult synchronous_dc05_bdc050(String bdc050, HttpServletRequest request) {
        logger.info("同步个人在dc05表格中数据接口开始调用");
        String ipAddress = NetworkUtil.getIpAddress(request);
        if (isValidateParams(bdc050)) {
            JsonResult jsonResult = dc05WebService.synchronous_dc05_bdc050(bdc050, ipAddress);
            logger.info("接口调用完毕");
            return jsonResult;
        } else {
            logger.warn("bdc050=" + bdc050 + "，参数错误，跳过处理。");
            return new JsonResult(ResultCode.PARAMS_ERROR);
        }
    }

    @RequestMapping(value = "datagrid_ac01", method = RequestMethod.POST)
    public JsonResult datagrid_ac01(String aae017, String aac011, String aac002, String aac003, String aac004) {
        logger.info("查询及统计个人注册业务接口开始调用");
        Map<String, String> map = new HashMap<String, String>();
        map.put("aae017", aae017);
        map.put("aac011", aac011);
        map.put("aac002", aac002);
        map.put("aac003", aac003);
        map.put("aac004", aac004);
        if (isValidateParams(aae017)) {
            JsonResult jsonResult = datagrid_ac01Service.query_ac01(map);
            logger.info("接口调用完毕");
            return jsonResult;
        } else {
            logger.warn("aae017=" + aae017 + "，参数错误，跳过处理。");
            return new JsonResult(ResultCode.PARAMS_ERROR);
        }
    }

    @RequestMapping(value = "datagrid_ab01", method = RequestMethod.POST)
    public JsonResult datagrid_ab01(String aae017, String aab004, String aab070, String aab019, String dab002, String aae036_begin, String aae036_end) {
        logger.info("查询及统计单位注册业务接口开始调用");
        Map<String, String> map = new HashMap<String, String>();
        map.put("aae017", aae017);
        map.put("aab004", aab004);
        map.put("aab070", aab070);
        map.put("aab019", aab019);
        map.put("dab002", dab002);
        map.put("aae036_begin", aae036_begin);
        map.put("aae036_end", aae036_end);
        if (isValidateParams(aae017)) {
            JsonResult jsonResult = datagrid_ab01Service.query_ab01(map);
            logger.info("接口调用完毕");
            return jsonResult;
        } else {
            logger.warn("aae017=" + aae017 + "，参数错误，跳过处理。");
            return new JsonResult(ResultCode.PARAMS_ERROR);
        }
    }

    @RequestMapping(value = "datagrid_dc04", method = RequestMethod.POST)
    public JsonResult datagrid_dc04(String aae017, String aab004, String aae002, String bdc042, String aab070, String aae036_begin, String aae036_end) {
        logger.info("查询及统计稳岗补贴业务接口开始调用");
        Map<String, String> map = new HashMap<String, String>();
        map.put("aae017", aae017);
        map.put("aae002", aae002);
        map.put("aab004", aab004);
        map.put("bdc042", bdc042);
        map.put("aab070", aab070);
        map.put("aae036_begin", aae036_begin);
        map.put("aae036_end", aae036_end);
        if (isValidateParams(aae017)) {
            JsonResult jsonResult = datagrid_dc04Service.query_dc04(map);
            logger.info("接口调用完毕");
            return jsonResult;
        } else {
            logger.warn("aae017=" + aae017 + "，参数错误，跳过处理。");
            return new JsonResult(ResultCode.PARAMS_ERROR);
        }
    }

    @RequestMapping(value = "datagrid_jc10Web", method = RequestMethod.POST)
    public JsonResult datagrid_jc10Web(String aae017, String aac002, String aac003, String bjc01h, String bjc01f, String bjc109, String aae036_begin, String aae036_end) {
        logger.info("查询及统计失业金申领业务接口开始调用");
        Map<String, String> map = new HashMap<String, String>();
        map.put("aae017", aae017);
        map.put("aac002", aac002);
        map.put("aac003", aac003);
        map.put("bjc01h", bjc01h);
        map.put("bjc01f", bjc01f);
        map.put("bjc109", bjc109);
        map.put("aae036_begin", aae036_begin);
        map.put("aae036_end", aae036_end);
        if (isValidateParams(aae017)) {
            JsonResult jsonResult = datagrid_jc10WebService.query_jc10web(map);
            logger.info("接口调用完毕");
            return jsonResult;
        } else {
            logger.warn("aae017=" + aae017 + "，参数错误，跳过处理。");
            return new JsonResult(ResultCode.PARAMS_ERROR);
        }
    }


    @RequestMapping(value = "datagrid_dc05", method = RequestMethod.POST)
    public JsonResult datagrid_dc05(String aae017, String aac002, String aac003, String bdc053, String bdc057, String bdc052, String bdc051, String bdc054, String bdc056_begin, String bdc056_end, String aae036_begin, String aae036_end) {
        logger.info("查询及统计技能提升补贴申领业务接口开始调用");
        Map<String, String> map = new HashMap<String, String>();
        map.put("aae017", aae017);
        map.put("aac002", aac002);
        map.put("aac003", aac003);
        map.put("bdc053", bdc053);
        map.put("bdc057", bdc057);
        map.put("bdc052", bdc052);
        map.put("bdc051", bdc051);
        map.put("bdc054", bdc054);
        map.put("bdc056_begin", bdc056_begin);
        map.put("bdc056_end", bdc056_end);
        map.put("aae036_begin", aae036_begin);
        map.put("aae036_end", aae036_end);
        if (isValidateParams(aae017)) {
            JsonResult jsonResult = datagrid_dc05Service.query_dc05(map);
            logger.info("接口调用完毕");
            return jsonResult;
        } else {
            logger.warn("aae017=" + aae017 + "，参数错误，跳过处理。");
            return new JsonResult(ResultCode.PARAMS_ERROR);
        }
    }

    @RequestMapping(value = "goAllDownload", method = RequestMethod.POST)
    public JsonResult goAllDownload(String aac001) {
        logger.info("查询身份证正反面照片接口开始调用");
        if (isValidateParams(aac001)) {
            JsonResult jsonResult = datagrid_ac01Service.goAllDownload(aac001, aac001);
            logger.info("接口调用完毕");
            return jsonResult;
        } else {
            logger.warn("aac001=" + aac001 + "，参数错误，跳过处理。");
            return new JsonResult(ResultCode.PARAMS_ERROR);
        }
    }


    @RequestMapping(value = "query_analysis_tjsub", method = RequestMethod.POST)
    public JsonResult query_analysis_tjsub(String type, String aae017, String aae036_begin, String aae036_end) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", type);
        map.put("aae017", aae017);
        map.put("aae036_begin", aae036_begin);
        map.put("aae036_end", aae036_end);
        if (isValidateParams(type, aae017, aae036_begin, aae036_end)) {
            logger.info(type + "业务数据量接口开始调用");
            JsonResult jsonResult = analysis_tjsubService.query_analysis_tjsub(map);
            logger.info("接口调用完毕");
            return jsonResult;
        } else {
            logger.warn("type=" + type + "aae017=" + aae017 + "aae036_begin=" + aae036_begin + "aae036_end=" + aae036_end + "，参数错误，跳过处理。");
            return new JsonResult(ResultCode.PARAMS_ERROR);
        }
    }
}
