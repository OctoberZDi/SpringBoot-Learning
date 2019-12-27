package com.didispace.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description: Person <br>
 * date: 2019/12/25 15:50 <br>
 *
 * @author: Zhangdi <br>
 * version: 1.0 <br>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String id;
    private String name;
    private int age;
}
