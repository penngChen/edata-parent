package com.tzsw.consumer.support;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tzsw.api.utils.DateUtil;
import com.tzsw.api.utils.JsonResult;
import com.tzsw.api.utils.ResultCode;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 14:29 2018/10/31
 */

@Aspect
@Component
public class AspectAdvice {

    private Logger logger = LoggerFactory.getLogger(AspectAdvice.class);

    @Around("execution(* com.tzsw.consumer.api.ApiController.*(..))")
    public JsonResult process(ProceedingJoinPoint point) {
        logger.info("请求方法：" + point.getSignature());
        try {
            JsonResult returnObj = (JsonResult) point.proceed();
            String json = JSON.toJSONString(returnObj, SerializerFeature.WriteMapNullValue);
            JSONObject jsonObject = JSONObject.parseObject(json);
            if (!StringUtils.isEmpty(jsonObject.get("data"))) {
                @SuppressWarnings("unchecked")
                List<Map<String, Object>> mapList = (List) jsonObject.get("data");
                reassignMap(mapList);
                returnObj.setData(mapList);
                return returnObj;
            } else {
                return returnObj;
            }

        } catch (Throwable e) {
            e.printStackTrace();
            logger.error("Aspect【切面异常信息】：" + e.getMessage());
            return new JsonResult(ResultCode.EXCEPTION);
        }
    }

    /*
     * 将空值赋值
     * @Param
     * @return
     **/

    private void reassignMap(List<Map<String, Object>> mapList) {
        for (Map<String, Object> map : mapList) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (org.springframework.util.StringUtils.isEmpty(entry.getValue())) {
                    entry.setValue("-");
                }
            }
        }
    }
}
