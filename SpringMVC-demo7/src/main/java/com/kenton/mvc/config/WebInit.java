package com.kenton.mvc.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import java.io.File;
import java.nio.charset.CharacterCodingException;

/**
 * @author: Kenton
 * @description
 * @date: 2022/6/29 16:10
 */
// Web工程的初始化类 用来代替web.xml
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    // 指定Spring的配置类
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    // 指定SpringMVC配置类
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    // 指定DispatcherServlet的映射规则 即url-pattern
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    // 注册过滤器
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceRequestEncoding(true);
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        return new Filter[]{characterEncodingFilter,hiddenHttpMethodFilter};
    }


}
