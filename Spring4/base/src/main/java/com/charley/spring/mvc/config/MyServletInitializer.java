package com.charley.spring.mvc.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;

/**
 * Web配置
 * 自定义Servlert、Filter、Listener的两种方式：
 * 1、通过实现WebApplicationInitializer来注册Servlet
 * 2、通过AbstractAnnotationConfigDispatcherServletInitializer的getServletFilters()
 */
public class MyServletInitializer implements WebApplicationInitializer {

    /**
     * 重写onStartup方法
     * @param servletContext
     * @throws ServletException
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Servlet3.0设置profile环境
        servletContext.setInitParameter("spring.profiles.default", "dev");

        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        // 注册MVC配置
        ctx.register(ServletConfig.class);
        // 关联servletContext
        ctx.setServletContext(servletContext);

        // 注册Spring MVC的DispatcherServlet
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);


        // 添加Servlet
        ServletRegistration.Dynamic myServlet = servletContext.addServlet("myServlet", MyServlet.class);
        myServlet.addMapping("/custom/**");

        // 添加Filter
        FilterRegistration.Dynamic myFilter = servletContext.addFilter("myFilter", MyFilter.class);
        myFilter.addMappingForUrlPatterns(null, false, "/custom/*");

        // 添加Servlet，设置附件上传
        DispatcherServlet ds = new DispatcherServlet();
        ServletRegistration.Dynamic registration = servletContext.addServlet("appServlet", ds);
        registration.addMapping("/");
        registration.setMultipartConfig(new MultipartConfigElement("/tmp/uploads", 200 * 1024, 200 * 1024, 0));
    }

}
