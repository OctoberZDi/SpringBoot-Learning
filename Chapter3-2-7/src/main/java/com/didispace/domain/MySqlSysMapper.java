package com.didispace.domain;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 *
 * @author zhangdi03
 */
@Mapper
public interface MySqlSysMapper {

    @Select("SELECT * FROM information_schema.TABLES WHERE  TABLE_SCHEMA='guns';")
    List<Map<String, Object>> getAllTables();
}
