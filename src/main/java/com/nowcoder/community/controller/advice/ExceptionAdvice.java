package com.nowcoder.community.controller.advice;

import com.nowcoder.community.util.CommunityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// 只扫描带有Controller注解的bean，aop
@ControllerAdvice(annotations = Controller.class)
public class ExceptionAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ExceptionHandler({Exception.class})
    public void handelException(Exception e, HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.error("服务器发生异常" + e.getMessage());
        for (StackTraceElement element: e.getStackTrace()){
            logger.error(element.toString());
        }

        // 判断是否是异步请求
        String xRequestedWith = request.getHeader("x-requested-with");
        if ("XMLHttpRequest".equals(xRequestedWith)) {
            // 说明该请求为异步请求，返回错误信息
            response.setContentType("application/plain;charset=utf-8"); // application/plain 表示响应为普通字符串，需要前端手动转为JS对象
            PrintWriter writer = response.getWriter();
            writer.write(CommunityUtil.getJSONString(1, "服务器异常"));
        } else {
            // 说明该请求为普通请求，重定向到错误页面
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }
}
