package com.charley.springMvc.jetty;

import com.charley.springMvc.WebInitializer;
import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.annotations.ClassInheritanceHandler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebXmlConfiguration;
import org.springframework.web.WebApplicationInitializer;

import java.util.HashSet;

public class JettyRun {
    
    public static final int PORT = 8112;
    
    // web访问的根路径http://ip:port/，相当于项目名,/即忽略项目名  
    public static final String CONTEXT = "/emerge";
    
    private static final String DEFAULT_WEBAPP_PATH = "src/main/webapp";
    
    public static Server createServerIn(int port) {
        
        // WebAppContext webContext = new WebAppContext(DEFAULT_WEBAPP_PATH, CONTEXT);
        WebAppContext context = new WebAppContext();
        context.setContextPath(CONTEXT);
        // context.setResourceBase(DEFAULT_WEBAPP_PATH);
        
        context.setConfigurations(new Configuration[]{
                new WebXmlConfiguration(),
                new AnnotationConfiguration() {
                    @Override
                    public void preConfigure(WebAppContext context) {
                        ClassInheritanceMap map = new ClassInheritanceMap();
                        map.put(WebApplicationInitializer.class.getName(), new HashSet<String>() {{
                            add(WebInitializer.class.getName());
                            //add(SecurityWebInitializer.class.getName());
                        }});
                        context.setAttribute(CLASS_INHERITANCE_MAP, map);
                        _classInheritanceHandler = new ClassInheritanceHandler(map);
                    }
                }
        });
        context.setParentLoaderPriority(true);
        
        // webContext.setDescriptor("src/main/webapp/WEB-INF/web.xml");
        // context.setClassLoader(Thread.currentThread().getContextClassLoader());
    
        // 创建Server
        Server server = new Server(port);
        server.setHandler(context);
        return server;
    }
    
    public static void main(String[] args) throws Exception {
        /*DOMConfigurator.configure(Thread.currentThread().getContextClassLoader()
                .getResource("log4j.xml"));*/
        Server server = createServerIn(PORT);
        // server.stop();
        server.start();
        server.join();
    }
}