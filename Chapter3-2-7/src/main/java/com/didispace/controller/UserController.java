package com.didispace.controller;

import com.didispace.domain.MySqlSysMapper;
import com.mysql.cj.xdevapi.SessionFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: MyGitHub-OctoberZDi-springboot-learning
 * @ClassName: UserController
 * @Description: 测试用户
 * @Author: zhangdi
 * @Date: 2020年02月06日 16:28
 **/
@RestController
public class UserController {

    @Resource
    private MySqlSysMapper mySqlSysMapper;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public Object test() {
        List<Map<String, Object>> allTables = mySqlSysMapper.getAllTables();
        return allTables;
    }
}

