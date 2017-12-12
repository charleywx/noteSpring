package com.charley.spring.di;

import com.charley.spring.di.config.DataSourceConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataSourceConfig.class})
public class TestDataSource {

    private final static Logger log = LoggerFactory.getLogger(TestDataSource.class);

    @Autowired
    private DataSource dataSource1;

    @Autowired
    private DataSource dataSource2;

    @Test
    public void testData1() {
        Assert.assertNotNull(dataSource1);
        Connection con = null;
        try {
            dataSource1.getConnection();
            con = dataSource1.getConnection();
            // ResultSet rs = con.prepareStatement("select * from Customer").executeQuery();
            ResultSet rs = con.createStatement().executeQuery("select * from Customer");
            while(rs.next()) {
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                log.info(firstName + " " + lastName);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Test
    public void testData2() {
        Assert.assertNotNull(dataSource2);
    }

}
