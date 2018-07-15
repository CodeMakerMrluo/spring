package com.springcomponent.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author Administrator
 * @Title: DBUtil
 * @ProjectName helloworld
 * @Description: TODO
 * @date 2018/7/15 001522:20
 */

@Repository
public class DBUtil {
    public JdbcTemplate jdbcTempate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTempate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTempate = jdbcTemplate;
    }


    public void testSave() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
        jdbcTempate = (JdbcTemplate)context.getBean("jdbcTempate");
        String sql = "insert into dept values(?, ?, ?)";
        jdbcTempate.update(sql, 11, "xxx", "xxx");
    }


}
