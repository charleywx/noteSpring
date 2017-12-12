package com.charley.spring.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Mvc配置
 * Adapter 配置器\配适器
 * extends WebMvcConfigurerAdapter 重写方法可对MVC进行配置
 * 默认查找跟bean名称匹配的View
 */
@Configuration
@EnableWebMvc // 开启SpringMvc
@ComponentScan("com.charley.spring.mvc.web")
public class ServletConfig extends WebMvcConfigurerAdapter{

    /**
     * 视图解析器 ViewResolver 接口的实现类：
     * InternalResourceViewResolver 将视图解析为Web应用的内部资源，一般为Jsp
     * TilesViewResolver 将视图解析为Apache Tiles
     * FreeMarkerViewResolver 将视图解析为FreeMarker模版
     * BeanNameviewResolver 将视图解析为Spring上下文中的Bean，其中Bean的ID与视图的名字相同
     * ......
     *
     *
     * 例如：home的视图解析为：/WEB-INF/views/home.jsp
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        // 配置JSP视图解析器
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        // 前缀
        resolver.setPrefix("/bean/");
        // 后缀
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        // 将视图解析为JstlView，默认为InternalResourceView
        // resolver.setViewClass(org.springframework.web.servlet.bean.JstlView.class);
        return resolver;
    }

    /**
     * 设置静态资源的访问转发给默认的Servlet处理，而不是DispatcherServlet本身来处理
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        // 配置静态资源处理
        configurer.enable();
    }

    /**
     * Spring提供的附件上传类
     *
     * @return
     */
    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

}
