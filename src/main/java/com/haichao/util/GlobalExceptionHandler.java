package com.haichao.util;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *     全局异常捕获
 * </p>
 * @Author yusj
 * @Date 2019/3/11
 * @Version 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value=RuntimeException.class)
    public Object defaultErrorHandler(HttpServletRequest req, RuntimeException e){
        e.printStackTrace();
        return e.getMessage();
    }


    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
        //lamda 表达式
        return (factory->{
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.do");
            factory.addErrorPages( error404Page);
        });
    }


}
