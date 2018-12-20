package com.tzsw.provider.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.alibaba.fastjson.JSON;
import com.tzsw.api.utils.DateUtil;
import com.tzsw.api.utils.JsonResult;
import com.tzsw.api.utils.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @Author: chenpeng
 * @Description:自定义ExceptionFilter拦截器异常处理
 * @Date: Created in 17:19 2018/11/1
 */
@Activate(group = Constants.PROVIDER)
public class ExceptionFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(ExceptionFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        Result result = null;
        try {
            result = invoker.invoke(invocation);
            if (result.hasException() && GenericService.class != invoker.getInterface()) {
                Throwable exception = result.getException();
                String data = String.format("\r\n[level]:Error，[createTime]:%s，[platform]:%s，[serviceName]:%s，[methodName]:%s，[inputParam]:%s", DateUtil.formatDateTime(new Date()), ResultCode.EXCEPTION, invoker.getInterface().getName(), invocation.getMethodName(), JSON.toJSONString(invocation.getArguments()));
                logger.error(data, exception);
                //出现异常，打印日志后返回错误码
                return new RpcResult(new JsonResult(ResultCode.EXCEPTION));
            }
        } catch (RuntimeException e) {
            String data = String.format("\r\n[level]:Error，[createTime]:%s，[platform]:%s，[serviceName]:%s，[methodName]:%s，[inputParam]:%s", DateUtil.formatDateTime(new Date()), ResultCode.EXCEPTION, invoker.getInterface().getName(), invocation.getMethodName(), JSON.toJSONString(invocation.getArguments()));
            logger.error(data, e);
        }
        return result;
    }
}
