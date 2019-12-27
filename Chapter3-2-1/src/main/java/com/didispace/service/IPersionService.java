package com.didispace.service;

import java.util.List;
import java.util.Map;

/**
 * description: IPersionService <br>
 * date: 2019/12/25 15:53 <br>
 *
 * @author: Zhangdi <br>
 * version: 1.0 <br>
 */
public interface IPersionService {
    int add(String name, int age);

    List<Map<String, Object>> getAllUsers();

    int deleteAllUsers();
}
