package com.tzsw.consumer.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 10:21 2018/10/19
 */
public class ApiBaseController {

    protected Logger logger = LoggerFactory.getLogger(ApiBaseController.class);

    /**
     * 验证参数是否为空
     *
     * @param params
     * @return
     */
    public boolean isValidateParams(String... params) {
        for (String param : params) {
            if (org.apache.commons.lang3.StringUtils.isBlank(param)) {
                return false;
            }
        }
        return true;
    }
}