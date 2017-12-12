package com.charley.spring.di.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 连接数据库的方式：
 * 1、DriverManger
 * 2、DataSource
 * 3、BasicDataSource
 * 4、jndi容器tomcat
 * 5、c3p0
 */
@Configuration
public class DataSourceConfig {

    // @Bean(name = "dataSource1", destroyMethod = "shutdown")
    @Bean(name = "dataSource1")
    public DataSource dataSource11() {
        return new EmbeddedDatabaseBuilder().addScript("classpath:schema.sql").build();
    }

    @Bean
    public DataSource dataSource2() {
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("jdbc/myDs");
        jndiObjectFactoryBean.setResourceRef(true);
        jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
        return (DataSource) jndiObjectFactoryBean.getObject();
    }

    /**
     * BasicDataSource 方式
     * 最大连接数
     */
    @Bean(name = "dataSource3")
    public DataSource dataSource13() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:h2:tcp://.....");
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUsername("sa");
        dataSource.setPassword("password");
        // 连接池创建时的连接数量
        dataSource.setInitialSize(20);
        // 同一时间可从连接池中分配的最多连接数，如果设置为0，表示无限制
        dataSource.setMaxTotal(30);
        dataSource.setMinIdle(5);
        dataSource.setMaxWaitMillis(300);
        return dataSource;
    }

    /**
     * C3P0
     * ComboPooledDataSource 方式
     * 最大连接时间
     */
    @Bean
    public DataSource dataSource4() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/jdbc_demo");
        try {
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        // 用户名。Default: null
        dataSource.setUser("controller");
        // 密码。Default: null
        dataSource.setPassword("controller");
        dataSource.setInitialPoolSize(3);
        dataSource.setMaxPoolSize(6);
        dataSource.setMaxIdleTime(1000);
        //当连接池中的连接耗尽的时候c3p0一次同时获取的连接数。Default: 3
        dataSource.setAcquireIncrement(3);
        //-定义在从数据库获取新连接失败后重复尝试的次数。Default: 30
        dataSource.setAcquireRetryAttempts(30);
        //两次连接中间隔时间，单位毫秒。Default: 1000
        dataSource.setAcquireRetryDelay(1000);
        //连接关闭时默认将所有未提交的操作回滚。Default: false
        dataSource.setAutoCommitOnClose(false);
        /*c3p0将建一张名为Test的空表，并使用其自带的查询语句进行测试。如果定义了这个参数那么
        属性preferredTestQuery将被忽略。你不能在这张Test表上进行任何操作，它将只供c3p0测试
        使用。Default: null*/
        dataSource.setAutomaticTestTable(null);
        /*获取连接失败将会引起所有等待连接池来获取连接的线程抛出异常。但是数据源仍有效
        保留，并在下次调用getConnection()的时候继续尝试获取连接。如果设为true，那么在尝试
        获取连接失败后该数据源将申明已断开并永久关闭。Default: false*/
        dataSource.setBreakAfterAcquireFailure(false);
        /*当连接池用完时客户端调用getConnection()后等待获取新连接的时间，超时后将抛出
        SQLException,如设为0则无限期等待。单位毫秒。Default: 0*/
        dataSource.setCheckoutTimeout(100);
        /*通过实现ConnectionTester或QueryConnectionTester的类来测试连接。类名需制定全路径。
        Default: com.mchange.v2.c3p0.impl.DefaultConnectionTester*/
        //dataSource.setConnectionTesterClassName();
        //指定c3p0 libraries的路径，如果（通常都是这样）在本地即可获得那么无需设置，默认null即可 Default: null
        dataSource.setFactoryClassLocation(null);
        //每60秒检查所有连接池中的空闲连接。Default: 0
        dataSource.getIdleConnectionTestPeriod();
        //初始化时获取三个连接，取值应在minPoolSize与maxPoolSize之间。Default: 3
        dataSource.setInitialPoolSize(3);
        //最大空闲时间,60秒内未使用则连接被丢弃。若为0则永不丢弃。Default: 0
        dataSource.setMaxIdleTime(60);
        //连接池中保留的最大连接数。Default: 15
        dataSource.setMaxPoolSize(15);
        /*JDBC的标准参数，用以控制数据源内加载的PreparedStatements数量。但由于预缓存的statements
        属于单个connection而不是整个连接池。所以设置这个参数需要考虑到多方面的因素。
        如果maxStatements与maxStatementsPerConnection均为0，则缓存被关闭。Default: 0*/
        dataSource.setMaxStatements(100);
        //maxStatementsPerConnection定义了连接池内单个连接所拥有的最大缓存statements数。Default: 0
        dataSource.setMaxStatementsPerConnection(0);
        //c3p0是异步操作的，缓慢的JDBC操作通过帮助进程完成。扩展这些操作可以有效的提升性能 通过多线程实现多个操作同时被执行。Default: 3
        dataSource.setNumHelperThreads(3);
        //当用户调用getConnection()时使root用户成为去获取连接的用户。主要用于连接池连接非c3p0   的数据源时。Default: null
        dataSource.setOverrideDefaultUser("root");
        //与overrideDefaultUser参数对应使用的一个参数。Default: null
        dataSource.setOverrideDefaultPassword("password");
        //定义所有连接测试都执行的测试语句。在使用连接测试的情况下这个一显著提高测试速度。注意：测试的表必须在初始数据源的时候就存在。Default: null
        dataSource.setPreferredTestQuery(null);
        //用户修改系统配置参数执行前最多等待300秒。Default: 300
        dataSource.setPropertyCycle(300);
        /*因性能消耗大请只在需要的时候使用它。如果设为true那么在每个connection提交的
        时候都将校验其有效性。建议使用idleConnectionTestPeriod或automaticTestTable
        等方法来提升连接测试的性能。Default: false*/
        dataSource.setTestConnectionOnCheckout(false);
        //如果设为true那么在取得连接的同时将校验连接的有效性。Default: false
        dataSource.setTestConnectionOnCheckin(true);
        return dataSource;
    }

    public static void main(String[] args) throws Exception {
        //1. 加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获得数据库连接
        Connection conn = DriverManager.getConnection("URL", "USER", "PASSWORD");
        //3. 操作数据库，实现增删改查
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT user_name, age FROM imooc_goddess");
        // 如果有数据，rs.next()返回true
        while(rs.next()){
            System.out.println(rs.getString("user_name")+" 年龄："+rs.getInt("age"));
        }
    }

}
