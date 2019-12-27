package com.didispace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * description: PersonService <br>
 * date: 2019/12/25 15:53 <br>
 *
 * @author: Zhangdi <br>
 * version: 1.0 <br>
 */
@Service
public class PersonService implements IPersionService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int add(String name, int age) {
        int update = jdbcTemplate.update("insert into person (name ,age) values(?,?)", name, age);

        return update;
    }

    @Override
    public List<Map<String, Object>> getAllUsers() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select name,age from person");

        return maps;
    }

    @Override
    public int deleteAllUsers() {
        int deleteCount = jdbcTemplate.update("delete from person");

        return deleteCount;
    }
}
