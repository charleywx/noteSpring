package com.charley.springMvc;

import com.charley.springMvc.interceptor.DemoInterceptor;
import com.charley.springMvc.messageconverter.MyMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

/**
 */
@Configuration
@EnableWebMvc //开启springmvc的支持
@EnableScheduling//开启计划任务
@ComponentScan("com.charley.springMvc")
public class MvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 添加视图解析器
     * @return
     */
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    /**
     * 显式注册拦截器
     * @return
     */
    @Bean
    public DemoInterceptor demoInterceptor() {
        return new DemoInterceptor();
    }

    /**
     * 自定义媒体类型
     * @return
     */
    @Bean
    public MyMessageConverter converter() {
        return new MyMessageConverter();
    }

    /**
     * 配置文件上传类
     * 设置上传文件的最大大小
     */
    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver =
                new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(10000);

        return multipartResolver;
    }

    /**
     * 添加对静态资源的访问
     * http://localhost:8080/assets/static.html
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //super.addResourceHandlers(registry);
        //addResourceHandler  对外的暴露的访问路径
        //addResourceLocations 文件资源的存放路径
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor());
    }

    //添加多个页面跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/index2").setViewName("error");
        registry.addViewController("/toUpload").setViewName("/upload");
        registry.addViewController("/converter").setViewName("/conventer");
        registry.addViewController("/sse").setViewName("/sse");
        registry.addViewController("/async").setViewName("/async");
    }

    //不忽略.后的参数
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        //super.configurePathMatch(configurer);
        configurer.setUseSuffixPatternMatch(false);
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //super.extendMessageConverters(converters);
        converters.add(converter());
    }

}
