package com.didispace.controller;

import org.apache.ibatis.jdbc.SqlRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: MyGitHub-OctoberZDi-springboot-learning
 * @ClassName: TestMain
 * @Description: ddd
 * @Author: zhangdi
 * @Date: 2020年02月06日 17:11
 **/
public class TestMain {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=utf-8&useSSL=false";
            Connection connection = DriverManager.getConnection(url, "root", "root");

            SqlRunner sqlRunner = new SqlRunner(connection);
            List<Map<String, Object>> maps = sqlRunner.selectAll("SELECT * FROM information_schema.TABLES WHERE  TABLE_SCHEMA='guns';");
            System.out.println("*********");
            System.out.println(maps);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
