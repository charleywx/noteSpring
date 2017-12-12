package com.charley.spring.repository;

import com.charley.spring.di.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MyRepository {

    /**
     * 数据库接口类
     */
//    @Autowired
//    private JdbcOperations jdbcOperations;

    @Autowired
    private JdbcTemplate jdbcTemplateMs;

    public void test() {
        jdbcTemplateMs.queryForObject("", (rs, rowNum) -> {
            return new Person(
                    rs.getString("name"),
                    rs.getString("age")
            );
        });
    }

}
