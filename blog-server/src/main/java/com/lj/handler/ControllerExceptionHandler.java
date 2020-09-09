package com.lj.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

// @C...Advice 注解：会拦截掉所有带有 @Controller 注解的控制器
@ControllerAdvice
public class ControllerExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
//    从 request 里可以知道访问的哪个 url 出现了异常；
//    @E...Handler 注解：标注下面 exceptionHandler 这个方法是可以作为异常处理的
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest request,Exception e){
//        e 会以堆栈的形式打印异常信息，e.getMessage() 则不会在日志/控制台打印异常信息。
        logger.error("Request URL : {},Exception : {}",request.getRequestURL(),e);
//        该类的model属性存储数据，该类的view指定返回页面
        ModelAndView mv = new ModelAndView();
        mv.addObject("url",request.getRequestURL());
        mv.addObject("exception",e);
//        定位到哪个页面：error/目录下的 error页面
        mv.setViewName("error/error");
        return mv;
    }
}
