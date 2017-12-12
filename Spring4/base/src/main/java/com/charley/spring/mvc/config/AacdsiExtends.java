package com.charley.spring.mvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * Servlet3.0环节中，容器会在类路径下查找实现javax.servlet.ServletContainerInitializer接口的实现类
 * Spring4.0中的 SpringServletContainerInitializer类实现了这个接口，并实现了onStartup方法：
 *      1、List<WebApplicationInitializer> initializers = new LinkedList<WebApplicationInitializer>();
 *      2、 for (WebApplicationInitializer initializer : initializers) {
                initializer.onStartup(servletContext);
            }
 * 一个接口，3个实现类：
 * WebApplicationInitializer <-实现：AbstractContextLoaderInitializer <-继承 AbstractDispatcherServletInitializer <-继承 AbstractAnnotationConfigDispatcherServletInitializer

 * DispatcherServlet是SpringMVC的核心，加载包含Web组件的Bean，如控制器、视图解析器、处理器映射
 * ContextLoaderListener 上下文加载监听器，加载后端中间件、数据层组件
 */
public class AacdsiExtends extends AbstractAnnotationConfigDispatcherServletInitializer{

    /**
     * @return 将一个或多个路径映射到DispatcherServlet上
     */
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    /**
     * @return 返回带有@Configration注解的类、将其设置为ContextLoaderListener应用的上下文的bean
     */
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    /**
     * @return 返回带有@Configration注解的类、将其设置为DispatcherServlet应用的上下文的bean
     */
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ServletConfig.class};
    }

    /**
     * 也可通过配置XML实现
     * @param registration
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        // 设置附件上传的路径、大小
        registration.setMultipartConfig(new MultipartConfigElement("/tmp/uploads", 200 * 1024, 400 * 1024, 0));
    }
}
